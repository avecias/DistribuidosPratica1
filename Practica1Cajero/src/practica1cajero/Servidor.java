/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1cajero;

import com.mysql.jdbc.Statement;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Kevin
 */
public class Servidor {

    String user = "root";
    String pass = "n0m3l0s3";
    String operacion = "";
    int res;
    double monto;
    int opc;
    String cuenta, trans;
    double saldo, nuevosaldo;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Servidor ser = new Servidor();
        ser.servidors();
    }

    public void servidors() throws ClassNotFoundException, SQLException {

        try {
            ServerSocket socketservidor = new ServerSocket(5000);
            //JOptionPane.showMessageDialog(null, "OK");

            Socket sc = socketservidor.accept();
            System.out.println("Conexion Aceptada " + sc);

            DataOutputStream dos = new DataOutputStream(sc.getOutputStream());
            DataInputStream dis = new DataInputStream(sc.getInputStream());
            while (true) {

                cuenta = dis.readUTF();
                trans = dis.readUTF();
                opc = dis.readInt();
                monto = dis.readDouble();

                if (opc == 1) {
                    operacion = "Retiro de Efectivo";
                    System.out.println("Cuenta: " + cuenta);
                    System.out.println("Opcion: " + operacion);
                    System.out.println("Monto:  " + monto);
                    System.out.println("\n ");

                    this.saldo();
                    nuevosaldo = (saldo - monto);
                    System.out.println("Saldo actual: " + nuevosaldo);

                    if ((nuevosaldo) >= 0) {
                        this.actualiza();
                        res = 1;
                        dos.writeInt(res);
                        saldo = 0;
                        dos.writeDouble(saldo);
                        this.operacion();
                    } else if ((nuevosaldo) < 0) {
                        res = 0;
                        dos.writeInt(res);
                        saldo = 0;
                        nuevosaldo = 0;
                        dos.writeDouble(saldo);
                    }
                } else if (opc == 2) {
                    operacion = "Consulta Saldo";
                    System.out.println("Cuenta:  " + cuenta);
                    System.out.println("Opcion:  " + operacion);
                    System.out.println("\n ");
                    System.out.println("Cuenta:  " + cuenta);
                    this.saldo();
                    System.out.println(saldo);
                    res = 1;
                    dos.writeInt(res);
                    dos.writeDouble(saldo);
                    monto=saldo;
                    this.operacion();
                } else if (opc == 3) {
                    operacion = "Deposito";
                    System.out.println("Cuenta:  " + cuenta);
                    System.out.println("Opcion:  " + operacion);
                    System.out.println("Monto:  " + monto);
                    System.out.println("\n ");
                    this.saldo();
                    nuevosaldo = (saldo + monto);
                    System.out.println("Saldo actual: " + nuevosaldo);
                    this.actualiza();
                    res = 1;
                    dos.writeInt(res);
                    saldo = 0;
                    nuevosaldo = 0;
                    dos.writeDouble(saldo);
                    this.operacion();
                } else if (opc == 4) {
                    operacion = "Transferencia";
                    String auxo = cuenta;
                    String auxd = "";

                    System.out.println("Cuenta Origen :  " + auxo);
                    System.out.println("Cuenta Destino:  " + trans);
                    System.out.println("Opcion: " + operacion);
                    System.out.println("Monto:  " + monto);
                    System.out.println("\n ");

                    //verificamos saldo cuenta origen
                    this.saldo();
                    nuevosaldo = (saldo - monto);
                    //System.out.println("1Cuenta origen : " + cuenta);
                    // System.out.println("1Nuevo saldo : " + nuevosaldo);

                    if (nuevosaldo >= 0) {
                        //verificamos existencia cuenta destino
                        cuenta = trans;
                        this.saldo();

                        if (res == 1) {
                            cuenta = auxo;
                            this.actualiza();
                            System.out.println("Saldo actual Origen: " + nuevosaldo);
                            cuenta = trans;
                            this.saldo();
                            nuevosaldo = (saldo + monto);
                            this.actualiza();
                            System.out.println("Saldo actual Destino: " + nuevosaldo);
                            res = 1;
                            dos.writeInt(res);
                            saldo = 0;
                            dos.writeDouble(saldo);
                            cuenta=auxo;
                            this.operacion();
                        } else if (res == 0) {
                            res = 0;
                            dos.writeInt(res);
                            saldo = 0;
                            nuevosaldo = 0;
                            dos.writeDouble(saldo);
                        }

                    } else if (nuevosaldo < 0) {
                        res = 0;
                        dos.writeInt(res);
                        saldo = 0;
                        nuevosaldo = 0;
                        dos.writeDouble(saldo);
                    }

                }

            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            JOptionPane.showMessageDialog(null, "Liberando Recursos");

        }
    }

    public void actualiza() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        try (java.sql.Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/banco", user, pass)) {
            Statement st = (Statement) conexion.createStatement();
            st.executeUpdate("UPDATE cuenta SET balance=" + nuevosaldo + " WHERE idcuenta=" + cuenta);
        }
    }

    public void saldo() {
        try {
            try (java.sql.Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/banco", user, pass)) {
                Statement comando = (Statement) conexion.createStatement();
                System.out.println(cuenta);
                ResultSet registro = comando.executeQuery("select balance from cliente,cuenta where cliente.idcliente=cuenta.idclientes and cuenta.idcuenta=" + cuenta);
                if (registro.next() == true) {
                    saldo = registro.getDouble("balance");
                    res = 1;
                } else {
                    System.out.println("No existe un cuenta con dicho código");
                    res = 0;
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void operacion() throws ClassNotFoundException, SQLException {
        java.util.Date date = new Date();
        java.sql.Date fechaActual = new java.sql.Date(date.getTime());

        Class.forName("com.mysql.jdbc.Driver");
        java.sql.Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/banco", user, pass);
        Statement st = (Statement) conexion.createStatement();
        st.executeUpdate("INSERT INTO operacionescuenta (idcuenta, fechaoperacion, tipomovimiento,cantidad) "
                + "VALUES ('" + cuenta + "','" + fechaActual + "','" + operacion + "','" + monto + "' )");

    }

}

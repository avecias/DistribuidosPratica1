/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1cajero;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Kevin
 */
public class Inicio extends javax.swing.JFrame {

    private JLabel lblUser, lblPass;
    private JButton btnAceptar, btnCancelar;
    public static String usuario, nocuenta;

    /**
     * Creates new form Inicio
     */
    public Inicio() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("ENTRAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 119, 39));

        jLabel1.setText("USUARIO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel2.setText("NO. CUENTA");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));
        getContentPane().add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 160, -1));

        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });
        getContentPane().add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 160, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon("/Users/Kevin/Downloads/hsbc.png")); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 190));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            //chekar si el usuario escrbio el nombre de usuario y pw
            if (txtUser.getText().length() > 0 && txtPass.getText().length() > 0) {
                // Si el usuario si fue validado correctamente
                if (validarUsuario(txtUser.getText(), txtPass.getText())) //enviar datos a validar
                {
                    // Codigo para mostrar la ventana principal
                    nocuenta = txtPass.getText();
                    System.out.println(nocuenta);
                    setVisible(false);
                    Cliente ventana1 = new Cliente();
                  
                    ventana1.show();

                } else {
                    JOptionPane.showMessageDialog(null, "El usuario y/o No. de Cuenta no son validos.");
                    JOptionPane.showMessageDialog(null, txtUser.getText() + " " + txtPass.getText());
                    nocuenta = txtPass.getText();
                    txtUser.setText("");    //limpiar campos
                    txtPass.setText("");

                    txtUser.requestFocusInWindow();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Debe escribir usuario y No. de cuenta.\n"
                        + "NO puede dejar ningun campo vacio");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassActionPerformed

    boolean validarUsuario(String elUsr, String elPw) throws IOException {
        try {

            Connection unaConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "root", "avecias");
            // Preparamos la consulta   
            Statement instruccionSQL = unaConexion.createStatement();
            ResultSet resultadosConsulta = instruccionSQL.executeQuery("SELECT * FROM cliente,cuenta WHERE cuenta.idclientes='" + elUsr + "' AND cuenta.idcuenta='" + elPw + "'");

            return resultadosConsulta.first(); // si es valido el primer reg. hay una fila, tons el usuario y su pw existen
            //usuario validado correctamente
            //usuario validado incorrectamente
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

   

    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}

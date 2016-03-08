/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package berckeysocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 *
 * @author Kevin
 */
public class Maestro {

    int i = 1;
    long[] horalocal = new long[3];
    long hora;
    long horaserv;
    long promedio;
    long[] ajuste = new long[3];
    byte[] b = new byte[19];

    public static void main(String[] args) throws IOException, InterruptedException {
        Maestro m = new Maestro();
        m.dale();
    }

    public void dale() throws IOException, InterruptedException {

        DatagramPacket dgram = new DatagramPacket(b, b.length);
        MulticastSocket socket = new MulticastSocket(4000);
        socket.joinGroup(InetAddress.getByName("235.1.1.1"));

        while (true) {
            socket.receive(dgram);
            // Se bloquea hasta que llegue un datagrama
            byte[] recibido = dgram.getData();
            String cadena = new String(recibido, "UTF-8");

            if (i <= 3) {
                horalocal[i - 1] = Long.valueOf(cadena).longValue();
                System.out.println("Cliente " + i + "  " + cadena);
                i++;

            } else {
                horaserv = System.nanoTime();
                System.out.println("Servidor   " + horaserv);
                i = 1;
                for (int j = 0; j < 3; j++) {
                    hora += horalocal[j];
                }
                //System.out.println(horalocal);
                promedio = ((hora + horaserv) / (4));

                System.out.println("\nPromedio:  " + promedio);
                System.out.println("\nAJUSTE CLIENTES");
                //this.multicast();
                for (int j = 0; j < 3; j++) {
                    ajuste[j] = promedio - horalocal[j];
                    System.out.println("Cliente " + (j + 1) + " " + ajuste[j]);

                }
                System.out.println("------------------------------");

                hora = 0;
                horaserv = 0;
                promedio=0;
            }
            //break;
        }

        // promedio = 0;
    }

    public void multicast() throws InterruptedException, IOException {
        //byte[] e = new byte[19];
        MulticastSocket socket = new MulticastSocket();
        DatagramPacket dagram;
       
        while (true) {
            String cad = Long.toString(promedio);
            //cad="Cliente 1 : "+cad;
            byte[] e = cad.getBytes("UTF-8");

            dagram = new DatagramPacket(e, e.length, InetAddress.getByName("235.1.1.1"), 4000);

            System.out.println("Enviando " + promedio);

            socket.send(dagram);
            //Thread.sleep(10000);
            break;
        }
        this.dale();
    }

}

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
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kevin
 */
public class Cliente3 {

    long tiempo;
    MulticastSocket socket;
    DatagramPacket dgram;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO code application logic here

        Cliente3 so = new Cliente3();
        so.multicast();
        try {
            so.multicast();
        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cliente3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Cliente3() {
        tiempo = System.nanoTime();
        try {
            socket = new MulticastSocket();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void multicast() throws InterruptedException, IOException {

        while (true) {
            tiempo = System.nanoTime();
            String cad = Long.toString(tiempo);
            //cad="Cliente 1 : "+cad;
            byte[] b = cad.getBytes("UTF-8");

            dgram = new DatagramPacket(b, b.length, InetAddress.getByName("235.1.1.1"), 4000);

            System.out.println("Enviando " + tiempo);

            socket.send(dgram);
           Thread.sleep(10000);
           // this.leer();
            

        }

    }


}
    

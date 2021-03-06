/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1cajero;

import java.awt.Image;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 *
 * @author Kevin
 */
public class Cliente extends javax.swing.JFrame  {

    Socket cl;
    int opc = 0;
    int res = 0;
    double monto = 0;
    String montolcd;
    String trans = "";
    String cuenta = Inicio.nocuenta;

    //Opciones
    //1 retiro   2 saldo   3 deposito  4 transferencia  5 cancelar 6 salir
    /**
     * Creates new form Cliente
     */
    public Cliente() {
        initComponents();
        //ajusta();
        this.setLocationRelativeTo(null);
        this.cancelar();
        lcd.setHorizontalAlignment(SwingConstants.RIGHT);
          

        try {
            cl = new Socket("127.0.0.1", 5000);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton12 = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lcd = new javax.swing.JFormattedTextField();
        lfondo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jList2.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        jList3.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(jList3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 150, 80, 60));

        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 80, 60));

        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 80, 60));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel1.setText("RETIRO EFECTIVO ===>");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, -1, -1));

        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, 80, 60));

        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 80, 60));

        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 290, 80, 60));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setText("CONSULTA SALDO ===>");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, -1, -1));

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel3.setText("DEPOSITO ======>");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, -1, -1));

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel4.setText("TRANSFERENCIA ===>");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, -1, -1));

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel5.setText("<===== SALIR");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, -1, -1));

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel6.setText("<== CANCELAR");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, -1, -1));

        lcd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lcdActionPerformed(evt);
            }
        });
        getContentPane().add(lcd, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 270, 50));

        lfondo.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/2.jpg"))); // NOI18N
        getContentPane().add(lfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 350, 250));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 310, 360));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 350, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (opc == 1 || opc == 3 || opc == 4) {
            monto = 300;
            lcd.setText("300");

        } else if (opc == 0) {
            opc = 2;
            jLabel1.setText("");
            jLabel2.setText("");
            jLabel3.setText("");
            jLabel4.setText("");
            jLabel5.setText("<===== ACEPTAR");
            jLabel6.setText("<===== SALIR");

        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.cancelar();

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if (lcd.getText().length() > 0) {

            if (opc == 1 || opc == 3) {
                monto = Math.abs(Long.valueOf(lcd.getText()));
                this.socket();

                if (res == 1) {
                    JOptionPane.showMessageDialog(null, "ACCION REALIZADA CON EXITO");
                    res = 0;
                    this.cancelar();
                } else if (res == 0) {
                    JOptionPane.showMessageDialog(null, "NO PUEDES RETIRAR ESA CANTIDAD "
                            + "\n REVISA EL MONTO INGRESADO");
                    res = 0;
                    this.cancelar();
                }

            } else if (opc == 4) {
                monto = Math.abs(Long.valueOf(lcd.getText()));
                this.socket();

                if (res == 1) {
                    JOptionPane.showMessageDialog(null, "TRANSFERENCIA EXITOSA");
                    res = 0;
                    this.cancelar();
                } else if (res == 0) {
                    JOptionPane.showMessageDialog(null, "NO SE PUDO REALIZAR LA OPERACION");
                    res = 0;
                    this.cancelar();
                }
            }

        } else if (opc == 2) {
            monto = 0;
            this.socket();
            if (res == 1) {

                lcd.setText(montolcd);
                res = 0;
            }

        }

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

        if (opc == 0) {
            opc = 1;

            jLabel1.setText("                     100 =====>");
            jLabel2.setText("                     300 =====>");
            jLabel3.setText("                500 =====>");
            jLabel4.setText("OTRA CANTIDAD  ===>");
            jLabel5.setText("<===== ACEPTAR");

        } else if (opc == 1 || opc == 3 || opc == 4) {
            lcd.setText("100");
        }


    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        if (opc == 1 || opc == 3 || opc == 4) {
            monto = 500;
            lcd.setText("500");
        } else if (opc == 0) {
            opc = 3;
            jLabel1.setText("                     100 =====>");
            jLabel2.setText("                     300 =====>");
            jLabel3.setText("                500 =====>");
            jLabel4.setText("OTRA CANTIDAD  ===>");
            jLabel5.setText("<===== ACEPTAR");
        }

    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        if (opc == 1 || opc == 3 || opc == 4) {
            //monto=100;
            lcd.setEditable(true);
            lcd.setText("");
            lcd.requestFocus();
        } else if (opc == 0) {
            opc = 4;
            trans = JOptionPane.showInputDialog(this, "INGRESE NO. DE CUENTA", "showInputDialog", JOptionPane.INFORMATION_MESSAGE);
            jLabel1.setText("                     100 =====>");
            jLabel2.setText("                     300 =====>");
            jLabel3.setText("                500 =====>");
            jLabel4.setText("OTRA CANTIDAD  ===>");
            jLabel5.setText("<===== ACEPTAR");
        }

    }//GEN-LAST:event_jButton13ActionPerformed

    private void lcdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lcdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lcdActionPerformed

    public void ajusta() {
        ImageIcon imgIcon = new ImageIcon(getClass().getResource("/img/Fondo.png"));
        Image imgEscalada = imgIcon.getImage().getScaledInstance(lfondo.getWidth(),
                lfondo.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        lfondo.setIcon(iconoEscalado);
    }

    public void cancelar() {
        opc = 0;
        jLabel1.setText("RETIRO EFECTIVO ===>");
        jLabel2.setText("CONSULTA SALDO ===>");
        jLabel3.setText("DEPOSITO ======>");
        jLabel4.setText("TRANSFERENCIA ===>");
        jLabel6.setText("<== CANCELAR");
        jLabel5.setText("<===== SALIR");

        lcd.setText("");
        lcd.setEditable(false);

    }

    public void socket() {

        while (true) {
            try {
                DataOutputStream dos = new DataOutputStream(cl.getOutputStream());
                DataInputStream dis = new DataInputStream(cl.getInputStream());

                dos.writeUTF(cuenta);
                dos.flush();
                dos.writeUTF(trans);
                dos.flush();
                dos.writeInt(opc);
                dos.flush();
                dos.writeDouble(monto);
                dos.flush();

                res = ((dis.readInt()));
                montolcd = Double.toString(dis.readDouble());

            } catch (IOException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;
        }

    }

    public void cuenta() {
      cuenta=  Inicio.nocuenta;
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
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JList jList3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JFormattedTextField lcd;
    private javax.swing.JLabel lfondo;
    // End of variables declaration//GEN-END:variables
}

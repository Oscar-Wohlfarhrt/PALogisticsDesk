/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.EnderFire.PALogisticsDesk.Views;

import com.EnderFire.PALogisticsDesk.Models.*;
import javax.swing.JOptionPane;
import com.EnderFire.PALogisticsDesk.Controls.DAO;
import com.EnderFire.PALogisticsDesk.Controls.QueryController;
import com.EnderFire.PALogisticsDesk.Views.Informes.InformeProveedor;
import com.EnderFire.PALogisticsDesk.Views.Informes.InformeStock;
import com.EnderFire.PALogisticsDesk.Views.Informes.TransportistaPorRuta;
import com.EnderFire.PALogisticsDesk.Views.UserSelectForm;

/**
 *
 * @author Oscar2
 */
public class InformesForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    public InformesForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        ClienteBut = new javax.swing.JButton();
        OrdenCompraBut = new javax.swing.JButton();
        CentroDistribucionBut = new javax.swing.JButton();
        InformacionContactoBut = new javax.swing.JButton();
        ProveedorBut1 = new javax.swing.JButton();
        ProveedorBut = new javax.swing.JButton();
        ProveedorBut2 = new javax.swing.JButton();
        ProveedorBut3 = new javax.swing.JButton();
        ReturnBut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Informes Menu");

        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new java.awt.GridLayout(4, 4, 5, 5));

        ClienteBut.setText("Costos de Transporte");
        ClienteBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClienteButActionPerformed(evt);
            }
        });
        jPanel1.add(ClienteBut);

        OrdenCompraBut.setText("Informe de proveedores");
        OrdenCompraBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrdenCompraButActionPerformed(evt);
            }
        });
        jPanel1.add(OrdenCompraBut);

        CentroDistribucionBut.setText("Transportista por ruta");
        CentroDistribucionBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CentroDistribucionButActionPerformed(evt);
            }
        });
        jPanel1.add(CentroDistribucionBut);

        InformacionContactoBut.setText("Informe stock por almacen");
        InformacionContactoBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InformacionContactoButActionPerformed(evt);
            }
        });
        jPanel1.add(InformacionContactoBut);

        ProveedorBut1.setText("Pedidos entregados");
        ProveedorBut1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProveedorBut1ActionPerformed(evt);
            }
        });
        jPanel1.add(ProveedorBut1);

        ProveedorBut.setText("Pedidos en camino");
        ProveedorBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProveedorButActionPerformed(evt);
            }
        });
        jPanel1.add(ProveedorBut);

        ProveedorBut2.setText("Pedidos despachados");
        ProveedorBut2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProveedorBut2ActionPerformed(evt);
            }
        });
        jPanel1.add(ProveedorBut2);

        ProveedorBut3.setText("Pedidos no despachados");
        ProveedorBut3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProveedorBut3ActionPerformed(evt);
            }
        });
        jPanel1.add(ProveedorBut3);

        ReturnBut.setText("Retroceder");
        ReturnBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnButActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ReturnBut, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ReturnBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ReturnButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnButActionPerformed
        new UserSelectForm().setVisible(true);
        dispose();
    }//GEN-LAST:event_ReturnButActionPerformed

    private void InformacionContactoButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InformacionContactoButActionPerformed
        new InformeStock().setVisible(true);
    }//GEN-LAST:event_InformacionContactoButActionPerformed

    private void CentroDistribucionButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CentroDistribucionButActionPerformed
        //new TableViewForm(TransportistaPorRuta.class).setVisible(true);
        new TransportistaPorRuta().setVisible(true);
    }//GEN-LAST:event_CentroDistribucionButActionPerformed

    private void OrdenCompraButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrdenCompraButActionPerformed
        new InformeProveedor().setVisible(true);
    }//GEN-LAST:event_OrdenCompraButActionPerformed

    private void ClienteButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClienteButActionPerformed
        JOptionPane.showMessageDialog(null, "Los costos totales son $" + qc.informeCostosTotalesTansoportistas());
    }//GEN-LAST:event_ClienteButActionPerformed

    private void ProveedorBut1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProveedorBut1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Hay " +  qc.informePedidosE()+ " pedidos entregados en total");
    }//GEN-LAST:event_ProveedorBut1ActionPerformed

    private void ProveedorBut2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProveedorBut2ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Hay " + qc.informePedidosD()+ " pedidos entregados en total");
    }//GEN-LAST:event_ProveedorBut2ActionPerformed

    private void ProveedorButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProveedorButActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Hay " +  qc.informePedidosEC()+ " pedidos en camino en total");
    }//GEN-LAST:event_ProveedorButActionPerformed

    private void ProveedorBut3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProveedorBut3ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Hay " + qc.informePedidosND()+ " pedidos no despachados en total");
    }//GEN-LAST:event_ProveedorBut3ActionPerformed

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
            java.util.logging.Logger.getLogger(InformesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformesForm().setVisible(true);
            }
        });
    }

    QueryController qc = new QueryController();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CentroDistribucionBut;
    private javax.swing.JButton ClienteBut;
    private javax.swing.JButton InformacionContactoBut;
    private javax.swing.JButton OrdenCompraBut;
    private javax.swing.JButton ProveedorBut;
    private javax.swing.JButton ProveedorBut1;
    private javax.swing.JButton ProveedorBut2;
    private javax.swing.JButton ProveedorBut3;
    private javax.swing.JButton ReturnBut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

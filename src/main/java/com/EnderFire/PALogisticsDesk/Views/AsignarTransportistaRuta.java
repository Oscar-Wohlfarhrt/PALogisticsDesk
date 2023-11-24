/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.EnderFire.PALogisticsDesk.Views;

import com.EnderFire.PALogisticsDesk.Controls.GenericJpaController;
import com.EnderFire.PALogisticsDesk.Models.*;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Oscar
 */
public class AsignarTransportistaRuta extends javax.swing.JFrame {

    GenericJpaController<Transportista> tJPA = new GenericJpaController<>(Transportista.class);
    GenericJpaController<Ruta> rJPA = new GenericJpaController<>(Ruta.class);
    List<Transportista> transportistas;
    List<Ruta> rutas;
    
    DefaultComboBoxModel<String> transModel = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<String> rutaModel = new DefaultComboBoxModel<>();
    
    
    /**
     * Creates new form AsignarTransportistaRuta
     */
    public AsignarTransportistaRuta() {
        initComponents();
        
        transportistas = tJPA.findEntityEntities();
        rutas = rJPA.findEntityEntities();
        
        transModel.addAll(transportistas.stream().map(t -> t.toString()).toList());
        rutaModel.addAll(rutas.stream().map(r -> r.toString()).toList());
        
        ComboTransportista.setModel(transModel);
        ComboRuta.setModel(rutaModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ComboTransportista = new javax.swing.JComboBox<>();
        TransportistaLabel = new javax.swing.JLabel();
        RutaLabel = new javax.swing.JLabel();
        ComboRuta = new javax.swing.JComboBox<>();
        AsignarRutaBut = new javax.swing.JButton();
        RutaActLabel = new javax.swing.JLabel();
        RutaActOutput = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        ComboTransportista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboTransportista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboTransportistaActionPerformed(evt);
            }
        });

        TransportistaLabel.setText("Transportista:");

        RutaLabel.setText("Ruta:");

        ComboRuta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        AsignarRutaBut.setText("Asignar Ruta");
        AsignarRutaBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AsignarRutaButActionPerformed(evt);
            }
        });

        RutaActLabel.setText("Ruta Actual:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AsignarRutaBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TransportistaLabel)
                            .addComponent(RutaLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ComboRuta, 0, 261, Short.MAX_VALUE)
                            .addComponent(ComboTransportista, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(RutaActLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RutaActOutput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboTransportista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TransportistaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RutaLabel)
                    .addComponent(ComboRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(RutaActOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RutaActLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AsignarRutaBut)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AsignarRutaButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AsignarRutaButActionPerformed
        int iRuta=ComboRuta.getSelectedIndex(),iTrans=ComboTransportista.getSelectedIndex();
        
        if(iRuta>=0 && iRuta<rutas.size() && iTrans>=0 && iTrans<transportistas.size()){
            transportistas.get(iTrans).setRuta(rutas.get(iRuta));
            try{
                tJPA.edit(transportistas.get(iTrans));
                updateUI();
            }
            catch(Exception e){}
        }
    }//GEN-LAST:event_AsignarRutaButActionPerformed

    public void updateUI(){
        int iTrans=ComboTransportista.getSelectedIndex();
        if(iTrans>=0 && iTrans<transportistas.size()){            
            Ruta r = transportistas.get(iTrans).getRuta();
            RutaActOutput.setText(r!=null?r.toString():"No hay ruta asignada");
        }
    }
    
    private void ComboTransportistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboTransportistaActionPerformed
        updateUI();
    }//GEN-LAST:event_ComboTransportistaActionPerformed

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
            java.util.logging.Logger.getLogger(AsignarTransportistaRuta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AsignarTransportistaRuta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AsignarTransportistaRuta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AsignarTransportistaRuta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AsignarTransportistaRuta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AsignarRutaBut;
    private javax.swing.JComboBox<String> ComboRuta;
    private javax.swing.JComboBox<String> ComboTransportista;
    private javax.swing.JLabel RutaActLabel;
    private javax.swing.JLabel RutaActOutput;
    private javax.swing.JLabel RutaLabel;
    private javax.swing.JLabel TransportistaLabel;
    // End of variables declaration//GEN-END:variables
}

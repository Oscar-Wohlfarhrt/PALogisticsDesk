/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.EnderFire.PALogisticsDesk.Views;

import com.EnderFire.PALogisticsDesk.Controls.GenericJpaController;
import com.EnderFire.PALogisticsDesk.Models.*;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Oscar
 */
public class ActRendimientoProveedor extends javax.swing.JFrame {
    DefaultComboBoxModel<String> pModel = new DefaultComboBoxModel<>();
    SpinnerNumberModel cpModel = new SpinnerNumberModel(0f, 0f, 100f, 1f);
    SpinnerNumberModel teModel = new SpinnerNumberModel(0f, 0f, 100f, 1f);
    SpinnerNumberModel eeModel = new SpinnerNumberModel(0f, 0f, 100f, 1f);
    
    GenericJpaController<Proveedor> pJPA = new GenericJpaController<>(Proveedor.class);
    List<Proveedor> proveedores;
    /**
     * Creates new form ActRendimientoProveedor
     */
    public ActRendimientoProveedor() {
        initComponents();
        
        CalidadSpinner.setModel(cpModel);
        EntregaSpinner.setModel(teModel);
        EnviosSpinner.setModel(eeModel);
        
        proveedores = pJPA.findEntityEntities();
        pModel.addAll(proveedores.stream().map(p->p.toString()).toList());
        ComboProveedor.setModel(pModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TitleLabel = new javax.swing.JLabel();
        ProveedorLabel = new javax.swing.JLabel();
        ComboProveedor = new javax.swing.JComboBox<>();
        UpdateRendimientoBut = new javax.swing.JButton();
        CalidadLabel = new javax.swing.JLabel();
        EntregaLabel = new javax.swing.JLabel();
        EnviosLabel = new javax.swing.JLabel();
        CalidadSpinner = new javax.swing.JSpinner();
        EntregaSpinner = new javax.swing.JSpinner();
        EnviosSpinner = new javax.swing.JSpinner();
        ErrorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TitleLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TitleLabel.setText("Actualizar Rendimiento de Proveedor");

        ProveedorLabel.setText("Proveedor:");

        ComboProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboProveedorActionPerformed(evt);
            }
        });

        UpdateRendimientoBut.setText("Actualizar Rendimiento");
        UpdateRendimientoBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateRendimientoButActionPerformed(evt);
            }
        });

        CalidadLabel.setText("Calidad de los productos:");

        EntregaLabel.setText("Cumplimiento del tiempo de entrega:");

        EnviosLabel.setText("Porcentaje de errores de envios:");

        ErrorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ProveedorLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboProveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(UpdateRendimientoBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EntregaLabel)
                            .addComponent(CalidadLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CalidadSpinner)
                            .addComponent(EntregaSpinner)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(EnviosLabel)
                        .addGap(38, 38, 38)
                        .addComponent(EnviosSpinner)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ProveedorLabel)
                    .addComponent(ComboProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CalidadLabel)
                    .addComponent(CalidadSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EntregaLabel)
                    .addComponent(EntregaSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EnviosLabel)
                    .addComponent(EnviosSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UpdateRendimientoBut)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UpdateRendimientoButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateRendimientoButActionPerformed
        int index = ComboProveedor.getSelectedIndex();
        
        if(index>=0 && index<proveedores.size()){
            RendimientoProveedor ren = proveedores.get(index).getPerformance();
            ren.setProductQuality(((Number)cpModel.getValue()).floatValue());
            ren.setInTime(((Number)teModel.getValue()).floatValue());
            ren.setDeliveryErrors(((Number)eeModel.getValue()).floatValue());
            try{
                pJPA.edit(proveedores.get(index));
                ErrorLabel.setText("");
            }
            catch(Exception e){}
        }
    }//GEN-LAST:event_UpdateRendimientoButActionPerformed

    private void ComboProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboProveedorActionPerformed
        int index = ComboProveedor.getSelectedIndex();
        
        if(index>=0 && index<proveedores.size()){
            RendimientoProveedor ren = proveedores.get(index).getPerformance();
            if(ren==null){
                ErrorLabel.setText("El proveedor no posee rendimiento aun");
                ren = new RendimientoProveedor();
                ren.setProveedor(proveedores.get(index));
                proveedores.get(index).setPerformance(ren);
            }
            
            cpModel.setValue(ren.getProductQuality());
            teModel.setValue(ren.getInTime());
            eeModel.setValue(ren.getDeliveryErrors());
        }
    }//GEN-LAST:event_ComboProveedorActionPerformed

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
            java.util.logging.Logger.getLogger(ActRendimientoProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActRendimientoProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActRendimientoProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActRendimientoProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ActRendimientoProveedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CalidadLabel;
    private javax.swing.JSpinner CalidadSpinner;
    private javax.swing.JComboBox<String> ComboProveedor;
    private javax.swing.JLabel EntregaLabel;
    private javax.swing.JSpinner EntregaSpinner;
    private javax.swing.JLabel EnviosLabel;
    private javax.swing.JSpinner EnviosSpinner;
    private javax.swing.JLabel ErrorLabel;
    private javax.swing.JLabel ProveedorLabel;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JButton UpdateRendimientoBut;
    // End of variables declaration//GEN-END:variables
}

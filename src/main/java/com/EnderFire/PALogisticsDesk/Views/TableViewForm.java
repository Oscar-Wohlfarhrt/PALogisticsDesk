/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.EnderFire.PALogisticsDesk.Views;

import com.EnderFire.PALogisticsDesk.Utils.GenericEntity;
import com.EnderFire.PALogisticsDesk.Controls.GenericJpaController;
import com.EnderFire.PALogisticsDesk.Models.*;
import com.EnderFire.PALogisticsDesk.Utils.DynamicTable;
import com.EnderFire.PALogisticsDesk.Utils.DynamicTableModel;
import com.EnderFire.PALogisticsDesk.Utils.TableData;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Oscar2
 */
public class TableViewForm<T extends GenericEntity> extends javax.swing.JFrame {

    private Class<T> tClass;
    private List<T> values;
    private List<T> toRemove = new ArrayList<>();
        GenericJpaController<T> jpac;
    /**
     * Creates new form TableViewTest
     */
    public TableViewForm(Class<T> tClass) {
        this.tClass=tClass;
        initComponents();
        
        if(tClass.isAnnotationPresent(TableData.class))
            TableName.setText(tClass.getAnnotation(TableData.class).name());
        else
            TableName.setText(tClass.getSimpleName());
        
        DynamicTable<T> dTable = new DynamicTable<>(tClass);
        dTable.setJTableModels(DataTable);
        jpac = new GenericJpaController<>(tClass);
        values=jpac.findEntityEntities();
        ((DynamicTableModel<T>)DataTable.getModel()).setValues(values);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        DataTable = new javax.swing.JTable();
        SaveTableBut = new javax.swing.JButton();
        AddEntryBut = new javax.swing.JButton();
        DelEntryBut = new javax.swing.JButton();
        TableName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        DataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(DataTable);

        SaveTableBut.setText("Save table");
        SaveTableBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveTableButActionPerformed(evt);
            }
        });

        AddEntryBut.setText("Add entry");
        AddEntryBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddEntryButActionPerformed(evt);
            }
        });

        DelEntryBut.setText("Del entry");
        DelEntryBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelEntryButActionPerformed(evt);
            }
        });

        TableName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TableName.setText("Clase mostrada");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AddEntryBut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DelEntryBut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SaveTableBut))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TableName)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TableName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveTableBut)
                    .addComponent(AddEntryBut)
                    .addComponent(DelEntryBut))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddEntryButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddEntryButActionPerformed
        try{
        values.add(0, (T)tClass.getDeclaredConstructors()[0].newInstance());
        DataTable.updateUI();
        }
        catch (InstantiationException| IllegalAccessException | InvocationTargetException e){
            JOptionPane.showMessageDialog(this, "Error al crear un nuevo objeto");
        }
    }//GEN-LAST:event_AddEntryButActionPerformed

    private void DelEntryButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelEntryButActionPerformed
        int row = DataTable.getSelectedRow();
        if(row>-1){
            toRemove.add(values.remove(row));
            DataTable.updateUI();
        }
    }//GEN-LAST:event_DelEntryButActionPerformed

    private void SaveTableButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveTableButActionPerformed
        try{
        for(T ent:toRemove){
            jpac.destroy(ent.getId());
        }
        for(T ent:values){
            if(ent.getId()==null){
                System.out.println("sin id");
                jpac.create(ent);
            }
            else{
                System.out.println(ent.getId());
                jpac.edit(ent);
            }
        }
        values=jpac.findEntityEntities();
        ((DynamicTableModel<T>)DataTable.getModel()).setValues(values);
        DataTable.updateUI();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_SaveTableButActionPerformed

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
            java.util.logging.Logger.getLogger(TableViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TableViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TableViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TableViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TableViewForm<Cliente>(Cliente.class).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddEntryBut;
    private javax.swing.JTable DataTable;
    private javax.swing.JButton DelEntryBut;
    private javax.swing.JButton SaveTableBut;
    private javax.swing.JLabel TableName;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

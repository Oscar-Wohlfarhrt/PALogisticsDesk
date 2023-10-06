/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EnderFire.PALogisticsDesk.Utils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Oscar2
 */
public class DynamicTable<T> {
    public final Class<T> classType;
    public DynamicTable(Class<T> classType){
        this.classType=classType;
    }
    
    public void setJTableModels(JTable jTable){
        TableHeader[] headers = getTableHeadersAnnotation().toArray(TableHeader[]::new);
        //String[] hNames = headers.map((h)->h.name()).toArray(String[]::new);
        //System.out.println("Headers: "+String.join("; ", getTableHeaders()));
        //headers.forEach((h)->{System.out.println(h.name()+"; ");});
        CustomTableModel tModel = new CustomTableModel();
        tModel.setColumnCount(headers.length);
        jTable.setModel(tModel);
        TableColumnModel cModel = jTable.getColumnModel();
        int i =0;
        for(TableHeader header:headers){
            /*while(cModel.getColumnCount()<=i)
                cModel.addColumn(new TableColumn());*/
            
            TableColumn tCol = cModel.getColumn(i);
            tCol.setHeaderValue(header.name());
            if(header.columnSize()>0)
                tCol.setWidth(header.columnSize());
            JComboBox<String> ops = new JComboBox<>(){
                /*@Override
                public String toString(){
                    return getSelectedItem().toString();
                }*/
            };
            JCheckBox checkbox = new JCheckBox();
            switch(header.columnType()){
                case ColumnType.COMBOBOX:
                    DefaultComboBoxModel<String> boxModel = new DefaultComboBoxModel<>();
                    
                    List<String> options = Arrays.stream(header.enumClass().getEnumConstants()).map((o)->o.toString()).toList();
                    
                    boxModel.addAll(options);
                    /*boxModel.addElement("Masculino");
                    boxModel.addElement("Femenino");*/
                    
                    ops.setModel(boxModel);
                    tModel.setColumnClass(i, JCheckBox.class);
                    tCol.setCellEditor(new DefaultCellEditor(ops));
                    break;
                case ColumnType.CHECKBOX:
                    //tCol.setCellEditor(new DefaultCellEditor(checkbox));
                    tModel.setColumnClass(i, Boolean.class);
                    break;
                default:
                    break;
            }
            /*if(i==2){
                    tModel.setColumnClass(i, JComboBox.class);
            }*/
            i++;
        }
            /*while(cModel.getColumnCount()>=i)
                cModel.removeColumn(cModel.getColumn(i));*/
        
    }
    
    private Stream<TableHeader> getTableHeadersAnnotation(){
        Field[] fields = classType.getDeclaredFields();
        
        Stream<TableHeader> th = Arrays.stream(fields)
               .filter(f->f.isAnnotationPresent(TableHeader.class))
               .map(f->f.getAnnotation(TableHeader.class));
        return th;
    }
    public String[] getTableHeaders(){
        return getTableHeadersAnnotation().map(f->f.name()).toArray(String[]::new);
    }
}

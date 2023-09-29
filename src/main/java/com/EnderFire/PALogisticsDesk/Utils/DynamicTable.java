/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EnderFire.PALogisticsDesk.Utils;

import java.util.Arrays;
import java.util.stream.Stream;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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
              
        TableHeader[] headers = (TableHeader[])getTableHeadersAnnotation().toArray();
        String[] hNames = Arrays.stream(headers).map((h)->h.name()).toArray(String[]::new);
        System.out.println("Headers: "+String.join("; ", ));
        /*TableColumnModel cModel = jTable.getColumnModel();
        int i =0;
        for(TableHeader header:headers){
            while(cModel.getColumnCount()<=i)
                cModel.addColumn(new TableColumn());
            
            TableColumn tCol = cModel.getColumn(i);
            tCol.setHeaderValue(header.name());
            if(header.columnSize()>0)
                tCol.setWidth(header.columnSize());
            JComboBox<String> ops = new JComboBox<>(){
                @Override
                public String toString(){
                    return getSelectedItem().toString();
                }
            };
            switch(header.columnType()){
                case ColumnType.COMBOBOX:
                    DefaultComboBoxModel<String> boxModel = new DefaultComboBoxModel<>();
                    
                    boxModel.addElement("Masculino");
                    boxModel.addElement("Femenino");
                    
                    ops.setModel(boxModel);
                    tCol.setCellEditor(new DefaultCellEditor(ops));
                    break;
                case ColumnType.CHECKBOX:
                    break;
                default:
                    break;
            }
            i++;
        }
            while(cModel.getColumnCount()>=i)
                cModel.removeColumn(cModel.getColumn(i));*/
        
    }
    
    private Stream<TableHeader> getTableHeadersAnnotation(){
        return Arrays.stream(classType.getDeclaredFields())
                .filter(f->f.isAnnotationPresent(TableHeader.class))
                .map(f->f.getAnnotation(TableHeader.class));
    }
    public String[] getTableHeaders(Class<T> tClass){
        return getTableHeadersAnnotation().map(f->f.name()).toArray(String[]::new);
    }
}

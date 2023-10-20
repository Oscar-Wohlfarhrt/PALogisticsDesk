/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EnderFire.PALogisticsDesk.Utils;

import com.EnderFire.PALogisticsDesk.Controls.GenericEntity;
import com.EnderFire.PALogisticsDesk.Controls.GenericJpaController;
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
public class DynamicTable<T extends GenericEntity> {
    public final Class<T> classType;
    public DynamicTable(Class<T> classType){
        this.classType=classType;
    }
    public void setJTableModels(JTable jTable){
        setJTableModels(jTable, false);
    }
    public void setJTableModels(JTable jTable,boolean autoColResize){
        TableHeader[] headers = getTableHeadersAnnotation().toArray(TableHeader[]::new);
        //String[] hNames = headers.map((h)->h.name()).toArray(String[]::new);
        //System.out.println("Headers: "+String.join("; ", getTableHeaders()));
        //headers.forEach((h)->{System.out.println(h.name()+"; ");});
        DynamicTableModel<T> tModel = new DynamicTableModel<>(classType);
        //tModel.setColumnCount(headers.length);
        jTable.setModel(tModel);
        if(!autoColResize)
            jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumnModel cModel = jTable.getColumnModel();
        int i =0;
        for(TableHeader header:headers){
            
            TableColumn tCol = cModel.getColumn(i);
            tCol.setHeaderValue(header.name());
            if(!autoColResize){
                if(header.columnSize()>0){
                    tCol.setPreferredWidth(header.columnSize());
                }
                else{
                    tCol.setPreferredWidth(200);
                }
            }
            JComboBox<String> ops = new JComboBox<>(){
                @Override
                public String toString(){
                    return getSelectedItem().toString();
                }
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
                    tModel.setColumnClass(i, String.class);
                    break;
            }
            /*if(i==2){
                    tModel.setColumnClass(i, JComboBox.class);
            }*/
            i++;
        }
        jTable.setColumnModel(cModel);
    }
    
    public static <T extends GenericEntity> void LoadTableFromJPA(Class<T> eClass,JTable jTable){
        GenericJpaController<T> gjc = new GenericJpaController<>(eClass);
        List<T> list = gjc.findEntityEntities();
        DynamicTableModel tModel = (DynamicTableModel)jTable.getModel();
        tModel.setValues(list);
        /*tModel.clearValues();
        for(T ent:list){
            tModel.addRow(ent.getValues());
        }*/
    }
    
    public static <T extends GenericEntity> void LoadTableFromList(List<T> list, JTable jTable){
        DynamicTableModel tModel = (DynamicTableModel)jTable.getModel();
        tModel.setValues(list);
        /*tModel.clearValues();
        for(T ent:list){
            tModel.addRow(ent);
        }*/
    }
    
    public static <T extends GenericEntity> Stream<Field> getDynTableFields(Class<T> tClass){
        Field[] fields = tClass.getDeclaredFields();
        
        return Arrays.stream(fields)
               .filter(f->f.isAnnotationPresent(TableHeader.class));
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

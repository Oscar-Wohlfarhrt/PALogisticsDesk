/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EnderFire.PALogisticsDesk.Utils;

import com.EnderFire.PALogisticsDesk.Controls.GenericJpaController;
import com.sun.net.httpserver.Headers;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
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
        Field[] fields=getDynTableFields(classType).toArray(Field[]::new);
        DynamicTableModel<T> tModel = new DynamicTableModel<>(classType);
        
        jTable.setModel(tModel);
        if(!autoColResize)
            jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumnModel cModel = jTable.getColumnModel();
        int i =0;
        for(Field field:fields){
            TableHeader header = field.getAnnotation(TableHeader.class);
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
            DefaultComboBoxModel<String> boxModel = new DefaultComboBoxModel<>();
            if(field.getType().isEnum()){
                List<String> options = Arrays.stream(field.getType().getEnumConstants()).map((o)->o.toString()).toList();
                boxModel.addAll(options);
                ops.setModel(boxModel);
                tCol.setCellEditor(new DefaultCellEditor(ops));
            }
            else if(Arrays.asList(field.getType().getInterfaces()).indexOf(GenericEntity.class)>0){
                GenericJpaController<?> jpaEnum = new GenericJpaController(field.getType());
                boxModel.addAll(jpaEnum.findEntityEntities().stream().map((ent)->ent.toString()).toList());
                ops.setModel(boxModel);
                tCol.setCellEditor(new DefaultCellEditor(ops));
            }
            i++;
        }
        jTable.setColumnModel(cModel);
    }
    
    public static <T> List<String> getEnumFromClass(Class<T> tClass){
        int iIndex=Arrays.asList(tClass.getInterfaces()).indexOf(GenericEntity.class);
        if(iIndex<0){
            return Arrays.stream(tClass.getEnumConstants()).map((o)->o.toString()).toList();
        }
        else{
            GenericJpaController<?> jpaEnum = new GenericJpaController(tClass);
            return jpaEnum.findEntityEntities().stream().map((ent)->ent.toString()).toList();
        }
    }
    
    public static <T> Long getIdFromEnumClass(Class<T> tClass, String value){
        Pattern enumIdPat = Pattern.compile("\\[.+?\\].*");
        Matcher mat = enumIdPat.matcher(value);
        try{
            if(mat.find()){
                return Long.parseLong(mat.group(1));
            }
            else{
                return Long.valueOf(getEnumFromClass(tClass).indexOf(value));
            }
        }
        finally{
            return Long.valueOf(-1);
        }
    }
    
    public static <T extends GenericEntity> void LoadTableFromJPA(Class<T> eClass,JTable jTable){
        GenericJpaController<T> gjc = new GenericJpaController<>(eClass);
        List<T> list = gjc.findEntityEntities();
        DynamicTableModel tModel = (DynamicTableModel)jTable.getModel();
        tModel.setValues(list);
    }
    
    public static <T extends GenericEntity> void LoadTableFromList(List<T> list, JTable jTable){
        DynamicTableModel tModel = (DynamicTableModel)jTable.getModel();
        tModel.setValues(list);
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

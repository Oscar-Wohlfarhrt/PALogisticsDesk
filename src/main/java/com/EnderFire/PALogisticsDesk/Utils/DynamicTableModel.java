/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EnderFire.PALogisticsDesk.Utils;

import com.EnderFire.PALogisticsDesk.Controls.GenericJpaController;
import com.EnderFire.PALogisticsDesk.exceptions.NonexistentEntityException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import javax.persistence.Id;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Oscar2
 */

public class DynamicTableModel<T extends GenericEntity> extends AbstractTableModel implements TableModel {
    private Class<?>[] typesArr;
    private List<T> values = new ArrayList<>();
    private Field[] tFields;
    private Object filter;
    private Class<T> tClass;
    
    public DynamicTableModel(Class<T> tClass){
        this.tClass = tClass;
        tFields = DynamicTable.getDynTableFields(tClass).toArray(Field[]::new);
        for(Field f:tFields){
            f.setAccessible(true);
        }
        typesArr=((Stream<Class<?>>)DynamicTable.getDynTableFields(tClass).map((f)->f.getType())).toArray(Class<?>[]::new);
    }
    
    public void setColumnClass(int col,Class<?> tClass){
        typesArr[col]=tClass;
    }
    
    @Override
    public Class<?> getColumnClass(int column){
        return typesArr[column];
    }

    @Override
    public int getRowCount() {
        return values.size();
    }

    @Override
    public int getColumnCount() {
        return typesArr.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //return values.get(rowIndex).getValue(columnIndex);
        try{
            Object val = tFields[columnIndex].get(values.get(rowIndex));
            return typesArr[columnIndex].cast(val);
        }
        catch(IllegalArgumentException | IllegalAccessException | ClassCastException e){
            return new Object();
        }
        
    }
    
    public void setValues(List<T> newValues){
        values=newValues;
    }
    public List<T> getValues(){
        return values;
    }
    
    public void setValueAt(Object value, int row, int col){
        if (value!=null)
            System.out.println(value.getClass());
        else
            System.out.println("Es null");
        
        try{
            TableHeader tHead = typesArr[col].getAnnotation(TableHeader.class);
            if(Number.class.isAssignableFrom(typesArr[col])){
                tFields[col].set(values.get(row),value);
            }
            else if(GenericEntity.class.isAssignableFrom(typesArr[col])){
                GenericJpaController<?> jpa = new GenericJpaController(typesArr[col]);
                Pattern enumIdPat = Pattern.compile("\\[(.+?)\\].*");
                Matcher mat = enumIdPat.matcher((String)value);
                if(mat.find())
                    tFields[col].set(values.get(row),jpa.findEntity(Long.parseLong(mat.group(1))));
            }
            else if(typesArr[col].isEnum()){
                int index = Arrays.stream(typesArr[col].getEnumConstants()).map((o)->o.toString()).toList().indexOf(value);
                System.out.println(index);
                tFields[col].set(values.get(row),typesArr[col].getEnumConstants()[index]);
            }
            else{
                tFields[col].set(values.get(row),value);
            }
        }
        catch(Exception e){
        }
    }
    
    public void addRow(T row){
        values.add(row);
    }
    
    public void clearValues(){
        values.clear();
    }
    
    public boolean isCellEditable(int row, int col) {
        return !tFields[col].isAnnotationPresent(Id.class);
    }
}

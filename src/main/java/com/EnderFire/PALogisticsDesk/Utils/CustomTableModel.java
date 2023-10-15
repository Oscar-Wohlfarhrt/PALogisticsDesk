/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EnderFire.PALogisticsDesk.Utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Oscar2
 */
public class CustomTableModel extends AbstractTableModel implements TableModel {
    private List<Class<?>> types = new ArrayList<>();
    private List<Object[]> values = new ArrayList<>();
    private Object filter;
    
    public void setColumnClass(int column,Class<?> classType){
        types.set(column, classType);
        for(int i =0;i<values.size();i++){
            values.get(i)[column]=Array.get(Array.newInstance(classType, 1),0);
        }
    }
    
    @Override
    public Class<?> getColumnClass(int column){
        return types.get(column);
    }

    @Override
    public int getRowCount() {
        return values.size();
    }
    
    public void setColumnCount(int size){
        types.clear();
        values.clear();
        List<Object> vals = new ArrayList<>();
        for(int i =0;i<size;i++){
            types.add(Object.class);
            vals.add("");
        }
       
        values.add(vals.toArray());
        values.add(vals.toArray());
        values.add(vals.toArray());
        values.add(vals.toArray());
    }

    @Override
    public int getColumnCount() {
        return types.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return values.get(rowIndex)[columnIndex];
    }
    
    public void setValueAt(Object value, int row, int col){
        values.get(row)[col]=value;
    }
    
    public void addRow(Object[] row){
        values.add(row);
    }
    public void setRow(int index, Object[] row){
        values.set(index, row);
    }
    public void clearValues(){
        values.clear();
    }
    
    public boolean isCellEditable(int row, int col) {
        if (col < 1) {
            return false;
        } else {
            return true;
        }
    }
}

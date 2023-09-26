/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EnderFire.PALogisticsDesk.Utils;

import java.util.Arrays;
import java.util.stream.Stream;
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
        TableColumnModel cModel = jTable.getColumnModel();
        
        TableHeader[] headers = (TableHeader[])getTableHeadersAnnotation().toArray();
        
        for(TableHeader header:headers){
            TableColumn tCol = cModel.getColumn(0);
            tCol.setHeaderValue(header.name());
            if(header.columnSize()>0)
                tCol.setWidth(header.columnSize());
            switch(header.columnType()){
                case ColumnType.COMBOBOX:
                    break;
                case ColumnType.CHECKBOX:
                    break;
                default:
                    break;
            }
        }
        
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

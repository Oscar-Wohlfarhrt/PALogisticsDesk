/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EnderFire.PALogisticsDesk.Utils;

/**
 *
 * @author Oscar2
 */
public @interface TableHeader {
    String name();
    int columnType() default ColumnType.TEXTFIELD;
    int columnSize() default -1;
}
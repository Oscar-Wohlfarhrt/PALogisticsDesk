/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.EnderFire.PALogisticsDesk;

import com.EnderFire.PALogisticsDesk.Controls.GenericJpaController;
import com.EnderFire.PALogisticsDesk.Models.*;
import com.EnderFire.PALogisticsDesk.Utils.DynamicTable;
import com.EnderFire.PALogisticsDesk.Views.UserSelectForm;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JTable;

/**
 *
 * @author Oscar2
 */
public class PALogisticsDesk {
    
    public static void main(String[] args) {
        new UserSelectForm().setVisible(true);
    }
}

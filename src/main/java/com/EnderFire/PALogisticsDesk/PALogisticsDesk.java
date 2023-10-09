/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.EnderFire.PALogisticsDesk;

import com.EnderFire.PALogisticsDesk.Controls.ClientJpaController;
import com.EnderFire.PALogisticsDesk.Controls.GenericJpaController;
import com.EnderFire.PALogisticsDesk.Models.*;
import com.EnderFire.PALogisticsDesk.Utils.DynamicTable;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JTable;

/**
 *
 * @author Oscar2
 */
public class PALogisticsDesk {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PALogisticsDeskPU");
    public static void main(String[] args) {
        //DynamicTable<Client> test = new DynamicTable<>(Client.class);
        //test.setJTableModels(new JTable());
        GenericJpaController<Client> cjc=new GenericJpaController(Client.class);
        
        System.out.println("Hello World!");
        Client test = new Client();
        test.setId(1L);
        test.setName("Oscar Wohlfarhrt 4");
        Pedido ped = new Pedido();
        ped.setName("Pedido 3");
        ped.setClient(test);
        //ped.setId(1L);
        test.getPedidos().add(ped);
        Client test2 = new Client();
        test2.setId(2L);
        test2.setName("Oscar Wohlfarhrt 5");
        Pedido ped2 = new Pedido();
        ped2.setName("Pedido 4");
        ped2.setClient(test2);
        //ped.setId(1L);
        test2.getPedidos().add(ped2);
        ped2 = new Pedido();
        ped2.setName("Pedido 20");
        ped2.setClient(test2);
        //ped.setId(1L);
        test2.getPedidos().add(ped2);
        cjc.create(test);
        cjc.create(test2);
        
        List<Client> clis = cjc.findEntityEntities();
        for(Client c:clis){
            System.out.println(c.getName());
            for(Pedido p:c.getPedidos()){
                System.out.println(p.getName());
            }
        }
    }
    
    public static EntityManagerFactory getEntityManagerFactory(){
        return emf;
    }
}

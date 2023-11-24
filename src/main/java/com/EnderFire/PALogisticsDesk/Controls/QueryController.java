/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EnderFire.PALogisticsDesk.Controls;

import com.EnderFire.PALogisticsDesk.Models.*;
import java.util.List;
import com.EnderFire.PALogisticsDesk.Controls.GenericJpaController.*;
import java.util.ArrayList;
import javax.persistence.EntityManager;

/**
 *
 * @author nicol
 */
public class QueryController {

    public QueryController() {
    }

    public static void qtest2() {//ahcer que esto no sea static (me daba pereza importar para la prueba
        GenericJpaController<Pedido> pJPA = new GenericJpaController<>(Pedido.class);
        List<Pedido> resultados = pJPA.findEntityEntities();

        for (Pedido infoPedido : resultados) {
            System.out.println(infoPedido.getId());
        }
    }

    //INFORME DE PEDIDOS
    public static Integer informePedidosND() {
        GenericJpaController<Pedido> pJPA = new GenericJpaController<>(Pedido.class);
        Integer count = 0;
        List<Pedido> resultados = pJPA.findEntityEntities();
        for (Pedido infoPedido : resultados) {
            if (infoPedido.getState() == EstadosPedido.NoDespachado) {//no funciona con un switch
                count++;
            }
        }
        return count;
    }

    public static Integer informePedidosD() {
        GenericJpaController<Pedido> pJPA = new GenericJpaController<>(Pedido.class);
        Integer count = 0;
        List<Pedido> resultados = pJPA.findEntityEntities();
        for (Pedido infoPedido : resultados) {
            if (infoPedido.getState() == EstadosPedido.Despachado) {//no funciona con un switch
                count++;
            }
        }
        return count;
    }

    public static Integer informePedidosE() {
        GenericJpaController<Pedido> pJPA = new GenericJpaController<>(Pedido.class);
        Integer count = 0;
        List<Pedido> resultados = pJPA.findEntityEntities();
        for (Pedido infoPedido : resultados) {
            if (infoPedido.getState() == EstadosPedido.Entregado) {//no funciona con un switch
                count++;
            }
        }
        return count;
    }
/**
 * Esta funcion la proceso en java solo para mostrar que se puede filtrar aca pero tranquilamente podria traer solo los EnCamino o directamente el numero pero es un tp de POO
 * @return Integer
 */
    public Integer informePedidosEC() {
        GenericJpaController<Pedido> pJPA = new GenericJpaController<>(Pedido.class);
        Integer count = 0;
        List<Pedido> resultados = pJPA.findEntityEntities();
        for (Pedido infoPedido : resultados) {
            if (infoPedido.getState() == EstadosPedido.EnCamino) {//no funciona con un switch
                count++;
            }
        }
        return count;
    }

}

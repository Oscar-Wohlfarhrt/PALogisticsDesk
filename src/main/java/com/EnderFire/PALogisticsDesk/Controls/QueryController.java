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

        EntityManager entityManager = GenericJpaController.getEMF().createEntityManager();
        DAO dao = new DAO(entityManager);

        List<Pedido> resultados = dao.obtenerTodosPedidos();

        for (Pedido infoPedido : resultados) {
            System.out.println(infoPedido.getId());
        }

        entityManager.close();

    }

    //INFORME DE PEDIDOS
    public static Integer informePedidosND() {
        EntityManager entityManager = GenericJpaController.getEMF().createEntityManager();
        DAO dao = new DAO(entityManager);
        Integer count = 0;
        //ArrayList<Integer> informe = new ArrayList<>();
        List<Pedido> resultados = dao.obtenerTodosPedidos();
        for (Pedido infoPedido : resultados) {
            if (infoPedido.getState() == EstadosPedido.NoDespachado) {//no funciona con un switch
                count++;
            }
        }
        return count;
    }

    public static Integer informePedidosD() {
        EntityManager entityManager = GenericJpaController.getEMF().createEntityManager();
        DAO dao = new DAO(entityManager);
        Integer count = 0;
        //ArrayList<Integer> informe = new ArrayList<>();
        List<Pedido> resultados = dao.obtenerTodosPedidos();
        for (Pedido infoPedido : resultados) {
            if (infoPedido.getState() == EstadosPedido.Despachado) {//no funciona con un switch
                count++;
            }
        }
        return count;
    }

    public static Integer informePedidosE() {
        EntityManager entityManager = GenericJpaController.getEMF().createEntityManager();
        DAO dao = new DAO(entityManager);
        Integer count = 0;
        //ArrayList<Integer> informe = new ArrayList<>();
        List<Pedido> resultados = dao.obtenerTodosPedidos();
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
        EntityManager entityManager = GenericJpaController.getEMF().createEntityManager();
        DAO dao = new DAO(entityManager);
        Integer count = 0;
        //ArrayList<Integer> informe = new ArrayList<>();
        List<Pedido> resultados = dao.obtenerTodosPedidos();
        for (Pedido infoPedido : resultados) {
            if (infoPedido.getState() == EstadosPedido.EnCamino) {//no funciona con un switch
                count++;
            }
        }
        return count;
    }

}

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
    public Integer informePedidosND() {
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

    public Integer informePedidosD() {
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

    public Integer informePedidosE() {
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

    public Float informeCostosTotalesTansoportistas() {
        EntityManager entityManager = GenericJpaController.getEMF().createEntityManager();
        DAO dao = new DAO(entityManager);
        Float costos = 0f;
        List<Transportista> resultados = dao.obtenerTodosTransportistas();
        for (Transportista t : resultados) {
            costos += t.getCosts();
        }
        entityManager.close();
        return costos;
    }

    public Float informeSalariosTotalesTansoportistas() {
        EntityManager entityManager = GenericJpaController.getEMF().createEntityManager();
        DAO dao = new DAO(entityManager);
        Float salario = 0f;
        List<Transportista> resultados = dao.obtenerTodosTransportistas();
        for (Transportista t : resultados) {
            salario += t.getSalary();
        }
        entityManager.close();
        return salario;
    }

    public Integer informeRutas() {
        GenericJpaController<Ruta> pJPA = new GenericJpaController<>(Ruta.class);
        EntityManager entityManager = GenericJpaController.getEMF().createEntityManager();
        DAO dao = new DAO(entityManager);
        Integer count = 0;
        List<Ruta> resultados = pJPA.findEntityEntities();
        List<Transportista> transportistas = new ArrayList<>();
        for (Ruta r : resultados) {
            transportistas = dao.obtenerTransportitasPorRuta(r);
        }
        return count;
    }

}

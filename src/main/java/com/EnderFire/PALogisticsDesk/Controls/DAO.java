/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EnderFire.PALogisticsDesk.Controls;

import com.EnderFire.PALogisticsDesk.Models.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

//estas consultas podrian ser mas flexibles para mayor reutilizacion pero no creo que las vaya usar mucho
/**
 *
 * @author nicol
 */
public class DAO {

    private final EntityManager entityManager;

    public DAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private List<Pedido> obtenerTodosPedidos() {
        String jpql = "SELECT p FROM Pedido p";
        TypedQuery<Pedido> consulta = entityManager.createQuery(jpql, Pedido.class);
        return consulta.getResultList();
    }

    public List<Transportista> obtenerTodosTransportistas() {
        String jpql = "SELECT t FROM Transportista t";
        TypedQuery<Transportista> consulta = entityManager.createQuery(jpql, Transportista.class);
        return consulta.getResultList();
    }

    public List<Proveedor> obtenerTodosProveedores() {
        String jpql = "SELECT p FROM Proveedor p";
        TypedQuery<Proveedor> consulta = entityManager.createQuery(jpql, Proveedor.class);
        return consulta.getResultList();
    }

    public List<RendimientoProveedor> obtenerTodosRendimientoProveedores() {
        String jpql = "SELECT rp FROM RendimientoProveedor rp";
        TypedQuery<RendimientoProveedor> consulta = entityManager.createQuery(jpql, RendimientoProveedor.class);
        return consulta.getResultList();
    }

    /**
     * Esto trael el rendimiento del proveedor asociado
     *
     * @param proveedor
     * @return RendimientoProveedor
     */
    public RendimientoProveedor obtenerRendimientoPorProveedor(Proveedor proveedor) {
        String jpql = "SELECT rp FROM RendimientoProveedor rp WHERE rp.proveedor = :proveedor";
        TypedQuery<RendimientoProveedor> consulta = entityManager.createQuery(jpql, RendimientoProveedor.class);
        consulta.setParameter("proveedor", proveedor);
        List<RendimientoProveedor> resultados = consulta.getResultList();
        return resultados.isEmpty() ? null : resultados.get(0);
    }

    public List<Ruta> obtenerTodosRutas() {
        String jpql = "SELECT rp FROM RendimientoProveedor rp";
        TypedQuery<Ruta> consulta = entityManager.createQuery(jpql, Ruta.class);
        return consulta.getResultList();
    }
    
    public List<Transportista> obtenerTransportitasPorRuta(Ruta ruta){
        String jpql = "SELECT trp FROM Transportista trp WHERE trp.ruta = :ruta";
        TypedQuery<Transportista> consulta = entityManager.createQuery(jpql, Transportista.class);
        consulta.setParameter("ruta", ruta);
        return consulta.getResultList();
    }
    
}

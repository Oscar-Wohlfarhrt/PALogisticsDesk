/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EnderFire.PALogisticsDesk.Controls;

import com.EnderFire.PALogisticsDesk.Models.Pedido;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author nicol
 */
public class DAO {

    private final EntityManager entityManager;

    public DAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Pedido> obtenerTodosPedidos() {
        String jpql = "SELECT p FROM Pedido p";
        TypedQuery<Pedido> consulta = entityManager.createQuery(jpql, Pedido.class);
        return consulta.getResultList();
    }


}

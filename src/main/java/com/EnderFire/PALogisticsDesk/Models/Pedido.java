/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EnderFire.PALogisticsDesk.Models;

import com.EnderFire.PALogisticsDesk.Utils.GenericEntity;
import com.EnderFire.PALogisticsDesk.Utils.TableData;
import com.EnderFire.PALogisticsDesk.Utils.TableHeader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
//falta la relacion con mercancia

/**
 *
 * @author Oscar2
 */
@Entity
@TableData(name = "Pedidos")
public class Pedido implements Serializable, GenericEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableHeader(name = "ID", columnSize = 50)
    private Long id;

    @Column(name = "Nombre")
    @TableHeader(name = "Nombre", columnSize = 200)
    private String name;

    @TableHeader(name = "Estado", columnSize = 150)
    private EstadosPedido state = EstadosPedido.NoDespachado;
    @TableHeader(name = "Direccion de entrega", columnSize = 200)
    private String deliveryAddress = "Unknown";

    @TableHeader(name = "Id de Cliente", columnSize = 200)
    @ManyToOne(targetEntity = Cliente.class)
    private Cliente client;

    @ManyToOne
    @JoinColumn
    private Ubicacion location;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "pedido_id"), inverseJoinColumns = @JoinColumn(name = "mercancia_id"))
    private List<Mercancia> mercancias = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public Object[] getValues() {
        return new Object[]{id, name, state, deliveryAddress, String.format("[%d] %s", client.getId(), client.getName())};
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s", id, name);
    }

}

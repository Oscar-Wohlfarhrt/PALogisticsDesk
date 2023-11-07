/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EnderFire.PALogisticsDesk.Models;

import com.EnderFire.PALogisticsDesk.Utils.GenericEntity;
import com.EnderFire.PALogisticsDesk.Utils.TableHeader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Oscar2
 */
@Entity
public class Cliente implements Serializable, GenericEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableHeader(name = "DNI", columnSize = 50)
    private Long id;

    @Column(name = "Nombre")
    @TableHeader(name = "Nombre", columnSize = 300)
    private String name;

    @OneToMany(/*mappedBy = "client",*/targetEntity = Preferencia.class, cascade = CascadeType.ALL)
    List<Preferencia> preferencias = new ArrayList<>();

    @OneToMany(/*mappedBy = "client",*/targetEntity = Pedido.class, cascade = CascadeType.ALL)
    private List<Pedido> pedidos = new ArrayList<>();
    
    @OneToOne(cascade = CascadeType.ALL, targetEntity = InformacionContacto.class)
    //@JoinColumn(referencedColumnName = "id")
    private InformacionContacto contactInfo;
      
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

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public Object[] getValues() {
        return new Object[]{id, name};
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
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s", id, name);
        //return "com.EnderFire.PALogisticsDesk.Models.Client[ id=" + id + " ]";
    }

    /*@Override
    public Object getValue(int index) {
        switch(index){
            case 0:
                return id;
            case 1:
                return name;
            default:
                return "";
        }
    }

    @Override
    public void setValue(int index, Object value) {
        switch(index){
            case 0:
                id = (Long)value;
                break;
            case 1:
                name = (String)value;
                break;
            default:
                break;
        }
    }*/
}

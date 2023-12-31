/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EnderFire.PALogisticsDesk.Models;

import com.EnderFire.PALogisticsDesk.Utils.GenericEntity;
import com.EnderFire.PALogisticsDesk.Utils.TableData;
import com.EnderFire.PALogisticsDesk.Utils.TableHeader;
import java.io.Serializable;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Oscar2
 */
@Entity
@TableData(name = "Centros de Distribucion")
public class CentroDistribucion implements Serializable, GenericEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @TableHeader(name = "ID", columnSize = 50)
    private Long id;
    @TableHeader(name = "Nombre",columnSize = 200)
    private String name;
    private Period timeOpen;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    @TableHeader(name = "Ubicacion",columnSize = 200)
    private Ubicacion location;
    
    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "crentroDistribucion_id"),inverseJoinColumns = @JoinColumn(name = "mercancia_id") )
    private List<Mercancia> mercancias = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Mercancia> getMercancias() {
        return mercancias;
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
        if (!(object instanceof CentroDistribucion)) {
            return false;
        }
        CentroDistribucion other = (CentroDistribucion) object;
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

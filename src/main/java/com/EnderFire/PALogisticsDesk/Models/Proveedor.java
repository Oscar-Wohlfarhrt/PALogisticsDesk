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
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Oscar2 relaciones 5/5
 */
@Entity
@TableData(name = "Proveedores")
public class Proveedor implements Serializable, GenericEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableHeader(name = "ID", columnSize = 50)
    private Long id;
    @TableHeader(name = "Nombre",columnSize = 200)
    private String name;
    @TableHeader(name = "Marca de productos",columnSize = 200)
    private String productBrand;
    //Informacion contacto (relacion 1)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    @TableHeader(name = "Informacion de Contacto",columnSize = 200)
    private InformacionContacto contactInfo;
    //Mercancia(relacion 2)
    @ManyToMany
    private List<Mercancia> merch;
    //Rendimiento(relacion 3)
    @OneToOne(mappedBy = "suplier",targetEntity = RendimientoProveedor.class, cascade = CascadeType.ALL)/*rendimiento proveedor*/
    @TableHeader(name = "Rendimiento de Proveedor",columnSize = 200)
    private RendimientoProveedor performance;
    //OrdenCompra un proveedor muchas ordenes(relacion 4)
    @OneToMany(mappedBy = "suplier",targetEntity = OrdenCompra.class, cascade = CascadeType.ALL)
    List<OrdenCompra> order = new ArrayList<>();
    //Contrato(relacion5)
    @OneToMany(mappedBy = "suplier",targetEntity = Contrato.class, cascade = CascadeType.ALL)
    private List<Contrato> contratos = new ArrayList<>();

    public RendimientoProveedor getPerformance() {
        return performance;
    }
    
    public List<RendimientoProveedor> getPerformanceInList() {
        List<RendimientoProveedor> rp = new ArrayList<>();
        rp.add(performance);
        return rp;
    }

    public void setPerformance(RendimientoProveedor performance) {
        this.performance = performance;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
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
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EnderFire.PALogisticsDesk.Models;

import com.EnderFire.PALogisticsDesk.Utils.GenericEntity;
import com.EnderFire.PALogisticsDesk.Utils.TableData;
import com.EnderFire.PALogisticsDesk.Utils.TableHeader;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Oscar2
 */
@Entity
@TableData(name = "Redimiento de Proveedores")
public class RendimientoProveedor implements Serializable, GenericEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @TableHeader(name = "ID", columnSize = 50)
    private Long id;
    @TableHeader(name = "Calidad de producto",columnSize = 200)
    private Float productQuality=0f;
    @TableHeader(name = "Entregas a Tiempo",columnSize = 200)
    private Float inTimeP=0f;//P=porcentaje
    @TableHeader(name = "Errores de envio",columnSize = 200)
    private Float deliveryErrorsP=0f;//P=porcentaje
    
    @OneToOne(targetEntity = Proveedor.class,cascade = CascadeType.ALL)
    @TableHeader(name = "Proveedor",columnSize = 200)
    private Proveedor suplier;//estaba como suplier

    public Float getDeliveryErrors() {
        return deliveryErrorsP;
    }

    public Float getInTime() {
        return inTimeP;
    }

    public Float getProductQuality() {
        return productQuality;
    }

    public void setDeliveryErrors(Float deliveryErrorsP) {
        this.deliveryErrorsP = deliveryErrorsP;
    }

    public void setInTime(Float inTimeP) {
        this.inTimeP = inTimeP;
    }

    public void setProductQuality(Float productQuality) {
        this.productQuality = productQuality;
    }
    
    public void setProveedor(Proveedor proveedor) {
        this.suplier = proveedor;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof RendimientoProveedor)) {
            return false;
        }
        RendimientoProveedor other = (RendimientoProveedor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("[%d] Rendimiento de %s", id, suplier.getName());
    }
}

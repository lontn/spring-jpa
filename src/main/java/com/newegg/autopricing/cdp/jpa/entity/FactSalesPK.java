package com.newegg.autopricing.cdp.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;


public class FactSalesPK implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Column(name = "Date_Id", columnDefinition = "int", nullable = false)
    private Integer dateId;
    @Column(name = "Store_Id", columnDefinition = "int", nullable = false)
    private Integer storeId;
    @Column(name = "Product_Id", columnDefinition = "int", nullable = false)
    private Integer productId;

    public FactSalesPK() {
    }

    public FactSalesPK(Integer dateId, Integer storeId, Integer productId) {
        this.dateId = dateId;
        this.storeId = storeId;
        this.productId = productId;
    }

    public Integer getDateId() {
        return dateId;
    }
    public void setDateId(Integer dateId) {
        this.dateId = dateId;
    }
    public Integer getStoreId() {
        return storeId;
    }
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }
    public Integer getProductId() {
        return productId;
    }
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FactSalesPK) {
            FactSalesPK factSalesPKPK = (FactSalesPK) obj;
            if (this.dateId == factSalesPKPK.getDateId() && this.storeId == factSalesPKPK.getStoreId()
                    && this.productId == factSalesPKPK.getProductId()) {
                return true;
            }
        } else {
            return false;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

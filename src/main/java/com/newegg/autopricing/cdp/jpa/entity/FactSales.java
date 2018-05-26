package com.newegg.autopricing.cdp.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@javax.persistence.Entity
@IdClass(FactSalesPK.class)
@Table(name = "Fact_Sales")
public class FactSales extends Entity {

    @Id
//    @Column(name = "Date_Id", columnDefinition = "int", nullable = false)
    private Integer dateId;

    @Id
//    @Column(name = "Store_Id", columnDefinition = "int", nullable = false)
    private Integer storeId;

    @Id
//    @Column(name = "Product_Id", columnDefinition = "int", nullable = false)
    private Integer productId;

    @Column(name = "Units_Sold", columnDefinition = "int", nullable = false)
    @NotNull
    private Integer unitsSold;

    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.REMOVE,
            CascadeType.MERGE,
            CascadeType.REFRESH })
    @JoinColumn(name = "Product_Id", insertable = false, updatable = false)
    private DimProduct product;

    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.REMOVE,
            CascadeType.MERGE,
            CascadeType.REFRESH })
    @JoinColumn(name = "Date_Id", insertable = false, updatable = false)
    private DimDate date;

    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.REMOVE,
            CascadeType.MERGE,
            CascadeType.REFRESH })
    @JoinColumn(name = "Store_Id", insertable = false, updatable = false)
    private DimStore store;

    public FactSales() {
    }

    public FactSales(Integer unitsSold, DimProduct product, DimDate date,
            DimStore store) {
        this.unitsSold = unitsSold;
        this.product = product;
        this.date = date;
        this.store = store;
//        this.dateId = date.getId();
//        this.storeId = store.getId();
//        this.productId = product.getId();
    }

    public static FactSales newFactSales(Integer unitsSold, DimProduct product, DimDate date, DimStore store) {
        return new FactSales(unitsSold, product, date, store);
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

    public Integer getUnitsSold() {
        return unitsSold;
    }

    public void setUnitsSold(Integer unitsSold) {
        this.unitsSold = unitsSold;
    }

    public DimProduct getProduct() {
        return product;
    }

    public void setProduct(DimProduct product) {
        this.product = product;
    }

    public DimDate getDate() {
        return date;
    }

    public void setDate(DimDate date) {
        this.date = date;
    }

    public DimStore getStore() {
        return store;
    }

    public void setStore(DimStore store) {
        this.store = store;
    }
}

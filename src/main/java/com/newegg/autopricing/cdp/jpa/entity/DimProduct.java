package com.newegg.autopricing.cdp.jpa.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@javax.persistence.Entity
@Table(name = "Dim_Product")
public class DimProduct extends Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "EAN_Code", columnDefinition = "varchar", length = 50, nullable = false)
    @NotNull
    private String eanCode;
    
    @Column(name = "Product_Name", columnDefinition = "varchar", length = 100, nullable = false)
    @NotNull
    private String productName;
    
    @Column(name = "Brand", columnDefinition = "varchar", length = 30, nullable = false)
    @NotNull
    private String brand;

    public Integer getId() {
        return id;
    }

    public String getEanCode() {
        return eanCode;
    }

    public void setEanCode(String eanCode) {
        this.eanCode = eanCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

}

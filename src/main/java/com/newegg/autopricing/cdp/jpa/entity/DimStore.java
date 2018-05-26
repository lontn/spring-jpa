package com.newegg.autopricing.cdp.jpa.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@javax.persistence.Entity
@Table(name = "Dim_Store")
public class DimStore extends Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Store_Number", columnDefinition = "varchar", length = 50, nullable = false)
    @NotNull
    private String storeNumber;
    
    @Column(name = "State_Province", columnDefinition = "varchar", length = 50, nullable = false)
    @NotNull
    private String stateProvince;

    @Column(name = "Country", columnDefinition = "char", length = 3, nullable = false)
    @NotNull
    private String country;

    public String getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(String storeNumber) {
        this.storeNumber = storeNumber;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

}

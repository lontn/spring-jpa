package com.newegg.autopricing.cdp.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@javax.persistence.Entity
@Table(name = "TB_Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Name", columnDefinition = "varchar", length = 30, nullable = false)
    private String name;

    @Column(name = "Age", columnDefinition = "tinyint", nullable = false)
    @NotNull
    private int age;

    @OneToMany(fetch = FetchType.EAGER, targetEntity = EMail.class, cascade = { CascadeType.PERSIST, CascadeType.REMOVE,
            CascadeType.MERGE, CascadeType.REFRESH })
    @JoinColumns(value = { @JoinColumn(name = "PersonId", referencedColumnName = "Id", nullable = false) })
    // @Fetch(value = FetchMode.SUBSELECT)
    @OrderBy(value = "EMail Desc")
    private List<EMail> eMails = new ArrayList<EMail>();

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Phone.class, cascade = { CascadeType.PERSIST, CascadeType.REMOVE,
            CascadeType.MERGE, CascadeType.REFRESH })
    @JoinColumns(value = { @JoinColumn(name = "PersonId", referencedColumnName = "Id", nullable = false) })
    // @Fetch(value = FetchMode.SUBSELECT)
    private List<Phone> phones = new ArrayList<Phone>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<EMail> geteMails() {
        return eMails;
    }

    public void seteMails(List<EMail> eMails) {
        this.eMails = eMails;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

}

package com.newegg.autopricing.cdp.jpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@javax.persistence.Entity
@Table(name = "Dim_Date")
public class DimDate extends Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Date", columnDefinition = "datetime", nullable = false)
    @NotNull
    private Date date;

    @Column(name = "Day", columnDefinition = "int", nullable = false)
    @NotNull
    private int day;

    @Column(name = "Day_of_Week", columnDefinition = "int", nullable = false)
    @NotNull
    private int dayOfWeek;

    @Column(name = "Month", columnDefinition = "tinyint", nullable = false)
    @NotNull
    private int month;

    @Column(name = "Month_Name", columnDefinition = "varchar", length = 50, nullable = false)
    @NotNull
    private String monthName;

    @Column(name = "Quarter", columnDefinition = "varchar", length = 50, nullable = false)
    @NotNull
    private String quarter;

    @Column(name = "Quarter_Name", columnDefinition = "varchar", length = 50, nullable = false)
    @NotNull
    private String quarterName;

    @Column(name = "Year", columnDefinition = "int", nullable = false)
    @NotNull
    private int year;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }

    public String getQuarterName() {
        return quarterName;
    }

    public void setQuarterName(String quarterName) {
        this.quarterName = quarterName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

}

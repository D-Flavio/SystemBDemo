package com.example.SystemBDemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class ZTPSPFEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String chdrnum;
    private BigDecimal survalue;
    private String company;
    private String currency;
    private LocalDateTime validDate;

    public ZTPSPFEntity() {}

    public ZTPSPFEntity(String chdrnum, BigDecimal survalue, String company, String currency, LocalDateTime validDate) {
        this.chdrnum = chdrnum;
        this.survalue = survalue;
        this.company = company;
        this.currency = currency;
        this.validDate = validDate;
    }

    public String getChdrnum() {
        return chdrnum;
    }

    public void setChdrnum(String chdrnum) {
        this.chdrnum = chdrnum;
    }

    public BigDecimal getSurvalue() {
        return survalue;
    }

    public void setSurvalue(BigDecimal survalue) {
        this.survalue = survalue;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDateTime getValidDate() {
        return validDate;
    }

    public void setValidDate(LocalDateTime validDate) {
        this.validDate = validDate;
    }

    @Override
    public String toString() {
        return "ZTPSPFDTO{" +
                "id='" + id + '\'' +
                ", chdrnum='" + chdrnum + '\'' +
                ", survalue=" + survalue +
                ", company='" + company + '\'' +
                ", currency='" + currency + '\'' +
                ", validDate=" + validDate +
                '}';
    }
}

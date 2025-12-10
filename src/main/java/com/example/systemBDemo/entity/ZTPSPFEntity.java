package com.example.systemBDemo.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "survalues")
public class ZTPSPFEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="chdrnum")
    private String chdrNum;

    @Column(name="survalue")
    private BigDecimal surValue;

    @Column(name="company")
    private String company;

    @Column(name="currency")
    private String currency;

    @Column(name="validdate")
    private LocalDateTime validDate;

    public ZTPSPFEntity() {}

    public ZTPSPFEntity(String chdrNum, BigDecimal surValue, String company, String currency, LocalDateTime validDate) {
        this.chdrNum = chdrNum;
        this.surValue = surValue;
        this.company = company;
        this.currency = currency;
        this.validDate = validDate;
    }

    public String getChdrNum() {
        return chdrNum;
    }

    public void setChdrNum(String chdrNum) {
        this.chdrNum = chdrNum;
    }

    public BigDecimal getSurValue() {
        return surValue;
    }

    public void setSurValue(BigDecimal surValue) {
        this.surValue = surValue;
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
                ", chdrNum='" + chdrNum + '\'' +
                ", surValue=" + surValue +
                ", company='" + company + '\'' +
                ", currency='" + currency + '\'' +
                ", validDate=" + validDate +
                '}';
    }
}

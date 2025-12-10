package com.example.systemBDemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "policy")
public class CustomerCompanyPolicyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="chdrnum")
    private String chdrNum;

    @Column(name="cownnum")
    private String cownNum;

    @Column(name="ownername")
    private String ownerName;

    @Column(name="lifcnum")
    private String lifcNum;

    @Column(name="lifcname")
    private String lifcName;

    @Column(name="aracde")
    private String aracde;

    @Column(name="agntnum")
    private String agntNum;

    @Column(name="mailaddress")
    private String mailAddress;

    public CustomerCompanyPolicyEntity() {}

    public CustomerCompanyPolicyEntity(String chdrnum, String cownnum, String ownerName, String lifcNum, String lifcName, String aracde, String agntnum, String mailAddress) {
        this.chdrNum = chdrnum;
        this.cownNum = cownnum;
        this.ownerName = ownerName;
        this.lifcNum = lifcNum;
        this.lifcName = lifcName;
        this.aracde = aracde;
        this.agntNum = agntnum;
        this.mailAddress = mailAddress;
    }

    public String getChdrNum() {
        return chdrNum;
    }

    public void setChdrNum(String chdrNum) {
        this.chdrNum = chdrNum;
    }

    public String getCownNum() {
        return cownNum;
    }

    public void setCownNum(String cownNum) {
        this.cownNum = cownNum;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getLifcNum() {
        return lifcNum;
    }

    public void setLifcNum(String lifcNum) {
        this.lifcNum = lifcNum;
    }

    public String getLifcName() {
        return lifcName;
    }

    public void setLifcName(String lifcName) {
        this.lifcName = lifcName;
    }

    public String getAracde() {
        return aracde;
    }

    public void setAracde(String aracde) {
        this.aracde = aracde;
    }

    public String getAgntNum() {
        return agntNum;
    }

    public void setAgntNum(String agntNum) {
        this.agntNum = agntNum;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    @Override
    public String toString() {
        return "CustomerCompanyPolicyDTO{" +
                "id='" + id + '\'' +
                ", chdrNum='" + chdrNum + '\'' +
                ", cownNum='" + cownNum + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", lifcNum='" + lifcNum + '\'' +
                ", lifcName='" + lifcName + '\'' +
                ", aracde='" + aracde + '\'' +
                ", agntNum='" + agntNum + '\'' +
                ", mailAddress='" + mailAddress + '\'' +
                '}';
    }
}

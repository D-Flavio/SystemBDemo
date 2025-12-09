package com.example.SystemBDemo.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "outpay_header")
public class OutpayHeaderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="clntnum")
    private String clntNum;

    @Column(name="chdrnum")
    private String chrdNum;

    @Column(name="lettertype")
    private String letterType;

    @Column(name="printdate")
    private LocalDateTime printDate;

    @Column(name="dataid")
    private String dataId;

    @Column(name="clntname")
    private String clntName;

    @Column(name="clntaddress")
    private String clntAddress;

    @Column(name="regdate")
    private LocalDateTime regDate;

    @Column(name="benpercent")
    private BigDecimal benPercent;

    @Column(name="role1")
    private String role1;

    @Column(name="role2")
    private String role2;

    @Column(name="cownnum")
    private String cownNum;

    @Column(name="cownname")
    private String cownName;

    @Column(name="notice01")
    private String notice01;

    @Column(name="notice02")
    private String notice02;

    @Column(name="notice03")
    private String notice03;

    @Column(name="notice04")
    private String notice04;

    @Column(name="notice05")
    private String notice05;

    @Column(name="notice06")
    private String notice06;

    @Column(name="claim_id")
    private String claim_Id;

    @Column(name="tp2processdate")
    private LocalDateTime tP2ProcessDate;

    public OutpayHeaderEntity() {}

    public OutpayHeaderEntity(String clntnum, String chrdnum, String letterType, LocalDateTime printDate, String dataID, String clntName, String clntAddress, LocalDateTime regDate, BigDecimal benPercent, String role1, String role2, String cownNum, String cownName, String notice01, String notice02, String notice03, String notice04, String notice05, String notice06, String claim_ID, LocalDateTime tP2ProcessDate) {
        this.clntNum = clntnum;
        this.chrdNum = chrdnum;
        this.letterType = letterType;
        this.printDate = printDate;
        this.dataId = dataID;
        this.clntName = clntName;
        this.clntAddress = clntAddress;
        this.regDate = regDate;
        this.benPercent = benPercent;
        this.role1 = role1;
        this.role2 = role2;
        this.cownNum = cownNum;
        this.cownName = cownName;
        this.notice01 = notice01;
        this.notice02 = notice02;
        this.notice03 = notice03;
        this.notice04 = notice04;
        this.notice05 = notice05;
        this.notice06 = notice06;
        this.claim_Id = claim_ID;
        this.tP2ProcessDate = tP2ProcessDate;
    }

    public String getClntNum() {
        return clntNum;
    }

    public void setClntNum(String clntNum) {
        this.clntNum = clntNum;
    }

    public String getChrdNum() {
        return chrdNum;
    }

    public void setChrdNum(String chrdNum) {
        this.chrdNum = chrdNum;
    }

    public String getLetterType() {
        return letterType;
    }

    public void setLetterType(String letterType) {
        this.letterType = letterType;
    }

    public LocalDateTime getPrintDate() {
        return printDate;
    }

    public void setPrintDate(LocalDateTime printDate) {
        this.printDate = printDate;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getClntName() {
        return clntName;
    }

    public void setClntName(String clntName) {
        this.clntName = clntName;
    }

    public String getClntAddress() {
        return clntAddress;
    }

    public void setClntAddress(String clntAddress) {
        this.clntAddress = clntAddress;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    public BigDecimal getBenPercent() {
        return benPercent;
    }

    public void setBenPercent(BigDecimal benPercent) {
        this.benPercent = benPercent;
    }

    public String getRole1() {
        return role1;
    }

    public void setRole1(String role1) {
        this.role1 = role1;
    }

    public String getRole2() {
        return role2;
    }

    public void setRole2(String role2) {
        this.role2 = role2;
    }

    public String getCownNum() {
        return cownNum;
    }

    public void setCownNum(String cownNum) {
        this.cownNum = cownNum;
    }

    public String getCownName() {
        return cownName;
    }

    public void setCownName(String cownName) {
        this.cownName = cownName;
    }

    public String getNotice01() {
        return notice01;
    }

    public void setNotice01(String notice01) {
        this.notice01 = notice01;
    }

    public String getNotice02() {
        return notice02;
    }

    public void setNotice02(String notice02) {
        this.notice02 = notice02;
    }

    public String getNotice03() {
        return notice03;
    }

    public void setNotice03(String notice03) {
        this.notice03 = notice03;
    }

    public String getNotice04() {
        return notice04;
    }

    public void setNotice04(String notice04) {
        this.notice04 = notice04;
    }

    public String getNotice05() {
        return notice05;
    }

    public void setNotice05(String notice05) {
        this.notice05 = notice05;
    }

    public String getNotice06() {
        return notice06;
    }

    public void setNotice06(String notice06) {
        this.notice06 = notice06;
    }

    public String getClaim_Id() {
        return claim_Id;
    }

    public void setClaim_Id(String claim_Id) {
        this.claim_Id = claim_Id;
    }

    public LocalDateTime gettP2ProcessDate() {
        return tP2ProcessDate;
    }

    public void settP2ProcessDate(LocalDateTime tP2ProcessDate) {
        this.tP2ProcessDate = tP2ProcessDate;
    }

    @Override
    public String toString() {
        return "OutpayHeaderDTO{" +
                "id='" + id + '\'' +
                ", clntNum='" + clntNum + '\'' +
                ", chrdNum='" + chrdNum + '\'' +
                ", letterType='" + letterType + '\'' +
                ", printDate=" + printDate +
                ", dataId='" + dataId + '\'' +
                ", clntName='" + clntName + '\'' +
                ", clntAddress='" + clntAddress + '\'' +
                ", regDate=" + regDate +
                ", benPercent=" + benPercent +
                ", role1='" + role1 + '\'' +
                ", role2='" + role2 + '\'' +
                ", cownNum='" + cownNum + '\'' +
                ", cownName='" + cownName + '\'' +
                ", notice01='" + notice01 + '\'' +
                ", notice02='" + notice02 + '\'' +
                ", notice03='" + notice03 + '\'' +
                ", notice04='" + notice04 + '\'' +
                ", notice05='" + notice05 + '\'' +
                ", notice06='" + notice06 + '\'' +
                ", claim_Id='" + claim_Id + '\'' +
                ", tP2ProcessDate=" + tP2ProcessDate +
                '}';
    }
}

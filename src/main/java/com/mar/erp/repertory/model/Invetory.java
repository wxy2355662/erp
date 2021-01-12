package com.mar.erp.repertory.model;

public class Invetory {
    private Long iId;

    private Long gId;

    private Long stId;

    private Long iNum;

    private String iType;

    private String iStatus;

    private String iRemark;

    public Invetory(Long iId, Long gId, Long stId, Long iNum, String iType, String iStatus, String iRemark) {
        this.iId = iId;
        this.gId = gId;
        this.stId = stId;
        this.iNum = iNum;
        this.iType = iType;
        this.iStatus = iStatus;
        this.iRemark = iRemark;
    }

    public Invetory() {
        super();
    }

    public Long getiId() {
        return iId;
    }

    public void setiId(Long iId) {
        this.iId = iId;
    }

    public Long getgId() {
        return gId;
    }

    public void setgId(Long gId) {
        this.gId = gId;
    }

    public Long getStId() {
        return stId;
    }

    public void setStId(Long stId) {
        this.stId = stId;
    }

    public Long getiNum() {
        return iNum;
    }

    public void setiNum(Long iNum) {
        this.iNum = iNum;
    }

    public String getiType() {
        return iType;
    }

    public void setiType(String iType) {
        this.iType = iType;
    }

    public String getiStatus() {
        return iStatus;
    }

    public void setiStatus(String iStatus) {
        this.iStatus = iStatus;
    }

    public String getiRemark() {
        return iRemark;
    }

    public void setiRemark(String iRemark) {
        this.iRemark = iRemark;
    }
}
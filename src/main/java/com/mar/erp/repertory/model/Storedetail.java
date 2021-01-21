package com.mar.erp.repertory.model;

public class Storedetail {
    private Long sdId;

    private Long srId;

    private Long gId;

    private Long sdNum;

    private Long Num;

    public Long getNum() {
        return Num;
    }

    public void setNum(Long num) {
        Num = num;
    }

    public Storedetail(Long sdId, Long srId, Long gId, Long sdNum) {
        this.sdId = sdId;
        this.srId = srId;
        this.gId = gId;
        this.sdNum = sdNum;
    }

    public Storedetail() {
        super();
    }

    public Long getSdId() {
        return sdId;
    }

    public void setSdId(Long sdId) {
        this.sdId = sdId;
    }

    public Long getSrId() {
        return srId;
    }

    public void setSrId(Long srId) {
        this.srId = srId;
    }

    public Long getgId() {
        return gId;
    }

    public void setgId(Long gId) {
        this.gId = gId;
    }

    public Long getSdNum() {
        return sdNum;
    }

    public void setSdNum(Long sdNum) {
        this.sdNum = sdNum;
    }
}
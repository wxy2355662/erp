package com.mar.erp.basics.model;

public class GoodsType {
    private Long tId;

    private String tName;

    public GoodsType(Long tId, String tName) {
        this.tId = tId;
        this.tName = tName;
    }

    public GoodsType() {
        super();
    }

    public Long gettId() {
        return tId;
    }

    public void settId(Long tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }
}
package com.mar.erp.basics.model;

public class Goods {
    private Long gId;

    private String gName;

    private String gAddress;

    private String gProducer;

    private String gUnit;

    private Long gInprice;

    private Long gOutprice;

    private Long tId;

    public Goods(Long gId, String gName, String gAddress, String gProducer, String gUnit, Long gInprice, Long gOutprice, Long tId) {
        this.gId = gId;
        this.gName = gName;
        this.gAddress = gAddress;
        this.gProducer = gProducer;
        this.gUnit = gUnit;
        this.gInprice = gInprice;
        this.gOutprice = gOutprice;
        this.tId = tId;
    }

    public Goods() {
        super();
    }

    public Long getgId() {
        return gId;
    }

    public void setgId(Long gId) {
        this.gId = gId;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public String getgAddress() {
        return gAddress;
    }

    public void setgAddress(String gAddress) {
        this.gAddress = gAddress;
    }

    public String getgProducer() {
        return gProducer;
    }

    public void setgProducer(String gProducer) {
        this.gProducer = gProducer;
    }

    public String getgUnit() {
        return gUnit;
    }

    public void setgUnit(String gUnit) {
        this.gUnit = gUnit;
    }

    public Long getgInprice() {
        return gInprice;
    }

    public void setgInprice(Long gInprice) {
        this.gInprice = gInprice;
    }

    public Long getgOutprice() {
        return gOutprice;
    }

    public void setgOutprice(Long gOutprice) {
        this.gOutprice = gOutprice;
    }

    public Long gettId() {
        return tId;
    }

    public void settId(Long tId) {
        this.tId = tId;
    }
}
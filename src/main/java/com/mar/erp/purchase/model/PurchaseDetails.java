package com.mar.erp.purchase.model;

public class PurchaseDetails {
    private Long piId;

    private Long piGoodId;

    private String piGoodName;

    private Long piPrice;

    private Long piNum;

    private Long piMoery;

    private Long piState;

    private Long piOid;

    private Long piRid;

    public PurchaseDetails(Long piId, Long piGoodId, String piGoodName, Long piPrice, Long piNum, Long piMoery, Long piState, Long piOid, Long piRid) {
        this.piId = piId;
        this.piGoodId = piGoodId;
        this.piGoodName = piGoodName;
        this.piPrice = piPrice;
        this.piNum = piNum;
        this.piMoery = piMoery;
        this.piState = piState;
        this.piOid = piOid;
        this.piRid = piRid;
    }

    public PurchaseDetails() {
        super();
    }

    public Long getPiId() {
        return piId;
    }

    public void setPiId(Long piId) {
        this.piId = piId;
    }

    public Long getPiGoodId() {
        return piGoodId;
    }

    public void setPiGoodId(Long piGoodId) {
        this.piGoodId = piGoodId;
    }

    public String getPiGoodName() {
        return piGoodName;
    }

    public void setPiGoodName(String piGoodName) {
        this.piGoodName = piGoodName;
    }

    public Long getPiPrice() {
        return piPrice;
    }

    public void setPiPrice(Long piPrice) {
        this.piPrice = piPrice;
    }

    public Long getPiNum() {
        return piNum;
    }

    public void setPiNum(Long piNum) {
        this.piNum = piNum;
    }

    public Long getPiMoery() {
        return piMoery;
    }

    public void setPiMoery(Long piMoery) {
        this.piMoery = piMoery;
    }

    public Long getPiState() {
        return piState;
    }

    public void setPiState(Long piState) {
        this.piState = piState;
    }

    public Long getPiOid() {
        return piOid;
    }

    public void setPiOid(Long piOid) {
        this.piOid = piOid;
    }

    public Long getPiRid() {
        return piRid;
    }

    public void setPiRid(Long piRid) {
        this.piRid = piRid;
    }

    @Override
    public String toString() {
        return "PurchaseDetails{" +
                "piId=" + piId +
                ", piGoodId=" + piGoodId +
                ", piGoodName='" + piGoodName + '\'' +
                ", piPrice=" + piPrice +
                ", piNum=" + piNum +
                ", piMoery=" + piMoery +
                ", piState=" + piState +
                ", piOid=" + piOid +
                ", piRid=" + piRid +
                '}';
    }
}
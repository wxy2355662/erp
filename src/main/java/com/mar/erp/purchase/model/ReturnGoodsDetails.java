package com.mar.erp.purchase.model;

public class ReturnGoodsDetails {
    private Long rgId;

    private Long rgGoodId;

    private String rgGoodName;

    private Long rgPrice;

    private Long rgNum;

    private Long rgMoery;

    private Integer rgState;

    private Long rgOid;

    private Long warehouseId;

    public ReturnGoodsDetails(Long rgId, Long rgGoodId, String rgGoodName, Long rgPrice, Long rgNum, Long rgMoery, Integer rgState, Long rgOid, Long warehouseId) {
        this.rgId = rgId;
        this.rgGoodId = rgGoodId;
        this.rgGoodName = rgGoodName;
        this.rgPrice = rgPrice;
        this.rgNum = rgNum;
        this.rgMoery = rgMoery;
        this.rgState = rgState;
        this.rgOid = rgOid;
        this.warehouseId = warehouseId;
    }

    public ReturnGoodsDetails() {
        super();
    }

    public Long getRgId() {
        return rgId;
    }

    public void setRgId(Long rgId) {
        this.rgId = rgId;
    }

    public Long getRgGoodId() {
        return rgGoodId;
    }

    public void setRgGoodId(Long rgGoodId) {
        this.rgGoodId = rgGoodId;
    }

    public String getRgGoodName() {
        return rgGoodName;
    }

    public void setRgGoodName(String rgGoodName) {
        this.rgGoodName = rgGoodName;
    }

    public Long getRgPrice() {
        return rgPrice;
    }

    public void setRgPrice(Long rgPrice) {
        this.rgPrice = rgPrice;
    }

    public Long getRgNum() {
        return rgNum;
    }

    public void setRgNum(Long rgNum) {
        this.rgNum = rgNum;
    }

    public Long getRgMoery() {
        return rgMoery;
    }

    public void setRgMoery(Long rgMoery) {
        this.rgMoery = rgMoery;
    }

    public Integer getRgState() {
        return rgState;
    }

    public void setRgState(Integer rgState) {
        this.rgState = rgState;
    }

    public Long getRgOid() {
        return rgOid;
    }

    public void setRgOid(Long rgOid) {
        this.rgOid = rgOid;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }
}
package com.mar.erp.sell.model;

public class OrderOutDetails {
    private Long oroId;

    private Long oroGoodId;

    private String oroGoodName;

    private Long oroGoodPrice;

    private Integer oroGoodCount;

    private Long oroOrderId;

    private Long oroMoney;

    private Integer oroState;

    private Long oId;

    private Long warehouseId;

    public OrderOutDetails(Long oroId, Long oroGoodId, String oroGoodName, Long oroGoodPrice, Integer oroGoodCount, Long oroOrderId, Long oroMoney, Integer oroState, Long oId, Long warehouseId) {
        this.oroId = oroId;
        this.oroGoodId = oroGoodId;
        this.oroGoodName = oroGoodName;
        this.oroGoodPrice = oroGoodPrice;
        this.oroGoodCount = oroGoodCount;
        this.oroOrderId = oroOrderId;
        this.oroMoney = oroMoney;
        this.oroState = oroState;
        this.oId = oId;
        this.warehouseId = warehouseId;
    }

    public OrderOutDetails() {
        super();
    }

    public Long getOroId() {
        return oroId;
    }

    public void setOroId(Long oroId) {
        this.oroId = oroId;
    }

    public Long getOroGoodId() {
        return oroGoodId;
    }

    public void setOroGoodId(Long oroGoodId) {
        this.oroGoodId = oroGoodId;
    }

    public String getOroGoodName() {
        return oroGoodName;
    }

    public void setOroGoodName(String oroGoodName) {
        this.oroGoodName = oroGoodName;
    }

    public Long getOroGoodPrice() {
        return oroGoodPrice;
    }

    public void setOroGoodPrice(Long oroGoodPrice) {
        this.oroGoodPrice = oroGoodPrice;
    }

    public Integer getOroGoodCount() {
        return oroGoodCount;
    }

    public void setOroGoodCount(Integer oroGoodCount) {
        this.oroGoodCount = oroGoodCount;
    }

    public Long getOroOrderId() {
        return oroOrderId;
    }

    public void setOroOrderId(Long oroOrderId) {
        this.oroOrderId = oroOrderId;
    }

    public Long getOroMoney() {
        return oroMoney;
    }

    public void setOroMoney(Long oroMoney) {
        this.oroMoney = oroMoney;
    }

    public Integer getOroState() {
        return oroState;
    }

    public void setOroState(Integer oroState) {
        this.oroState = oroState;
    }

    public Long getoId() {
        return oId;
    }

    public void setoId(Long oId) {
        this.oId = oId;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }
}
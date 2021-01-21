package com.mar.erp.sell.model;

public class OrderOutDetails {
    //退货明细编号
    private Long oroId;
    //商品编号
    private Long oroGoodId;
    //商品名称
    private String oroGoodName;
    //商品价格
    private Long oroGoodPrice;
    //商品数量
    private Integer oroGoodCount;
    //订单编号
    private Long oroOrderId;
    //总金额
    private Long oroMoney;
    //退货状态
    private Integer oroState;
    //退货订单编号
    private Long oId;
    //仓库号
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
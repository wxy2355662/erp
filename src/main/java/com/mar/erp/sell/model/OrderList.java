package com.mar.erp.sell.model;

public class OrderList {
    //订单明细编号
    private Long olId;
    //订单编号
    private Long orderId;
    //商品编号
    private Long  goodId;
    //商品名称
    private String goodName;
    //商品单价
    private Long goodPrice;
    //商品数量
    private Long goodCount;
    //商品总金额
    private Long goodMoney;
    //商品状态
    private Integer goodType;
    //退货订单编号
    private Long goodOid;



    public OrderList(Long olId, Long orderId, Long goodId, String goodName, Long goodPrice, Long goodCount, Long goodMoney, Integer goodType, Long goodOid) {
        this.olId = olId;
        this.orderId = orderId;
        this.goodId = goodId;
        this.goodName = goodName;
        this.goodPrice = goodPrice;
        this.goodCount = goodCount;
        this.goodMoney = goodMoney;
        this.goodType = goodType;
        this.goodOid = goodOid;
    }

    public OrderList() {
        super();
    }

    public Long getOlId() {
        return olId;
    }

    public void setOlId(Long olId) {
        this.olId = olId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getGoodId() {
        return goodId;
    }

    public void setGoodId(Long goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public Long getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(Long goodPrice) {
        this.goodPrice = goodPrice;
    }

    public Long getGoodCount() {
        return goodCount;
    }

    public void setGoodCount(Long goodCount) {
        this.goodCount = goodCount;
    }

    public Long getGoodMoney() {
        return goodMoney;
    }

    public void setGoodMoney(Long goodMoney) {
        this.goodMoney = goodMoney;
    }

    public Integer getGoodType() {
        return goodType;
    }

    public void setGoodType(Integer goodType) {
        this.goodType = goodType;
    }

    public Long getGoodOid() {
        return goodOid;
    }

    public void setGoodOid(Long goodOid) {
        this.goodOid = goodOid;
    }
}
package com.mar.erp.sell.Vo;

import com.mar.erp.sell.model.OrderOutDetails;

/**
 * 退货订单Vo类
 */
public class OrderOutListVo extends OrderOutDetails {
    //商品单价
    private Long goodPrice;


    private Long orderId;
    //商品编号
    private Long goodId;
    //商品名称
    private String goodName;
    //商品价格
    private Long goodMoney;
    //商品数量
    private Integer goodCount;

    //订单明细编号
    private Long olId;
    //商品状态
    private Integer goodType;

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

    public Long getGoodMoney() {
        return goodMoney;
    }

    public void setGoodMoney(Long goodMoney) {
        this.goodMoney = goodMoney;
    }

    public Integer getGoodCount() {
        return goodCount;
    }

    public void setGoodCount(Integer goodCount) {
        this.goodCount = goodCount;
    }

    public Long getOlId() {
        return olId;
    }

    public void setOlId(Long olId) {
        this.olId = olId;
    }

    public Integer getGoodType() {
        return goodType;
    }

    public void setGoodType(Integer goodType) {
        this.goodType = goodType;
    }
    public Long getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(Long goodPrice) {
        this.goodPrice = goodPrice;
    }

    @Override
    public String toString() {
        return "OrderOutListVo{" +
                "goodPrice=" + goodPrice +
                ", orderId=" + orderId +
                ", goodId=" + goodId +
                ", goodName='" + goodName + '\'' +
                ", goodMoney=" + goodMoney +
                ", goodCount=" + goodCount +
                ", olId=" + olId +
                ", goodType=" + goodType +
                '}';
    }
}

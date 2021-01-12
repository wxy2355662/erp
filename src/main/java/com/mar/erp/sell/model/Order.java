package com.mar.erp.sell.model;

import java.util.Date;

public class Order {
    private Long orderId;

    private Long orderCid;

    private Date orderCreate;

    private String orderCreatePerson;

    private String orderYdh;

    private Long orderMoney;

    private Long orderStatc;

    public Order(Long orderId, Long orderCid, Date orderCreate, String orderCreatePerson, String orderYdh, Long orderMoney, Long orderStatc) {
        this.orderId = orderId;
        this.orderCid = orderCid;
        this.orderCreate = orderCreate;
        this.orderCreatePerson = orderCreatePerson;
        this.orderYdh = orderYdh;
        this.orderMoney = orderMoney;
        this.orderStatc = orderStatc;
    }

    public Order() {
        super();
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderCid() {
        return orderCid;
    }

    public void setOrderCid(Long orderCid) {
        this.orderCid = orderCid;
    }

    public Date getOrderCreate() {
        return orderCreate;
    }

    public void setOrderCreate(Date orderCreate) {
        this.orderCreate = orderCreate;
    }

    public String getOrderCreatePerson() {
        return orderCreatePerson;
    }

    public void setOrderCreatePerson(String orderCreatePerson) {
        this.orderCreatePerson = orderCreatePerson;
    }

    public String getOrderYdh() {
        return orderYdh;
    }

    public void setOrderYdh(String orderYdh) {
        this.orderYdh = orderYdh;
    }

    public Long getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Long orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Long getOrderStatc() {
        return orderStatc;
    }

    public void setOrderStatc(Long orderStatc) {
        this.orderStatc = orderStatc;
    }
}
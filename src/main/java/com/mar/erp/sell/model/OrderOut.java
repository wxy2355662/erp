package com.mar.erp.sell.model;

import java.util.Date;

public class OrderOut {
    private Long oId;

    private Date oCreatetime;

    private String oCreatePerson;

    private Long cId;

    private Long oMoney;

    private Integer oState;

    private String pWaybill;

    private Long orderId;

    public OrderOut(Long oId, Date oCreatetime, String oCreatePerson, Long cId, Long oMoney, Integer oState, String pWaybill, Long orderId) {
        this.oId = oId;
        this.oCreatetime = oCreatetime;
        this.oCreatePerson = oCreatePerson;
        this.cId = cId;
        this.oMoney = oMoney;
        this.oState = oState;
        this.pWaybill = pWaybill;
        this.orderId = orderId;
    }

    public OrderOut() {
        super();
    }

    public Long getoId() {
        return oId;
    }

    public void setoId(Long oId) {
        this.oId = oId;
    }

    public Date getoCreatetime() {
        return oCreatetime;
    }

    public void setoCreatetime(Date oCreatetime) {
        this.oCreatetime = oCreatetime;
    }

    public String getoCreatePerson() {
        return oCreatePerson;
    }

    public void setoCreatePerson(String oCreatePerson) {
        this.oCreatePerson = oCreatePerson;
    }

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public Long getoMoney() {
        return oMoney;
    }

    public void setoMoney(Long oMoney) {
        this.oMoney = oMoney;
    }

    public Integer getoState() {
        return oState;
    }

    public void setoState(Integer oState) {
        this.oState = oState;
    }

    public String getpWaybill() {
        return pWaybill;
    }

    public void setpWaybill(String pWaybill) {
        this.pWaybill = pWaybill;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
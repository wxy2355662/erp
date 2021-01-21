package com.mar.erp.sell.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class OrderOut {
    //退货订单编号
    private Long oId;
    //退货订单生成日期
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date oCreatetime;
    //退货员
    private String oCreatePerson;
    //客户id
    private Long cId;
    //总金额
    private Long oMoney;
    //退货状态
    private Integer oState;
    //运单号
    private String pWaybill;
    //订单id
    private Long orderId;





    //客户姓名
    private  String cName;

    //最大时间
    private  String Time;
    //最小时间
    private  String end;

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }









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
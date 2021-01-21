package com.mar.erp.sell.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Order {
    //订单编号
    private Long orderId;
    //客户id
    private Long orderCid;
    //创建日期
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date orderCreate;
    //创建人
    private String orderCreatePerson;
    //运单号
    private String orderYdh;
    //总价格
    private Long orderMoney;
    //订单状态
    private Long orderStatc;


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
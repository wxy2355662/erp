package com.mar.erp.purchase.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Purchase {
    private Long pId;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date pCreatetime;

    private String pCrecker;

    private String pSupplieruuid;

    private Long pTotalmoney;

    private Integer pState;

    private String pWaybill;

    public Purchase(Long pId, Date pCreatetime, String pCrecker, String pSupplieruuid, Long pTotalmoney, Integer pState, String pWaybill) {
        this.pId = pId;
        this.pCreatetime = pCreatetime;
        this.pCrecker = pCrecker;
        this.pSupplieruuid = pSupplieruuid;
        this.pTotalmoney = pTotalmoney;
        this.pState = pState;
        this.pWaybill = pWaybill;
    }

    public Purchase() {
        super();
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public Date getpCreatetime() {
        return pCreatetime;
    }

    public void setpCreatetime(Date pCreatetime) {
        this.pCreatetime = pCreatetime;
    }

    public String getpCrecker() {
        return pCrecker;
    }

    public void setpCrecker(String pCrecker) {
        this.pCrecker = pCrecker;
    }

    public String getpSupplieruuid() {
        return pSupplieruuid;
    }

    public void setpSupplieruuid(String pSupplieruuid) {
        this.pSupplieruuid = pSupplieruuid;
    }

    public Long getpTotalmoney() {
        return pTotalmoney;
    }

    public void setpTotalmoney(Long pTotalmoney) {
        this.pTotalmoney = pTotalmoney;
    }

    public Integer getpState() {
        return pState;
    }

    public void setpState(Integer pState) {
        this.pState = pState;
    }

    public String getpWaybill() {
        return pWaybill;
    }

    public void setpWaybill(String pWaybill) {
        this.pWaybill = pWaybill;
    }
}
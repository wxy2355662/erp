package com.mar.erp.purchase.model;

import java.util.Date;

public class ReturnGoods {
    private Long rId;

    private Date rCreatetime;

    private String rCrecker;

    private Long rSupplieruuid;

    private Long rTotalmoney;

    private Integer rState;

    private String pWaybill;

    private Long pId;

    public ReturnGoods(Long rId, Date rCreatetime, String rCrecker, Long rSupplieruuid, Long rTotalmoney, Integer rState, String pWaybill, Long pId) {
        this.rId = rId;
        this.rCreatetime = rCreatetime;
        this.rCrecker = rCrecker;
        this.rSupplieruuid = rSupplieruuid;
        this.rTotalmoney = rTotalmoney;
        this.rState = rState;
        this.pWaybill = pWaybill;
        this.pId = pId;
    }

    public ReturnGoods() {
        super();
    }

    public Long getrId() {
        return rId;
    }

    public void setrId(Long rId) {
        this.rId = rId;
    }

    public Date getrCreatetime() {
        return rCreatetime;
    }

    public void setrCreatetime(Date rCreatetime) {
        this.rCreatetime = rCreatetime;
    }

    public String getrCrecker() {
        return rCrecker;
    }

    public void setrCrecker(String rCrecker) {
        this.rCrecker = rCrecker;
    }

    public Long getrSupplieruuid() {
        return rSupplieruuid;
    }

    public void setrSupplieruuid(Long rSupplieruuid) {
        this.rSupplieruuid = rSupplieruuid;
    }

    public Long getrTotalmoney() {
        return rTotalmoney;
    }

    public void setrTotalmoney(Long rTotalmoney) {
        this.rTotalmoney = rTotalmoney;
    }

    public Integer getrState() {
        return rState;
    }

    public void setrState(Integer rState) {
        this.rState = rState;
    }

    public String getpWaybill() {
        return pWaybill;
    }

    public void setpWaybill(String pWaybill) {
        this.pWaybill = pWaybill;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }
}
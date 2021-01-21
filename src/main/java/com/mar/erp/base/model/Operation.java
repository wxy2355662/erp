package com.mar.erp.base.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Operation {
    private Long cId;

    private String cName;

    private String cInfo;

    private String cJg;

    private Long cPid;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date cTime;

    private String cType;

    public Operation(Long cId, String cName, String cInfo, String cJg, Long cPid, Date cTime, String cType) {
        this.cId = cId;
        this.cName = cName;
        this.cInfo = cInfo;
        this.cJg = cJg;
        this.cPid = cPid;
        this.cTime = cTime;
        this.cType = cType;
    }

    public Operation() {
        super();
    }

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcInfo() {
        return cInfo;
    }

    public void setcInfo(String cInfo) {
        this.cInfo = cInfo;
    }

    public String getcJg() {
        return cJg;
    }

    public void setcJg(String cJg) {
        this.cJg = cJg;
    }

    public Long getcPid() {
        return cPid;
    }

    public void setcPid(Long cPid) {
        this.cPid = cPid;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }
}
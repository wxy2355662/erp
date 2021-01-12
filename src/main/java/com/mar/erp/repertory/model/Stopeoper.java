package com.mar.erp.repertory.model;

import java.util.Date;

public class Stopeoper {
    private Long stId;

    private Long eId;

    private Date stOpertime;

    private Long srId;

    private Long gId;

    private Long stNum;

    private String stType;

    public Stopeoper(Long stId, Long eId, Date stOpertime, Long srId, Long gId, Long stNum, String stType) {
        this.stId = stId;
        this.eId = eId;
        this.stOpertime = stOpertime;
        this.srId = srId;
        this.gId = gId;
        this.stNum = stNum;
        this.stType = stType;
    }

    public Stopeoper() {
        super();
    }

    public Long getStId() {
        return stId;
    }

    public void setStId(Long stId) {
        this.stId = stId;
    }

    public Long geteId() {
        return eId;
    }

    public void seteId(Long eId) {
        this.eId = eId;
    }

    public Date getStOpertime() {
        return stOpertime;
    }

    public void setStOpertime(Date stOpertime) {
        this.stOpertime = stOpertime;
    }

    public Long getSrId() {
        return srId;
    }

    public void setSrId(Long srId) {
        this.srId = srId;
    }

    public Long getgId() {
        return gId;
    }

    public void setgId(Long gId) {
        this.gId = gId;
    }

    public Long getStNum() {
        return stNum;
    }

    public void setStNum(Long stNum) {
        this.stNum = stNum;
    }

    public String getStType() {
        return stType;
    }

    public void setStType(String stType) {
        this.stType = stType;
    }
}
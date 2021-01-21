package com.mar.erp.repertory.vo;

import com.mar.erp.repertory.model.Storedetail;

public class StoredetailVo extends Storedetail {
    private Long piId;

    private Long eId;

    private Long rgId;

    public Long getRgId() {
        return rgId;
    }

    public void setRgId(Long rgId) {
        this.rgId = rgId;
    }

    public Long geteId() {
        return eId;
    }

    public void seteId(Long eId) {
        this.eId = eId;
    }

    public Long getPiId() {
        return piId;
    }

    public void setPiId(Long piId) {
        this.piId = piId;
    }
}

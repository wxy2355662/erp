package com.mar.erp.basics.model;

public class Store {
    private Long srId;

    private String srName;

    private String srAddr;

    private Long eId;

    public Store(Long srId, String srName, String srAddr, Long eId) {
        this.srId = srId;
        this.srName = srName;
        this.srAddr = srAddr;
        this.eId = eId;
    }

    public Store() {
        super();
    }

    public Long getSrId() {
        return srId;
    }

    public void setSrId(Long srId) {
        this.srId = srId;
    }

    public String getSrName() {
        return srName;
    }

    public void setSrName(String srName) {
        this.srName = srName;
    }

    public String getSrAddr() {
        return srAddr;
    }

    public void setSrAddr(String srAddr) {
        this.srAddr = srAddr;
    }

    public Long geteId() {
        return eId;
    }

    public void seteId(Long eId) {
        this.eId = eId;
    }
}
package com.mar.erp.basics.model;

public class Supplier {
    private Long sId;

    private String sName;

    private String sAddress;

    private String sContact;

    private String sTele;

    private String sEmal;

    private String sType;

    public Supplier(Long sId, String sName, String sAddress, String sContact, String sTele, String sEmal, String sType) {
        this.sId = sId;
        this.sName = sName;
        this.sAddress = sAddress;
        this.sContact = sContact;
        this.sTele = sTele;
        this.sEmal = sEmal;
        this.sType = sType;
    }

    public Supplier() {
        super();
    }

    public Long getsId() {
        return sId;
    }

    public void setsId(Long sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsAddress() {
        return sAddress;
    }

    public void setsAddress(String sAddress) {
        this.sAddress = sAddress;
    }

    public String getsContact() {
        return sContact;
    }

    public void setsContact(String sContact) {
        this.sContact = sContact;
    }

    public String getsTele() {
        return sTele;
    }

    public void setsTele(String sTele) {
        this.sTele = sTele;
    }

    public String getsEmal() {
        return sEmal;
    }

    public void setsEmal(String sEmal) {
        this.sEmal = sEmal;
    }

    public String getsType() {
        return sType;
    }

    public void setsType(String sType) {
        this.sType = sType;
    }
}
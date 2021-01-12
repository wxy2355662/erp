package com.mar.erp.basics.model;

public class Curstrumer {
    private Long cId;

    private String cName;

    private String cAddress;

    private String cContact;

    private String cTele;

    private String cEmal;

    private String cRmd;

    public Curstrumer(Long cId, String cName, String cAddress, String cContact, String cTele, String cEmal, String cRmd) {
        this.cId = cId;
        this.cName = cName;
        this.cAddress = cAddress;
        this.cContact = cContact;
        this.cTele = cTele;
        this.cEmal = cEmal;
        this.cRmd = cRmd;
    }

    public Curstrumer() {
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

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    public String getcContact() {
        return cContact;
    }

    public void setcContact(String cContact) {
        this.cContact = cContact;
    }

    public String getcTele() {
        return cTele;
    }

    public void setcTele(String cTele) {
        this.cTele = cTele;
    }

    public String getcEmal() {
        return cEmal;
    }

    public void setcEmal(String cEmal) {
        this.cEmal = cEmal;
    }

    public String getcRmd() {
        return cRmd;
    }

    public void setcRmd(String cRmd) {
        this.cRmd = cRmd;
    }
}
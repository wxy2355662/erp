package com.mar.erp.personnel.model;

import java.util.Date;

public class Ataff {
    private Long ataId;

    private String ataUsername;

    private String ataPassword;

    private String ataRealname;

    private String ataSex;

    private String ataEmail;

    private String ataPhone;

    private Date ataDate;

    private Long ataDep;

    private String ataAddress;

    public Ataff(Long ataId, String ataUsername, String ataPassword, String ataRealname, String ataSex, String ataEmail, String ataPhone, Date ataDate, Long ataDep, String ataAddress) {
        this.ataId = ataId;
        this.ataUsername = ataUsername;
        this.ataPassword = ataPassword;
        this.ataRealname = ataRealname;
        this.ataSex = ataSex;
        this.ataEmail = ataEmail;
        this.ataPhone = ataPhone;
        this.ataDate = ataDate;
        this.ataDep = ataDep;
        this.ataAddress = ataAddress;
    }

    public Ataff() {
        super();
    }

    public Long getAtaId() {
        return ataId;
    }

    public void setAtaId(Long ataId) {
        this.ataId = ataId;
    }

    public String getAtaUsername() {
        return ataUsername;
    }

    public void setAtaUsername(String ataUsername) {
        this.ataUsername = ataUsername;
    }

    public String getAtaPassword() {
        return ataPassword;
    }

    public void setAtaPassword(String ataPassword) {
        this.ataPassword = ataPassword;
    }

    public String getAtaRealname() {
        return ataRealname;
    }

    public void setAtaRealname(String ataRealname) {
        this.ataRealname = ataRealname;
    }

    public String getAtaSex() {
        return ataSex;
    }

    public void setAtaSex(String ataSex) {
        this.ataSex = ataSex;
    }

    public String getAtaEmail() {
        return ataEmail;
    }

    public void setAtaEmail(String ataEmail) {
        this.ataEmail = ataEmail;
    }

    public String getAtaPhone() {
        return ataPhone;
    }

    public void setAtaPhone(String ataPhone) {
        this.ataPhone = ataPhone;
    }

    public Date getAtaDate() {
        return ataDate;
    }

    public void setAtaDate(Date ataDate) {
        this.ataDate = ataDate;
    }

    public Long getAtaDep() {
        return ataDep;
    }

    public void setAtaDep(Long ataDep) {
        this.ataDep = ataDep;
    }

    public String getAtaAddress() {
        return ataAddress;
    }

    public void setAtaAddress(String ataAddress) {
        this.ataAddress = ataAddress;
    }
}
package com.mar.erp.personnel.model;

public class Department {
    private Long depId;

    private String depName;

    private String depPhone;

    public Department(Long depId, String depName, String depPhone) {
        this.depId = depId;
        this.depName = depName;
        this.depPhone = depPhone;
    }

    public Department() {
        super();
    }

    public Long getDepId() {
        return depId;
    }

    public void setDepId(Long depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getDepPhone() {
        return depPhone;
    }

    public void setDepPhone(String depPhone) {
        this.depPhone = depPhone;
    }
}
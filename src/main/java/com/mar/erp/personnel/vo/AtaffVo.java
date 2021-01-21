package com.mar.erp.personnel.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mar.erp.personnel.model.Ataff;
import com.mar.erp.sys.vo.PermissionVo;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class AtaffVo extends Ataff {
    private List<PermissionVo> list=new ArrayList<PermissionVo>();
    private String startDate;
    private String endDate;
    private String atime;

    public String getAtime() {
        return atime;
    }

    public void setAtime(String atime) {
        this.atime = atime;
    }

    public List<PermissionVo> getList() {
        return list;
    }

    public void setList(List<PermissionVo> list) {
        this.list = list;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }


    @Override
    public String toString() {
        return super.toString()+ "AtaffVo{" +
                "list=" + list +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}

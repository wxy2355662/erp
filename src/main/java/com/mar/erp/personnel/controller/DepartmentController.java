package com.mar.erp.personnel.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mar.erp.base.util.JsonResponseBody;
import com.mar.erp.base.util.PageBean;
import com.mar.erp.personnel.model.Department;
import com.mar.erp.personnel.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private IDepartmentService departmentService;


    @RequestMapping("/addDepartment")
    public JsonResponseBody addDepartment(Department department){
     return departmentService.insertSelective(department);
    }

    @RequestMapping("/delDepartment")
    public JsonResponseBody delDepartment(Department department){
        return departmentService.deleteByPrimaryKey(department.getDepId());
    }


    @RequestMapping("/updDepartment")
    public JsonResponseBody updDepartment(Department department){
        return departmentService.updateByPrimaryKeySelective(department);
    }

    /**
     * 根据ID查询单个部门
     * @param department
     * @return
     */
    @RequestMapping("/queryDepartmentByDepId")
    public JsonResponseBody queryDepartmentByDepId(Department department){
        return departmentService.selectByPrimaryKey(department.getDepId());
    }

    /**
     * 条件查询部门
     * @param department
     * @return
     */
    @RequestMapping("/queryDepartment")
    public JsonResponseBody queryDepartment(Department department, PageBean pageBean){
        return departmentService.queryDepartmentPagers(department,pageBean);
    }

    /**
     * 根据部门名精确查询部门
     * @param department
     * @return
     */
    @RequestMapping("/selectDepartmentByName")
    public JsonResponseBody selectDepartmentByName(Department department){
        return departmentService.selectDepartmentByName(department);
    }






}

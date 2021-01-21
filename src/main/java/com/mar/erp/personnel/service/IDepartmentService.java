package com.mar.erp.personnel.service;

import com.github.pagehelper.Page;
import com.mar.erp.base.util.JsonResponseBody;
import com.mar.erp.base.util.PageBean;
import com.mar.erp.personnel.model.Department;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IDepartmentService {
    JsonResponseBody<?> deleteByPrimaryKey(Long depId);

    JsonResponseBody<?> insert(Department record);

    JsonResponseBody<?> insertSelective(Department record);

    JsonResponseBody<Department> selectByPrimaryKey(Long depId);

    JsonResponseBody<?> updateByPrimaryKeySelective(Department record);

    JsonResponseBody<?> updateByPrimaryKey(Department record);

    /**
     * 根据条件查询所有部门
     * @param department 条件
     * @return
     */
    JsonResponseBody<List<Department>> queryDepartmentPagers(Department department, PageBean pageBean);


    /**
     * 判断是否有重复名称的部门
     * @param department
     * @return
     */
    JsonResponseBody<List<Department>> selectDepartmentByName(Department department);
}
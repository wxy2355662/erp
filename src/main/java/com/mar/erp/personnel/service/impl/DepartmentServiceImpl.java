package com.mar.erp.personnel.service.impl;

import com.mar.erp.base.exception.BusinessException;
import com.mar.erp.base.util.JsonResponseBody;
import com.mar.erp.base.util.PageBean;
import com.mar.erp.base.util.ResponseStatus;
import com.mar.erp.personnel.mapper.DepartmentMapper;
import com.mar.erp.personnel.model.Department;
import com.mar.erp.personnel.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;


    @Override
    public JsonResponseBody<?> deleteByPrimaryKey(Long depId) {
        int i = departmentMapper.deleteByPrimaryKey(depId);
        if(i<1){
            throw  new BusinessException(ResponseStatus.STATUS_603);
        }
        return new JsonResponseBody<>();
    }

    @Override
    public JsonResponseBody<?> insert(Department record) {
        int i = departmentMapper.insert(record);
        if(i<1){
            throw  new BusinessException(ResponseStatus.STATUS_601);
        }
        return new JsonResponseBody<>();
    }

    @Override
    public JsonResponseBody<?> insertSelective(Department record) {
        int i = departmentMapper.insertSelective(record);
        if(i<1){
            throw  new BusinessException(ResponseStatus.STATUS_601);
        }
        return new JsonResponseBody<>();
    }

    @Override
    public JsonResponseBody<Department> selectByPrimaryKey(Long depId) {
        Department department = departmentMapper.selectByPrimaryKey(depId);
        if (department==null){
            throw new BusinessException(ResponseStatus.STATUS_604);
        }
        return new JsonResponseBody<>(department);
    }

    @Override
    public JsonResponseBody<?> updateByPrimaryKeySelective(Department record) {
        int i = departmentMapper.updateByPrimaryKeySelective(record);
        if(i<1){
            throw  new BusinessException(ResponseStatus.STATUS_608);
        }
        return new JsonResponseBody<>();
    }

    @Override
    public JsonResponseBody<?> updateByPrimaryKey(Department record) {
        int i = departmentMapper.updateByPrimaryKey(record);
        if(i<1){
            throw  new BusinessException(ResponseStatus.STATUS_608);
        }
        return new JsonResponseBody<>();
    }

    @Override
    public JsonResponseBody<List<Department>> queryDepartmentPagers(Department department, PageBean pageBean) {
        List<Department> departments = departmentMapper.queryDepartment(department);
        if(departments.size()<1){
            throw  new BusinessException(ResponseStatus.STATUS_602);
        }
        return new JsonResponseBody<>(departments);
    }

    @Override
    public JsonResponseBody<List<Department>> selectDepartmentByName(Department department) {
        List<Department> departments = departmentMapper.selectDepartmentByName(department);

        return new JsonResponseBody<>(departments);
    }

}

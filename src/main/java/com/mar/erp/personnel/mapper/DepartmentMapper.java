package com.mar.erp.personnel.mapper;

import com.mar.erp.personnel.model.Department;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Long depId);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Long depId);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}
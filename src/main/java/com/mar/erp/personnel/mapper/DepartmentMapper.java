package com.mar.erp.personnel.mapper;

import com.mar.erp.personnel.model.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentMapper {
    int deleteByPrimaryKey(Long depId);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Long depId);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    /**
     * 根据条件查询所有部门
     * @param department 条件
     * @return
     */
    List<Department> queryDepartment(Department department);

    /**
     * 根据名称查询部门
     * @param department
     * @return
     */
    List<Department> selectDepartmentByName(Department department);
}
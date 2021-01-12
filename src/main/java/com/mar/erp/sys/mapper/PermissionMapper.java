package com.mar.erp.sys.mapper;

import com.mar.erp.sys.model.Permission;
import com.mar.erp.sys.vo.PermissionVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionMapper {

    int deleteByPrimaryKey(Integer perId);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer perId);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    /**
     * 找到所有父节点
     * @return 返回vo层集合
     */
    List<PermissionVo> queryPrimaryByParent();

    /**
     * 根据父节点找到所有父节点下的子节点
     * @return
     */
    List<Permission>  queryPrimaryByPid(Integer pid);


}
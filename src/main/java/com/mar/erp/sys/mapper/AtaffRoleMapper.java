package com.mar.erp.sys.mapper;

import com.mar.erp.sys.model.AtaffRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AtaffRoleMapper {
    int deleteByPrimaryKey(Integer arId);

    int insert(AtaffRole record);

    int insertSelective(AtaffRole record);

    AtaffRole selectByPrimaryKey(Integer arId);

    int updateByPrimaryKeySelective(AtaffRole record);

    int updateByPrimaryKey(AtaffRole record);

    /**
     * 统计报表
     */
    List<Map<String,Object>> querySales(@Param("startTime") String startTime,@Param("endTime") String endTime);

    /**
     * 获取订单年份
     */

    List<String>  querySalesYear();

    /**
     * 根据年份查询每个月销售额
     * @param year
     * @return
     */
    List<Map<String,Object>> querySalesMonthByYear(@Param("year")String year);

    /**
     * 查询每个客户的销售额
     */
    List<Map<String,Object>> querySalesByClient(@Param("year")String year);

}
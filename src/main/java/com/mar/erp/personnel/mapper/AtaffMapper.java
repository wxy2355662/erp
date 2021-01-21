package com.mar.erp.personnel.mapper;

import com.mar.erp.personnel.model.Ataff;
import com.mar.erp.personnel.vo.AtaffVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public interface AtaffMapper {
    int deleteByPrimaryKey(Long ataId);

    int insert(Ataff record);

    int insertSelective(Ataff record);

    Ataff selectByPrimaryKey(Long ataId);

    int updateByPrimaryKeySelective(Ataff record);

    int updateByPrimaryKey(Ataff record);

    /**
     * 根据用户名查询用户
     * @param userName
     * @return
     */
    AtaffVo queryByLogin(String userName);

//    /**
//     * 查询所有用户
//     * @param ataff
//     * @return
//     */
//    List<Ataff> queryAtaff(AtaffVo ataff);

    /**
     * 查询所有用户(人员管理)
     * @param ataffVo
     * @return
     */
    List<Map<String,Object>> queryAtaffByCrux(AtaffVo ataffVo);




    /**
     * 根据用户id查询对应的角色id
     * @param ataId 用户ID
     * @return
     */
    List<Integer> queryAtaByRoleId(Long ataId);

    /**
     * 添加用户对应的角色
     * @param ataId
     * @param roleIds
     * @return
     */
    int addAtaByRoleId(@Param("ataId")Long ataId,@Param("roleIds") Integer[] roleIds);

    /**
     * 根据用户Id删除对应角色
     * @param ataId
     * @return
     */
    int deleteAtaByAtaId(Long ataId);

    /**
     * 根据用户名查询用户的角色
     * @param ataUserName
     * @return
     */
    Set<String> findRole(String ataUserName);

    /**
     * 根据用户名查询用户角色的权限
     * @param ataUserName
     * @return
     */
    Set<String> findPermissions(String ataUserName);


    /**
     * 根据邮箱查询账号
     * @param email
     * @return
     */
    Ataff  findAtaffByEmail(@Param("email") String email);



}
package com.mar.erp.personnel.service.impl;

import com.mar.erp.base.exception.BusinessException;
import com.mar.erp.base.util.JsonResponseBody;
import com.mar.erp.base.util.PageBean;
import com.mar.erp.base.util.ResponseStatus;
import com.mar.erp.personnel.mapper.AtaffMapper;
import com.mar.erp.personnel.model.Ataff;
import com.mar.erp.personnel.service.IAtaffService;
import com.mar.erp.personnel.vo.AtaffVo;
import com.mar.erp.sys.service.IPermissionService;
import com.mar.erp.sys.vo.PermissionVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class AtaffServiceImpl implements IAtaffService {

    @Autowired
    private AtaffMapper ataffMapper;
    @Autowired
    IPermissionService permissionService;


    @Override
    public JsonResponseBody<?> deleteByPrimaryKey(Long ataId) {
        if(ataId==1){
            throw new BusinessException(ResponseStatus.STATUS_611);
        }
        int i = ataffMapper.deleteByPrimaryKey(ataId);
        if(i<1){
            throw new BusinessException(ResponseStatus.STATUS_603);
        }
        return new  JsonResponseBody<>();
    }

    @Override
    public JsonResponseBody<?> insert(Ataff record) {
        int insert = ataffMapper.insert(record);
        if(insert<1){
            throw new BusinessException(ResponseStatus.STATUS_601);
        }
        return new  JsonResponseBody<>();
    }

    @Override
    public JsonResponseBody<?> insertSelective(Ataff record) {
        int insert = ataffMapper.insertSelective(record);
        if(insert<1){
            throw new BusinessException(ResponseStatus.STATUS_601);
        }
        return new  JsonResponseBody<>();

    }

    @Override
    public JsonResponseBody<Ataff> selectByPrimaryKey(Long ataId) {
        Ataff ataff = ataffMapper.selectByPrimaryKey(ataId);
        if(ataff==null)
            return new JsonResponseBody<>(ResponseStatus.STATUS_602);
        return new  JsonResponseBody<>(ataff);
    }

    @Override
    public JsonResponseBody<?> updateByPrimaryKeySelective(Ataff record) {
        int insert = ataffMapper.updateByPrimaryKeySelective(record);
        if(insert<1){
            throw new BusinessException(ResponseStatus.STATUS_608);
        }
        return new  JsonResponseBody<>();
    }

    @Override
    public JsonResponseBody<?> updateByPrimaryKey(Ataff record) {
        int insert = ataffMapper.updateByPrimaryKey(record);
        if(insert<1){
            throw new BusinessException(ResponseStatus.STATUS_608);
        }
        return new  JsonResponseBody<>();
    }

    @Override
    public AtaffVo queryByLogin(String userName) {
        return ataffMapper.queryByLogin(userName);
    }

    @Override
    public JsonResponseBody<AtaffVo> userLogin(String userName, String pwd) {
        //获得主体
        Subject subject = SecurityUtils.getSubject();
        //创建登录令牌Token
        UsernamePasswordToken token = new UsernamePasswordToken(
                userName,
                pwd
        );
        //登录处理
        try{
            subject.login(token);
            //查询到用户
            AtaffVo ataffVo = queryByLogin(userName);

            //登录验证成功，把页面权限设置进用户对象
            List<PermissionVo> primaryByUserName = permissionService.findPrimaryByUserName(userName);
            ataffVo.setList(primaryByUserName);

            return new JsonResponseBody<>(ataffVo);
        }catch(UnknownAccountException e){

            throw new BusinessException(ResponseStatus.STATUS_609);

        }catch (IncorrectCredentialsException e){

            throw new BusinessException(ResponseStatus.STATUS_610);

        }



    }

    @Override
    public JsonResponseBody<List<Map<String,Object>>> queryAtaffPagers(AtaffVo ataff, PageBean pageBean) {

        List<Map<String,Object>> ataffs=ataffMapper.queryAtaffByCrux(ataff);
        if(ataffs.size()<1){
            return new JsonResponseBody<>(ResponseStatus.STATUS_602);
        }
        return new JsonResponseBody<>(ataffs);
    }

    @Override
    public JsonResponseBody<List<Integer>> queryAtaByRoleId(Long ataId) {
        List<Integer> integers = ataffMapper.queryAtaByRoleId(ataId);
        if(integers.size()<1){
            return new JsonResponseBody<>(ResponseStatus.STATUS_602);
        }

        return new JsonResponseBody<>(integers);
    }

    @Transactional
    @Override
    public JsonResponseBody<?> addAtaByRoleId(Long ataId, Integer[] roleIds) {


        ataffMapper.deleteAtaByAtaId(ataId);
        int i = ataffMapper.addAtaByRoleId(ataId, roleIds);
        if(i<1){
            throw  new BusinessException(ResponseStatus.STATUS_601);
        }

        return new JsonResponseBody<>();
    }

    @Override
    public JsonResponseBody<?> deleteAtaByAtaId(Long ataId) {
        if(ataId==1){
            throw  new BusinessException(ResponseStatus.STATUS_611);
        }
        int i = ataffMapper.deleteAtaByAtaId(ataId);
        if(i<1){
            throw  new BusinessException(ResponseStatus.STATUS_603);
        }
        return new JsonResponseBody<>();
    }

    @Override
    public Set<String> findRole(String ataUserName) {
        return ataffMapper.findRole(ataUserName);
    }

    @Override
    public Set<String> findPermissions(String ataUserName) {
        return ataffMapper.findPermissions(ataUserName);
    }


    public JsonResponseBody<Ataff> verifyUserName(String userName){
          return new JsonResponseBody<>(ataffMapper.queryByLogin(userName));
    }

    @Override
    public JsonResponseBody<Ataff> findAtaffByEmail(String email) {
        Ataff ataffByEmail = ataffMapper.findAtaffByEmail(email);
        if(null==ataffByEmail){
            throw new BusinessException(ResponseStatus.STATUS_602);
        }
        return new JsonResponseBody<>(ataffByEmail);
    }

}

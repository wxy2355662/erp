package com.mar.erp.personnel.controller;

import com.mar.erp.base.exception.BusinessException;
import com.mar.erp.base.jwt.JwtUtils;
import com.mar.erp.base.redis.RedisSet;
import com.mar.erp.base.thread.EmailThread;
import com.mar.erp.base.thread.RedisThrad;
import com.mar.erp.base.util.GetIpUtil;
import com.mar.erp.base.util.JsonResponseBody;
import com.mar.erp.base.util.PageBean;
import com.mar.erp.base.util.ResponseStatus;
import com.mar.erp.personnel.model.Ataff;
import com.mar.erp.personnel.service.IAtaffService;
import com.mar.erp.personnel.vo.AtaffVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

@Controller
@RequestMapping("/ataff")
@ResponseBody
public class AtaffController {
    @Autowired
    private IAtaffService ataffService;

    //redis注入
    @Autowired
    private RedisSet redisSet;

    @Autowired
    //邮件发送
    private JavaMailSenderImpl mailSender;


    /**
     * 登录验证
     *
     * @param request 请求
     * @param ataff   员工
     * @param checked 判断是否需要30分钟免登录
     * @return
     */
    @RequestMapping("/userLogin")
    public JsonResponseBody<AtaffVo> userLogin(HttpServletRequest request, HttpServletResponse response, Ataff ataff, boolean checked) {
//        System.out.println("getIpAddress:"+GetIpUtil.getIpAddress(request));
//        System.out.println("getIP:"+GetIpUtil.getIP(request));
//        System.out.println("getRealIp:"+GetIpUtil.getRealIp(request));
        JsonResponseBody<AtaffVo> ataffJsonResponseBody = ataffService.userLogin(ataff.getAtaUsername(), ataff.getAtaPassword());
        //如果勾选了30分钟免登陆,就把数据存入Redis中30分钟
        if (checked) {
            //获得请求的ip地址
            String ipAddress = GetIpUtil.getIpAddress(request);
            //用线程执行redis储存,加快前端响应速度
            RedisThrad redisThrad = new RedisThrad(redisSet, ipAddress, ataffJsonResponseBody.getData(), 30);
            Thread t = new Thread(redisThrad);
            t.start();

//            redisSet.setRedisData(ipAddress,ataffJsonResponseBody.getData());
        }
        //传入jwt令牌
        String jwt = JwtUtils.createJwt(new HashMap<>(), JwtUtils.JWT_WEB_TTL);
        response.setHeader(JwtUtils.JWT_HEADER_KEY, jwt);
        return ataffJsonResponseBody;
    }

    /**
     * 30分钟免登陆验证
     *
     * @param request 请求头
     * @return
     */
    @RequestMapping("/verifyByIp")
    public JsonResponseBody verifyByIp(HttpServletRequest request, HttpServletResponse response) {
        //获得IP地址
        String ipAddress = GetIpUtil.getIpAddress(request);
        //从redis里判断是否有对象
        Ataff redisValue = (Ataff) redisSet.getRedisValue(ipAddress);
        if (null != redisValue ) {


            //传入jwt令牌
            String jwt = JwtUtils.createJwt(new HashMap<>(), JwtUtils.JWT_WEB_TTL);
            response.setHeader(JwtUtils.JWT_HEADER_KEY, jwt);
            //如果有就用这个用户登录
            return ataffService.userLogin(redisValue.getAtaUsername(), redisValue.getAtaPassword());

        } else {
            //如果没有就正常返回
            JsonResponseBody<Object> objectJsonResponseBody = new JsonResponseBody<>();
            objectJsonResponseBody.setStatus(700);
            return objectJsonResponseBody;
        }
    }

    /**
     * 退出
     *
     * @param request
     */
    @RequestMapping("/exitByAtaff")
    public JsonResponseBody exitByAtaff(HttpServletRequest request) {
        //获得IP地址
        String ipAddress = GetIpUtil.getIpAddress(request);
        //从redis里删除
        redisSet.deleteRedisByKey(ipAddress);
        //注销主体
        SecurityUtils.getSubject().logout();
        return new JsonResponseBody<>();
    }

    /**
     * 根据传递过来的值进行修改，为null不修改
     *
     * @param ataff
     * @return
     */
    @RequestMapping("/updateAta")
    public JsonResponseBody updateAta(Ataff ataff) {
        JsonResponseBody<?> jsonResponseBody = ataffService.updateByPrimaryKeySelective(ataff);
        return jsonResponseBody;
    }

    @RequiresPermissions("system:user:pwd")
    @RequestMapping("/updatePwdByAid")
    public JsonResponseBody updatePwdByAid(Ataff ataff) {
        //随机生成密码
        // 密码随机生成规则
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        Random rad = new Random();
        Integer pwdi = rad.nextInt(800) + 100;
        Date date = new Date();
        String pwd = df.format(date);
        pwd += pwdi;
        //获取发件邮箱
        String email = ataff.getAtaEmail();
        //把新密码设置进对象
        ataff.setAtaPassword(pwd);
        //把邮件设置为空(不然会被修改方法执行)
        ataff.setAtaEmail(null);
        //执行修改方法
        JsonResponseBody<?> jsonResponseBody = ataffService.updateByPrimaryKeySelective(ataff);
        /*
            创建发送邮件的线程
            如果不用线程发送邮件，会导致Json无法返回数据,不清楚原因
         */
        String msg = "您的密码已经重置成功，密码为:" + pwd + " ,请您尽快修改！";
        EmailThread emailThread = new EmailThread(mailSender, email, msg);
        Thread t = new Thread(emailThread);
        t.start();

        return jsonResponseBody;
    }

    /**
     * 条件查询所有用户
     *
     * @param ataff
     * @param pageBean
     * @return
     */
    @RequiresPermissions("system:user:query")
    @RequestMapping("/queryAtaff")
    public JsonResponseBody queryAtaff(AtaffVo ataff, PageBean pageBean) {
        return ataffService.queryAtaffPagers(ataff, pageBean);
    }

    /**
     * 条件查询所有员工
     *
     * @param ataff
     * @param pageBean
     * @return
     */
    @RequestMapping("/queryAtaffByAll")
    public JsonResponseBody queryAtaffByAll(AtaffVo ataff, PageBean pageBean) {
        return ataffService.queryAtaffPagers(ataff, pageBean);
    }


    @RequestMapping("/queryAtaByRoleId")
    public JsonResponseBody queryAtaByRoleId(Ataff ataff) {
        return ataffService.queryAtaByRoleId(ataff.getAtaId());
    }

    @RequiresPermissions("system:user:role")
    @RequestMapping("/addAtaByRoleId")
    public JsonResponseBody addAtaByRoleId(Ataff ataff, Integer[] roleIds) {
        return ataffService.addAtaByRoleId(ataff.getAtaId(), roleIds);
    }


    //删除
    @RequestMapping("/deleteByPrimaryKey")
    public JsonResponseBody deleteByPrimaryKey(Ataff ataff) {
        return ataffService.deleteByPrimaryKey(ataff.getAtaId());
    }

    //添加
    @RequestMapping("/insertAta")
    public JsonResponseBody insertAta(AtaffVo ataff) {

        try {
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
            ataff.setAtaDate(sd.parse(ataff.getAtime()));
            ataff.setAtaPassword("666666");
        } catch (ParseException e) {
            throw new BusinessException(ResponseStatus.STATUS_601);
        }


        return ataffService.insertSelective(ataff);
    }

    //修改
    @RequestMapping("/updAta")
    public JsonResponseBody updAta(AtaffVo ataff) {
        try {
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
            ataff.setAtaDate(sd.parse(ataff.getAtime()));
        } catch (ParseException e) {
            throw new BusinessException(ResponseStatus.STATUS_608);
        }
        return ataffService.updateByPrimaryKeySelective(ataff);
    }

    /**
     * 验证用户名是否存在
     *
     * @param ataff
     * @return
     */
    @RequestMapping("/verifyUserName")
    public JsonResponseBody verifyUserName(Ataff ataff) {
        return ataffService.verifyUserName(ataff.getAtaUsername());

    }

    /**
     * 通过邮箱验证用户是否存在
     */
    @RequestMapping("/verifyEmail")
    public JsonResponseBody verifyEmail(String email) {
        return ataffService.findAtaffByEmail(email);
    }

    /**
     * 发送验证码
     *
     * @param email
     * @return
     */
    @RequestMapping("/sendVerify")
    public JsonResponseBody sendVerify(String email) {

            JsonResponseBody<Ataff> ataffByEmail = ataffService.findAtaffByEmail(email);
            if (null != ataffByEmail.getData()) {
                //邮箱有账号就发送验证码
                //验证码
                Random rad = new Random();
                Integer pwd = rad.nextInt(8000) + 1000;
                System.out.println(pwd);
         /*
            创建发送邮件的线程
            如果不用线程发送邮件，会导致Json无法返回数据,不清楚原因
         */
                String msg = "您好，您的登录验证码为:" + pwd + " ,有效时间2分钟请尽快登录！";
                EmailThread emailThread = new EmailThread(mailSender, email, msg);
                //创建存入redis的线程
                RedisThrad redisThrad = new RedisThrad(redisSet, email, pwd, 2);
                Thread t = new Thread(emailThread);
                t.start();
                t = new Thread(redisThrad);
                t.start();

                return new JsonResponseBody();
            }else{
                throw new BusinessException(ResponseStatus.STATUS_609);
            }

    }

    /**
     * 邮箱登录
     *
     * @param email 邮箱
     * @param pwd   验证码
     * @return
     */
    @RequestMapping("/emailLogin")
    public JsonResponseBody<AtaffVo> emailLogin(HttpServletRequest request,HttpServletResponse response,String email, String pwd, boolean checked) {
       //通过邮箱从Redis里拿到验证码
        String pw =String.valueOf(redisSet.getRedisValue(email));

        JsonResponseBody<AtaffVo> ataffJsonResponseBody=null;
        //判断是否有拿到东西
        if(null==pw){
            throw new BusinessException(ResponseStatus.STATUS_612);
        }else{
            //判断验证码是否和前端传过来的一致
            if(pw.equals(pwd)){
                //通过邮箱拿到用户对象
                JsonResponseBody<Ataff> ataffByEmail = ataffService.findAtaffByEmail(email);
                //用户对象
                Ataff data = ataffByEmail.getData();
                //调用登录方法进行登录（因为要走redis）
                ataffJsonResponseBody=userLogin(request,response,data,checked);
                //登录成功就删掉Redis里的东西
                redisSet.deleteRedisByKey(email);
            }else{
                throw new BusinessException(ResponseStatus.STATUS_612);
            }
        }
        return ataffJsonResponseBody;
    }
}


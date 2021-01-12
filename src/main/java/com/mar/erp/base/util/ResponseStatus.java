package com.mar.erp.base.util;

/**
 * 用于数据接口返回的状态码枚举
 */
public enum ResponseStatus {

    STATUS_200(200,"OK"),
    STATUS_601(601,"保存数据失败！"),
    STATUS_602(602,"查无数据！"),
    STATUS_603(603,"删除数据失败！"),
    STATUS_604(604,"查询数据失败！"),
    STATUS_605(605,"登录身份过期，请重新登录！"),
    STATUS_606(606,"Token令牌失效或已过期！"),
    STATUS_607(607,"权限不足！"),
    STATUS_608(608,"修改数据失败！"),
    STATUS_609(609,"登录失败，账号错误！"),
    STATUS_610(608,"登录失败，密码错误！"),
    UNKNOWN_ERROR(999, "未知错误，请联系管理员！"),
    ;

    private Integer status;
    private String msg;

    ResponseStatus(Integer status, String msg) {
        this.status=status;
        this.msg=msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

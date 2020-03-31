package com.zh.learn.common.domain;

import lombok.Data;

/**
 * @Author: Zhou Hu
 * @Description: 统一返回格式
 * @Date: 13:51 2019-05-05
 **/
@Data
public class ResultBean {
    /**
     * 900000 成功
     * 900102 参数为空或者null
     * 900401 权限不足
     * 999999 系统错误
     */
    private Integer code;
    /**
     * 信息说明
     */
    private String message;
    /**
     * 如果有数据保存数据使用
     */
    private Object data = null;


    private ResultBean() {

    }

    public static ResultBean isOk() {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(900000);
        return resultBean;
    }

    public static ResultBean isMissParameter() {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(999102);
        return resultBean;
    }

    public static ResultBean isPermissionDenied() {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(999401);
        return resultBean;
    }

    public static ResultBean isError() {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(999999);
        return resultBean;
    }
}
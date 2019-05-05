package com.zhcloud.domain;

import lombok.Data;

/**
 * @Author: Zhou Hu
 * @Description: 统一返回格式
 * @Date: 13:51 2019-05-05
 **/
@Data
public class RestBean<T> {
    /**
     * 900000 成功
     * 900102 参数为空或者null
     * 900403 权限不足
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
    private T data = null;
}
package com.zh.learn.order.mapper;

import com.zh.learn.order.entity.Order;

import java.util.List;

/**
 * @author ZhouHu
 * @Class Name OrderMapper
 * @Desc
 * @create: 2020-03-19 11:24
 **/

public interface OrderMapper {
    /**
     * 添加多条记录到数据库
     * @param recordList 要添加的数据库
     * @return 添加结果
     */
    int saveAll(List<Order> recordList);

    int deleteByIds(List<Long> ids);

    Order selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}
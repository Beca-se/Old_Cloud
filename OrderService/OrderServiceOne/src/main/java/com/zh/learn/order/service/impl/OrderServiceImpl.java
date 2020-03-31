package com.zh.learn.order.service.impl;

import com.zh.learn.common.domain.ResultBean;
import com.zh.learn.order.domain.OrderQueryBean;
import com.zh.learn.order.entity.Order;
import com.zh.learn.order.mapper.OrderMapper;
import com.zh.learn.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ZhouHu
 * @Class Name OrderServiceImpl
 * @Desc
 * @create: 2020-03-19 11:46
 **/
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultBean cratedOrder(List<Order> orderList) {
        orderMapper.saveAll(orderList);
        ResultBean ok = ResultBean.isOk();
        ok.setMessage("Created order SUCCESSFUL!");
        return ok;
    }

    @Override
    public ResultBean delete(List<Long> ids) {
        orderMapper.deleteByIds(ids);
        return null;
    }

    @Override
    public ResultBean update(Order order) {
        return null;
    }

    @Override
    public ResultBean queryOrder(OrderQueryBean orderQueryBean) {
        return null;
    }
}

package com.zh.learn.order.controller;

import com.zh.learn.common.domain.ResultBean;
import com.zh.learn.order.domain.OrderQueryBean;
import com.zh.learn.order.entity.Order;
import com.zh.learn.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ZhouHu
 * @Class Name OrderController
 * @Desc
 * @create: 2020-03-19 11:35
 **/
@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResultBean cratedOrder(@RequestBody List<Order> orderList) {
        return orderService.cratedOrder(orderList);
    }

    @PostMapping("/delete")
    public ResultBean deleteOrder(@RequestBody List<Long> ids) {
        return orderService.delete(ids);
    }

    @PostMapping("/update")
    public ResultBean updateOrder(Order order) {
        return orderService.update(order);
    }

    @GetMapping("/query")
    public ResultBean queryOrder(OrderQueryBean orderQueryBean) {
        return orderService.queryOrder(orderQueryBean);
    }
}

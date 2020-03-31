package com.zh.learn.feign.fallback;

import com.zh.learn.common.domain.ResultBean;
import com.zh.learn.domain.Order;
import com.zh.learn.feign.OrderFeign;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ZhouHu
 * @Class Name OrderFeignImpl
 * @Desc TODO
 * @create: 2020-03-30 17:45
 **/
@Component
public class OrderFeignImpl implements OrderFeign {
    @Override
    public ResultBean cratedOrder(List<Order> orderList) {
        ResultBean error = ResultBean.isError();
        error.setMessage("The is the crated order fallback!");
        return error;
    }

    @Override
    public ResultBean deleteOrders(List<Long> ids) {
        ResultBean error = ResultBean.isError();
        error.setMessage("The is the delete order fallback!");
        return error;
    }

    @Override
    public ResultBean queryOrders(String sfd) {
        return null;
    }
}

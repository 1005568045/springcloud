package com.imooc.order.service.impl;

import com.imooc.order.OrderApplicationTests;
import com.imooc.order.dto.OrderDTO;
import com.imooc.order.pojo.OrderMaster;
import com.imooc.order.service.OrderService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.junit.Assert.*;
@Component
public class OrderServiceImplTest extends OrderApplicationTests {

    @Autowired
    private OrderService orderService;
    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("zhangsan");
        orderDTO.setBuyerAddress("兴海云");
        orderDTO.setBuyerOpenid("sdsgfdgdfgd14343");
        orderDTO.setBuyerPhone("25454645");
        orderService.create(orderDTO);
    }
}
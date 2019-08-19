package com.imooc.order.service.impl;

import com.imooc.order.enums.OrderStatusEnum;
import com.imooc.order.enums.PayStatusEnum;
import com.imooc.order.mapper.OrderDetailMapper;
import com.imooc.order.mapper.OrderMasterMapper;
import com.imooc.order.dto.OrderDTO;
import com.imooc.order.pojo.OrderMaster;
import com.imooc.order.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Autowired
    private OrderMasterMapper orderMasterMapper;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        //TODO 查询商品信息(调用商品服务)
        //TODO 计算总价
        //TODO 扣库存(调用商品服务)
        OrderMaster orderMaster = new OrderMaster();
        //orderMaster.setOrderId(IdWorker.getIdStr()); 自动生成

        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterMapper.insert(orderMaster);
        return orderDTO;
    }
}

package com.imooc.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.imooc.product.eunm.ProductStatusEnum;
import com.imooc.product.mapper.ProductMapper;
import com.imooc.product.pojo.ProductInfo;
import com.imooc.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductInfo> findUpAll() {
        Map<String, Object> map = new HashMap<>();
        map.put("product_status", ProductStatusEnum.UP.getCode());
        return productMapper.selectByMap(map);
    }

    @Override
    public List<ProductInfo> findByIds(List<String> productIds) {
        List<ProductInfo> productInfos = productMapper.selectBatchIds(productIds);
        return productInfos;
    }
}

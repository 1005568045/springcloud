package com.imooc.product.service.impl;

import com.imooc.product.ProductApplicationTests;
import com.imooc.product.mapper.ProductMapper;
import com.imooc.product.pojo.ProductInfo;
import com.imooc.product.service.ProductService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ProductServiceImplTest extends ProductApplicationTests {

    @Autowired
    private ProductService productService;

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfos = productService.findUpAll();
        productInfos.forEach( System.out::println);

    }

    @Test
    public void findByIds() {
        List<ProductInfo> productInfoList = productService.findByIds(Arrays.asList("157875196366160022", "157875227953464068"));
        productInfoList.forEach(System.out::println);
    }
}
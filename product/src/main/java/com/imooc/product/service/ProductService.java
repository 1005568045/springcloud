package com.imooc.product.service;

import com.imooc.product.pojo.ProductInfo;

import java.util.List;

public interface ProductService {
    List<ProductInfo> findUpAll();

    List<ProductInfo> findByIds(List<String> productIds);
}

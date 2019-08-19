package com.imooc.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.imooc.product.mapper.CategoryMapper;
import com.imooc.product.pojo.ProductCategory;
import com.imooc.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        QueryWrapper<ProductCategory> wrapper = new QueryWrapper<>();
        wrapper.in("category_type",categoryTypeList);
        return categoryMapper.selectList(wrapper);
    }
}

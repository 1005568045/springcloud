package com.imooc.product.service.impl;

import com.imooc.product.ProductApplicationTests;
import com.imooc.product.pojo.ProductCategory;
import com.imooc.product.service.CategoryService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
@Component
public class CategoryServiceImplTest extends ProductApplicationTests {
    @Autowired
    private CategoryService categoryService;
    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> ProductCategoryList = categoryService.findByCategoryTypeIn(Arrays.asList(22));
        ProductCategoryList.forEach(System.out::println);
    }
}
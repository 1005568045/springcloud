package com.imooc.product.controller;

import com.imooc.product.pojo.ProductCategory;
import com.imooc.product.pojo.ProductInfo;
import com.imooc.product.service.CategoryService;
import com.imooc.product.service.ProductService;
import com.imooc.product.utils.ResultVOUtil;
import com.imooc.product.vo.CategoryVo;
import com.imooc.product.vo.ProductVo;
import com.imooc.product.vo.ResultVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1. 查询所有在架的商品
 * 2. 获取类目type列表
 * 3. 查询类目
 * 4. 构造数据
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public ResultVo list(){
        List<ProductInfo> productInfoList = productService.findUpAll();
        List<Integer> categoryTypeList = productInfoList.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        List<CategoryVo> categoryVoList = new ArrayList<>();
       for (ProductCategory productCategory:categoryList){
           CategoryVo categoryVo = new CategoryVo();
           categoryVo.setCategoryName(productCategory.getCategoryName());
           categoryVo.setCategoryType(productCategory.getCategoryType());
           List<ProductVo> productVoList = new ArrayList<>();
           for (ProductInfo productInfo:productInfoList){
               if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                   ProductVo productVo = new ProductVo();
                   BeanUtils.copyProperties(productInfo, productVo);
                   productVoList.add(productVo);
               }
           }
           categoryVo.setProductInfoVOList(productVoList);
           categoryVoList.add(categoryVo);
       }

        return ResultVOUtil.success(categoryVoList);
    }

    /**
     * 获取商品列表（给订单服务使用）
     * @return
     */
    @GetMapping("listForOrder")
    public List<ProductInfo> listForOrder(@RequestBody List<String> productIdList){
        return productService.findByIds(productIdList);
    }

}

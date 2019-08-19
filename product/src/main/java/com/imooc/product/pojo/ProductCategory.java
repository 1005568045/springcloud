package com.imooc.product.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import java.util.Date;

/**
 * Created by wh
 * 2019年8月19日10:32:21
 */
@Data
public class ProductCategory {

    @TableId
    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;
}

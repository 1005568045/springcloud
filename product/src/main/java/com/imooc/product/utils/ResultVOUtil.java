package com.imooc.product.utils;

import com.imooc.product.vo.ResultVo;

public class ResultVOUtil {
    public static ResultVo success(Object obj){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(0);
        resultVo.setData(obj);
        resultVo.setMsg("成功");
        return resultVo;
    }
}

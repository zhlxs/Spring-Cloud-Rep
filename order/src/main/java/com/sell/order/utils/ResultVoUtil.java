package com.sell.product.utils;

import com.sell.product.vo.ResultVo;

/**
 * 返回结果
 */
public class ResultVoUtil {

    /**
     * 请求成功
     *
     * @param data
     * @return
     */
    public static ResultVo success(Object data) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(0);
        resultVo.setMsg("查询数据成功！");
        resultVo.setData(data);
        return resultVo;
    }

}

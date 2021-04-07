package com.zhong.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {

    /**
     * Json 封装体
     */


    //404 not_found
    private Integer code;
    private String message;
    private T data;

    //只有两个参数的构造
    public CommonResult(Integer code, String message){

        this(code,message,null);
        /*
        使用Lombok 简化了以前的 this.code = code; ...
         */
    }

}


package com.zzyl.exception;


import com.zzyl.enums.BasicEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * BaseException
 * @author itheima
 **/
@Getter
@Setter
public class BaseException extends RuntimeException {

    private BasicEnum basicEnum;
    //入参的basicEnum传给成员变量的basicEnum，成员变量basicEnum就有值了
    //有值后，全局异常处理器就能获取这个值并包装返回给前端

    public BaseException(BasicEnum basicEnum) {
        this.basicEnum = basicEnum;
    }
}

package com.cc.common.enums;

/**
 * @author 池臣
 * @data 2020/8/1
 */
public enum ResultStatusEnum {

    SUCCESS(1),
    FAILURE(0);

    public Integer code;

    ResultStatusEnum(Integer code) {
        this.code = code;
    }
}

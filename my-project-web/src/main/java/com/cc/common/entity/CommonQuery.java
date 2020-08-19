package com.cc.common.entity;

import lombok.Data;

/**
 * @author 池臣
 * @data 2020/8/19
 */
@Data
public class CommonQuery {

    /**
     * 当前页
     */
    private Integer current = 1;
    /**
     * 每页显示记录数
     */
    private Integer size = 10;

}

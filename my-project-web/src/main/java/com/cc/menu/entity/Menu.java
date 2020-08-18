package com.cc.menu.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 菜单管理
 * </p>
 *
 * @author
 * @since 2020-08-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("menu")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("seq")
    private String seq;

    /**
     * 父菜单seq
     */
    @TableField("parent_seq")
    private String parentSeq;

    /**
     * 菜单名称
     */
    @TableField("menu_name")
    private String menuName;

    /**
     * 菜单地址
     */
    @TableField("menu_path")
    private String menuPath;

    /**
     * 图标
     */
    @TableField("icon")
    private String icon;


}

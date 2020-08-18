package com.cc.menu.service;

import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.menu.entity.Menu;

import java.util.List;

/**
 * <p>
 * 菜单管理 服务类
 * </p>
 *
 * @author
 * @since 2020-08-13
 */
public interface IMenuService extends IService<Menu> {

    /**
     * 查询树菜单
     *
     * @return
     * @throws Exception
     */
    List<Tree<String>> getTreeMenu() throws Exception;
}

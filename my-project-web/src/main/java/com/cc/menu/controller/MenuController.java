package com.cc.menu.controller;


import cn.hutool.core.lang.tree.Tree;
import com.cc.common.entity.Result;
import com.cc.common.enums.ResultStatusEnum;
import com.cc.menu.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 菜单管理 前端控制器
 * </p>
 *
 * @author
 * @since 2020-08-13
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private IMenuService iMenuService;

    /**
     * 查询树菜单
     *
     * @return
     */
    @RequestMapping("/getTreeMenu")
    public Result getTreeMenu() {
        try {
            return new Result<List<Tree<String>>>(ResultStatusEnum.SUCCESS.code, iMenuService.getTreeMenu());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<String>(ResultStatusEnum.FAILURE.code, "查询失败");
        }
    }

}

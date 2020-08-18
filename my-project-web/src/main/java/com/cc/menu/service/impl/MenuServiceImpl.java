package com.cc.menu.service.impl;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.menu.entity.Menu;
import com.cc.menu.mapper.MenuMapper;
import com.cc.menu.service.IMenuService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜单管理 服务实现类
 * </p>
 *
 * @author
 * @since 2020-08-13
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Override
    public List<Tree<String>> getTreeMenu() throws Exception {
        List<Menu> list = list();
        List<TreeNode<String>> collect = list.stream().map(menu ->
                new TreeNode<>(menu.getSeq(), menu.getParentSeq(), menu.getMenuName(), null)
                        .setExtra(new HashMap<String, Object>(1) {{
                            put("path", menu.getMenuPath());
                        }}))
                .collect(Collectors.toList());
        return TreeUtil.build(collect, "0");
    }
}

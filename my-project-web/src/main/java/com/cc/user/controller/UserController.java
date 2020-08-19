package com.cc.user.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cc.common.entity.CommonQuery;
import com.cc.common.entity.Result;
import com.cc.common.enums.ResultStatusEnum;
import com.cc.user.entity.User;
import com.cc.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author
 * @since 2020-08-01
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping("/login")
    public Result<String> login(@RequestBody User user) {
        try {
            iUserService.login(user);
            return new Result<>(ResultStatusEnum.SUCCESS.code, "登录成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(ResultStatusEnum.FAILURE.code, "登录失败");
        }
    }

    @RequestMapping("/registered")
    public Result<String> registered(@RequestBody User user) throws Exception {
        iUserService.registered(user);
        return new Result<>(ResultStatusEnum.SUCCESS.code, "注册成功");
    }

    @RequestMapping("/pageUser")
    public Result<IPage<User>> pageUser(@RequestBody CommonQuery commonQuery) throws Exception {
        return new Result<IPage<User>>(ResultStatusEnum.SUCCESS.code, iUserService.page(new Page<>(commonQuery.getCurrent(), commonQuery.getSize())));
    }

}

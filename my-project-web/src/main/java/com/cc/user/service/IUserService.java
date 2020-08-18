package com.cc.user.service;

import com.cc.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author
 * @since 2020-08-01
 */
public interface IUserService extends IService<User> {

    /**
     * 登录
     *
     * @param user
     * @throws Exception
     */
    void login(User user) throws Exception;

    /**
     * 注册
     *
     * @param user
     * @throws Exception
     */
    void registered(User user) throws Exception;
}

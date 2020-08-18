package com.cc.user.service.impl;

import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.user.entity.User;
import com.cc.user.mapper.UserMapper;
import com.cc.user.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author
 * @since 2020-08-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public void login(User user) throws Exception {
        User one = getOne(new QueryWrapper<User>()
                .lambda()
                .eq(User::getUsername, user.getUsername()));
        if (!DigestUtil.md5Hex(user.getPassword()).equals(one.getPassword())) {
            throw new Exception("密码错误");
        }
    }

    @Override
    public void registered(User user) throws Exception {
        save(user.setPassword(DigestUtil.md5Hex(user.getPassword())));
    }

}

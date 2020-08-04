package com.jwt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jwt.constant.CommonConstant;
import com.jwt.dao.RoleMapper;
import com.jwt.entity.User;
import com.jwt.dao.UserMapper;
import com.jwt.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jwt.utils.CommonUtils;
import com.jwt.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author dctang
 * @since 2020-07-30
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser() {
        /*User user = new User();
        user.setRealName("test");*/
        User user = userMapper.selectById(1);
        log.info("User real name " + user.getRealName());
        return user;
    }


    @Override
    // @Cacheable(value = CommonConstant.L, key = "'Users_' + #username")
    public User getUserByName(String name) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>()
                .eq(User::getUserName, name)
                .last("limit 1");
        User user = userMapper.selectOne(queryWrapper);

//         User user = userMapper.selectById(1);

//        User user = new User();
//        user.setRealName(name);
        log.info("User real name " + user.getRealName());
        return user;
    }

    /**
     * 校验用户是否有效
     * @param user
     * @return
     */
    @Override
    public Result<Object> checkUserIsEffective(User user) {
        Result<Object> result = new Result<>();

        // 情况1：根据用户信息查询，该用户不存在
        if (CommonUtils.isEmpty(user)) {
            result.error500("该用户不存在，请注册");
            return result;
        }

        // 情况2：根据用户信息查询，该用户已注销
        if ("1".equals(user.getDelFlag())) {
            result.error500("该用户已注销");
            return result;
        }

        // 请款3： 根据用户信息查询，该用户已删除
        if ("2".equals(user.getDelFlag())) {
            result.error500("该用户已被删除");
            return result;
        }

        return result;
    }
}

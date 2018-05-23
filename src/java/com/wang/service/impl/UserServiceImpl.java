package com.wang.service.impl;

import com.wang.entity.User;
import com.wang.mapper.UserMapper;
import com.wang.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @Desc UserService实现类
 * @Author Wang926454
 * @Date 2018/5/21 17:10
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int updateByPrimaryKeySelective(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int delete(User user) {
        return userMapper.delete(user);
    }

    @Override
    public User selectOne(User user) {
        return userMapper.selectOne(user);
    }
}

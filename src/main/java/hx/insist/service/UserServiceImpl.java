package hx.insist.service;

import hx.insist.mapper.UserMapper;
import hx.insist.pojo.User;
import hx.insist.utils.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(String username, String password) {
        return userMapper.selectByUsernamePassword(username,password);
    }

    @Override
    public void regist(User user) {
        //包装user
        user.setUid(UUID.randomUUID().toString());
        user.setPassword(WebUtil.md5(user.getPassword()));
        //填入数据库
        userMapper.insert(user);
    }

    @Override
    public int countUserByUsername(String username) {
        return userMapper.selectCountUserByUsername(username);
    }

    @Override
    public int countEmail(String email) {
        return userMapper.selectCountEmail(email);
    }

    @Override
    public void modifyByUid(User user) {
        userMapper.updateByPrimaryKey(user);
    }
}

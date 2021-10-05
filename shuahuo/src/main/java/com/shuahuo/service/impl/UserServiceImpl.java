package com.shuahuo.service.impl;

import com.shuahuo.bean.User;
import com.shuahuo.dao.UserMapper;
import com.shuahuo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> findAllUser() {
        List<User> list = userMapper.findAllUser();
        return list;
    }
    public int addUser(User stu) {
        return userMapper.insertUserSelective(stu);
    }

    public int deleteUser(Integer id) {
        return userMapper.deleteUserByPrimaryKey(id);
    }

    public int updateUser(User stu) {
        return userMapper.updateUserByPrimaryKeySelective(stu);
    }

    public List<User> findUserByUsername(String username) {
        return userMapper.selectUserByUsername(username);
    }

    public List<User> findUserByPhonenum(String phonenum) {
        return userMapper.selectUserByPhonenum(phonenum);
    }

    public List<User> findUserByMail(String mail) {
        return userMapper.selectUserByMail(mail);
    }

    public List<User> findUserById(Integer id) {
        return userMapper.selectUserById(id);
    }
}

package com.shuahuo.service;

import com.shuahuo.bean.User;
import java.util.List;

public interface UserService {
    /**
    查询所有用户
     */
    public List<User> findAllUser();
    /**
    添加用户记录
     */
    public int addUser(User user);
    /**
    根据id删除用户记录
     */
    public int deleteUser(Integer id);
    /**
    更新用户记录
     */
    public int updateUser(User stu);
    /**
     根据username查询用户信息
     */
    public List<User> findUserByUsername(String username);
    /**
     根据phonenum查询用户信息
     */
    public List<User> findUserByPhonenum(String phonenum);
    /**
     根据mail查询用户信息
     */
    public List<User> findUserByMail(String mail);
    /**
     根据id查询用户信息
     */
    public List<User> findUserById(Integer id);
}

package com.shuahuo.dao;

import com.shuahuo.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 得到所有的用户信息
     * @return List<Stu>
     */
    List<User> findAllUser();
    /**
     * 根据id删除某个用户信息
     * @param id
     * @return
     */
    int deleteUserByPrimaryKey(Integer id);
    /**
     * 插入一条用户信息
     * @param record
     * @return
     */
    int insertUserSelective(User record);

    /**
     * 根据username查找某个用户信息
     * @param username
     * @return UserPO
     */
    List<User> selectUserByUsername(String username);

    /**
     * 根据phonenum查找某个用户信息
     * @param phonenum
     * @return
     */

    List<User> selectUserByPhonenum(String phonenum);

    /**
     * 根据phonenum查找某个用户信息
     * @param mail
     * @return
     */

    List<User> selectUserByMail(String mail);

    /**
     *根据id查找某个用户信息
     * @param id
     * @return
     */
    List<User> selectUserById(Integer id);
    /**
     * 根据id更新一条用户信息
     * @param record
     * @return
     */
    int updateUserByPrimaryKeySelective(User record);
}

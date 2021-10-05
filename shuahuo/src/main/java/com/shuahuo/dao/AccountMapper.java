package com.shuahuo.dao;

import com.shuahuo.bean.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountMapper {
    /**
     * 查找所有管理员信息
     * @return UserPO
     */
    public List<Account> findAllAccount();

    /**
     * 根据id查找某个管理员信息
     * @param id
     * @return UserPO
     */
    public List<Account> selectAccountById(Integer id);

    /**
     * 根据id查找某个管理员信息
     * @param name
     * @return UserPO
     */
    public List<Account> selectAccountByUsername(String name);

    /**
     * 根据id删除某个管理员信息
     * @param id
     * @return
     */
    int deleteAccountByPrimaryKey(Integer id);

    /**
     * 插入一条管理员信息
     * @param record
     * @return
     */
    int insertAccountSelective(Account record);

    /**
     * 根据id更新一条管理员信息
     * @param record
     * @return
     */
    int updateAccountByPrimaryKeySelective(Account record);
}

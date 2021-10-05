package com.shuahuo.service;

import com.shuahuo.bean.Account;

import java.util.List;

public interface AccountService {
    /**
     * 查询所有管理员
     */
    public List<Account> findlAccount();

    /**
     * 根据id查询管理员
     */
    public List<Account> findlAccountById(Integer id);

    /**
     * 根据username查询管理员
     */
    public List<Account> findlAccountByUsername(String Username);

    /**
     * 添加管理员
     */
    public int addlAccount(Account account);

    /**
     * 更新管理员
     */
    public int updatelAccount(Account account);

    /**
     * 根据id删除管理员
     */
    public int deletelAccount(Integer id);
}

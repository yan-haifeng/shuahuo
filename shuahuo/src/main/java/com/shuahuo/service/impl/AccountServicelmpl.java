package com.shuahuo.service.impl;

import com.shuahuo.bean.Account;
import com.shuahuo.dao.AccountMapper;
import com.shuahuo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServicelmpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<Account> findlAccount() {
        return accountMapper.findAllAccount();
    }

    @Override
    public List<Account> findlAccountById(Integer id) {
        return accountMapper.selectAccountById(id);
    }

    @Override
    public List<Account> findlAccountByUsername(String Username) {
        return accountMapper.selectAccountByUsername(Username);
    }

    @Override
    public int addlAccount(Account account) {
        return accountMapper.insertAccountSelective(account);
    }

    @Override
    public int updatelAccount(Account account) {
        return accountMapper.updateAccountByPrimaryKeySelective(account);
    }

    @Override
    public int deletelAccount(Integer id) {
        return deletelAccount(id);
    }
}

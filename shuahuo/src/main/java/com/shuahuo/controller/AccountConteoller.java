package com.shuahuo.controller;

import com.shuahuo.bean.Account;
import com.shuahuo.service.AccountService;
import com.shuahuo.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AccountConteoller {
    @Autowired
    private AccountService accountService;

    /**
     *账号登录
     * @param
     * @return
     */
    @CrossOrigin
    @RequestMapping("/backaccountlogin")
    public JsonUtil<Account> backaccountlogin(String username, String password, HttpServletResponse response, HttpServletRequest request) {
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));//处理跨域
        response.setHeader("Access-Control-Allow-Credentials", "true");//表示是否允许发送Cookie
        try {
            Account account = accountService.findlAccountByUsername(username).get(0);
            if(password.equals(account.getPassword())){
                //登录成功
                List<Account> list = new ArrayList<Account>();
                list.add(account);
                request.getSession().setAttribute("account", list);
                return JsonUtil.success().addData(list);
            }else{
                return JsonUtil.fail("密码输入错误");
            }
        }catch (Exception e){
            e.printStackTrace();
            return JsonUtil.fail("错误 登录失败");
        }
    }

    /**
     * 用户名是否登录
     * @return
     */
    @CrossOrigin
    @RequestMapping("backislogin")
    public JsonUtil<Account> AccountIsLogin(HttpServletRequest request) {
        if (request.getSession().getAttribute("account")!=null) {
            List<Account> account = (List<Account>) request.getSession().getAttribute("account");
            return JsonUtil.success().addCount(1).addData(account);
        }else {
            return JsonUtil.fail("无用户登录");
        }
    }

    /**
     * 退出登录
     * @return
     */
    @CrossOrigin
    @RequestMapping("backexitlogin")
    public boolean backExitLogin(HttpServletRequest request) {
        if (request.getSession().getAttribute("account")!=null) {
            request.getSession().removeAttribute("account");
            request.getSession().invalidate();
            return true;
        }else {
            return false;
        }
    }
}

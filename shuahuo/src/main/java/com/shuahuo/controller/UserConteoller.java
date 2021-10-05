package com.shuahuo.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.shuahuo.bean.User;
import com.shuahuo.service.MailService;
import com.shuahuo.service.UserService;
import com.shuahuo.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserConteoller {

    @Autowired
    private UserService userService;
    @Autowired
    private MailService mailService;
    NodeCodeUtil nodeCodeUtil = new NodeCodeUtil();

    /**
     * 发送手机验证码
     * @param phonenum
     * @param request
     */
    @CrossOrigin
    @RequestMapping("/getphonecode")
    public JsonUtil<User> getphonecode(String phonenum ,HttpServletRequest request,HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));//处理跨域
        response.setHeader("Access-Control-Allow-Credentials", "true");//表示是否允许发送Cookie
        try {
            String getcode = nodeCodeUtil.  getNodeCode(phonenum);
            JsonObject jsoncode = new JsonParser().parse(getcode).getAsJsonObject();
            String code = jsoncode.get("code").toString();
            String obj = jsoncode.get("obj").toString();
            if(code.equals("200")){
                request.getSession().setAttribute(phonenum,obj);
                request.getSession().setAttribute("msg",code);
                request.getSession().setMaxInactiveInterval(600);
                return JsonUtil.success();
            }else{
                request.getSession().setAttribute("msg",code);
                return JsonUtil.fail("错误"+code);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return JsonUtil.fail("错误");
        }
    }

    /**
     * 发送邮箱验证码
     * @param mailuser
     * @param request
     * @param response
     * @return
     */
    @CrossOrigin
    @RequestMapping("/getMailCode")
        public JsonUtil<User> getMailCode(String mailuser,HttpServletRequest request,HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));//处理跨域
        response.setHeader("Access-Control-Allow-Credentials", "true");//表示是否允许发送Cookie
        String verificat = RandomName.GetRandomNumber(6);
        String content = "<html><body><h5>" + "尊敬的耍货用户，您的验证码是:" + "</h5><h3 color=\"red\">"+verificat+"</h3></body></html>";
        Boolean code = mailService.sendHtmlMail(mailuser, "耍货验证码", content);
        if(code){
            request.getSession().setAttribute(mailuser,verificat);
            request.getSession().setMaxInactiveInterval(600);
            return JsonUtil.success();
        }else {
            return JsonUtil.fail("验证码发送失败");
        }
    }

    /**
     * 手机号注册
     * 判断验证码是否正确并添加账号
     * @param phonenum
     * @param request
     */
    @CrossOrigin
    @RequestMapping("/phonenumadduser")
    public JsonUtil<User> PhonenumAddUser(String phonenum,String verificatcode,String password,HttpServletRequest request,HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));//处理跨域
        response.setHeader("Access-Control-Allow-Credentials", "true");//表示是否允许发送Cookie
        try {
            String verificat = (request.getSession().getAttribute(phonenum).toString()).substring(1,7);
            System.out.println("验证码:"+verificat);
            System.out.println("输入验证码为"+verificatcode);
            if(verificat!=null||!verificat.equals("")) {
                if (verificatcode.equals(verificat)){
                    User user = new User();
                    user.setPhonenum(phonenum);
                    user.setPassword(password);
                    int code = userService.addUser(user);
                    if (code == 1) {
                        return JsonUtil.success();
                    }else {
                        return JsonUtil.fail("手机号已注册");
                    }
                }else{
                    return JsonUtil.fail("验证码错误");
                }
            }else{
                return JsonUtil.fail("添加失败"+request.getSession().getAttribute("msg").toString());
            }
        }catch (Exception e){
            e.printStackTrace();
            return JsonUtil.fail("错误 添加失败");
        }
    }

    /**
     * 邮箱注册
     * 判断邮箱验证码是否正确
     * @return
     */
    @CrossOrigin
    @RequestMapping("/MailAddUser")
    public JsonUtil<User> MailAddUser(String mailname,String verificatcode,String password,HttpServletResponse response,HttpServletRequest request){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));//处理跨域
        response.setHeader("Access-Control-Allow-Credentials", "true");//表示是否允许发送Cookie
        String verificat = request.getSession().getAttribute(mailname).toString();
        System.out.println("验证码:"+verificat);
        System.out.println("输入验证码为"+verificatcode);
        if(verificat!=null||!verificat.equals("")) {
            if (verificatcode.equals(verificat)){
                User user = new User();
                user.setE_mail(mailname);
                user.setPassword(password);
                int code = userService.addUser(user);
                if (code == 1) {
                    return JsonUtil.success();
                }else {
                    return JsonUtil.fail("邮箱号已注册");
                }
            }else{
                return JsonUtil.fail("验证码错误");
            }
        }else{
            return JsonUtil.fail("添加失败");
        }
    }

    /**
     *普通账号注册
     * @param
     * @return
     */
    @CrossOrigin
    @RequestMapping("/usernameadduser")
    public JsonUtil<User> UsernameAddUser(String username,String password,String newpassword,HttpServletRequest request,HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));//处理跨域
        response.setHeader("Access-Control-Allow-Credentials", "true");//表示是否允许发送Cookie
        if(password.equals(newpassword)){
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            int code =  userService.addUser(user);
            if(code==1){
                return JsonUtil.success();
            }else {
                return JsonUtil.fail("添加失败");
            }
        }else{
            return JsonUtil.fail("两次密码不一致");
        }
    }

    /**
     *手机账号登录
     * @param phonenum
     * @return
     */
    @CrossOrigin
    @RequestMapping("/mobilelogin")
    public JsonUtil<User> mobileLogin(String phonenum,String verificatcode,HttpServletResponse response,HttpServletRequest request) {
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));//处理跨域
        response.setHeader("Access-Control-Allow-Credentials", "true");//表示是否允许发送Cookie
        try {
            String verificat = (request.getSession().getAttribute(phonenum).toString()).substring(1,7);
            System.out.println("验证码:"+verificat);
            System.out.println("输入验证码为"+verificatcode);
            System.out.println(verificat.equals(verificatcode));
            if(verificat!=null||!verificat.equals("")) {
                if (verificatcode.equals(verificat)){
                    List<User> user =  userService.findUserByPhonenum(phonenum);
                    if (user!=null||user.size()!=0) {
                        //登录成功
                        request.getSession().setAttribute("user", user);
                        return JsonUtil.success().addData(user);
                    }else{
                        return JsonUtil.fail("该手机号未注册");
                    }
                }else{
                    return JsonUtil.fail("验证码错误");
                }
            }else{
                return JsonUtil.fail("登录失败"+request.getSession().getAttribute("msg").toString());
            }
        }catch (Exception e){
            e.printStackTrace();
            return JsonUtil.fail("错误 登录失败");
        }
    }

    /**
     * 邮箱登录
     * 判断邮箱验证码是否正确
     * @return
     */
    @CrossOrigin
    @RequestMapping("/MailLogin")
    public JsonUtil<User> MailLogin(String mailname,String verificatcode,HttpServletResponse response,HttpServletRequest request){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));//处理跨域
        response.setHeader("Access-Control-Allow-Credentials", "true");//表示是否允许发送Cookie
        String verificat = request.getSession().getAttribute(mailname).toString();
        System.out.println("验证码:"+verificat);
        System.out.println("输入验证码为"+verificatcode);
        if(verificat!=null||!verificat.equals("")) {
            if (verificatcode.equals(verificat)){
                List<User> user =  userService.findUserByMail(mailname);
                if (user!=null||user.size()!=0) {
                    //登录成功
                    request.getSession().setAttribute("user", user);
                    return JsonUtil.success().addData(user);
                }else{
                    return JsonUtil.fail("该邮箱号未注册");
                }
            }else{
                return JsonUtil.fail("验证码错误");
            }
        }else{
            return JsonUtil.fail("添加失败");
        }
    }


    /**
     *账号登录
     * @param
     * @return
     */
    @CrossOrigin
    @RequestMapping("/accountlogin")
    public JsonUtil<User> accountLogin(String username,String password,HttpServletResponse response,HttpServletRequest request) {
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));//处理跨域
        response.setHeader("Access-Control-Allow-Credentials", "true");//表示是否允许发送Cookie
        try {
            User user = userService.findUserByUsername(username).get(0);
            if(password.equals(user.getPassword())){
                //登录成功
                List<User> list = new ArrayList<User>();
                list.add(user);
                request.getSession().setAttribute("user", list);
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
    @RequestMapping("islogin")
    public JsonUtil<User> UserIsLogin(HttpServletRequest request) {
        if (request.getSession().getAttribute("user")!=null) {
            List<User> user = (List<User>) request.getSession().getAttribute("user");
            return JsonUtil.success().addCount(1).addData(user);
        }else {
            return JsonUtil.fail("无用户登录");
        }
    }

    /**
     * 退出登录
     * @return
     */
    @CrossOrigin
    @RequestMapping("exitlogin")
    public boolean ExitLogin(HttpServletRequest request) {
        if (request.getSession().getAttribute("user")!=null) {
            request.getSession().removeAttribute("user");
            request.getSession().invalidate();
            return true;
        }else {
            return false;
        }
    }

    /**
     * 根据用户id拿用户信息
     * @return
     */
    @CrossOrigin
    @RequestMapping("findUserById")
    public JsonUtil<User> findUserById(int id) {
        return JsonUtil.success().addData(userService.findUserById(id));
    }

    /**
     * 返回所有用户信息
     * @return
     */
    @CrossOrigin
    @RequestMapping("findAllUser")
    public JsonUtil<User> findAllUser() {
        return JsonUtil.success().addData(userService.findAllUser());
    }

    /**
     * 头像图片上传
     * @param file
     * @param id
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "uploadHeadImgFile",method = RequestMethod.POST)
    public JsonUtil<User> uploadHeadImage(@RequestParam("file") MultipartFile file,int id) {
        User user = userService.findUserById(id).get(0);
        if (!file.isEmpty()) {
            try {
                String UPLOAD_FILE_PATH = ResourceUtils.getURL("classpath:").getPath()+"static/page/shuaHuoProject/resources/upload/headimg";
                String suffixName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
                String name = id+"headimg"+suffixName;//上传图片的真实名称
                String imgname =  GenerateImage.uploadFile(file,UPLOAD_FILE_PATH,name);
                System.out.println("头像上传成功:"+UPLOAD_FILE_PATH+"/"+imgname);
                user.setHeadimg_name(imgname);
                userService.updateUser(user);
                return JsonUtil.success().addMsg(imgname);
            } catch (IOException e) {
                e.printStackTrace();
                return JsonUtil.fail("错误");
            }
        } else {
            return null;
        }
    }

    /**
     * 根据用户id修改用户信息
     * @return
     */
    @CrossOrigin
    @RequestMapping("changeUserData")
    public JsonUtil<User> changeUserData(User user) {
                int code = userService.updateUser(user);
                if (code == 1) {
                    return JsonUtil.success();
                } else {
                    return JsonUtil.fail("修改失败");
                }
            }

            /**
             * 根据用户id用户工作室信息
             * @return
             */
            @CrossOrigin
            @RequestMapping("changeStudioIdForUser")
            public JsonUtil<User> changeStudioIdForUser ( int userId, int studioId){
                User user = userService.findUserById(userId).get(0);
                user.setStudio_id(studioId);
                int code = userService.updateUser(user);
                if (code == 1) {
                    return JsonUtil.success();
                } else {
                    return JsonUtil.fail("修改失败");
                }
            }

            @CrossOrigin
            @RequestMapping("changeUsernameById")
            public JsonUtil<User> changeUsernameById ( int id, String newusername, String password){
                User user = userService.findUserById(id).get(0);
                if (password.equals(user.getPassword())) {
                    user.setUsername(newusername);
                    int code = userService.updateUser(user);
                    if (code == 1) {
                        return JsonUtil.success();
                    } else {
                        return JsonUtil.fail("该账户已被使用");
                    }
                } else {
                    return JsonUtil.fail("密码输入错误");
                }
            }

            @CrossOrigin
            @RequestMapping("changePasswordById")
            public JsonUtil<User> changePasswordById ( int id, String password, String newpassword){
                User user = userService.findUserById(id).get(0);
                if (password.equals(newpassword)) {
                    user.setPassword(password);
                    int code = userService.updateUser(user);
                    if (code == 1) {
                        return JsonUtil.success();
                    } else {
                        return JsonUtil.fail("错误");
                    }
                } else {
                    return JsonUtil.fail("两次密码不一致");
                }
            }

            @CrossOrigin
            @RequestMapping("changePhoneNumById")
            public JsonUtil<User> changePhoneNumById ( int id, String phonenum, String verificatcode, HttpServletRequest
            request, HttpServletResponse response){
                response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));//处理跨域
                response.setHeader("Access-Control-Allow-Credentials", "true");//表示是否允许发送Cookie
                try {
                    String verificat = (request.getSession().getAttribute(phonenum).toString()).substring(1, 7);
                    System.out.println("验证码:" + verificat);
                    System.out.println("输入验证码为" + verificatcode);
                    System.out.println(verificat.equals(verificatcode));
                    if (verificat != null || !verificat.equals("")) {
                        if (verificatcode.equals(verificat)) {
                            User user = userService.findUserById(id).get(0);
                            //修改成功
                            user.setPhonenum(phonenum);
                            userService.updateUser(user);
                            return JsonUtil.success();
                        } else {
                            return JsonUtil.fail("验证码错误");
                        }
                    } else {
                        return JsonUtil.fail("修改失败" + request.getSession().getAttribute("msg").toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return JsonUtil.fail("错误 修改失败，可能该手机已被使用");
                }
            }

            @CrossOrigin
            @RequestMapping("changeMailById")
            public JsonUtil<User> changeMailById ( int id, String mail, String verificatcode, HttpServletRequest
            request, HttpServletResponse response){
                response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));//处理跨域
                response.setHeader("Access-Control-Allow-Credentials", "true");//表示是否允许发送Cookie
                try {
                    String verificat = request.getSession().getAttribute(mail).toString();
                    System.out.println("验证码:" + verificat);
                    System.out.println("输入验证码为" + verificatcode);
                    System.out.println(verificat.equals(verificatcode));
                    if (verificat != null || !verificat.equals("")) {
                        if (verificatcode.equals(verificat)) {
                            User user = userService.findUserById(id).get(0);
                            //修改成功
                            user.setE_mail(mail);
                            userService.updateUser(user);
                            return JsonUtil.success();
                        } else {
                            return JsonUtil.fail("验证码错误");
                        }
                    } else {
                        return JsonUtil.fail("修改失败" + request.getSession().getAttribute("msg").toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return JsonUtil.fail("错误 修改失败，可能该邮箱已被使用");
                }
            }

    @CrossOrigin
    @RequestMapping("deleteUserById")
    public JsonUtil<User> deleteUserById(@RequestParam(value="id", defaultValue="-1") Integer id) {
        int code = userService.deleteUser(id);
        if(code==1){
            return JsonUtil.success();
        }else {
            return JsonUtil.fail("删除失败");
        }
    }

    @CrossOrigin
    @RequestMapping("addUser")
    public  JsonUtil<User> addUser(User user){
         int code = userService.addUser(user);
         if(code==1){
          return JsonUtil.success();
           }else{
             return JsonUtil.fail("添加失败");
           }
    }
}
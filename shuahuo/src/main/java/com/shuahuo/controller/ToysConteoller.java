package com.shuahuo.controller;

import com.shuahuo.bean.Toys;
import com.shuahuo.service.ToysService;
import com.shuahuo.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToysConteoller {
    @Autowired
    private ToysService toysService;

    //查询所有的玩具
    @CrossOrigin
    @RequestMapping("/findAllToys")
    public JsonUtil<Toys> findAllToys() {
        return JsonUtil.success().addData(toysService.findAllToys());
    }

    //根据Id查询玩具
    @CrossOrigin
    @RequestMapping("/findToysById")
    public JsonUtil<Toys> findToysById(int id) {
        return JsonUtil.success().addData(toysService.findToysById(id));
    }

    /**
     * 根据用户id修改用户信息
     * @return
     */
    @CrossOrigin
    @RequestMapping("changeToysData")
    public JsonUtil<Toys> changeToysData(Toys toys) {
        int code = toysService.updateToys(toys);
        if (code == 1) {
            return JsonUtil.success();
        } else {
            return JsonUtil.fail("修改失败");
        }
    }

    @CrossOrigin
    @RequestMapping("deleteToysById")
    public JsonUtil<Toys> deleteToysById(@RequestParam(value="id", defaultValue="-1") Integer id) {
        int code = toysService.deleteToys(id);
        if(code==1){
            return JsonUtil.success();
        }else {
            return JsonUtil.fail("删除失败");
        }
    }

    @CrossOrigin
    @RequestMapping("addToys")
    public JsonUtil<Toys> addToys(Toys toys) {
        int code = toysService.addToys(toys);
        if(code==1){
            return JsonUtil.success();
        }else {
            return JsonUtil.fail("添加失败");
        }
    }
}

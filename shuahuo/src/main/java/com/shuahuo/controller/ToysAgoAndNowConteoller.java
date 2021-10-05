package com.shuahuo.controller;

import com.shuahuo.bean.ToysAgoAndNow;
import com.shuahuo.service.ToysAgoAndNowService;
import com.shuahuo.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToysAgoAndNowConteoller {
    @Autowired
    private ToysAgoAndNowService toysAgoAndNowService;

    //根据玩具id查询玩具前世今生
    @CrossOrigin
    @RequestMapping("/findToysAgoAndNowByToysId")
    public JsonUtil<ToysAgoAndNow> findToysAgoAndNowByToysId(int toysid) {
        return JsonUtil.success().addData(toysAgoAndNowService.findToysAgoAndNowByToysId(toysid));
    }
}

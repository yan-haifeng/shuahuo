package com.shuahuo.controller;

import com.shuahuo.bean.ToysMemory;
import com.shuahuo.service.ToysMemoryService;
import com.shuahuo.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToysMemoryConteoller {
    @Autowired
    private ToysMemoryService toysMemoryService;

    //根据玩具id查询玩具文化记忆
    @CrossOrigin
    @RequestMapping("/findToysMemoryByToysId")
    public JsonUtil<ToysMemory> findToysAgoAndNowByToysId(int toysid) {
        return JsonUtil.success().addData(toysMemoryService.findToysMemoryByToysId(toysid));
    }

}

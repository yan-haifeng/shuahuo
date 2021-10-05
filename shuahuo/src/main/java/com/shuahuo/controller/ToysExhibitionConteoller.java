package com.shuahuo.controller;

import com.shuahuo.bean.ToysExhibition;
import com.shuahuo.service.ToysExhibitionService;
import com.shuahuo.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToysExhibitionConteoller {
    @Autowired
    private ToysExhibitionService toysExhibitionService;

    //根据玩具id查询玩具虚拟展厅
    @CrossOrigin
    @RequestMapping("/findToysExhibitionByToysId")
    public JsonUtil<ToysExhibition> findToysExhibitionByToysId(int toysid) {
        return JsonUtil.success().addData(toysExhibitionService.findToysExhibitionByToysId(toysid));
    }
}

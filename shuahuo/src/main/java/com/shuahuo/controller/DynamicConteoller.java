package com.shuahuo.controller;


import com.shuahuo.bean.Dynamic;
import com.shuahuo.service.DynamicService;
import com.shuahuo.util.GenerateImage;
import com.shuahuo.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
public class DynamicConteoller {
    @Autowired
    private DynamicService dynamicService;

    //根据用户id查询动态根据发布早晚
    @CrossOrigin
    @RequestMapping("/findDynamicByUserId")
    public JsonUtil<Dynamic> findDynamicByUserId(int userid) {
        return JsonUtil.success().addData(dynamicService.findDynamicByUserId(userid));
    }

    //查询所有的动态根据发布早晚
    @CrossOrigin
    @RequestMapping("/findAllDynamic")
    public JsonUtil<Dynamic> findAllDynamic() {
        return JsonUtil.success().addData(dynamicService.findAllDynamicDesc());
    }

    //添加动态
    @CrossOrigin
    @RequestMapping("/addDynamic")
    public JsonUtil<Dynamic> AddDynamic(Dynamic dynamic) {
        int code = dynamicService.addDynamic(dynamic);
        if (code == 1) {
            return JsonUtil.success();
        } else {
            return JsonUtil.fail("添加失败");
        }
    }

    //图片文件上传
    @CrossOrigin
    @RequestMapping(value = "uploadImgFile", method = RequestMethod.POST)
    public JsonUtil<Dynamic> uploadImage(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                String UPLOAD_FILE_PATH = ResourceUtils.getURL("classpath:").getPath() + "static/page/shuaHuoProject/resources/upload/img";
                System.out.println(UPLOAD_FILE_PATH);
                String name = file.getOriginalFilename();//上传图片的真实名称
                String imgname = GenerateImage.uploadFile(file, UPLOAD_FILE_PATH, name);
                System.out.println("图片上传成功:" + UPLOAD_FILE_PATH + "/" + imgname);
                return JsonUtil.success().addMsg(imgname);
            } catch (IOException e) {
                e.printStackTrace();
                return JsonUtil.fail("错误");
            }
        } else {
            return null;
        }
    }

    //视频文件上传
    @CrossOrigin
    @RequestMapping(value = "uploadVideoFile", method = RequestMethod.POST)
    public JsonUtil<Dynamic> uploadVideo(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                String UPLOAD_FILE_PATH = ResourceUtils.getURL("classpath:").getPath() + "static/page/shuaHuoProject/resources/upload/video";
                String name = file.getOriginalFilename();//上传视频的真实名称
                String videoname = GenerateImage.uploadFile(file, UPLOAD_FILE_PATH,name);
                System.out.println("视频上传成功:" + UPLOAD_FILE_PATH + "/" + videoname);
                return JsonUtil.success().addMsg(videoname);
            } catch (IOException e) {
                e.printStackTrace();
                return JsonUtil.fail("错误");
            }
        } else {
            return null;
        }
    }

    //添加点赞
    @CrossOrigin
    @RequestMapping("/addDianzan")
    public JsonUtil<Dynamic> AddDianzan(int id) {
        List<Dynamic> list = dynamicService.findDynamicById(id);
        Dynamic dynamic = list.get(0);
        int dianzanNum = dynamic.getDynamic_dianzan_num();
        dianzanNum = dianzanNum + 1;
        dynamic.setDynamic_dianzan_num(dianzanNum);
        int code = dynamicService.updateDynamic(dynamic);
        if (code == 1) {
            return JsonUtil.success();
        } else {
            return JsonUtil.fail("点赞失败");
        }
    }

    //减少点赞
    @CrossOrigin
    @RequestMapping("/reduceDianzan")
    public JsonUtil<Dynamic> ReduceDianzan(int id) {
        List<Dynamic> list = dynamicService.findDynamicById(id);
        Dynamic dynamic = list.get(0);
        int dianzanNum = dynamic.getDynamic_dianzan_num();
        dianzanNum = dianzanNum - 1;
        dynamic.setDynamic_dianzan_num(dianzanNum);
        int code = dynamicService.updateDynamic(dynamic);
        if (code == 1) {
            return JsonUtil.success();
        } else {
            return JsonUtil.fail("取消失败");
        }
    }

    /**
     * 根据用户id修改用户信息
     * @return
     */
    @CrossOrigin
    @RequestMapping("changeDynamicData")
    public JsonUtil<Dynamic> changeOrderData(Dynamic dynamic) {
        int code = dynamicService.updateDynamic(dynamic);
        if (code == 1) {
            return JsonUtil.success();
        } else {
            return JsonUtil.fail("修改失败");
        }
    }

    @CrossOrigin
    @RequestMapping("deleteDynamicById")
    public JsonUtil<Dynamic> deleteOrderById(@RequestParam(value="id", defaultValue="-1") Integer id) {
        int code = dynamicService.deleteDynamic(id);
        if(code==1){
            return JsonUtil.success();
        }else {
            return JsonUtil.fail("删除失败");
        }
    }
}

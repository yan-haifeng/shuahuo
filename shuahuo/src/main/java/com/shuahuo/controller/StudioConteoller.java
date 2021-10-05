package com.shuahuo.controller;

import com.shuahuo.bean.Studio;
import com.shuahuo.service.StudioService;
import com.shuahuo.util.GenerateImage;
import com.shuahuo.util.JsonUtil;
import com.shuahuo.util.RandomName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
public class StudioConteoller {
    @Autowired
    private StudioService studioService;

    //查询所有的工作室
    @CrossOrigin
    @RequestMapping("/findAllStudio")
    public JsonUtil<Studio> findAllStudio() {
        return JsonUtil.success().addData(studioService.findAllStudio());
    }

    //根据id查询工作室
    @CrossOrigin
    @RequestMapping("/findStudioById")
    public JsonUtil<Studio> findStudioById(int id) {
        return JsonUtil.success().addData(studioService.findStudioById(id));
    }

    //添加工作室
    @CrossOrigin
    @RequestMapping("/addStudio")
    public JsonUtil<Studio> AddStudio(Studio studio) {
        String uuid = UUID.randomUUID().toString();
        studio.setStudio_uuid(uuid);
        int code = studioService.addStudio(studio);
        if (code == 1) {
            List list = studioService.findStudioByUUID(uuid);
            return JsonUtil.success().addData(list);
        } else {
            return JsonUtil.fail("添加失败");
        }
    }

    //Logo图片上传
    @CrossOrigin
    @RequestMapping(value = "uploadStudioLogoImg", method = RequestMethod.POST)
    public JsonUtil<Studio> uploadLogoImage(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                String UPLOAD_FILE_PATH = ResourceUtils.getURL("classpath:").getPath() + "static/page/shuaHuoProject/resources/upload/studiologoimg";
                String suffixName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
                String name = RandomName.GetRandomName()+suffixName;//上传图片的真实名称
                String imgname = GenerateImage.uploadFile(file, UPLOAD_FILE_PATH, name);
                System.out.println("Logo上传成功:" + UPLOAD_FILE_PATH + "/" + imgname);
                return JsonUtil.success().addMsg(imgname);
            } catch (IOException e) {
                e.printStackTrace();
                return JsonUtil.fail("错误");
            }
        } else {
            return null;
        }
    }

    //工作室图片上传
    @CrossOrigin
    @RequestMapping(value = "uploadStudioImg", method = RequestMethod.POST)
    public JsonUtil<Studio> uploadStudioImage(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                String UPLOAD_FILE_PATH = ResourceUtils.getURL("classpath:").getPath() + "static/page/shuaHuoProject/resources/upload/studioimg";
                String name = file.getOriginalFilename();//上传图片的真实名称
                String imgname = GenerateImage.uploadFile(file, UPLOAD_FILE_PATH, name);
                System.out.println("工作室图片上传成功:" + UPLOAD_FILE_PATH + "/" + imgname);
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
     * 根据id修改工作室信息
     * @return
     */
    @CrossOrigin
    @RequestMapping("changeStudioData")
    public JsonUtil<Studio> changeStudioData(Studio studio) {
        int code = studioService.updateStudio(studio);
        if (code == 1) {
            return JsonUtil.success();
        } else {
            return JsonUtil.fail("修改失败");
        }
    }

    @CrossOrigin
    @RequestMapping("deleteStudioById")
    public JsonUtil<Studio> deleteStudioById(@RequestParam(value="id", defaultValue="-1") Integer id) {
        int code = studioService.deleteStudio(id);
        if(code==1){
            return JsonUtil.success();
        }else {
            return JsonUtil.fail("删除失败");
        }
    }
}

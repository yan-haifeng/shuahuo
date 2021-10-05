package com.shuahuo.controller;

import com.shuahuo.bean.StudioMember;
import com.shuahuo.service.StudioMemberService;
import com.shuahuo.util.GenerateImage;
import com.shuahuo.util.JsonUtil;
import com.shuahuo.util.RandomName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
public class StudioMemberConteoller {
    @Autowired
    private StudioMemberService studioMemberService;

    //添加工作室成员
    @CrossOrigin
    @RequestMapping("/addStudioMember")
    public JsonUtil<StudioMember> AddStudioMember(StudioMember studio_member) {
        int code = studioMemberService.addStudio_member(studio_member);
        if (code == 1) {
            return JsonUtil.success();
        } else {
            return JsonUtil.fail("添加失败");
        }
    }

    //根据工作室id查询玩具
    @CrossOrigin
    @RequestMapping("/findStudioMemberByStudioId")
    public JsonUtil<StudioMember> findStudioById(int id) {
        return JsonUtil.success().addData(studioMemberService.findStudio_memberByStudioId(id));
    }

    //成员图片上传
    @CrossOrigin
    @RequestMapping(value = "uploadStudioMemberHeadImg", method = RequestMethod.POST)
    public JsonUtil<StudioMember> UploadStudioMemberHeadImg(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                String UPLOAD_FILE_PATH = ResourceUtils.getURL("classpath:").getPath() + "static/page/shuaHuoProject/resources/upload/memberheadimg";
                String suffixName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
                String name = RandomName.GetRandomName()+suffixName;//上传图片的真实名称
                String imgname = GenerateImage.uploadFile(file, UPLOAD_FILE_PATH, name);
                System.out.println("工作室成员上传成功:" + UPLOAD_FILE_PATH + "/" + imgname);
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
     * 返回所有用户信息
     * @return
     */
    @CrossOrigin
    @RequestMapping("findAllStudioMember")
    public JsonUtil<StudioMember> findAllStudioMember() {
        return JsonUtil.success().addData(studioMemberService.findAllStudio_member());
    }

    /**
     * 根据用户id修改用户信息
     * @return
     */
    @CrossOrigin
    @RequestMapping("changeStudioMemberData")
    public JsonUtil<StudioMember> changeStudioMemberData(StudioMember studioMember) {
        int code = studioMemberService.updateStudio_member(studioMember);
        if (code == 1) {
            return JsonUtil.success();
        } else {
            return JsonUtil.fail("修改失败");
        }
    }

    @CrossOrigin
    @RequestMapping("deleteStudioMemberById")
    public JsonUtil<StudioMember> deleteStudioMemberById(@RequestParam(value="id", defaultValue="-1") Integer id) {
        int code = studioMemberService.deleteStudio_member(id);
        if(code==1){
            return JsonUtil.success();
        }else {
            return JsonUtil.fail("删除失败");
        }
    }

}

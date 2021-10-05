package com.shuahuo.controller;

import com.shuahuo.bean.Comment;
import com.shuahuo.service.CommentService;
import com.shuahuo.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentConteoller {
    @Autowired
    private CommentService commentService;

    //查询与动态id相关的动态
    @CrossOrigin
    @RequestMapping("/findCommentByDynamicId")
    public JsonUtil<Comment> findCommentByDynamicId(int dynamicid) {
        return JsonUtil.success().addData(commentService.findCommentByDynamicId(dynamicid));
    }

    //添加评论
    @CrossOrigin
    @RequestMapping("/addComment")
    public JsonUtil<Comment> addComment(Comment comment) {
        int code = commentService.addComment(comment);
        if (code==1){
            return JsonUtil.success();
        }else{
            return JsonUtil.fail("添加失败");
        }
    }
}

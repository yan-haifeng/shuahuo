package com.shuahuo.service;

import com.shuahuo.bean.Comment;

import java.util.List;

public interface CommentService {
    /**
     查询所有微博动态
     */
    public List<Comment> findAllComment();
    /**
     根据微博动态id查询微博动态
     */
    public List<Comment> findCommentByDynamicId(Integer dynamicid);
    /**
     根据用户id查询微博动态
     */
    public List<Comment> findCommentByUserId(Integer userid);
    /**
     根据评论id查询微博动态
     */
    public List<Comment> findCommentByPrimaryKey(Integer commentid);
    /**
     添加微博动态
     */
    public int addComment(Comment comment);
    /**
     根据id删除微博动态
     */
    public int deleteComment(Integer id);


}

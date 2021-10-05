package com.shuahuo.service.impl;

import com.shuahuo.bean.Comment;
import com.shuahuo.dao.CommentMapper;
import com.shuahuo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServicelmpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> findAllComment() {
        List<Comment> list = commentMapper.findAllComment();
        return list;
    }

    @Override
    public List<Comment> findCommentByDynamicId(Integer dynamicid) {
        List<Comment> list = commentMapper.selectCommentByDynamicId(dynamicid);
        return list;
    }

    @Override
    public List<Comment> findCommentByUserId(Integer userid) {
        List<Comment> list = commentMapper.selectCommentByUserId(userid);
        return list;
    }

    @Override
    public List<Comment> findCommentByPrimaryKey(Integer commentid) {
        List<Comment> list = commentMapper.selectCommentByPrimaryKey(commentid);
        return list;
    }

    @Override
    public int addComment(Comment comment) {
        return commentMapper.insertCommentSelective(comment);
    }

    @Override
    public int deleteComment(Integer id) {
        return commentMapper.deleteCommentByPrimaryKey(id);
    }
}

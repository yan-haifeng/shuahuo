package com.shuahuo.dao;

import com.shuahuo.bean.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    /**
     * 得到所有的微博评论信息
     * @return List<Comment>
     */
    public List<Comment> findAllComment();

    /**
     * 根据微博动态id获得微博评论信息
     * @return
     */
    public List<Comment> selectCommentByDynamicId(Integer dynamicid);

    /**
     * 根据用户id获得微博评论信息
     * @return
     */
    public List<Comment> selectCommentByUserId(Integer userid);

    /**
     * 根据评论id获得微博评论信息
     * @return
     */
    public List<Comment> selectCommentByPrimaryKey(Integer id);

    /**
     * 根据id删除某条评论
     * @param id
     * @return
     */
    public int deleteCommentByPrimaryKey(Integer id);

    /**
     添加微博评论
     */
    public int insertCommentSelective(Comment comment);
}

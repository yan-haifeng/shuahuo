package com.shuahuo.dao;

import com.shuahuo.bean.StudioMember;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudioMemberMapper {
    /**
     * 查找所有工作室成员信息
     * @return
     */
    public List<StudioMember> findAllStudio_member();

    /**
     * 根据studioid查找某个工作室成员信息
     *
     * @param studioid
     * @return
     */
    public List<StudioMember> selectStudio_memberByStudioId(Integer studioid);

    /**
     * 根据id查找某个工作室成员信息
     *
     * @param id
     * @return
     */
    public List<StudioMember> selectStudio_memberById(Integer id);

    /**
     * 根据id删除某个工作室成员信息
     *
     * @param id
     * @return
     */
    int deleteStudio_memberByPrimaryKey(Integer id);

    /**
     * 插入一条工作室成员信息
     *
     * @param record
     * @return
     */
    int insertStudio_memberSelective(StudioMember record);

    /**
     * 根据id更新一条工作室成员信息
     *
     * @param record
     * @return
     */
    int updateStudio_memberByPrimaryKeySelective(StudioMember record);
}

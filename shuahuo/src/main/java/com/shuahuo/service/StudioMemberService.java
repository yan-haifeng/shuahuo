package com.shuahuo.service;

import com.shuahuo.bean.StudioMember;

import java.util.List;

public interface StudioMemberService {
    /**
     * 查询所有工作室
     */
    public List<StudioMember> findAllStudio_member();

    /**
     * 根据id查询工作室
     */
    public List<StudioMember> findStudio_memberById(Integer id);

    /**
     * 根据uuid查询工作室
     */
    public List<StudioMember> findStudio_memberByStudioId(Integer studioid);

    /**
     * 添加工作室
     */
    public int addStudio_member(StudioMember studio_member);

    /**
     * 更新工作室
     */
    public int updateStudio_member(StudioMember studio_member);

    /**
     * 根据id删除工作室
     */
    public int deleteStudio_member(Integer id);
}

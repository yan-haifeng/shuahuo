package com.shuahuo.service;

import com.shuahuo.bean.Studio;

import java.util.List;

public interface StudioService {
    /**
     * 查询所有工作室
     */
    public List<Studio> findAllStudio();

    /**
     * 根据id查询工作室
     */
    public List<Studio> findStudioById(Integer id);

    /**
     * 根据uuid查询工作室
     */
    public List<Studio> findStudioByUUID(String uuid);

    /**
     * 添加工作室
     */
    public int addStudio(Studio studio);

    /**
     * 更新工作室
     */
    public int updateStudio(Studio studio);

    /**
     * 根据id删除工作室
     */
    public int deleteStudio(Integer id);
}

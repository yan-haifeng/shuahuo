package com.shuahuo.dao;

import com.shuahuo.bean.Studio;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudioMapper {

    /**
     * 查找所有工作室信息
     * @return UserPO
     */
    public List<Studio> findAllStudio();

    /**
     * 根据uuid查找某个工作室信息
     *
     * @param uuid
     * @return UserPO
     */
    public List<Studio> selectStudioByUUID(String uuid);

    /**
     * 根据id查找某个工作室信息
     *
     * @param id
     * @return UserPO
     */
    public List<Studio> selectStudioById(Integer id);

    /**
     * 根据id删除某个工作室信息
     *
     * @param id
     * @return
     */
    int deleteStudioByPrimaryKey(Integer id);

    /**
     * 插入一条工作室信息
     *
     * @param record
     * @return
     */
    int insertStudioSelective(Studio record);

    /**
     * 根据id更新一条工作室信息
     *
     * @param record
     * @return
     */
    int updateStudioByPrimaryKeySelective(Studio record);
}

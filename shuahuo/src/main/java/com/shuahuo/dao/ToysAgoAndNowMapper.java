package com.shuahuo.dao;

import com.shuahuo.bean.ToysAgoAndNow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ToysAgoAndNowMapper {
    /**
     * 查找所有玩具虚拟展厅信息
     * @return UserPO
     */
    public List<ToysAgoAndNow> findAllToysAgoAndNow();

    /**
     * 根据id查找某个玩具虚拟展厅信息
     * @param id
     * @return UserPO
     */
    public List<ToysAgoAndNow> selectToysAgoAndNowById(Integer id);

    /**
     * 根据玩具id查找某个玩具虚拟展厅信息
     * @param id
     * @return UserPO
     */
    public List<ToysAgoAndNow> selectToysAgoAndNowByToysId(Integer id);

    /**
     * 根据id删除某个玩具虚拟展厅信息
     * @param id
     * @return
     */
    int deleteToysAgoAndNowByPrimaryKey(Integer id);

    /**
     * 插入一条玩具虚拟展厅信息
     * @param record
     * @return
     */
    int insertToysAgoAndNowSelective(ToysAgoAndNow record);

    /**
     * 根据id更新一条玩具虚拟展厅信息
     * @param record
     * @return
     */
    int updateToysAgoAndNowByPrimaryKeySelective(ToysAgoAndNow record);
}

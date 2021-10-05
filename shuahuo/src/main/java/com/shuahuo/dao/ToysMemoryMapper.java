package com.shuahuo.dao;

import com.shuahuo.bean.ToysMemory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ToysMemoryMapper {
    /**
     * 查找所有玩具虚拟展厅信息
     * @return UserPO
     */
    public List<ToysMemory> findAllToysMemory();

    /**
     * 根据id查找某个玩具虚拟展厅信息
     * @param id
     * @return UserPO
     */
    public List<ToysMemory> selectToysMemoryById(Integer id);

    /**
     * 根据玩具id查找某个玩具虚拟展厅信息
     * @param id
     * @return UserPO
     */
    public List<ToysMemory> selectToysMemoryByToysId(Integer id);

    /**
     * 根据id删除某个玩具虚拟展厅信息
     * @param id
     * @return
     */
    int deleteToysMemoryByPrimaryKey(Integer id);

    /**
     * 插入一条玩具虚拟展厅信息
     * @param record
     * @return
     */
    int insertToysMemorySelective(ToysMemory record);

    /**
     * 根据id更新一条玩具虚拟展厅信息
     * @param record
     * @return
     */
    int updateToysMemoryByPrimaryKeySelective(ToysMemory record);
}

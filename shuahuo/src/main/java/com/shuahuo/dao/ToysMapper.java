package com.shuahuo.dao;

import com.shuahuo.bean.Toys;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ToysMapper {
    /**
     * 查找所有工作室信息
     * @return UserPO
     */
    public List<Toys> findAllToys();

    /**
     * 根据id查找某个工作室信息
     * @param id
     * @return UserPO
     */
    public List<Toys> selectToysById(Integer id);

    /**
     * 根据id删除某个工作室信息
     * @param id
     * @return
     */
    int deleteToysByPrimaryKey(Integer id);

    /**
     * 插入一条工作室信息
     * @param record
     * @return
     */
    int insertToysSelective(Toys record);

    /**
     * 根据id更新一条工作室信息
     * @param record
     * @return
     */
    int updateToysByPrimaryKeySelective(Toys record);
}

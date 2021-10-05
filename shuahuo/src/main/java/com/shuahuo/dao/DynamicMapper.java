package com.shuahuo.dao;

import com.shuahuo.bean.Dynamic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DynamicMapper {

    /**
     * 得到所有的微博动态信息
     * @return List<Dynamic>
     */
    public List<Dynamic> findAllDynamic();
    /**
     * 得到所有的微博动态信息(倒序)
     * @return List<Dynamic>
     */
    public List<Dynamic> findAllDynamicDesc();
    /**
     * 根据id删除某个动态信息
     * @param id
     * @return
     */
    int deleteDynamicByPrimaryKey(Integer id);
    /**
     * 插入一条动态信息
     * @param record
     * @return
     */
    int insertDynamicSelective(Dynamic record);

    /**
     * 根据id更新一条动态信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Dynamic record);

    /**
     * 根据动态id查找某个动态信息
     * @param id
     * @return UserPO
     */
    public List<Dynamic> selectDynamicByPrimaryKey(Integer id);

    /**
     * 根据用户名查找某个动态信息
     * @param userid
     * @return
     */

    public List<Dynamic> selectDynamicByUserId(Integer userid);
}

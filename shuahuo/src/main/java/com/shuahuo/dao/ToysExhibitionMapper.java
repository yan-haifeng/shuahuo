package com.shuahuo.dao;

import com.shuahuo.bean.ToysExhibition;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ToysExhibitionMapper {
    /**
     * 查找所有玩具虚拟展厅信息
     * @return UserPO
     */
    public List<ToysExhibition> findAllToysExhibition();

    /**
     * 根据id查找某个玩具虚拟展厅信息
     * @param id
     * @return UserPO
     */
    public List<ToysExhibition> selectToysExhibitionById(Integer id);

    /**
     * 根据玩具id查找某个玩具虚拟展厅信息
     * @param id
     * @return UserPO
     */
    public List<ToysExhibition> selectToysExhibitionByToysId(Integer id);

    /**
     * 根据id删除某个玩具虚拟展厅信息
     * @param id
     * @return
     */
    int deleteToysExhibitionByPrimaryKey(Integer id);

    /**
     * 插入一条玩具虚拟展厅信息
     * @param record
     * @return
     */
    int insertToysExhibitionSelective(ToysExhibition record);

    /**
     * 根据id更新一条玩具虚拟展厅信息
     * @param record
     * @return
     */
    int updateToysExhibitionByPrimaryKeySelective(ToysExhibition record);
}

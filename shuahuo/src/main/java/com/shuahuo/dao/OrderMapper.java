package com.shuahuo.dao;

import com.shuahuo.bean.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    /**
     * 查找所有订单信息
     * @return UserPO
     */
    public List<Order> findAllOrder();

    /**
     * 根据id查找某个订单信息
     *
     * @param id
     * @return UserPO
     */
    public List<Order> selectOrderById(Integer id);

    /**
     * 根据用户id查找某个订单信息
     *
     * @param id
     * @return UserPO
     */
    public List<Order> selectOrderByUserId(Integer id);

    /**
     * 根据工作室id查找某个订单信息
     *
     * @param id
     * @return UserPO
     */
    public List<Order> selectOrderByStudioId(Integer id);

    /**
     * 根据id删除某个订单信息
     *
     * @param id
     * @return
     */
    int deleteOrderByPrimaryKey(Integer id);

    /**
     * 插入一条订单信息
     *
     * @param record
     * @return
     */
    int insertOrderSelective(Order record);

    /**
     * 根据id更新一条订单信息
     *
     * @param record
     * @return
     */
    int updateOrderByPrimaryKeySelective(Order record);
}

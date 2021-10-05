package com.shuahuo.service;

import com.shuahuo.bean.Toys;

import java.util.List;

public interface ToysService {
    /**
     * 查询所有工作室
     */
    public List<Toys> findAllToys();

    /**
     * 根据id查询工作室
     */
    public List<Toys> findToysById(Integer id);

    /**
     * 添加工作室
     */
    public int addToys(Toys toys);

    /**
     * 更新工作室
     */
    public int updateToys(Toys toys);

    /**
     * 根据id删除工作室
     */
    public int deleteToys(Integer id);
}

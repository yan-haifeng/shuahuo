package com.shuahuo.service;

import com.shuahuo.bean.Dynamic;

import java.util.List;

public interface DynamicService {
    /**
    查询所有微博动态
     */
    public List<Dynamic> findAllDynamic();
    /**
     查询所有微博动态
     */
    public List<Dynamic> findAllDynamicDesc();
    /**
    添加微博动态
     */
    public int addDynamic(Dynamic dynamic);
    /**
     更新微博动态
     */
    public  int updateDynamic(Dynamic dynamic);
    /**
    根据id删除微博动态
     */
    public int deleteDynamic(Integer id);
    /**
     根据动态id查询微博动态
     */
    public List<Dynamic> findDynamicById(Integer id);
    /**
     根据用户名查询微博动态
     */
    public List<Dynamic> findDynamicByUserId(Integer userid);
}

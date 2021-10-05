package com.shuahuo.service.impl;

import com.shuahuo.bean.Dynamic;
import com.shuahuo.dao.DynamicMapper;
import com.shuahuo.service.DynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DynamicServiceImpl implements DynamicService {
    @Autowired
    private DynamicMapper dynamicMapper;

    public List<Dynamic> findAllDynamic() {
        List<Dynamic> list = dynamicMapper.findAllDynamic();
        return list;
    }

    public List<Dynamic> findAllDynamicDesc() {
        List<Dynamic> list = dynamicMapper.findAllDynamicDesc();
        return list;
    }

    public int addDynamic(Dynamic dynamic) {
        return dynamicMapper.insertDynamicSelective(dynamic);
    }

    public int updateDynamic(Dynamic dynamic) {
        return dynamicMapper.updateByPrimaryKeySelective(dynamic);
    }

    public int deleteDynamic(Integer id) {
        return dynamicMapper.deleteDynamicByPrimaryKey(id);
    }

    public List<Dynamic> findDynamicById(Integer id) {
        return dynamicMapper.selectDynamicByPrimaryKey(id);
    }

    public List<Dynamic> findDynamicByUserId(Integer userid) {
        return dynamicMapper.selectDynamicByUserId(userid);
    }
}

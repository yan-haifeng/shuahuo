package com.shuahuo.service.impl;

import com.shuahuo.bean.ToysMemory;
import com.shuahuo.dao.ToysMemoryMapper;
import com.shuahuo.service.ToysMemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToysMemoryServicelmpl implements ToysMemoryService {
    @Autowired
    private ToysMemoryMapper toysMemoryMapper;

    @Override
    public List<ToysMemory> findAllToysMemory() {
        return toysMemoryMapper.findAllToysMemory();
    }

    @Override
    public List<ToysMemory> findToysMemoryById(Integer id) {
        return toysMemoryMapper.selectToysMemoryById(id);
    }

    @Override
    public List<ToysMemory> findToysMemoryByToysId(Integer id) {
        return toysMemoryMapper.selectToysMemoryByToysId(id);
    }

    @Override
    public int addToysMemory(ToysMemory toysMemory) {
        return toysMemoryMapper.insertToysMemorySelective(toysMemory);
    }

    @Override
    public int updateToysMemory(ToysMemory toysMemory) {
        return toysMemoryMapper.updateToysMemoryByPrimaryKeySelective(toysMemory);
    }

    @Override
    public int deleteToysMemory(Integer id) {
        return toysMemoryMapper.deleteToysMemoryByPrimaryKey(id);
    }
}

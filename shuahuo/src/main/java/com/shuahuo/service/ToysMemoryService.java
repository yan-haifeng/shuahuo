package com.shuahuo.service;

import com.shuahuo.bean.ToysMemory;

import java.util.List;

public interface ToysMemoryService {
    public List<ToysMemory> findAllToysMemory();

    public List<ToysMemory> findToysMemoryById(Integer id);

    public List<ToysMemory> findToysMemoryByToysId(Integer id);

    public int addToysMemory(ToysMemory toysMemory);

    public int updateToysMemory(ToysMemory toysMemory);

    public int deleteToysMemory(Integer id);
}

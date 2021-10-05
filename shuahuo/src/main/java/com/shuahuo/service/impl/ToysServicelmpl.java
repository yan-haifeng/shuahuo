package com.shuahuo.service.impl;

import com.shuahuo.bean.Toys;
import com.shuahuo.dao.ToysMapper;
import com.shuahuo.service.ToysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToysServicelmpl implements ToysService {
    @Autowired
    private ToysMapper toysMapper;

    @Override
    public List<Toys> findAllToys() {
        return toysMapper.findAllToys();
    }

    @Override
    public List<Toys> findToysById(Integer id) {
        return toysMapper.selectToysById(id);
    }

    @Override
    public int addToys(Toys toys) {
        return toysMapper.insertToysSelective(toys);
    }

    @Override
    public int updateToys(Toys toys) {
        return toysMapper.updateToysByPrimaryKeySelective(toys);
    }

    @Override
    public int deleteToys(Integer id) {
        return toysMapper.deleteToysByPrimaryKey(id);
    }
}

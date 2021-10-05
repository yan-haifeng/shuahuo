package com.shuahuo.service.impl;

import com.shuahuo.bean.ToysExhibition;
import com.shuahuo.dao.ToysExhibitionMapper;
import com.shuahuo.service.ToysExhibitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToysExhibitionServicelmpl implements ToysExhibitionService {
    @Autowired
    private ToysExhibitionMapper toysExhibitionMapper;

    @Override
    public List<ToysExhibition> findAllToysExhibition() {
        return toysExhibitionMapper.findAllToysExhibition();
    }

    @Override
    public List<ToysExhibition> findToysExhibitionById(Integer id) {
        return toysExhibitionMapper.selectToysExhibitionById(id);
    }

    @Override
    public List<ToysExhibition> findToysExhibitionByToysId(Integer id) {
        return toysExhibitionMapper.selectToysExhibitionByToysId(id);
    }

    @Override
    public int addToysExhibition(ToysExhibition toysExhibition) {
        return toysExhibitionMapper.insertToysExhibitionSelective(toysExhibition);
    }

    @Override
    public int updateToysExhibition(ToysExhibition toysExhibition) {
        return toysExhibitionMapper.updateToysExhibitionByPrimaryKeySelective(toysExhibition);
    }

    @Override
    public int deleteToysExhibition(Integer id) {
        return toysExhibitionMapper.deleteToysExhibitionByPrimaryKey(id);
    }
}

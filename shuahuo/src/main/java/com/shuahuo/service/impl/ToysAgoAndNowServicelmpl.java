package com.shuahuo.service.impl;

import com.shuahuo.bean.ToysAgoAndNow;
import com.shuahuo.dao.ToysAgoAndNowMapper;
import com.shuahuo.service.ToysAgoAndNowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToysAgoAndNowServicelmpl implements ToysAgoAndNowService {
    @Autowired
    private ToysAgoAndNowMapper toysAgoAndNowMapper;
    @Override
    public List<ToysAgoAndNow> findAllToysAgoAndNow() {
        return toysAgoAndNowMapper.findAllToysAgoAndNow();
    }

    @Override
    public List<ToysAgoAndNow> findToysAgoAndNowById(Integer id) {
        return toysAgoAndNowMapper.selectToysAgoAndNowById(id);
    }

    @Override
    public List<ToysAgoAndNow> findToysAgoAndNowByToysId(Integer id) {
        return toysAgoAndNowMapper.selectToysAgoAndNowByToysId(id);
    }

    @Override
    public int addToysAgoAndNow(ToysAgoAndNow toysAgoAndNow) {
        return toysAgoAndNowMapper.insertToysAgoAndNowSelective(toysAgoAndNow);
    }

    @Override
    public int updateToysAgoAndNow(ToysAgoAndNow toysAgoAndNow) {
        return toysAgoAndNowMapper.updateToysAgoAndNowByPrimaryKeySelective(toysAgoAndNow);
    }

    @Override
    public int deleteToysAgoAndNow(Integer id) {
        return toysAgoAndNowMapper.deleteToysAgoAndNowByPrimaryKey(id);
    }
}

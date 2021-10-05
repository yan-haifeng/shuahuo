package com.shuahuo.service;

import com.shuahuo.bean.ToysAgoAndNow;

import java.util.List;

public interface ToysAgoAndNowService {
    public List<ToysAgoAndNow> findAllToysAgoAndNow();

    public List<ToysAgoAndNow> findToysAgoAndNowById(Integer id);

    public List<ToysAgoAndNow> findToysAgoAndNowByToysId(Integer id);

    public int addToysAgoAndNow(ToysAgoAndNow toysAgoAndNow);

    public int updateToysAgoAndNow(ToysAgoAndNow toysAgoAndNow);

    public int deleteToysAgoAndNow(Integer id);
}

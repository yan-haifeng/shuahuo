package com.shuahuo.service;

import com.shuahuo.bean.ToysExhibition;

import java.util.List;

public interface ToysExhibitionService {
    public List<ToysExhibition> findAllToysExhibition();

    public List<ToysExhibition> findToysExhibitionById(Integer id);

    public List<ToysExhibition> findToysExhibitionByToysId(Integer id);

    public int addToysExhibition(ToysExhibition toysExhibition);

    public int updateToysExhibition(ToysExhibition toysExhibition);

    public int deleteToysExhibition(Integer id);
}

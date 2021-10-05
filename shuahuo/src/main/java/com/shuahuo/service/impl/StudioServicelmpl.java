package com.shuahuo.service.impl;

import com.shuahuo.bean.Studio;
import com.shuahuo.dao.StudioMapper;
import com.shuahuo.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudioServicelmpl implements StudioService {
    @Autowired
    private StudioMapper studioMapper;
    @Override
    public List<Studio> findAllStudio() {
        return studioMapper.findAllStudio();
    }

    @Override
    public List<Studio> findStudioById(Integer id) {
        return studioMapper.selectStudioById(id);
    }

    @Override
    public List<Studio> findStudioByUUID(String uuid) {
        return studioMapper.selectStudioByUUID(uuid);
    }

    @Override
    public int addStudio(Studio studio) {
        return studioMapper.insertStudioSelective(studio);
    }

    @Override
    public int updateStudio(Studio studio) {
        return studioMapper.updateStudioByPrimaryKeySelective(studio);
    }

    @Override
    public int deleteStudio(Integer id) {
        return studioMapper.deleteStudioByPrimaryKey(id);
    }
}

package com.shuahuo.service.impl;

import com.shuahuo.bean.StudioMember;
import com.shuahuo.dao.StudioMemberMapper;
import com.shuahuo.service.StudioMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudioMemberServicelmpl implements StudioMemberService {
    @Autowired
    private StudioMemberMapper studioMemberMapper;

    @Override
    public List<StudioMember> findAllStudio_member() {
        return studioMemberMapper.findAllStudio_member();
    }

    @Override
    public List<StudioMember> findStudio_memberById(Integer id) {
        return studioMemberMapper.selectStudio_memberById(id);
    }

    @Override
    public List<StudioMember> findStudio_memberByStudioId(Integer studioid) {
        return studioMemberMapper.selectStudio_memberByStudioId(studioid);
    }

    @Override
    public int addStudio_member(StudioMember studio_member) {
        return studioMemberMapper.insertStudio_memberSelective(studio_member);
    }

    @Override
    public int updateStudio_member(StudioMember studio_member) {
        return studioMemberMapper.updateStudio_memberByPrimaryKeySelective(studio_member);
    }

    @Override
    public int deleteStudio_member(Integer id) {
        return studioMemberMapper.deleteStudio_memberByPrimaryKey(id);
    }
}

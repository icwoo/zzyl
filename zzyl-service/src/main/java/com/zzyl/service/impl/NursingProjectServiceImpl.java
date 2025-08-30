package com.zzyl.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.zzyl.base.PageResponse;
import com.zzyl.dto.NursingProjectDto;
import com.zzyl.entity.NursingProject;
import com.zzyl.mapper.NursingProjectMapper;
import com.zzyl.service.NursingProjectService;
import com.zzyl.vo.NursingProjectVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description NursingProjectServiceImpl
 * @Author Lisheng Li
 * @Date 2025-08-28
 */
@Service
public class NursingProjectServiceImpl implements NursingProjectService {
    @Autowired
    private NursingProjectMapper nursingProjectMapper;

    @Override
    public PageResponse<NursingProjectVo> findByPage(NursingProjectDto nursingProjectDto) {
        PageHelper.startPage(nursingProjectDto.getPageNum(),nursingProjectDto.getPageSize());
        List<NursingProjectVo> list = nursingProjectMapper.findByPages(nursingProjectDto.getName(), nursingProjectDto.getStatus());
        //前端没写分页，写这个浪费表情
        return PageResponse.of(list);
    }

    @Override
    public NursingProjectVo findById(Long id) {
        NursingProject np = nursingProjectMapper.findById(id);
        NursingProjectVo nv = BeanUtil.toBean(np, NursingProjectVo.class);
        return nv;
    }

    @Override
    public void updeateById(NursingProjectVo nursingProjectVo) {
        NursingProject np = BeanUtil.toBean(nursingProjectVo, NursingProject.class);
        nursingProjectMapper.updeateById(np);
    }

    @Override
    public void createNursingProject(NursingProjectVo nursingProjectVo) {
        NursingProject np = BeanUtil.toBean(nursingProjectVo, NursingProject.class);
//        np.setCreateTime(LocalDateTime.now());
        np.setCreateBy(1L);
        nursingProjectMapper.createNursingProject(np);

    }

    @Override
    public void deleteById(Long id) {
        nursingProjectMapper.deleteById(id);
    }

    @Override
    public void changeStatus(Long id, Integer status) {
        nursingProjectMapper.changeStatus(id,status);
    }

    @Override
    public List<NursingProjectVo> findAll() {

         List<NursingProjectVo> nvlist=nursingProjectMapper.findAll();
        return nvlist;
    }
}

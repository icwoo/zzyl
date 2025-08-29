package com.zzyl.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzyl.base.PageResponse;
import com.zzyl.dto.NursingProjectDto;
import com.zzyl.entity.Bed;
import com.zzyl.entity.NursingProject;
import com.zzyl.enums.BasicEnum;
import com.zzyl.exception.BaseException;
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
        PageHelper.startPage(nursingProjectDto.getPage(),nursingProjectDto.getPageSize());
        List<NursingProjectVo> list= null;
        try {
            list = nursingProjectMapper.findByPages(nursingProjectDto.getName(),nursingProjectDto.getStatus());
        } catch (Exception e) {
            throw new BaseException(BasicEnum.BED_INSERT_FAIL);
        }
        PageResponse<NursingProjectVo> pages= PageResponse.of(list);
        return pages;
    }

    @Override
    public NursingProjectVo findById(Long id) {
         NursingProject np= nursingProjectMapper.findById(id);
        NursingProjectVo nv = BeanUtil.toBean(np, NursingProjectVo.class);
        return nv;
    }

    @Override
    public void updeateById(NursingProjectVo nursingProjectVo) {
        NursingProject np = BeanUtil.toBean(nursingProjectVo, NursingProject.class);
        nursingProjectMapper.updeateById(np);
    }
}

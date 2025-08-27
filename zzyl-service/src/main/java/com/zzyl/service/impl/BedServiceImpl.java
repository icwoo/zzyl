package com.zzyl.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.zzyl.dto.BedDto;
import com.zzyl.entity.Bed;
import com.zzyl.mapper.BedMapper;
import com.zzyl.service.BedService;
import com.zzyl.vo.BedVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BedServiceImpl implements BedService {

    @Autowired
    private BedMapper bedMapper;

    @Override
    public List<BedVo> getBedsByRoomId(Long roomId) {
        return bedMapper.getBedsByRoomId(roomId);
    }

    @Override
    public void createBed(BedDto bedDto) {
        Bed bed = BeanUtil.toBean(bedDto, Bed.class);
        bed.setBedStatus(0);
        bed.setCreateTime(LocalDateTime.now());
        bed.setCreateBy(1L);
        bedMapper.createBed(bed);
    }

    @Override
    public void deleteBedById(Integer id) {
        bedMapper.deleteBedById(id);
    }

    @Override
    public BedVo findBedById(Integer id) {
        Bed bed= bedMapper.findBedById(id);
        BedVo beanVo = BeanUtil.toBean(bed, BedVo.class);
        return beanVo;
    }

    @Override
    public void updateBedById(BedDto bedDto) {
        Bed bed = BeanUtil.toBean(bedDto, Bed.class);
        bed.setUpdateTime(LocalDateTime.now());
        bed.setUpdateBy(1L);
        bedMapper.updateBedById(bed);
    }
}


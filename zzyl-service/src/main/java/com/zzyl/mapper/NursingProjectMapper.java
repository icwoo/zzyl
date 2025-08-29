package com.zzyl.mapper;

import com.zzyl.entity.NursingProject;
import com.zzyl.vo.NursingProjectVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description NursingProjectMapper
 * @Author Lisheng Li
 * @Date 2025-08-28
 */
@Mapper
public interface NursingProjectMapper {

    List<NursingProjectVo> findByPages(String name, Integer status);
}

package com.zzyl.service;

import com.zzyl.base.PageResponse;
import com.zzyl.dto.NursingProjectDto;
import com.zzyl.vo.NursingProjectVo;

import java.util.List;

/**
 * @Description NursingProjectService
 * @Author Lisheng Li
 * @Date 2025-08-28
 */
public interface NursingProjectService {

    PageResponse<NursingProjectVo> findByPage(NursingProjectDto nursingProjectDto);

    /**
     * 根据id查询护理项目
     * @param id
     * @return
     */
    NursingProjectVo findById(Long id);

    /**
     * 修改护理项目
     * @param nursingProjectVo
     */
    void updeateById(NursingProjectVo nursingProjectVo);

    void createNursingProject(NursingProjectVo nursingProjectVo);

    void deleteById(Long id);

    void changeStatus(Long id, Integer status);

    List<NursingProjectVo> findAll();
}

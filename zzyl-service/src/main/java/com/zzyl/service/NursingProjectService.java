package com.zzyl.service;

import com.github.pagehelper.Page;
import com.zzyl.base.PageResponse;
import com.zzyl.dto.NursingProjectDto;
import com.zzyl.vo.NursingProjectVo;

/**
 * @Description NursingProjectService
 * @Author Lisheng Li
 * @Date 2025-08-28
 */
public interface NursingProjectService {

    PageResponse<NursingProjectVo> findByPage(NursingProjectDto nursingProjectDto);
}

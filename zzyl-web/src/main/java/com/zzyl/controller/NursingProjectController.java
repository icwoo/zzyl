package com.zzyl.controller;

import com.github.pagehelper.Page;
import com.zzyl.base.PageResponse;
import com.zzyl.base.ResponseResult;
import com.zzyl.dto.NursingElderDto;
import com.zzyl.dto.NursingProjectDto;
import com.zzyl.service.NursingProjectService;
import com.zzyl.vo.NursingProjectVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 护理项目Controller类
 * @Author Lisheng Li
 * @Date 2025-08-28
 */
@Slf4j
@RestController
@RequestMapping("/nursing_project")
@Api(tags = "护理项目管理")
public class NursingProjectController {
    @Autowired
    private NursingProjectService nursingProjectService;

    @GetMapping
    @ApiOperation("分页查询护理项目列表")
    public ResponseResult<NursingProjectVo> findByPage(NursingProjectDto nursingProjectDto){
        log.info("分页查询护理项目列表,参数：{}",nursingProjectDto);
        PageResponse<NursingProjectVo> pageList = nursingProjectService.findByPage(nursingProjectDto);

        return ResponseResult.success(pageList);
    }
}

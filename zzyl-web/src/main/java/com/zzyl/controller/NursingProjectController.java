package com.zzyl.controller;

import com.zzyl.base.PageResponse;
import com.zzyl.base.ResponseResult;
import com.zzyl.dto.NursingProjectDto;
import com.zzyl.service.NursingProjectService;
import com.zzyl.vo.NursingProjectVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ResponseResult<PageResponse<NursingProjectVo>> findByPage(NursingProjectDto nursingProjectDto) {
        log.info("分页查询护理项目列表,参数：{}", nursingProjectDto);
        PageResponse<NursingProjectVo> pageList = nursingProjectService.findByPage(nursingProjectDto);

        return ResponseResult.success(pageList);
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询护理项目")
    public ResponseResult findById(@PathVariable Long id) {

        log.info("根据id查询护理,id:{}", id);
        NursingProjectVo nv = nursingProjectService.findById(id);
        return ResponseResult.success(nv);
    }

    @PutMapping
    @ApiOperation("修改护理项目")
    public ResponseResult updeateById(@RequestBody NursingProjectVo nursingProjectVo) {
        //用Vo是因为俺设计的dto不能接收这么多参数，vo刚好能收
        log.info("修改护理项目,修改人id:{}", nursingProjectVo.getUpdateBy());
        nursingProjectService.updeateById(nursingProjectVo);

        return ResponseResult.success();
    }

    @PostMapping
    @ApiOperation("新增护理项目")
    public ResponseResult createNursingProject(@RequestBody NursingProjectVo nursingProjectVo) {
        //用Vo是因为俺设计的dto不能接收这么多参数，vo刚好能收
        log.info("新增护理项目");
        nursingProjectService.createNursingProject(nursingProjectVo);
        return ResponseResult.success();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除护理项目")
    public ResponseResult deleteById(@PathVariable Long id) {
        log.info("删除护理项目");
        nursingProjectService.deleteById(id);
        return ResponseResult.success();
    }
    @PutMapping("/{id}/status/{status}")
    @ApiOperation("启用禁用护理项目")
    public ResponseResult changeStatus(@PathVariable Long id,@PathVariable Integer status) {
        log.info("启用禁用护理项目,id:{},status:{}",id,status);
        nursingProjectService.changeStatus(id,status);
        return ResponseResult.success();
    }

}
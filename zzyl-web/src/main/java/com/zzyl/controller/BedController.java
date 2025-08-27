package com.zzyl.controller;

import com.zzyl.base.ResponseResult;
import com.zzyl.dto.BedDto;
import com.zzyl.service.BedService;
import com.zzyl.vo.BedVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bed")
@Api(tags = "床位管理相关接口")
public class BedController extends BaseController {

    @Autowired
    private BedService bedService;

    @GetMapping("/read/room/{roomId}")
    @ApiOperation(value = "根据房间id查询床位", notes = "传入房间id")
    public ResponseResult<List<BedVo>> readBedByRoomId(
            @ApiParam(value = "房间ID", required = true) @PathVariable("roomId") Long roomId) {
        List<BedVo> beds = bedService.getBedsByRoomId(roomId);
        return success(beds);
    }
    @PostMapping("/create")
    @ApiOperation(value = "新增床位")
    public ResponseResult createBed(@RequestBody BedDto bedDto){
        bedService.createBed(bedDto);
        return success();
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("根据id删除单个床位")
    public ResponseResult deleteBedById(@PathVariable Integer id){
        bedService.deleteBedById(id);
        return success();
    }

    @GetMapping("/read/{id}")
    @ApiOperation("根据id查询单个床位")
    public ResponseResult<BedVo> findBedById(@PathVariable Integer id){
        BedVo bedVo= bedService.findBedById(id);
        return success(bedVo);
    }

    @PutMapping("/update")
    @ApiOperation("根据id更新单个床位")
    public ResponseResult updateBedById(@RequestBody BedDto bedDto){
        bedService.updateBedById(bedDto);
        return success();
    }
}

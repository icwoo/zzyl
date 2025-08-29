package com.zzyl.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description NursingProjectDto
 * @Author Lisheng Li
 * @Date 2025-08-28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NursingProjectDto {
    private Integer page=1;
    private Integer pageSize=10;
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("状态")
    private Integer status;
}

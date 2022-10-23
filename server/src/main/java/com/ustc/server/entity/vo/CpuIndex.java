package com.ustc.server.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: ffideal
 * @CreateTime: 2022-10-23  14:36
 * @Description: TODO
 * @Version: 1.0
 */

@Data
public class CpuIndex {
    @ApiModelProperty(value = "cpu的名称")
    private String cpuName;

    @ApiModelProperty(value = "CPU总的使用率")
    private String cpuTotalUserate;
}

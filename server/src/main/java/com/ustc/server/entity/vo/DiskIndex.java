package com.ustc.server.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: ffideal
 * @CreateTime: 2022-10-23  22:05
 * @Description: TODO
 * @Version: 1.0
 */
@Data
public class DiskIndex {
    @ApiModelProperty(value = "盘符名称")
    private String dName;
    @ApiModelProperty(value = "已经使用率")
    private String dUseRate;
}

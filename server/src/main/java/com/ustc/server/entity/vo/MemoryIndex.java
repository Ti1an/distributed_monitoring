package com.ustc.server.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: ffideal
 * @CreateTime: 2022-10-23  20:22
 * @Description: TODO
 * @Version: 1.0
 */
@Data
public class MemoryIndex {

    @ApiModelProperty(value = "当前内存使用量")
    private String mUse;

    @ApiModelProperty(value = "当前内存剩余量")
    private String mFree;

    @ApiModelProperty(value = "内存使用率")
    private String mUserate;



    @ApiModelProperty(value = "当前交换区使用量")
    private String mSwapUse;

    @ApiModelProperty(value = "当前交换区剩余量")
    private String mSwapFree;

    @ApiModelProperty(value = "当前交换区使用率")
    private String mSwapUserate;
}

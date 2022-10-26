package com.ustc.server.entity.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @Author: ffideal
 * @CreateTime: 2022-10-25  10:29
 * @Description: TODO
 * @Version: 1.0
 */
public class CpuQuery {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "cpu在多核处理器机器中的编号")
    private Integer cpuNo;

    @ApiModelProperty(value = "cpu的名称")
    private String cpuName;

    @ApiModelProperty(value = "cpu的生产厂家")
    private String cpuManufacturer;

    @ApiModelProperty(value = "CPU的总量MHz")
    private Integer cpuTotalHz;

    @ApiModelProperty(value = "CPU类别")
    private String cpuType;

    @ApiModelProperty(value = "CPU用户使用率")
    private String cpuUserUserate;

    @ApiModelProperty(value = "CPU系统使用率")
    private String cpuSysUserate;

    @ApiModelProperty(value = "CPU当前等待率")
    private String cpuWaitrate;

    @ApiModelProperty(value = "CPU当前错误率")
    private String cpuErrorrate;

    @ApiModelProperty(value = "CPU当前空闲率")
    private String cpuFreerate;

    @ApiModelProperty(value = "CPU总的使用率")
    private String cpuTotalUserate;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

}

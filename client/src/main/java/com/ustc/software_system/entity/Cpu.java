package com.ustc.software_system.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * CPU表
 * </p>
 *
 * @author xutao
 * @since 2022-10-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Cpu对象", description="CPU表")
public class Cpu implements Serializable {

    private static final long serialVersionUID = 1L;

//    @ApiModelProperty(value = "cpu唯一的ID")
//    @TableId(value = "cpu_id", type = IdType.ID_WORKER_STR)
//    private String cpuId;

    @ApiModelProperty(value = "cpu所在电脑的ip")
    private String computerIp;

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

    @ApiModelProperty(value = "创建时间")// 创建时间
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;


}

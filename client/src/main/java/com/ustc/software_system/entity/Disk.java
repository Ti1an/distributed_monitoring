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
 * 硬盘表
 * </p>
 *
 * @author xutao
 * @since 2022-10-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Disk对象", description="硬盘表")
public class Disk implements Serializable {

    private static final long serialVersionUID = 1L;

//    @ApiModelProperty(value = "硬盘唯一的ID")
//    @TableId(value = "d_id", type = IdType.ID_WORKER_STR)
//    private String dId;

    @ApiModelProperty(value = "cpu所在电脑的ip")
    private String computerIp;

    @ApiModelProperty(value = "盘符名称")
    private String dName;

    @ApiModelProperty(value = "盘符类型")
    private String dType;

    @ApiModelProperty(value = "硬盘总量")
    private String dTotal;

    @ApiModelProperty(value = "已经使用量")
    private String dUse;

    @ApiModelProperty(value = "剩余大小")
    private String dFree;

    @ApiModelProperty(value = "已经使用率")
    private String dUseRate;

    @ApiModelProperty(value = "硬盘剩余率")
    private String dFreeRate;

    @ApiModelProperty(value = "读入")
    private String dCurrentRead;

    @ApiModelProperty(value = "写出")
    private String dCurrentWrite;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;


}

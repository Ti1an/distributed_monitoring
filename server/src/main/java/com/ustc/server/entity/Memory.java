package com.ustc.server.entity;

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
 * 内存表
 * </p>
 *
 * @author xutao
 * @since 2022-10-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Memory对象", description="内存表")
public class Memory implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "cpu所在电脑的ip")
    private String computerIp;

    @ApiModelProperty(value = "内存总量(G)")
    private String mTotal;

    @ApiModelProperty(value = "当前内存使用量(G)")
    private String mUse;

    @ApiModelProperty(value = "当前内存剩余量(G)")
    private String mFree;

    @ApiModelProperty(value = "内存使用率")
    private String mUserate;

    @ApiModelProperty(value = "内存剩余率")
    private String mFreerate;

    @ApiModelProperty(value = "交换区总量")
    private String mSwapTotal;

    @ApiModelProperty(value = "当前交换区使用量(G)")
    private String mSwapUse;

    @ApiModelProperty(value = "当前交换区剩余量(G)")
    private String mSwapFree;

    @ApiModelProperty(value = "当前交换区使用率")
    private String mSwapUserate;

    @ApiModelProperty(value = "当前交换区剩余率(%)")
    private String mSwapFreerate;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;


}

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
 * 网络表
 * </p>
 *
 * @author xutao
 * @since 2022-10-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Net对象", description="网络表")
public class Net implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "cpu所在电脑的ip")
    private String computerIp;

    @ApiModelProperty(value = "网卡IP地址")
    private String nIp;

    @ApiModelProperty(value = "子网掩码")
    private String nMask;

    @ApiModelProperty(value = "网卡名字")
    private String nEthName;

    @ApiModelProperty(value = "网卡类型")
    private String nEthType;

    @ApiModelProperty(value = "网卡描述信息")
    private String nEthDescription;

    @ApiModelProperty(value = "网关广播地址")
    private String nBroadcastAddress;

    @ApiModelProperty(value = "网卡MAC地址")
    private String nMacAddress;

    @ApiModelProperty(value = "接收的总包裹数")
    private String nAcceptPackets;

    @ApiModelProperty(value = "发送的总包裹数")
    private String nSendPackets;

    @ApiModelProperty(value = "接收到的总字节数")
    private String nAcceptByte;

    @ApiModelProperty(value = "发送的总字节数")
    private String nSendByte;

    @ApiModelProperty(value = "接收到的错误包数")
    private String nAcceptErrorPackets;

    @ApiModelProperty(value = "发送数据包时的错误数")
    private String nSendErrorPackets;

    @ApiModelProperty(value = "接收时丢弃的包数")
    private String nAcceptDropPackets;

    @ApiModelProperty(value = "发送时丢弃的包数")
    private String nSendDropPackets;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;


}

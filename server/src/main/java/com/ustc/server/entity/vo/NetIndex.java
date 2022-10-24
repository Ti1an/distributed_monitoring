package com.ustc.server.entity.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Author: ffideal
 * @CreateTime: 2022-10-24  12:59
 * @Description: TODO
 * @Version: 1.0
 */

@Data
public class NetIndex {
    @ApiModelProperty(value = "接收到的总字节数")
    private String nAcceptByte;

    @ApiModelProperty(value = "发送的总字节数")
    private String nSendByte;

    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;
}

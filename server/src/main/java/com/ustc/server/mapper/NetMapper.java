package com.ustc.server.mapper;

import com.ustc.server.entity.Net;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ustc.server.entity.vo.NetIndex;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 网络表 Mapper 接口
 * </p>
 *
 * @author xutao
 * @since 2022-10-22
 */
@Mapper
public interface NetMapper extends BaseMapper<Net> {

    @Select("select sum(n_accept_byte) as n_accept_byte,sum(n_send_byte) as n_send_byte,gmt_create from net where gmt_create>DATE_SUB(current_timestamp(), INTERVAL 10 day) and computer_ip = '192.168.56.1' group by gmt_create order by gmt_create desc limit 0,8")
    List<NetIndex> getCurrentNetIndex();

    @Select("select sum(n_accept_byte) as n_accept_byte,sum(n_send_byte) as n_send_byte,gmt_create from net where gmt_create like ${time} and computer_ip = '192.168.56.1' group by gmt_create order by gmt_create desc limit 0,8")
    List<NetIndex> getLastNetIndex(String time);
}

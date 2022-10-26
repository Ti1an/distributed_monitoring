package com.ustc.server.mapper;

import com.ustc.server.entity.Disk;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ustc.server.entity.vo.DiskIndex;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 硬盘表 Mapper 接口
 * </p>
 *
 * @author xutao
 * @since 2022-10-22
 */
@Mapper
public interface DiskMapper extends BaseMapper<Disk> {
    @Select("select d_name,d_use_rate from disk where gmt_create>DATE_SUB(current_timestamp(), INTERVAL 9 day) and computer_ip = '192.168.56.1' order by gmt_create desc limit 0,4")
    List<DiskIndex> getCurrentDiskIndex();
}

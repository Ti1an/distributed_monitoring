package com.ustc.server.mapper;

import com.ustc.server.entity.Cpu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ustc.server.entity.vo.CpuIndex;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * CPU表 Mapper 接口
 * </p>
 *
 * @author xutao
 * @since 2022-10-22
 */

@Mapper
public interface CpuMapper extends BaseMapper<Cpu> {

    @Select("select cpu_user_userate from cpu where computer_ip = '192.168.56.1' and cpu_no = 1")
    List<String> selectCpuUseRate();

    @Select("select cpu_name,cpu_total_userate from cpu where gmt_create>DATE_SUB(current_timestamp(), INTERVAL 11 second) limit 0,8")
    List<CpuIndex> getCurrentCpuUsageRate();
}

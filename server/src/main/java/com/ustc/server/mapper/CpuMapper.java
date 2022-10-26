package com.ustc.server.mapper;

import com.ustc.server.entity.Cpu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ustc.server.entity.vo.CpuIndex;
import com.ustc.server.entity.vo.CpuQuery;
import com.ustc.server.entity.vo.MemoryIndex;
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

//    @Select("select cpu_user_userate from cpu where computer_ip = ${ip} and cpu_no = 1")
//    List<String> selectCpuUseRate(String ip);

    @Select("select cpu_name,cpu_total_userate from cpu where gmt_create>DATE_SUB(current_timestamp(), INTERVAL 9 day) and computer_ip = '192.168.56.1' order by gmt_create desc,cpu_name asc limit 0,8")
    List<CpuIndex> getCurrentCpuUsageRate();

    // 默认情况下显示最近的一次
//    @Select("select cpu_no,cpu_name,cpu_manufacturer,cpu_total_hz,cpu_type,cpu_user_userate,cpu_sys_userate,cpu_waitrate,cpu_errorrate,cpu_freerate,cpu_total_userate,gmt_create from cpu where computer_ip = '192.168.56.1' order by gmt_create desc limit ${page},${limit}")
//    List<CpuQuery> getCurrentCpuInfo(Long page,Long limit,String time);


}

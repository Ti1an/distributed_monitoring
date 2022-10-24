package com.ustc.server.mapper;

import com.ustc.server.entity.Memory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ustc.server.entity.vo.MemoryIndex;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 内存表 Mapper 接口
 * </p>
 *
 * @author xutao
 * @since 2022-10-22
 */
@Mapper
public interface MemoryMapper extends BaseMapper<Memory> {
    @Select("select m_use,m_free,m_userate,m_swap_use,m_swap_free,m_swap_userate from memory where gmt_create>DATE_SUB(current_timestamp(), INTERVAL 9 second) limit 0,1")
    MemoryIndex getCurrentMemoryUsageRate();
}

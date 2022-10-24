package com.ustc.server.service;

import com.ustc.server.entity.Memory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ustc.server.entity.vo.MemoryIndex;

/**
 * <p>
 * 内存表 服务类
 * </p>
 *
 * @author xutao
 * @since 2022-10-22
 */
public interface MemoryService extends IService<Memory> {

    MemoryIndex getCurrentMemoryUsageRateServuce();
}

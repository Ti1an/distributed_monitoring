package com.ustc.server.service.impl;

import com.ustc.server.entity.Memory;
import com.ustc.server.mapper.MemoryMapper;
import com.ustc.server.service.MemoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 内存表 服务实现类
 * </p>
 *
 * @author xutao
 * @since 2022-10-22
 */
@Service
public class MemoryServiceImpl extends ServiceImpl<MemoryMapper, Memory> implements MemoryService {

}

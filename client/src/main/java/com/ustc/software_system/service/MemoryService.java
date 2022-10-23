package com.ustc.software_system.service;

import com.ustc.software_system.entity.Memory;
import com.baomidou.mybatisplus.extension.service.IService;
import org.hyperic.sigar.SigarException;

import java.net.UnknownHostException;
import java.util.Map;

/**
 * <p>
 * 内存表 服务类
 * </p>
 *
 * @author xutao
 * @since 2022-10-21
 */
public interface MemoryService extends IService<Memory> {

    Memory getMemoryInfo() throws SigarException, UnknownHostException;
}

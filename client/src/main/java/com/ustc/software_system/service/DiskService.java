package com.ustc.software_system.service;

import com.ustc.software_system.entity.Disk;
import com.baomidou.mybatisplus.extension.service.IService;
import org.hyperic.sigar.SigarException;

import java.net.UnknownHostException;
import java.util.List;

/**
 * <p>
 * 硬盘表 服务类
 * </p>
 *
 * @author xutao
 * @since 2022-10-21
 */
public interface DiskService extends IService<Disk> {

    List<Disk> getDiskInfo() throws SigarException, UnknownHostException;
}

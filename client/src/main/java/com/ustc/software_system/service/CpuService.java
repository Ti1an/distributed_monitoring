package com.ustc.software_system.service;

import com.ustc.software_system.entity.Cpu;
import com.baomidou.mybatisplus.extension.service.IService;
import org.hyperic.sigar.SigarException;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * CPU表 服务类
 * </p>
 *
 * @author xutao
 * @since 2022-10-21
 */
public interface CpuService extends IService<Cpu> {

    Map<String, Map<String,Object>> getCpuInfo() throws SigarException, UnknownHostException;

    List<Cpu> getCpuInfomation() throws UnknownHostException, SigarException;
}

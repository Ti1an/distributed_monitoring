package com.ustc.software_system.service;

import com.ustc.software_system.entity.Net;
import com.baomidou.mybatisplus.extension.service.IService;
import org.hyperic.sigar.SigarException;

import java.net.UnknownHostException;
import java.util.List;

/**
 * <p>
 * 网络表 服务类
 * </p>
 *
 * @author xutao
 * @since 2022-10-21
 */
public interface NetService extends IService<Net> {

    List<Net> getNetsInfo() throws SigarException, UnknownHostException;
}

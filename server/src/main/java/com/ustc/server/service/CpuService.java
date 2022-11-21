package com.ustc.server.service;

import com.ustc.server.entity.Cpu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ustc.server.entity.vo.CpuIndex;
import com.ustc.server.entity.vo.CpuQuery;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * CPU表 服务类
 * </p>
 *
 * @author xutao
 * @since 2022-10-22
 */
public interface CpuService extends IService<Cpu> {

    List<String> statisticCpuUseRate();

    List<CpuIndex> getCurrentCpuUsageRateService(String router);

}

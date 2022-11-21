package com.ustc.server.service.impl;

import com.ustc.server.entity.Cpu;
import com.ustc.server.entity.vo.CpuIndex;
import com.ustc.server.entity.vo.CpuQuery;
import com.ustc.server.mapper.CpuMapper;
import com.ustc.server.service.CpuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * CPU表 服务实现类
 * </p>
 *
 * @author xutao
 * @since 2022-10-22
 */
@Service
public class CpuServiceImpl extends ServiceImpl<CpuMapper, Cpu> implements CpuService {

    @Autowired
    private CpuMapper cpuMapper;

    @Override
    public List<String> statisticCpuUseRate() {
        List<String> list = new ArrayList<>();
        list = cpuMapper.selectCpuUseRate();
        return list;
    }

    @Override
    public List<CpuIndex> getCurrentCpuUsageRateService(String router) {
        Map<String, List<Object>> map = new HashMap<>();
        List<CpuIndex> currentCpuUsageRate = cpuMapper.getCurrentCpuUsageRate(router);
        return currentCpuUsageRate;
    }
}

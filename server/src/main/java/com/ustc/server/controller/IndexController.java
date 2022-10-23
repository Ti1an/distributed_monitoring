package com.ustc.server.controller;

import com.ustc.server.entity.vo.CpuIndex;
import com.ustc.server.service.CpuService;
import com.ustc.server.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: ffideal
 * @CreateTime: 2022-10-23  14:24
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("/server/index")
@CrossOrigin
public class IndexController {
    @Autowired
    private CpuService cpuService;
    @GetMapping("/show")
    public R showData() {
        // 获取cpu数据
        List<CpuIndex> cpuIndexList=new ArrayList<>();
        cpuIndexList = cpuService.getCurrentCpuUsageRateService();
        List<String> cpuName = new ArrayList<>();
        List<Double> cpuUsageRate = new ArrayList<>();
        for (int i = 0; i < cpuIndexList.size(); i++) {
            CpuIndex cpuIndex = cpuIndexList.get(i);
            cpuName.add(cpuIndex.getCpuName());
            String cpuTotalUsageRate = cpuIndex.getCpuTotalUserate().replace("%", "");
            cpuUsageRate.add(Double.parseDouble(cpuTotalUsageRate));
        }
            return R.ok().data("cpuName",cpuName).data("cpuUsageRate",cpuUsageRate);

    }
}

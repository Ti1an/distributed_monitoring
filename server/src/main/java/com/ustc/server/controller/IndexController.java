package com.ustc.server.controller;

import com.ustc.server.entity.vo.CpuIndex;
import com.ustc.server.entity.vo.DiskIndex;
import com.ustc.server.entity.vo.MemoryIndex;
import com.ustc.server.entity.vo.NetIndex;
import com.ustc.server.service.CpuService;
import com.ustc.server.service.DiskService;
import com.ustc.server.service.MemoryService;
import com.ustc.server.service.NetService;
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
    @Autowired
    private MemoryService memoryService;
    @Autowired
    private DiskService diskService;
    @Autowired
    private NetService netService;
    private static final Long MB = 1024L * 1024L;
    private static final Long KB = 1024L;

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
        // 获取内存数据
        MemoryIndex memoryIndex = memoryService.getCurrentMemoryUsageRateServuce();

        // 获取硬盘资源
        List<DiskIndex> diskIndexList = diskService.getCurrentDiskIndexService();
        List<String> diskName = new ArrayList<>();
        List<String> diskUsageRate = new ArrayList<>();
        for (int i = 0; i < diskIndexList.size(); i++) {
            DiskIndex diskIndex = diskIndexList.get(i);
            diskName.add(diskIndex.getDName());
            diskUsageRate.add(diskIndex.getDUseRate());
        }

        // 获取网卡资源
        List<NetIndex> netIndexList = netService.getCurrentNetIndexService();
        List<String> sendNet = new ArrayList<>();
        List<String> acceptNet = new ArrayList<>();
        List<String> timeNet = new ArrayList<>();
        for (int i = 0; i < netIndexList.size(); i++) {
            NetIndex netIndex = netIndexList.get(i);
            sendNet.add(String.format("%.2f",(Double.parseDouble(netIndex.getNSendByte()) * 1.0 / MB)));
            acceptNet.add(String.format("%.2f",(Double.parseDouble(netIndex.getNAcceptByte()) * 1.0 / MB)));
            timeNet.add(netIndex.getGmtCreate().toString().substring(11,20));
        }
        return R.ok().data("cpuName",cpuName).data("cpuUsageRate",cpuUsageRate)
                .data("memoryAndSwap",memoryIndex)
                .data("diskName",diskName).data("diskUsageRate",diskUsageRate)
                .data("sendNet",sendNet).data("acceptNet",acceptNet).data("timeNet",timeNet);

    }
}

package com.ustc.software_system.controller;


import com.ustc.software_system.entity.Cpu;
import com.ustc.software_system.service.CpuService;
import org.hyperic.sigar.SigarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * CPU表 前端控制器
 * </p>
 *
 * @author xutao
 * @since 2022-10-21
 */
@RestController
@RequestMapping("/rt/cpu")
public class CpuController {
    @Autowired
    private CpuService cpuService;

    @GetMapping("/findinfo")
    public Map<String, Map<String,Object>> findCpuInfo() throws SigarException, UnknownHostException {
        Map<String, Map<String,Object>> map = new HashMap<>();
        map = cpuService.getCpuInfo();
        return map;
    }

    @GetMapping("/findinfo2")
    public List<Cpu> getCpuInfo() throws SigarException, UnknownHostException {
        List<Cpu> cpuList = new ArrayList<>();
        cpuList = cpuService.getCpuInfomation();
        return cpuList;
    }
}


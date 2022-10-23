package com.ustc.software_system.controller;


import com.ustc.software_system.entity.Disk;
import com.ustc.software_system.entity.Net;
import com.ustc.software_system.service.DiskService;
import com.ustc.software_system.service.NetService;
import org.hyperic.sigar.SigarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 网络表 前端控制器
 * </p>
 *
 * @author xutao
 * @since 2022-10-21
 */
@RestController
@RequestMapping("/rt/net")
public class NetController {
    @Autowired
    private NetService netService;
    @GetMapping("/findinfo")
    public List<Net> findCpuInfo() throws SigarException, UnknownHostException {
//        Map<String, Object> map = new HashMap<>();
        List<Net> nets = new ArrayList<>();
        nets = netService.getNetsInfo();
        return nets;
    }
}


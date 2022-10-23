package com.ustc.software_system.controller;


import com.ustc.software_system.entity.Disk;
import com.ustc.software_system.entity.Memory;
import com.ustc.software_system.service.DiskService;
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
 * 硬盘表 前端控制器
 * </p>
 *
 * @author xutao
 * @since 2022-10-21
 */
@RestController
@RequestMapping("/rt/disk")
public class DiskController {


    @Autowired
    private DiskService diskService;
    @GetMapping("/findinfo")
    public List<Disk> findCpuInfo() throws SigarException, UnknownHostException {
//        Map<String, Object> map = new HashMap<>();
        List<Disk> disks = new ArrayList<>();
        disks = diskService.getDiskInfo();
        return disks;
    }

}


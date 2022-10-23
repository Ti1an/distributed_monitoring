package com.ustc.software_system.controller;


import com.ustc.software_system.entity.Memory;
import com.ustc.software_system.service.MemoryService;
import org.hyperic.sigar.SigarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 内存表 前端控制器
 * </p>
 *
 * @author xutao
 * @since 2022-10-21
 */
@RestController
@RequestMapping("/rt/memory")
public class MemoryController {
    @Autowired
    private MemoryService memoryService;

    @GetMapping("/findinfo")
    public Memory findCpuInfo() throws SigarException, UnknownHostException {
//        Map<String, Object> map = new HashMap<>();
        Memory memory = new Memory();
        memory = memoryService.getMemoryInfo();

        return memory;
    }
}


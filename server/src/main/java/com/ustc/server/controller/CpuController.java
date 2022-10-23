package com.ustc.server.controller;


import com.ustc.server.entity.Cpu;
import com.ustc.server.service.CpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * CPU表 前端控制器
 * </p>
 *
 * @author xutao
 * @since 2022-10-22
 */
@RestController
@RequestMapping("/server/cpu")
public class CpuController {
    @Autowired
    private CpuService cpuService;
    @GetMapping("/userate")
    public List<String> getCpuUseRate(){
        List<String> list = new ArrayList<>();
        list = cpuService.statisticCpuUseRate();
        return list;
    }

}


package com.ustc.server.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mysql.cj.util.StringUtils;
import com.ustc.server.entity.Cpu;
import com.ustc.server.service.CpuService;
import com.ustc.server.utils.R;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
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
@CrossOrigin
public class CpuController {
    @Autowired
    private CpuService cpuService;
    @GetMapping("/userate")
    public List<String> getCpuUseRate(){
        List<String> list = new ArrayList<>();
        list = cpuService.statisticCpuUseRate();
        return list;
    }

    @ApiOperation("有条件查询")
    @PostMapping("/hasCondition/{page}/{limit}/{time}")
    public R queryTeachersByCondition(@ApiParam("当前页")@PathVariable("page")Long page,
                                      @ApiParam("每页记录数") @PathVariable("limit")Long limit,
                                      @ApiParam("传入查询条件") @PathVariable("time") String time,
                                      @RequestBody List<String> routerList){
        System.out.println(routerList);
        String router = routerList.get(1);
        Page<Cpu> pageParam = new Page<>(page,limit);
        QueryWrapper<Cpu> wrapper = new QueryWrapper();
        if (!StringUtils.isNullOrEmpty(time)) {
            wrapper.like("gmt_create",time);
        }
        if (!StringUtils.isNullOrEmpty(router)){
            wrapper.like("computer_ip",router);
        }
//        wrapper.like("computer_ip",router);
        cpuService.page(pageParam, wrapper);
        List<Cpu> records = pageParam.getRecords();
        long total = pageParam.getTotal();
        long size = records.size();
        int cpuNums = records.size();
        // 获取总的使用率/当前空闲率/系统使用率/用户使用率
        List<String> cpuName = new ArrayList<>();
        List<String> totalUsageRate = new ArrayList<>();
        List<String> currentFreeRate = new ArrayList<>();
        List<String> systemUsageRate = new ArrayList<>();
        List<String> userUsageRate = new ArrayList<>();
        for (Cpu cpu:records) {
            cpuName.add(cpu.getCpuName());
            totalUsageRate.add(cpu.getCpuTotalUserate().replace("%",""));
            currentFreeRate.add(cpu.getCpuFreerate().replace("%",""));
            systemUsageRate.add(cpu.getCpuSysUserate().replace("%",""));
            userUsageRate.add(cpu.getCpuUserUserate().replace("%",""));
        }
        return R.ok().data("total", total).data("rows",records)
                .data("cpuName",cpuName).data("totalUsageRate",totalUsageRate).data("currentFreeRate",currentFreeRate)
                .data("systemUsageRate",systemUsageRate).data("userUsageRate",userUsageRate).data("size",size).data("cpuNums",cpuNums);
    }

}


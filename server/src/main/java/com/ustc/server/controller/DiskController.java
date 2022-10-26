package com.ustc.server.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mysql.cj.util.StringUtils;
import com.ustc.server.entity.Cpu;
import com.ustc.server.entity.Disk;
import com.ustc.server.entity.vo.DiskIndex;
import com.ustc.server.service.DiskService;
import com.ustc.server.utils.R;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 硬盘表 前端控制器
 * </p>
 *
 * @author xutao
 * @since 2022-10-22
 */
@RestController
@RequestMapping("/server/disk")
@CrossOrigin
public class DiskController {
    @Autowired
    private DiskService diskService;

    private static final String server = "192.168.56.2";
    @ApiOperation("有条件查询")
    @GetMapping("/hasCondition/{page}/{limit}/{time}")
    public R queryTeachersByCondition(@ApiParam("当前页")@PathVariable("page")Long page,
                                      @ApiParam("每页记录数") @PathVariable("limit")Long limit,
                                      @ApiParam("传入查询条件") @PathVariable("time") String time){
        Page<Disk> pageParam = new Page<>(page,limit);
        QueryWrapper<Disk> wrapper = new QueryWrapper();
        if (!StringUtils.isNullOrEmpty(time)) {
            wrapper.like("gmt_create",time);
        }
//        wrapper.eq("computer_ip",ip);
        diskService.page(pageParam, wrapper);
        List<Disk> records = pageParam.getRecords();
        long total = pageParam.getTotal();


        return R.ok().data("total", total).data("rows",records);
    }
}


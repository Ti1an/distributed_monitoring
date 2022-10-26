package com.ustc.server.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mysql.cj.util.StringUtils;
import com.ustc.server.entity.Cpu;
import com.ustc.server.entity.Memory;
import com.ustc.server.entity.vo.MemoryIndex;
import com.ustc.server.service.MemoryService;
import com.ustc.server.utils.R;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 内存表 前端控制器
 * </p>
 *
 * @author xutao
 * @since 2022-10-22
 */
@RestController
@RequestMapping("/server/memory")
@CrossOrigin
public class MemoryController {


    @Autowired
    private MemoryService memoryService;
    @ApiOperation("有条件查询")
    @GetMapping("/hasCondition/{page}/{limit}/{time}")
    public R queryTeachersByCondition(@ApiParam("当前页")@PathVariable("page")Long page,
                                      @ApiParam("每页记录数") @PathVariable("limit")Long limit,
                                      @ApiParam("传入查询条件") @PathVariable("time") String time){
        Page<Memory> pageParam = new Page<>(page,limit);
        QueryWrapper<Memory> wrapper = new QueryWrapper();
        if (!StringUtils.isNullOrEmpty(time)) {
            wrapper.like("gmt_create",time);
        }
        memoryService.page(pageParam, wrapper);
        List<Memory> records = pageParam.getRecords();
        long total = pageParam.getTotal();
        return R.ok().data("total", total).data("rows",records);
    }

}


package com.ustc.server.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mysql.cj.util.StringUtils;
import com.ustc.server.entity.Net;
import com.ustc.server.service.NetService;
import com.ustc.server.utils.R;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 网络表 前端控制器
 * </p>
 *
 * @author xutao
 * @since 2022-10-22
 */
@RestController
@RequestMapping("/server/net")
@CrossOrigin
public class NetController {

    @Autowired
    private NetService netService;
    @ApiOperation("有条件查询")
    @GetMapping("/hasCondition/{page}/{limit}/{time}")
    public R queryTeachersByCondition(@ApiParam("当前页")@PathVariable("page")Long page,
                                      @ApiParam("每页记录数") @PathVariable("limit")Long limit,
                                      @ApiParam("传入查询条件") @PathVariable("time") String time){
        Page<Net> pageParam = new Page<>(page,limit);
        QueryWrapper<Net> wrapper = new QueryWrapper();
        if (!StringUtils.isNullOrEmpty(time)) {
            wrapper.like("gmt_create",time);
        }
        netService.page(pageParam, wrapper);
        List<Net> records = pageParam.getRecords();
        long total = pageParam.getTotal();
//        wrapper.orderByDesc("n_send_byte");
        long sendNetL = 0L;
        long acceptNetL = 0L;
        for (int i = 0; i < records.size(); i++) {
            Net net = records.get(i);
            sendNetL += Long.parseLong(net.getNSendByte());
            acceptNetL += Long.parseLong(net.getNAcceptByte());
        }
        String sendNet = String.format("%.2f",sendNetL/(1024.0*1024.0));
        String acceptNet = String.format("%.2f",acceptNetL/(1024.0*1024.0));
        return R.ok().data("total", total).data("rows",records)
                .data("sendNet",sendNet).data("acceptNet",acceptNet);
    }

}


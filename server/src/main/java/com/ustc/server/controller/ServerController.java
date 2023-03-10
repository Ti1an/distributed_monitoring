package com.ustc.server.controller;

import com.ustc.server.entity.Cpu;
import com.ustc.server.entity.Disk;
import com.ustc.server.entity.Memory;
import com.ustc.server.entity.Net;
import com.ustc.server.service.CpuService;
import com.ustc.server.service.DiskService;
import com.ustc.server.service.MemoryService;
import com.ustc.server.service.NetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

/**
 * @Author: ffideal
 * @CreateTime: 2022-10-22  15:55
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("/server")
public class ServerController {

    @Autowired
    private CpuService cpuService;

    @Autowired
    private DiskService diskService;

    @Autowired
    private MemoryService memoryService;

    @Autowired
    private NetService netService;

    @Autowired
    private RestTemplate restTemplate;

    String[] routerList = {"192.168.56.1","192.168.43.45","192.168.43.108"};

    @GetMapping("/listener")
//    @Scheduled(cron = "0/3 * * * * ?")
    public void listener() throws InterruptedException {
//        while (true) {
        for (int i = 0; i < routerList.length; i++) {

            String ip = routerList[i];
            System.out.println(ip);
            System.out.println(new Date() + ":写入CPU、硬盘、内存、网卡数据");
            //CPU
            // 2. 利用RestTemplate发送http请求，查询用户
        String cpuUrl = "http://"+ip+":8001/rt/cpu/findinfo2";
//            String cpuUrl = "http://192.168.198.1:8001/rt/cpu/findinfo2";
            Cpu[] cpus = restTemplate.getForObject(cpuUrl, Cpu[].class);
            // 3.保存到数据库
            for (Cpu cpu : cpus) {
                cpuService.save(cpu);
            }

            // 硬盘
            String diskUrl = "http://"+ip+":8001/rt/disk/findinfo";
            Disk[] disks = restTemplate.getForObject(diskUrl, Disk[].class);
            for (Disk disk : disks) {
                diskService.save(disk);
            }

            String memoryUrl = "http://"+ip+":8001/rt/memory/findinfo";
            Memory memory = restTemplate.getForObject(memoryUrl, Memory.class);
            memoryService.save(memory);

            String neUrl = "http://"+ip+":8001/rt/net/findinfo";
            Net[] nets = restTemplate.getForObject(neUrl, Net[].class);
            for (Net net : nets) {
                netService.save(net);
            }
//            Thread.sleep(8000);
//        }
            // 4.返回
        }
    }


}

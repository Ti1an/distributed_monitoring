package com.ustc.software_system.service.impl;

import com.ustc.software_system.entity.Cpu;
import com.ustc.software_system.mapper.CpuMapper;
import com.ustc.software_system.service.CpuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * CPU表 服务实现类
 * </p>
 *
 * @author xutao
 * @since 2022-10-21
 */
@Service
public class CpuServiceImpl extends ServiceImpl<CpuMapper, Cpu> implements CpuService {

    @Override
    public Map<String, Map<String,Object>> getCpuInfo() throws SigarException, UnknownHostException {
        Map<String, Map<String,Object>> map = new HashMap<>();
        InetAddress addr = InetAddress.getLocalHost();;
        String ip = addr.getHostAddress();
        Sigar sigar =  new Sigar();
        CpuInfo infos[] = sigar.getCpuInfoList();
        CpuPerc cpuList[] =  null;
        cpuList = sigar.getCpuPercList();
        for ( int i = 0; i < infos.length; i++) { //  不管是单块CPU还是多CPU都适用
            CpuInfo info = infos[i];
            Map<String, Object> infoCpu = new HashMap<>();
            System.out.println("第" + (i + 1) + "块CPU信息");
            infoCpu.put("主机ip号", ip);
            System.out.println("CPU的总量MHz:    " + info.getMhz()); //  CPU的总量MHz
            infoCpu.put("CPU的总量MHz", info.getMhz());
            System.out.println("CPU生产商:    " + info.getVendor()); //  获得CPU的卖主，如：Intel
            infoCpu.put("CPU生产商", info.getVendor());
            System.out.println("CPU类别:    " + info.getModel()); //  获得CPU的类别，如：Celeron
            infoCpu.put("CPU类别",info.getModel());
            System.out.println("CPU用户使用率:    " + CpuPerc.format(cpuList[i].getUser())); //  用户使用率
            infoCpu.put("CPU用户使用率",CpuPerc.format(cpuList[i].getUser()));
            System.out.println("CPU系统使用率:    " + CpuPerc.format(cpuList[i].getSys())); //  系统使用率
            infoCpu.put("CPU系统使用率",CpuPerc.format(cpuList[i].getSys()));
            System.out.println("CPU当前等待率:    " + CpuPerc.format(cpuList[i].getWait())); //  当前等待率
            infoCpu.put("CPU当前等待率",CpuPerc.format(cpuList[i].getWait()));
            System.out.println("CPU当前错误率:    " + CpuPerc.format(cpuList[i].getNice())); //
            infoCpu.put("CPU当前错误率",CpuPerc.format(cpuList[i].getNice()));
            System.out.println("CPU当前空闲率:    " + CpuPerc.format(cpuList[i].getIdle())); //  当前空闲率
            infoCpu.put("CPU当前空闲率",CpuPerc.format(cpuList[i].getIdle()));
            System.out.println("CPU总的使用率:    " + CpuPerc.format(cpuList[i].getCombined())); //  总的使用率
            infoCpu.put("CPU总的使用率",CpuPerc.format(cpuList[i].getCombined()));
            map.put(String.valueOf(i+1),infoCpu);
        }
        return map;
    }

    @Override
    public List<Cpu> getCpuInfomation() throws UnknownHostException, SigarException {
        List<Cpu> list = new ArrayList<>();
        InetAddress addr = InetAddress.getLocalHost();;
        String ip = addr.getHostAddress();
        Sigar sigar =  new Sigar();
        CpuInfo infos[] = sigar.getCpuInfoList();
        CpuPerc cpuList[] =  null;
        cpuList = sigar.getCpuPercList();
        for ( int i = 0; i < infos.length; i++) { //  不管是单块CPU还是多CPU都适用
            Cpu cpu = new Cpu();
            CpuInfo info = infos[i];
            Map<String, Object> infoCpu = new HashMap<>();
            cpu.setCpuNo(i + 1);
            String name = new String("第" + (i + 1) + "块CPU信息");
            cpu.setCpuName(name);
            cpu.setComputerIp(ip);
            System.out.println("CPU的总量MHz:    " + info.getMhz()); //  CPU的总量MHz
            cpu.setCpuTotalHz(info.getMhz());
            System.out.println("CPU生产商:    " + info.getVendor()); //  获得CPU的卖主，如：Intel
            cpu.setCpuManufacturer(info.getVendor());
            System.out.println("CPU类别:    " + info.getModel()); //  获得CPU的类别，如：Celeron
            cpu.setCpuType(info.getModel());
            System.out.println("CPU用户使用率:    " + CpuPerc.format(cpuList[i].getUser())); //  用户使用率
            cpu.setCpuUserUserate(CpuPerc.format(cpuList[i].getUser()));
            System.out.println("CPU系统使用率:    " + CpuPerc.format(cpuList[i].getSys())); //  系统使用率
            cpu.setCpuSysUserate(CpuPerc.format(cpuList[i].getSys()));
            System.out.println("CPU当前等待率:    " + CpuPerc.format(cpuList[i].getWait())); //  当前等待率
            cpu.setCpuWaitrate(CpuPerc.format(cpuList[i].getWait()));
            System.out.println("CPU当前错误率:    " + CpuPerc.format(cpuList[i].getNice())); //
            cpu.setCpuErrorrate(CpuPerc.format(cpuList[i].getNice()));
            System.out.println("CPU当前空闲率:    " + CpuPerc.format(cpuList[i].getIdle())); //  当前空闲率
            cpu.setCpuFreerate(CpuPerc.format(cpuList[i].getIdle()));
            System.out.println("CPU总的使用率:    " + CpuPerc.format(cpuList[i].getCombined())); //  总的使用率
            cpu.setCpuTotalUserate(CpuPerc.format(cpuList[i].getCombined()));
            list.add(cpu);
        }
        return list;
    }

}

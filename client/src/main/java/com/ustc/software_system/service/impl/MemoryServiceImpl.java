package com.ustc.software_system.service.impl;

import com.ustc.software_system.entity.Memory;
import com.ustc.software_system.mapper.MemoryMapper;
import com.ustc.software_system.service.MemoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.Swap;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 内存表 服务实现类
 * </p>
 *
 * @author xutao
 * @since 2022-10-21
 */
@Service
public class MemoryServiceImpl extends ServiceImpl<MemoryMapper, Memory> implements MemoryService {

    private static final Long GB = 1024L * 1024L * 1024L;
    private static final Long MB = 1024L * 1024L;
    private static final Long KB = 1024L;

    @Override
    public Memory getMemoryInfo() throws SigarException, UnknownHostException {
//        Map<String,Object> map = new HashMap<>();
        Memory memory = new Memory();
        Sigar sigar = new Sigar();
        Mem mem = sigar.getMem();
        InetAddress addr = InetAddress.getLocalHost();
        String ip = addr.getHostAddress();
        memory.setComputerIp(ip);
        //  内存总量
        System.out.println("内存总量:    " + mem.getTotal() / 1024L + "K av");
        memory.setMTotal(String.format("%.2f",(double)mem.getTotal() / GB));
        //  当前内存使用量
        System.out.println("当前内存使用量:    " + mem.getUsed() / 1024L + "K used");
        memory.setMUse(String.format("%.2f",(double)mem.getUsed() / GB));
        //  当前内存剩余量
        System.out.println("当前内存剩余量:    " + mem.getFree() / 1024L + "K free");
        memory.setMFree(String.format("%.2f",(double)mem.getFree() / GB));
        //内存使用率
//        map.put("内存使用率", );
        memory.setMUserate(String.format("%.2f",mem.getUsed() * 100.0 / mem.getTotal()));
        // 内存未使用率
        memory.setMFreerate(String.format("%.2f",mem.getFree() * 100.0 / mem.getTotal()));
        Swap swap = sigar.getSwap();
        //  交换区总量
        System.out.println("交换区总量:    " + swap.getTotal() / 1024L + "K av");
        memory.setMSwapTotal(String.format("%.2f",(double)swap.getTotal() / GB));

        //  当前交换区使用量
        System.out.println("当前交换区使用量:    " + swap.getUsed() / 1024L + "K used");
        memory.setMSwapUse(String.format("%.2f",(double)swap.getUsed() / GB));

        //  当前交换区剩余量
        System.out.println("当前交换区剩余量:    " + swap.getFree() / 1024L + "K free");
        memory.setMSwapFree(String.format("%.2f",(double)swap.getFree() / GB));

        // 交换区使用率
        memory.setMSwapUserate(String.format("%.2f",swap.getUsed() * 100.0 / swap.getTotal()));

        // 交换为空闲率
        memory.setMSwapFreerate(String.format("%.2f",swap.getFree() * 100.0 / swap.getTotal()));
        return memory;
    }
}

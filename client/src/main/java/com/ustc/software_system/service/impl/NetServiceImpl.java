package com.ustc.software_system.service.impl;

import com.ustc.software_system.entity.Net;
import com.ustc.software_system.mapper.NetMapper;
import com.ustc.software_system.service.NetService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.hyperic.sigar.*;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 网络表 服务实现类
 * </p>
 *
 * @author xutao
 * @since 2022-10-21
 */
@Service
public class NetServiceImpl extends ServiceImpl<NetMapper, Net> implements NetService {

    // 网络通信
    @Override
    public List<Net> getNetsInfo() throws SigarException, UnknownHostException {
        List<Net> nets = new ArrayList<>();
        Sigar sigar =  new Sigar();
        String ifNames[] = sigar.getNetInterfaceList();
        String[] ifaces = sigar.getNetInterfaceList();
        InetAddress addr = InetAddress.getLocalHost();
        String ip = addr.getHostAddress();
        for ( int i = 0; i < ifNames.length; i++) {
            Net net = new Net();
            String name = ifNames[i];
            net.setComputerIp(ip);
            NetInterfaceConfig ifconfig = sigar.getNetInterfaceConfig(name);
            System.out.println("网络设备名:    " + name); //  网络设备名
            net.setNEthName(name);
            System.out.println("IP地址:    " + ifconfig.getAddress()); //  IP地址
            net.setNIp(ifconfig.getAddress());
            System.out.println("子网掩码:    " + ifconfig.getNetmask()); //  子网掩码
            net.setNMask(ifconfig.getNetmask());
            if ((ifconfig.getFlags() & 1L) <= 0L) {
                System.out.println("!IFF_UP...skipping getNetInterfaceStat");
                net.setNAcceptPackets(String.valueOf(0));
                net.setNSendPackets(String.valueOf(0));
                net.setNAcceptByte(String.valueOf(0));
                net.setNSendByte(String.valueOf(0));
                net.setNAcceptErrorPackets(String.valueOf(0));
                net.setNSendErrorPackets(String.valueOf(0));
                net.setNAcceptDropPackets(String.valueOf(0));
                net.setNSendDropPackets(String.valueOf(0));
//                continue;
            }
            NetInterfaceStat ifstat = sigar.getNetInterfaceStat(name);
            System.out.println(name + "接收的总包裹数:" + ifstat.getRxPackets()); //  接收的总包裹数
            net.setNAcceptPackets(String.valueOf(ifstat.getRxPackets()));
            System.out.println(name + "发送的总包裹数:" + ifstat.getTxPackets()); //  发送的总包裹数
            net.setNSendPackets(String.valueOf(ifstat.getTxPackets()));
            System.out.println(name + "接收到的总字节数:" + ifstat.getRxBytes()); //  接收到的总字节数
            net.setNAcceptByte(String.valueOf(ifstat.getRxBytes()));
            System.out.println(name + "发送的总字节数:" + ifstat.getTxBytes()); //  发送的总字节数
            net.setNSendByte(String.valueOf(ifstat.getTxBytes()));
            System.out.println(name + "接收到的错误包数:" + ifstat.getRxErrors()); //  接收到的错误包数
            net.setNAcceptErrorPackets(String.valueOf(ifstat.getRxErrors()));
            System.out.println(name + "发送数据包时的错误数:" + ifstat.getTxErrors()); //  发送数据包时的错误数
            net.setNSendErrorPackets(String.valueOf(ifstat.getTxErrors()));
            System.out.println(name + "接收时丢弃的包数:" + ifstat.getRxDropped()); //  接收时丢弃的包数
            net.setNAcceptDropPackets(String.valueOf(ifstat.getRxDropped()));
            System.out.println(name + "发送时丢弃的包数:" + ifstat.getTxDropped()); //  发送时丢弃的包数
            net.setNSendDropPackets(String.valueOf(ifstat.getTxDropped()));

            NetInterfaceConfig cfg = sigar.getNetInterfaceConfig(ifaces[i]);
//            if (NetFlags.LOOPBACK_ADDRESS.equals(cfg.getAddress()) || (cfg.getFlags() & NetFlags.IFF_LOOPBACK) != 0
//                    || NetFlags.NULL_HWADDR.equals(cfg.getHwaddr())) {
////                continue;
//            }
            System.out.println(cfg.getName() + "IP地址:" + cfg.getAddress()); //  IP地址
            System.out.println(cfg.getName() + "网关广播地址:" + cfg.getBroadcast()); //  网关广播地址
            net.setNBroadcastAddress(String.valueOf(cfg.getBroadcast()));
            System.out.println(cfg.getName() + "网卡MAC地址:" + cfg.getHwaddr()); //  网卡MAC地址
            net.setNMacAddress(String.valueOf(cfg.getHwaddr()));
            System.out.println(cfg.getName() + "子网掩码:" + cfg.getNetmask()); //  子网掩码
            net.setNMask(String.valueOf(cfg.getNetmask()));
            System.out.println(cfg.getName() + "网卡描述信息:" + cfg.getDescription()); //  网卡描述信息
            net.setNEthDescription(cfg.getDescription());
            System.out.println(cfg.getName() + "网卡类型" + cfg.getType()); //
            net.setNEthType(cfg.getType());
            nets.add(net);
        }

        return nets;
    }
}

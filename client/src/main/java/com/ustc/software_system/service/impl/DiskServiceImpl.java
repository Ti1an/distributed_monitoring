package com.ustc.software_system.service.impl;

import com.ustc.software_system.entity.Disk;
import com.ustc.software_system.mapper.DiskMapper;
import com.ustc.software_system.service.DiskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 硬盘表 服务实现类
 * </p>
 *
 * @author xutao
 * @since 2022-10-21
 */
@Service
public class DiskServiceImpl extends ServiceImpl<DiskMapper, Disk> implements DiskService {

    private static final Long GB = 1024L * 1024L;
    private static final Long MB = 1024L;

    @Override
    public List<Disk> getDiskInfo() throws SigarException, UnknownHostException {
        List<Disk> diskList = new ArrayList<>();
        Sigar sigar =  new Sigar();
        InetAddress addr = InetAddress.getLocalHost();
        String ip = addr.getHostAddress();
        FileSystem fslist[] = sigar.getFileSystemList();
        for ( int i = 0; i < fslist.length; i++) {
            Disk disk = new Disk();
            disk.setComputerIp(ip);
            System.out.println("分区的盘符名称" + i);
            FileSystem fs = fslist[i];
            //  分区的盘符名称
            System.out.println("盘符名称:    " + fs.getDevName());
            disk.setDName(fs.getDevName());
            //  文件系统类型，比如 FAT32、NTFS
            System.out.println("盘符类型:    " + fs.getSysTypeName());
            disk.setDType(fs.getSysTypeName());
            FileSystemUsage usage =  null;
            usage = sigar.getFileSystemUsage(fs.getDirName());
            switch (fs.getType()) {
                case 0:  //  TYPE_UNKNOWN ：未知
                    break;
                case 1:  //  TYPE_NONE
                    break;
                case 2:  //  TYPE_LOCAL_DISK : 本地硬盘
                    //  文件系统总大小
                    System.out.println(fs.getDevName() + "总大小:    " + usage.getTotal() + "KB");
                    disk.setDTotal(String.valueOf(usage.getTotal() / MB));
                    //  文件系统剩余大小
                    System.out.println(fs.getDevName() + "剩余大小:    " + usage.getFree() + "KB");
                    disk.setDFree(String.valueOf(usage.getFree()));

                    //  文件系统已经使用量
                    System.out.println(fs.getDevName() + "已经使用量:    " + usage.getUsed() + "KB");
                    disk.setDUse(String.valueOf(usage.getUsed()));
                    double usePercent = usage.getUsePercent() * 100.0;

                    //  文件系统资源的利用率
                    System.out.println(fs.getDevName() + "资源的利用率:    " + usePercent + "%");

                    disk.setDUseRate(String.format("%.2f",usage.getUsed() * 100.0 / usage.getTotal() * 1.0));
                    disk.setDFreeRate(String.format("%.2f",100.0 - usage.getUsed() * 100.0 / usage.getTotal() * 1.0));
                    break;
                case 3: //  TYPE_NETWORK ：网络
                    break;
                case 4: //  TYPE_RAM_DISK ：闪存
                    break;
                case 5: //  TYPE_CDROM ：光驱
                    break;
                case 6: //  TYPE_SWAP ：页面交换
                    break;
            }
            System.out.println(fs.getDevName() + "读出：    " + usage.getDiskReads());
            disk.setDCurrentRead(String.valueOf(usage.getDiskReads()));
            System.out.println(fs.getDevName() + "写入：    " + usage.getDiskWrites());
            disk.setDCurrentWrite(String.valueOf(usage.getDiskWrites()));
            diskList.add(disk);
        }
        return diskList;
    }
}

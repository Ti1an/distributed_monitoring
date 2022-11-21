package com.ustc.server.service;

import com.ustc.server.entity.Disk;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ustc.server.entity.vo.DiskIndex;

import java.util.List;

/**
 * <p>
 * 硬盘表 服务类
 * </p>
 *
 * @author xutao
 * @since 2022-10-22
 */
public interface DiskService extends IService<Disk> {

    List<DiskIndex> getCurrentDiskIndexService(String router);
}

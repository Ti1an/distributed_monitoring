package com.ustc.server.service.impl;

import com.ustc.server.entity.Disk;
import com.ustc.server.mapper.DiskMapper;
import com.ustc.server.service.DiskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 硬盘表 服务实现类
 * </p>
 *
 * @author xutao
 * @since 2022-10-22
 */
@Service
public class DiskServiceImpl extends ServiceImpl<DiskMapper, Disk> implements DiskService {

}

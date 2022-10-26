package com.ustc.server.service.impl;

import com.ustc.server.entity.Net;
import com.ustc.server.entity.vo.NetIndex;
import com.ustc.server.mapper.NetMapper;
import com.ustc.server.service.NetService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 网络表 服务实现类
 * </p>
 *
 * @author xutao
 * @since 2022-10-22
 */
@Service
public class NetServiceImpl extends ServiceImpl<NetMapper, Net> implements NetService {

    @Autowired
    private NetMapper netMapper;
    @Override
    public List<NetIndex> getCurrentNetIndexService() {
        List<NetIndex> netIndexList = new ArrayList<>();
        netIndexList = netMapper.getCurrentNetIndex();
        return  netIndexList;
    }

    @Override
    public List<NetIndex> getLastNetIndexService(String time) {
        List<NetIndex> netIndexList = new ArrayList<>();
        netIndexList = netMapper.getLastNetIndex(time);
        return  netIndexList;
    }
}

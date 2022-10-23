package com.ustc.server.service.impl;

import com.ustc.server.entity.Net;
import com.ustc.server.mapper.NetMapper;
import com.ustc.server.service.NetService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}

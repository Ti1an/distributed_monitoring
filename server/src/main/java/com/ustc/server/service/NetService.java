package com.ustc.server.service;

import com.ustc.server.entity.Net;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ustc.server.entity.vo.NetIndex;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 网络表 服务类
 * </p>
 *
 * @author xutao
 * @since 2022-10-22
 */
public interface NetService extends IService<Net> {

    List<NetIndex> getCurrentNetIndexService();

    List<NetIndex> getLastNetIndexService(String time);
}

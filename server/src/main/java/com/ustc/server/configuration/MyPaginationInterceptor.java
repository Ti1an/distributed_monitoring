package com.ustc.server.configuration;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: ffideal
 * @CreateTime: 2022-10-25  12:04
 * @Description: TODO
 * @Version: 1.0
 */
@Configuration
public class MyPaginationInterceptor {
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}

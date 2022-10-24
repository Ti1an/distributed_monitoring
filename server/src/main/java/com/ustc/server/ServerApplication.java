package com.ustc.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author: ffideal
 * @CreateTime: 2022-10-22  15:49
 * @Description: TODO
 * @Version: 1.0
 */
@SpringBootApplication
@EnableScheduling   // 开启定时
public class ServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class);
    }
}

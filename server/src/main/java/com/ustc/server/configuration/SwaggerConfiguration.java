package com.ustc.server.configuration;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: ffideal
 * @CreateTime: 2022-10-25  10:54
 * @Description: TODO
 * @Version: 1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket webApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")
                .apiInfo(webApiInfo())
                .select()
                .paths(Predicates.not(PathSelectors.regex("/admin/.*")))
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build();
    }
    private ApiInfo webApiInfo(){
        return new ApiInfoBuilder()
                // 页面黑色标题
                .title("分布式监控")
                // 副标题
                .description("本文档描述了课程中心微服务接口定义")
                .version("1.0")
                // 网页和邮箱
                .contact(new Contact("ffideal", "https://blog.csdn.net/xt199711?type=blog",
                        "1359975927@qq.com"))
                .build();
    }

}


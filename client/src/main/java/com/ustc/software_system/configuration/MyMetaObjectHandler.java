package com.ustc.software_system.configuration;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * @Author: ffideal
 * @CreateTime: 2022-10-22  15:02
 * @Description: TODO
 * @Version: 1.0
 */
@Configuration
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("gmtCreate",new Date(),metaObject);//metaObject元数据
    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}

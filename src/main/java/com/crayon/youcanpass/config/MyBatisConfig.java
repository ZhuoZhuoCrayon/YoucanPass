package com.crayon.youcanpass.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis配置类
 * Created by crayon on 2020/02/02
 */
@Configuration
@MapperScan({"com.crayon.youcanpass.mapper","com.crayon.youcanpass.dao"})
@EnableTransactionManagement
public class MyBatisConfig {
}
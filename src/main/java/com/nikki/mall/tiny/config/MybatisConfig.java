package com.nikki.mall.tiny.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.nikki.mall.tiny.mbg.mapper")
public class MybatisConfig {
}

package com.sxteng.datasource.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author shixtf
 * @description:
 * @date 2020/5/30  10:18
 */



@Configuration
@MapperScan( value = {"com.sxteng.datasource.mapper"})
@ImportResource({"classpath:dataSource.xml"})
public class Config {

}

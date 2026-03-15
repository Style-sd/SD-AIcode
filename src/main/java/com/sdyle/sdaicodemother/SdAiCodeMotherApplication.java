package com.sdyle.sdaicodemother;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * SD AI Code Mother 应用程序入口
 * 
 * @author Sdyle
 * @since 1.0.0
 */
@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true)
@MapperScan("com.sdyle.sdaicodemother.mapper")
public class SdAiCodeMotherApplication {

    public static void main(String[] args) {
        SpringApplication.run(SdAiCodeMotherApplication.class, args);
    }
}
package com.hansing.system;


import com.hansing.common.security.annotation.EnableCustomConfig;
import com.hansing.common.security.annotation.EnableRyFeignClients;
import com.hansing.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 系统模块
 *
 * @author hansing
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringCloudApplication
public class YmqSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(com.hansing.system.YmqSystemApplication.class, args);

    }
}

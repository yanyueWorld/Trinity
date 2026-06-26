package com.trinity.org.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * trinity-org 启动类
 */
@EnableFeignClients(basePackages = "com.trinity")
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.trinity")
public class OrgApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrgApplication.class, args);
    }
}

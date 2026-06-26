package com.trinity.supplies.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * trinity-supplies 启动类
 */
@EnableFeignClients(basePackages = "com.trinity")
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.trinity")
public class SuppliesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SuppliesApplication.class, args);
    }
}

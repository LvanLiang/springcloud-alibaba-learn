package com.liang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Liangxp
 * @date 2020/4/29 16:38
 */
@SpringBootApplication
@EnableDiscoveryClient
public class UserProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(UserProviderApp.class, args);
    }
}

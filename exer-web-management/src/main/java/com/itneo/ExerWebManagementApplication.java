package com.itneo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.servlet.context.ServletComponentScan;

@ServletComponentScan // 开启了SpringBoot的Servlet组件扫描功能
@SpringBootApplication
public class ExerWebManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExerWebManagementApplication.class, args);
    }

}

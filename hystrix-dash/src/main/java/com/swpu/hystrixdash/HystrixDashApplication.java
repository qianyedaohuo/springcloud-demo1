package com.swpu.hystrixdash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard  //开启仪表盘
public class HystrixDashApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashApplication.class, args);
    }

}

package com.swpu.goodsprovider;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker  //开启熔断
public class GoodsProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsProviderApplication.class, args);
    }

    //配置收集流数据的servlet
    @Bean
    public ServletRegistrationBean getServletRegistrationBean() {
        HystrixMetricsStreamServlet servlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registration = new ServletRegistrationBean(servlet);
        registration.setName("HystrixMetricsStreamServlet");
        registration.setLoadOnStartup(1); //设置优先级
        registration.addUrlMappings("/hystrix.stream");
        return registration;
    }
}

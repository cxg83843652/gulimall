package cn.actional.gulimall.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author actional
 * @email 854356662@qq.com
 * @date 2021/4/15 11:01 PM
 */
@EnableDiscoveryClient
@SpringBootApplication
public class GulimallGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GulimallGatewayApplication.class, args);
    }
}

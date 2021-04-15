package cn.actional.gulimall.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *   open-feign 使用流程
 *    1）引入依赖
 *    2) 编写一个接口，告诉springcloud 这个接口需要调用远程服务
 *       接口注解  @FeignClient("服务名")
 *       方法编写与要调用的远程服务方法相同， 并且，需要完整的访问路径
 *    3) 开启远程调用功能
 * @author actional
 */
@EnableFeignClients(basePackages = "cn.actional.gulimall.member.feign")
@SpringBootApplication
public class GulimallMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallMemberApplication.class, args);
    }

}

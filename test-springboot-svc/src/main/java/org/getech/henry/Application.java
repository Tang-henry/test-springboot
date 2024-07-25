package org.getech.henry;

import cn.getech.poros.starter.launch.PorosApplication;
import feign.Retryer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import javax.swing.*;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author hengji.li@getech.cn
 * @date 2020/2/19
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "cn.getech")
@MapperScan("org.getech.henry.mapper")
public class Application {

    public static void main(String[] args) {
        PorosApplication.run(Application.class, args);
    }
}

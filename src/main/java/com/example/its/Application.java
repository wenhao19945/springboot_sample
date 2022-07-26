package com.example.its;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @ClassName: Application
 * @Author: wenhao
 * @Description: 启动类
 * @Date Created in 2020/12/24 14:17
 * @Modified By:  指定配置文件  -Dspring.profiles.active=prod
 */
@SpringBootApplication
@EnableScheduling
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}

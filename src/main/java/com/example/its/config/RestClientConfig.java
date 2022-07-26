package com.example.its.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: RestClientConfig
 * @Author: lixin
 * @Description: RestClient 配置类
 * @Date Created in 2020/12/24 14:17
 * @Modified By:
 */
@Slf4j
@Configuration
public class RestClientConfig {

  @Bean
  public RestTemplate restTemplate() {
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.setErrorHandler(new DefaultResponseErrorHandler());
    return restTemplate;
  }
}

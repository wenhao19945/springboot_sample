package com.sutpc.its.config;

import javax.websocket.server.ServerEndpointConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @ClassName: WebSocketConfig
 * @Author: lixin
 * @Description: websocket 配置类
 * @Date Created in 2020/12/24 14:20
 * @Modified By:
 */
@Configuration
public class WebSocketConfig extends ServerEndpointConfig.Configurator {

  @Bean
  public ServerEndpointExporter serverEndpointExporter() {
    return new ServerEndpointExporter();
  }

}

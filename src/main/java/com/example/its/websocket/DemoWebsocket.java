package com.example.its.websocket;

import com.example.its.config.WebSocketConfig;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @ClassName: DemoWebsocket
 * @Author: lixin
 * @Description: websocket 服务端接收对象
 * @Date Created in 2020/12/24 14:36
 * @Modified By:
 */
@Slf4j
@ServerEndpoint(value = "/wsHandler/demo", configurator = WebSocketConfig.class)
@EqualsAndHashCode
@Component
public class DemoWebsocket {

  private static CopyOnWriteArraySet<DemoWebsocket> webSocketSet = new CopyOnWriteArraySet<DemoWebsocket>();

  private Session session;

  @OnOpen
  public void onOpen(Session session, EndpointConfig config) {
    this.session = session;

    try {
      webSocketSet.add(this);

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  /**
   * 字符接收器
   */
  @OnMessage
  public void onMessage(String message, Session session) throws IOException {
    log.info("接收消息：{}", message);
    session.getBasicRemote().sendText(message);
  }

  /**
   * 处理二进制消息,参数随便搭配
   *
   * @param message 消息体
   * @param session session
   */
  @OnMessage
  public void onMessage(Session session, byte[] message, boolean isLast) {
		log.info("字节长度：{}", message.length);
  }

  /**
   * 通知所有客户端发送消息
   *
   * @param message 消息体
   */
  public static void sendMessageToAll(String message) {
    for (DemoWebsocket item : webSocketSet) {
      try {
        item.session.getBasicRemote().sendText(message);
      } catch (IOException e) {

        e.printStackTrace();
      }

    }
  }

  /**
   * synchronized 发送消息
   *
   * @param message 消息体
   */
  public synchronized void sendMessage(String message) {
    try {
      // session.getBasicRemote() getAsyncRemote
      session.getBasicRemote().sendText(message);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 与客户端断开连接处理类
   *
   * @param session session
   */
  @OnClose
  public void onClose(Session session) {
    webSocketSet.remove(this);

  }

  /**
   * 与client 通信 异常
   *
   * @param session session
   * @param error 异常信息
   */
  @OnError
  public void onError(Session session, Throwable error) {
    log.error("error e:{}", error.getMessage());
  }
}

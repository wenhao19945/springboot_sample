# 一、命名规范

### 1、java bean 命名规则 
> 数据库实体 去除t_ 前缀 表面 + model 如: xxxModel
> controller 接收参数对象除Map 加 DTO后缀 如: xxxDTO  
> controller 接收返回对象除Map 加 VO后缀 如: xxxVO

### 2、controller 命名规则  
> 业务英文 + Controller 如: xxxController

### 3、service 命名规则
> 业务英文 + Service 如: xxxService
> 业务类 不用写 service 接口

### 3、dao 命名规则
> I + 表名 + Dao 如: IxxxDao

### 4、Mybatis xml sql映射文件(Mapper) 命名规则
> 表名 + Mapper 如: xxxMapper


# 二、该Springboo (版本 2.3.6.RELEASE)工程集成了如下组件，Jdk为1.8

### 1、 mybatis3
### 2、 swagger2在线文档
> 启动后打开http://localhost:8080/swagger-ui.html#/
### 3、 fastjson组件统一封装返回接口json
### 4、 数据库（pgsql）
> 注：Demo里的连接数据库为公共测试库
### 5、 数据库分页
> 参见DemoController里/ findObjectsByPage接口 与前端约定 0为开始页 分页组件需要对开始页加一
### 6、 Websocket
> \websocket\DemoWebsocket.java
### 7、 Timertask
> \timertask\DemoTimerTask.java
### 8、 async异步方法
> 参见DemoController里/testAsync接口
### 9、 统一结果返回
> 参见DemoController里的HttpResult
### 10、统一异常处理
> 参见DemoController里/ testException接口
> 实现方法\aop\ControllerException.java
### 11、日志
> 使用的是log4j + logback框架
> logback.xml 里有日志写入数据库的例子 
> 把日志文件(logback.xml)里的 File FileNamePattern 标签 springboot-sample替换为你的工程名称 如 var/工程名称/...
 
> 
### 12、实体类
> application.yml里已配置了实体类完整路径的前缀，因此在Mapper Xml里可简写实体类的名称
> 基类BaseModel，里面有sys_uuid属性，可在Mapper Xml里写关键字参数；以后会添加相关通用属性如当前时间，当前时间片，当前登录用户信息等
### 13、Http请求调用框架RestTemplate
> 参见DemoController里/ testRest接口
> 可参见https://blog.csdn.net/cowbin2012/article/details/85250855 或https://my.oschina.net/Mkeeper/blog/2054351

### 14、属性配置获取

> \service\DemoService.java

``` java
@Value("${com.sutpc.url.aliyun}")
String aliyunUrl;
```

> \resources\application.yml
```yaml
com:
  sutpc:
    url:
      base: https://market.aliyun.com/products/57096001/cmapi012362.html
      aliyun: ${com.sutpc.url.base}?spm=5176.2020520132.101.4.aa8qWG#sku=yuncode636200004?wd=
```

> 配置 可以用${} 拼接 数据

### 15、spring boot thymeleaf 类似jsp 可以在项目中引入html
> 参见HtmlController里/ index接口 接口返回string 对应 html文件.html 前缀
> html文件 \resources\templates\index.html


# 三、部署时可以读取外部配置文件，运行命令参考如下

> win
```cmd
 start javaw  -Xms20m -Xmx200m  -server -jar jars/springboot_sample-1.0.jar  --server.port=8888 --spring.config.location=file:./jars/config/application.yml,file:./jars/config/sample.properties
```

> linux
```shell
 nohup java -jar ./springboot_sample-1.0.jar  --server.port=8888 --spring.config.location=file:./application.yml,file:./app.properties >nohup.log 2>&1 &
```

> 查看占用端口

```shell
  netstat -tunlp|grep 端口号
```

> 杀死进程
```shell
  kill PID
```


# 待续
<h3> 关于私服，请参见pom.xml，已设置为http://maven.sutpc.cc/repository/public/


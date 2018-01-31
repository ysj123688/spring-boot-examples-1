# 基于rabbitmq的spring cloud stream消息队列使用例子  

本例子将发送消息和接收消息都写到一起了，可以根据需要下在其他项目。分别为input/output目录。

## 创建mq对应的用户

```bash
rabbitmqctl add_vhost TEST_USER_VHOST
rabbitmqctl add_user test_user test_user_pwd
rabbitmqctl set_permissions -p TEST_USER_VHOST test_user "^.*" ".*" ".*"
rabbitmqctl set_user_tags test_user administrator
```

## 运行

1. 启动主程序SpringCloudStreamApp.java
2. 运行测试代码EventPublishTest.testPulishMessage
3. 可以看到控制台输出接收到的事件日志


参考
--- 
- [spring-cloud-stream-docs](http://docs.spring.io/spring-cloud-stream/docs/current/reference/htmlsingle/)
- [spring-cloud-stream-compoents](spring-cloud-stream-compoents.md)
- [linux-centos7-install-rabbitmq](linux-centos7-install-rabbitmq.md)





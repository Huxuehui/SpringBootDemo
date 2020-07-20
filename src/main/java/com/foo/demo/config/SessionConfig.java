package com.foo.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400*30)
//maxInactiveIntervalInSeconds : 设置session的过期时间
//使用 Redis Session 之后，原 Spring Boot 的 server.session.timeout 属性不再生效。故须手动设置
public class SessionConfig {

}

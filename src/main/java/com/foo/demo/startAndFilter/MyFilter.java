package com.foo.demo.startAndFilter;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Configuration
public class MyFilter {

    @Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }


    @Bean
    //注册过滤器, 以便使用
    public FilterRegistrationBean testFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        //实例化过滤器类并设置到程序中
        registration.setFilter(new filters());
        //设置过滤路径
        registration.addUrlPatterns("/*");
        //设置默认参数
        registration.addInitParameter("paramName", "paramValue");
        //设置优先级
        registration.setName("MyFilter");
        //设置优先级
        registration.setOrder(1);
        return registration;
    }

    //自定义过滤器,并实现filter接口
    public class filters  implements Filter{

        @Override
        public void destroy(){

        }

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {

        }

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            System.out.println("this is MyFilter,url :"+request.getRequestURI());
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

}

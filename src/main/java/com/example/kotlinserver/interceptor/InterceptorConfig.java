package com.example.kotlinserver.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HeaderInterceptor()).addPathPatterns("/**").excludePathPatterns("/userCenter/login","/userCenter/register",
                "/goods/getGoodsList","/goods/getGoodsDetail","/goods/getGoodsListByKeyword");
    }
}

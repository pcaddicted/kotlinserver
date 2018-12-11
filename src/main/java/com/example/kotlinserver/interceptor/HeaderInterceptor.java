package com.example.kotlinserver.interceptor;

import com.alibaba.fastjson.JSON;
import com.example.kotlinserver.domain.BaseResp;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeaderInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        String token = httpServletRequest.getHeader("token");
        if(StringUtils.isEmpty(token)){
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("application/json; charset=utf-8");
            BaseResp resp = new BaseResp();
            resp.setStatus(-1);
            resp.setMessage("需要传递token");
            resp.setData(null);
            httpServletResponse.getWriter().write(JSON.toJSONString(resp));
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {


    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

}

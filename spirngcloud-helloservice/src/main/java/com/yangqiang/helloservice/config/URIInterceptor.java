package com.yangqiang.helloservice.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: Gabriel
 * @date: 2020/2/9 1:02
 * @description
 */
@Slf4j
@Component
public class URIInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 统一日志标记
        String logTrackId = request.getHeader("logTrackId");
        if (StringUtils.isEmpty(logTrackId)) {
            logTrackId = String.valueOf(System.currentTimeMillis());
        }
        MDC.put("logTrackId", logTrackId);

        request.setCharacterEncoding("UTF-8");
        request.setAttribute("interfaceStartTime", System.currentTimeMillis());

        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-type", "text/html;charset=UTF-8");

        String uri = request.getRequestURI();
        String method = request.getMethod();
        String userAgent = request.getHeader("User-Agent");
        log.info(String.format("##########【%s】，%s，%s", uri, method, userAgent));

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String uri = request.getRequestURI();
        String method = request.getMethod();
        long interfaceStartTime = (Long) request.getAttribute("interfaceStartTime");
        long interfaceEndTime = System.currentTimeMillis();

        long times = interfaceEndTime - interfaceStartTime;
        if (times > 1000) {
            log.info(String.format("==========【%s】，%s，耗时：%s，请检查是否异常", uri, method, times));
        } else {
            log.info(String.format("==========【%s】，%s，耗时：%s", uri, method, times));
        }
        MDC.remove("logTrackId");
    }
}


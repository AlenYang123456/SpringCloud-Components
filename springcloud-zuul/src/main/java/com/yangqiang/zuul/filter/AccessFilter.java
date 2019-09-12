package com.yangqiang.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: 杨强
 * @Date: 2019/6/30 12:37
 * @Version 1.0
 * @Discription Zuul API网关过滤器
 */
@Slf4j
@Component
public class AccessFilter extends ZuulFilter {

    /**
     *
     过滤器的4中类型
         pre：请求在被路由之前执行
         routing：在路由请求时调用
         post：在routing和errror过滤器之后调用
         error：处理请求时发生错误调用

     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器的顺序
     *      数字越小,越被优先被执行
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 过滤器是否被执行
     *      返回true / false
     *      实际运用中我们可以利用该方法来指定过滤器的有效范围
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器执行的具体逻辑
     *      这里的例子是校验头信息中是否有accessToken 这个信息
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        //获取请求上下文对象
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        //打印日志
        log.info("send {} request to {}", request.getMethod(),request.getRequestURL().toString());

        String accessToken = request.getParameter("accessToken");
        if (null==accessToken){
            log.warn("access token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            /*可以通过对响应体的内容进行编辑*/
            ctx.setResponseBody("");
            return null;
        }
        log.info("access token  Ok" );
        return null;
    }
}

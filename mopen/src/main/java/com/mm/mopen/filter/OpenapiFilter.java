package com.mm.mopen.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class OpenapiFilter extends ZuulFilter {

    /*
     *
     * 需重载ZuulFilter的多个方法
     *
     * filterType()的pre决定在路由之前生效, 同理还有其他的routing在路由时, post在路由后, error在错误发生时
     * filterOrder()决定多个filter的执行顺序
     * shouldFilter()返回boolean决定filter是否生效
     * run()决定filter的内容
     *
     */

    private static Logger logger = LoggerFactory.getLogger(OpenapiFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String name = request.getParameter("name");
        logger.info(String.format("getMethod [%s] url [%s] name [%s]", request.getMethod(), request.getRequestURL().toString(), name));
        if (name.equals("faker")) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(400);
            ctx.setResponseBody("you shall not pass!");
            ctx.set("isSuccess", false);
        } else {
            ctx.setSendZuulResponse(true);
            ctx.setResponseStatusCode(200);
            ctx.set("isSuccess", true);
        }
        return null;
    }
}

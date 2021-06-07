package com.sell.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.sell.zuul.constant.RedisConstant;
import com.sell.zuul.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * Created by 廖师兄
 * 2018-02-15 15:34
 */
@Component
public class AuthFilter extends ZuulFilter
{
	@Autowired
	private StringRedisTemplate redisTemplate;

	@Override
	public String filterType()
	{
		return PRE_TYPE;
	}

	@Override
	public int filterOrder()
	{
		return PRE_DECORATION_FILTER_ORDER - 1;
	}

	@Override
	public boolean shouldFilter()
	{
		return true;
	}

	@Override
	public Object run()
	{
		RequestContext requestContext = RequestContext.getCurrentContext();
		HttpServletRequest request = requestContext.getRequest();
		//实现权限控制 // TODO 实际开发过程有改造的空间
		if ("/order/create".equals(request.getRequestURI()))
		{
			Cookie cookie = CookieUtil.get(request, "openid");
			if (cookie == null || StringUtils.isEmpty(cookie.getValue()))
			{
				requestContext.setSendZuulResponse(false);
				requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
			}
		}
		if ("/order/finish".equals(request.getRequestURI()))
		{
			Cookie cookie = CookieUtil.get(request, "token");
			if (cookie == null || StringUtils.isEmpty(cookie.getValue()) || StringUtils.isEmpty(redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_TEMPLATE, cookie.getValue()))))
			{
				requestContext.setSendZuulResponse(false);
				requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
			}
		}
		return null;
	}
}

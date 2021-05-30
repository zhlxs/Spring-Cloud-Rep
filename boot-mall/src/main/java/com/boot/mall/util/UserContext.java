package com.boot.mall.util;

import com.boot.mall.entity.user.AdminUser;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

public class UserContext
{
	private static final String CURRENT_USER_IN_SESSION = "logininfo";

	/**
	 * 得到session
	 *
	 * @return
	 */
	public static HttpSession getSession()
	{
		//SpringMVC获取session的方式通过RequestContextHolder
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		return attrs.getRequest().getSession();
	}

	/**
	 * 设置当前用户到session中
	 *
	 * @param user
	 */
	public static void setCurrentUserInSession(AdminUser user)
	{
		getSession().setAttribute(CURRENT_USER_IN_SESSION, user);
	}

	/**
	 * 获取当前用户
	 *
	 * @return
	 */
	public static AdminUser getCurrentUserInfo()
	{
		return (AdminUser) getSession().getAttribute(CURRENT_USER_IN_SESSION);
	}
}

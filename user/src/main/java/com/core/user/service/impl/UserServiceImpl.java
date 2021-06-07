package com.core.user.service.impl;

import com.core.user.entity.UserInfo;
import com.core.user.repository.UserInfoRepository;
import com.core.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 廖师兄
 * 2018-03-04 21:45
 */
@Service
public class UserServiceImpl implements UserService
{

	@Autowired
	private UserInfoRepository userInfoRepository;

	/**
	 * 通过openid来查询用户信息
	 *
	 * @param openid
	 * @return
	 */
	@Override
	public UserInfo findByOpenid(String openid)
	{
		return userInfoRepository.findByOpenid(openid);
	}
}

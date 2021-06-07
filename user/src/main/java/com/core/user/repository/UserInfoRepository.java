package com.core.user.repository;

import com.core.user.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 廖师兄
 * 2018-03-04 21:42
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, String>
{

	UserInfo findByOpenid(String openid);
}

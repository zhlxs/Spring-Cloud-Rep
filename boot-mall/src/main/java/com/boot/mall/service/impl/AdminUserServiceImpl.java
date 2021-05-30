package com.boot.mall.service.impl;

import com.boot.mall.dao.user.AdminUserMapper;
import com.boot.mall.dto.LoginUserDTO;
import com.boot.mall.dto.QueryPageDTO;
import com.boot.mall.entity.user.AdminUser;
import com.boot.mall.service.AdminUserService;
import com.boot.mall.util.Assert;
import com.boot.mall.util.Result;
import com.boot.mall.util.UserContext;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AdminUserServiceImpl implements AdminUserService
{
	private final AdminUserMapper adminUserMapper;

	@Override
	public Result login(LoginUserDTO userDTO)
	{
		Gson gson = new Gson();
		//LoginUserDTO userDTO = gson.fromJson(data, LoginUserDTO.class);
		String username = userDTO.getUsername();
		String password = userDTO.getPassword();
		AdminUser query = new AdminUser();
		query.setUserName(username);
		AdminUser user = adminUserMapper.selectOne(query);
		Assert.isTrue(user != null, "用户不存在！");
		if (password.equals(user.getPassword()))
		{
			UserContext.setCurrentUserInSession(user);
			return Result.ok("登录成功", user);
		}
		return Result.fail("登录失败");
	}

	@Override
	public Result queryPage(QueryPageDTO otherParam)
	{
		//过滤
		Example example = new Example(AdminUser.class);
		String orderByClause = " create_time desc";
		example.setOrderByClause(orderByClause);
		//查询
		PageHelper.startPage(otherParam.getPageNum(), otherParam.getPageSize());
		List<AdminUser> users = adminUserMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(users))
		{
			return Result.ok("暂无数据");
		}
		return Result.ok(new PageInfo<>(users));
	}
}

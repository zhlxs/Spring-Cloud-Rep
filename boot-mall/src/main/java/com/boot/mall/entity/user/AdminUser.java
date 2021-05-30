package com.boot.mall.entity.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "admin_user")
public class AdminUser
{
	/**
	 * 主键
	 */
	@Id
	//	@GeneratedValue(generator = "JDBC")
	private String id;

	/**
	 * 用户名
	 */
	@Column(name = "user_name")
	private String userName;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 电子邮箱
	 */
	private String email;

	/**
	 * 联系方式
	 */
	private String phone;

	/**
	 * 角色
	 */
	private String role;

	/**
	 * 性别
	 */
	private String sex;

	/**
	 * 创建时间
	 */
	@Column(name = "create_time")
	private Date createTime;

	/**
	 * 更新时间
	 */
	@Column(name = "update_time")
	private Date updateTime;
}
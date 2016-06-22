package com.nieyue.bean;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
/**
 * 用户类
 * @author yy
 *
 */

public class User implements Serializable {
	
	private static final long serialVersionUID = 8198930199550185349L;
	/**
	 * 用户id
	 */
	@NotNull(message="{user.userId.notNull}")
	private Integer userId;
	/**
	 * 昵称
	 */
	@NotNull(message="{user.niceName.notNull}")
	private String niceName;
	/**
	 * 登录名
	 */
	@NotNull(message="{user.name.notNull}")
	private String name;
	/**
	 * 登录密码
	 */
	@NotNull(message="{user.password.notNull}")
	private String password;
	/**
	 * 注册时间 
	 */
	@NotNull(message="{user.regTime.notNull}")
	private Date regTime;
	/**
	 * 最后登陆时间
	 */
	@NotNull(message="{user.lastLoginTime.notNull}")
	private Date lastLoginTime;
	public User(Integer userId, String niceName, String name, String password,
			Date regTime, Date lastLoginTime) {
		super();
		this.userId = userId;
		this.niceName = niceName;
		this.name = name;
		this.password = password;
		this.regTime = regTime;
		this.lastLoginTime = lastLoginTime;
	}
	public User() {
		super();
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getNiceName() {
		return niceName;
	}
	public void setNiceName(String niceName) {
		this.niceName = niceName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegTime() {
		return regTime;
	}
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", niceName=" + niceName + ", name="
				+ name + ", password=" + password + ", regTime=" + regTime
				+ ", lastLoginTime=" + lastLoginTime + "]";
	}
	
	
}

package com.nieyue.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nieyue.bean.User;
import com.nieyue.dao.UserDao;
import com.nieyue.service.UserService;

/**
 * 用户业务实现类
 * @author Administrator
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Resource
	UserDao userDao;
	/**
	 * 用户登录
	 */
	public User userLogin(String name, String password) {
		User u = userDao.userLogin(name, password);
		return u;
	}

	/**
	 * 检查用户是否存在
	 */
	@Override
	public boolean chkLoginName(String name) {
		boolean s = userDao.chkLoginName(name);
		return s;
	}

	/**
	 * 找回用户
	 */
	@Override
	public User retrieveAccount(String name) {
		User u = userDao.retrieveAccount(name);
		return u;
	}

	/**
	 * 增加用户
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class,Exception.class})
	public void addUser(User user) {
		userDao.addUser(user);
	}

	/**
	 * 更新用户
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class,Exception.class})
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	/**
	 * 浏览当前页用户
	 */
	@Override
	public List<User> searchUser(Integer pageNum, Integer pageSize) {
		if(pageNum<1){
			pageNum=1;
		}
		List<User> list = userDao.searchUser(pageNum-1, pageSize);
		return list;
	}

	/**
	 * 浏览所有用户
	 */
	@Override
	public List<User> browseUser() {
		List<User> l = userDao.browseUser();
		return l;
	}

	/**
	 * 删除用户
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={RuntimeException.class,Exception.class})
	public void delUser(Integer userId) {
		userDao.delUser(userId);
	}

	/**
	 * 加载单个用户
	 */
	@Override
	public User loadUser(Integer userId) {
		User u = userDao.loadUser(userId);
		return u;
	}

}

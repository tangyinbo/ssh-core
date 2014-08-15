package cn.edu.ssh.module.user.dao.impl;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.ssh.base.BaseTest;
import cn.edu.ssh.module.user.dao.UserDao;
import cn.edu.ssh.module.user.entity.User;

public class UserDaoTest extends BaseTest{
	@Autowired
	private UserDao userDao;
	
	@Test
	public void testInsertUser(){
		User user = new User();
		user.setName("tangyinbo");
		user.setAge(1);
		user.setUserName("admin");
		user.setRegDate(new Date());
		user.setSalt("");
		userDao.insertUser(user);
	}
}

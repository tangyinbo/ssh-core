package cn.edu.ssh.module.user.dao;

import java.io.Serializable;

import cn.edu.ssh.module.provide.BaseDao;
import cn.edu.ssh.module.user.entity.User;

public interface UserDao extends BaseDao<User, Serializable>{
	public User getByUserName(String userName);
}

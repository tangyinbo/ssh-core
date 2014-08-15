package cn.edu.ssh.module.user.dao.impl;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.ssh.module.user.dao.UserDao;
import cn.edu.ssh.module.user.entity.User;

@Repository("userDao")
@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
public class UserDaoImpl implements UserDao{
	@PersistenceContext
	private EntityManager entityManager;
	
	public void insertUser(User user){
		this.entityManager.persist(user);
	}
	
}

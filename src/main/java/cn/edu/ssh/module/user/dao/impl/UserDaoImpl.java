package cn.edu.ssh.module.user.dao.impl;


import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.ssh.module.provide.impl.BaseDaoImpl;
import cn.edu.ssh.module.user.dao.UserDao;
import cn.edu.ssh.module.user.entity.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	
	private UserDaoImpl() {
		super();
	}

	protected UserDaoImpl(String idName) {
		super(idName);
	}

	@Override
	public void delteById(Serializable s) {
		
	}

	@Override
	public User getByUserName(String userName) {
		List<User> users =sessionFactory.getCurrentSession().createCriteria(clazz).add(Restrictions.eq("userName", userName)).list();
		if(users.size()==0) return null;
		return users.get(0);
	}

	
}

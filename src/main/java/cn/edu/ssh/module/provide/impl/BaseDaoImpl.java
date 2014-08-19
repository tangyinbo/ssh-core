package cn.edu.ssh.module.provide.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import cn.edu.ssh.module.provide.BaseDao;

@Lazy(true)
@Scope("prototype")
@Repository()
public abstract class BaseDaoImpl<T> implements BaseDao<T, Serializable>{
	protected Class clazz;
	@Autowired
	protected SessionFactory sessionFactory;
	private String idName;

	public BaseDaoImpl() {
		ParameterizedType type =(ParameterizedType)(this.getClass().getGenericSuperclass());
		clazz=(Class) type.getActualTypeArguments()[0];
	}

	protected BaseDaoImpl(String idName) {
		this.idName = idName;
	}

	@Override
	public T getById(Serializable id) {
		return (T) sessionFactory.getCurrentSession().get(clazz, id);
	}

	@Override
	public List<T> query() {
		return sessionFactory.getCurrentSession().createQuery("FROM "+clazz.getSimpleName()).list();
	}

	@Override
	public Integer save(T t) {
		return (Integer) sessionFactory.getCurrentSession().save(t);
	}

	@Override
	public void delete(T t) {
		sessionFactory.getCurrentSession().delete(t);		
	}

/*	@Override
	public void delteById(Serializable s) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from "+clazz.getSimpleName() +" where "+idName +"=:id");
		query.setParameter("id", s);
		query.executeUpdate();
	}*/
	public abstract void delteById(Serializable s);

	@Override
	public void update(T t) {
		sessionFactory.getCurrentSession().update(t);
	}


}

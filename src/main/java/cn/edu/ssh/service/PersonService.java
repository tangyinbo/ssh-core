package cn.edu.ssh.service;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.ssh.entity.Person;

@Service
public class PersonService {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addPerson(Person p) {
		/*Session s =sessionFactory.openSession();
		Transaction t =s.beginTransaction();
		s.save(p);
		t.commit();
		s.close();*/
		sessionFactory.openSession().save(p);
	}
}

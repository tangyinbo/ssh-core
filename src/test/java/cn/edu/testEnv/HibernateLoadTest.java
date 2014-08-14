package cn.edu.testEnv;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import cn.edu.ssh.entity.Person;
import cn.edu.ssh.util.HibernateUtils;

public class HibernateLoadTest {
	public static void main(String[] args) {
		Session session = HibernateUtils.getSession();
		//session.beginTransaction();
		List<Person> lists = session.createQuery("from Person").list();
		for(Person p : lists){
			System.out.println(p);
		}
	}
	
	public static void test1(){
		Configuration cfg = new Configuration();
		SessionFactory factory=cfg.configure().buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build());
		//SessionFactory factory=cfg.configure().buildSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction t = session.beginTransaction();
		Person p  = new Person();
		p.setName("tangyinbo");
		p.setAge(1);
		session.save(p);
		if(t.isActive()){
			System.out.println("--------commit the transaction.");
			t.commit();
		}
		session.close();
	}
}

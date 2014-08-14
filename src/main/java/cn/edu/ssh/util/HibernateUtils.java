package cn.edu.ssh.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
* @ClassName: HibernateUtils
* @Description: 获取sessionFactory 的工具类
* @author Tangyinbo
* @date 2014-8-14 下午2:36:37
*
 */
public class HibernateUtils {

	private static SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		Configuration config = new Configuration().configure();
		try {
			return config.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build());
		} catch (Exception e) {
			System.out.println("SesssionFactory init faild....");
			return null;
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	public static Session getSession(){
		return sessionFactory.openSession();
	}
}

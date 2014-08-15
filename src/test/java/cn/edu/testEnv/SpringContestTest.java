package cn.edu.testEnv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.activation.DataSource;
import javax.transaction.TransactionManager;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jca.support.LocalConnectionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import cn.edu.ssh.entity.Person;
import cn.edu.ssh.service.PersonService;

public class SpringContestTest {
	public static void main(String[] args) throws Exception {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
		ComboPooledDataSource ds =(ComboPooledDataSource) context.getBean("dataSource");
		System.out.println(ds);
		System.out.println(ds.getConnection());
		 
		System.out.println(context.getBean("sysEmf"));
		 
	
		/*Class.forName("com.mysql.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/ssh_edu", "root", "root");*/
	}
}

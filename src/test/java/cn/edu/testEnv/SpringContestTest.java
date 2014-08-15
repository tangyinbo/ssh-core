package cn.edu.testEnv;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.ssh.entity.Person;
import cn.edu.ssh.service.PersonService;

public class SpringContestTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
		PersonService service=(PersonService) context.getBean("personService");
		Person p = new Person();
		p.setName("admin");
		p.setAge(5);
		service.addPerson(p);
	}
}

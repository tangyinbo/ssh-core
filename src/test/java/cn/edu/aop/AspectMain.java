package cn.edu.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectMain {
	public static void main(String[] args) {
		/*ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
		Aspect01Test test = (Aspect01Test) context.getBean("aspect01test");
		test.test("tangyinbo");*/
		System.out.println(AspectMain.class.getClassLoader().getResource("").getPath());
		System.out.println(System.getProperty("user.dir"));
	}
}

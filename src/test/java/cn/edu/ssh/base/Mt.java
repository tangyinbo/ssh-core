package cn.edu.ssh.base;

import cn.edu.ssh.module.user.dao.impl.UserDaoTest;

public class Mt {
	public static void main(String[] args) {
			String s = Mt.class.getClassLoader().getResource("").getPath();
			String sub=s.substring(0,s.indexOf("target")).concat("src/test/resources");
			System.out.println(sub);
	}
}

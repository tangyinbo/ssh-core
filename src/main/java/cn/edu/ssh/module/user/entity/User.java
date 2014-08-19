package cn.edu.ssh.module.user.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class User {
	private int id;
	
	private String userName;
	
	private String name;
	
	private int age;
	
	private String salt;
	
	private Date regDate;
	
	private String password;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String userName, String name, int age, String salt, Date regDate) {
		super();
		this.id = id;
		this.userName = userName;
		this.name = name;
		this.age = age;
		this.salt = salt;
		this.regDate = regDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	/** 
	 * @return password 
	 */
	
	public String getPassword() {
		return password;
	}
	/** 
	 * @param password 要设置的 password 
	 */
	
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return this.name+"->"+this.userName+"->"+this.age;
	}
}

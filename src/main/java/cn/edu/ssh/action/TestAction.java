package cn.edu.ssh.action;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
public class TestAction extends ActionSupport{
	public String test1(){
		return "test1";
	}
	
	public String test2(){
		return "test2";
	}
}

package cn.edu.ssh.module.user.dao.impl;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.dbunit.DatabaseUnitException;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlProducer;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.metamodel.relational.Database;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.xml.sax.InputSource;

import cn.edu.ssh.base.BaseTest;
import cn.edu.ssh.module.user.dao.UserDao;
import cn.edu.ssh.module.user.entity.User;

public class UserDaoTest extends BaseTest{
	@Autowired
	private UserDao userDao;
	private IDataSet dataSet;
	File backFile= new File("G:/dbunit/t_user.xml");
	
	@Before
	public void startUp(){
		try {
			backUptable(new String[]{"t_user"}, backFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			File f = new File(dataFilePath, "t_user.xml");
			dataSet = new FlatXmlDataSet(new FlatXmlProducer(new InputSource(new FileInputStream("E:/java_workspacre/enhance/ssh-core/src/test/resources/datafile/t_user.xml"))));
		} catch (DataSetException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			DatabaseOperation.CLEAN_INSERT.execute(databaseConnection, dataSet);
		} catch (DatabaseUnitException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@After
	public void tearDown(){
		try {
			resumeData(dataSet, backFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInsertUser(){
		User user = new User();
		user.setUserName("tt");
		user.setName("tt");
		user.setSalt("a");
		user.setAge(13);
		user.setRegDate(new Date());
		int rows =userDao.save(user);
		assertNotEquals("添加用户失败", 0, rows);
	}
	
	@Test
	public void testDelte(){
		User user = new User();
		user.setId(3);
		userDao.delete(user);
		User user2 = userDao.getById(3);
		assertNull(user2);
	}
	
	@Test
	public void testQuery(){
		List<User> list =userDao.query();
		for(User u:list){
			System.out.println(u);
		}
	}
	
	@Test
	public void testGetByUserName(){
		String name = "admin1";
		User user =userDao.getByUserName(name);
		assertNotNull("测试用户登录失败",user);
	}
}

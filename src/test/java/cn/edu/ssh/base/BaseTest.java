package cn.edu.ssh.base;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlProducer;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.xml.sax.InputSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml" })
public class BaseTest {
	protected String dataFilePath ;
	@Autowired
	private static SessionFactory sessionFactory;

	protected static IDatabaseConnection databaseConnection;
	private static Connection connection;

	/**
	 * 
	 * @Title: backUptable
	 * @Description: 备份指定表到指定文件
	 * @param @param tables
	 * @param @param backFile
	 * @param @throws Exception
	 * @return void
	 * @author Tangyinbo
	 * @date 2014-8-11 下午5:07:47
	 * @throws
	 */
	protected void backUptable(String[] tables, File backFile) throws Exception {
		QueryDataSet dataSet = new QueryDataSet(databaseConnection);
		for (String table : tables)
			dataSet.addTable(table);
		FlatXmlDataSet.write(dataSet, new FileOutputStream(backFile));
		System.out.println("------------------------------------");
	}

	protected void resumeData(IDataSet dataSet, File backFile) throws Exception {

		DatabaseOperation.TRUNCATE_TABLE.execute(databaseConnection, dataSet);

		DatabaseOperation.INSERT.execute(databaseConnection, new FlatXmlDataSet(new FlatXmlProducer(new InputSource(new FileInputStream(backFile)))));
	}

	@BeforeClass
	public static void statupClass() throws DatabaseUnitException, SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/ssh_edu", "root", "root");
			System.out.println("======================================");
			System.out.println(connection);
			databaseConnection = new DatabaseConnection(connection);
			String dataFilePath_temp = Mt.class.getClassLoader().getResource("").getPath();
			String dataFilePath=dataFilePath_temp.substring(0,dataFilePath_temp.indexOf("target")).concat("src/test/resources/datafile");
			System.out.println(dataFilePath);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public static void tearDownClass() throws SQLException {
		databaseConnection.close();

	}
}

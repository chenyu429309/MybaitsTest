package com.felix.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.felix.mapper.StudentMapper;
import com.felix.mapper.UserMapper;
import com.felix.pojo.Orders;
import com.felix.pojo.Student;
import com.felix.utils.Sex;

public class MybaitsTest {
	private static SqlSessionFactory sqlSessionFactory = null;
	// 定义日志
	private static Logger logger = Logger.getLogger(MybaitsTest.class);

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		// 获取sqlsessionFactory
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info(inputStream.toString());
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 用java编程实现获取sqlSessionFactory
		// sqlSessionFactory=SqlSessionFactoryUtils.getSqlSessionFactory();
		logger.info(sqlSessionFactory.toString());
		// 获取sqlsession
		SqlSession sqlsession = sqlSessionFactory.openSession();
		// 获取代理借口
		UserMapper usermapper = sqlsession.getMapper(UserMapper.class);
		// User map=usermapper.findUserByIdMap(1);
		// logger.info("返回的map"+map);
		// User user = usermapper.findUserById(1);
		// logger.info("返回的map"+user);
		// User userByname = usermapper.findUserByname("json");
		// logger.info("返回的userByname"+userByname);
		//// logger.info(user);
		// //
		// User insertUser=new User();
		// insertUser.setAge(22);
		// insertUser.setName("felix");
		// usermapper.insertUser(insertUser);
		// usermapper.deleteUser(1);
		// usermapper.findUserBynameHandler("json");
		// Person person=new Person();
		// person.setAge("Test");
		// person.setName("json");
		// person.setSex(Sex.FEMALE);
		// //向数据库中插入Person
		// usermapper.insertPerson(person);
		// Person currentPerson=usermapper.getPersonById(5);
		// logger.info("当前人："+currentPerson);
		// currentPerson=usermapper.findPersonById(3);
		// logger.info("当前人1："+currentPerson);
		Orders order = usermapper.findOrderByid(1);
		logger.info(order);
		sqlsession.commit();
		long end = System.currentTimeMillis();
		logger.debug(end - start);
	}
	@Test
	public void studentMapperTest() {
		long start = System.currentTimeMillis();
		// 获取sqlsessionFactory
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info(inputStream.toString());
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 用java编程实现获取sqlSessionFactory
		// sqlSessionFactory=SqlSessionFactoryUtils.getSqlSessionFactory();
		logger.info(sqlSessionFactory.toString());
		// 获取sqlsession
		SqlSession sqlsession = sqlSessionFactory.openSession();
		// 获取代理借口
		 StudentMapper studentMapper=
		 sqlsession.getMapper(StudentMapper.class);
		// Student student= studentMapper.getStudentById(1);
		// logger.info("查到的学生为："+student);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Felix");
		map.put("sex", Sex.MALE);
		map.put("birthday", new Date());
		map.put("clazz_id", 2);
		studentMapper.insertIntoStudent(map);
		sqlsession.commit();
		long end = System.currentTimeMillis();
		logger.debug(end - start);
	}
}

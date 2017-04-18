package com.felix.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.felix.mapper.UserMapper;
import com.felix.pojo.User;
import com.felix.utils.SqlSessionFactoryUtils;

public class MybaitsTest {
	private static SqlSessionFactory sqlSessionFactory=null;
	//定义日志
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
		logger.debug(inputStream.toString());
//		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		sqlSessionFactory=SqlSessionFactoryUtils.getSqlSessionFactory();
		logger.debug(sqlSessionFactory.toString());
		// 获取sqlsession
		SqlSession sqlsession = sqlSessionFactory.openSession();
		// 获取代理借口
		UserMapper usermapper = sqlsession.getMapper(UserMapper.class);
		User user = usermapper.findUserById(1);
		logger.debug(user);
		long end = System.currentTimeMillis();
		logger.debug(end - start);
	}
}

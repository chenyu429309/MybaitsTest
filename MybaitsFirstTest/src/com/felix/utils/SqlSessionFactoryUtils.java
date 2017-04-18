package com.felix.utils;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.apache.log4j.Logger;

import com.felix.mapper.UserMapper;
import com.felix.pojo.User;
import com.felix.test.MybaitsTest;

public class SqlSessionFactoryUtils {
	private static Logger logger = Logger.getLogger(MybaitsTest.class);
	private static SqlSessionFactory sqlSessionFactory=null;
	//类线程索
	private static final Class<MybaitsTest> CLASS_LOCK=MybaitsTest.class;
	public static SqlSessionFactory getSqlSessionFactory(){
		PooledDataSource datasource=new PooledDataSource();
		datasource.setDriver("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/mybaitsDemoDB?useUniCode=true&characterEncoding=UTF-8");
		datasource.setUsername("root");
		datasource.setPassword("root");
		//构建事务管理
		TransactionFactory transactionfactory=new JdbcTransactionFactory();
		//创建环境
		Environment environment=new Environment("develoment",transactionfactory,datasource);
		//构建Configuration
		Configuration configuration=new Configuration(environment);
		//注册一个mybaits上下文别名
		configuration.getTypeAliasRegistry().registerAlias("user",User.class);
		configuration.addMapper(UserMapper.class);
		logger.debug(configuration);
		synchronized (CLASS_LOCK) {
			if(sqlSessionFactory==null){
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
			}
		}
		return sqlSessionFactory;
	}
}

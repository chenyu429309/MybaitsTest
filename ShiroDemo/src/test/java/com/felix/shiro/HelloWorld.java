package com.felix.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

import com.sun.istack.internal.logging.Logger;

public class HelloWorld {
private Logger logger=Logger.getLogger(HelloWorld.class);
	@Test
	public void testHelloWorld() {
		Factory< SecurityManager> factory=  new IniSecurityManagerFactory("classpath:shiro.ini");
		 SecurityManager securityManager=factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken("zhangsan", "123");
		subject.login(usernamePasswordToken);
	}
	
	public void login(String path) {
//		Factory< SecurityManager> factory=  new IniSecurityManagerFactory("classpath:shiro.ini");
		Factory< SecurityManager> factory=  new IniSecurityManagerFactory(path);
		 SecurityManager securityManager=factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken("zhangsan", "123");
		subject.login(usernamePasswordToken);
	}
	//自定义Realm测试
	@Test
	public void MyRealmsTest(){
		login("classpath:shiro-multi-realm.ini");
		Subject subject=SecurityUtils.getSubject();
		logger.info(subject.getPrincipal().toString());
	}
	@Test
	public void MyRealmsjdbcTest(){
		login("classpath:shiro-jdbc-realm.ini");
		Subject subject=SecurityUtils.getSubject();
		logger.info(subject.getPrincipal().toString());
	}
	

}

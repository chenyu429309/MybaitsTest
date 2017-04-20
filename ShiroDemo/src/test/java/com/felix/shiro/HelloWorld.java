package com.felix.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

public class HelloWorld {

	@Test
	public void testHelloWorld() {
		//1获取SecurityManager工厂，使用ini配置文件初始化SecurityManager
		Factory< SecurityManager> factory=  new IniSecurityManagerFactory("classpath:shiro.ini");
		//2 得到SecurityManager实例，并绑定给SecurityUtils
		 SecurityManager securityManager=factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		//得到Subject及创建用户名和密码验证身份Token（即用户凭证）
		
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken("zhangsan", "123");
		subject.login(usernamePasswordToken);
		
	}

}

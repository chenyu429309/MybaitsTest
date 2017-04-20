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
		//1��ȡSecurityManager������ʹ��ini�����ļ���ʼ��SecurityManager
		Factory< SecurityManager> factory=  new IniSecurityManagerFactory("classpath:shiro.ini");
		//2 �õ�SecurityManagerʵ�������󶨸�SecurityUtils
		 SecurityManager securityManager=factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		//�õ�Subject�������û�����������֤���Token�����û�ƾ֤��
		
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken("zhangsan", "123");
		subject.login(usernamePasswordToken);
		
	}

}

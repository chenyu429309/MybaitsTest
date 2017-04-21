package com.felix.myRealmTest;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

import com.sun.istack.internal.logging.Logger;

public class MyRealm1 implements Realm {
	Logger logger = Logger.getLogger(MyRealm1.class);

	@Override
	public String getName() {
		// get Realm name
		logger.info("MyRealm1");
		return "MyRealm1";
	}

	@Override
	public boolean supports(AuthenticationToken token) {
		// TODO 是否支持这个Token即 这个Token是否为UsernamePasswordToken 的子类
		return token instanceof UsernamePasswordToken;
	}

	@Override
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 将获取到的token与shiro配置里的属性相比较
		String username = (String) token.getPrincipal();// 获取用户名
		logger.info("账户" + username);
		String password = new String((char[])token.getCredentials());// 获取密码
		logger.info("密码" + password);
		if (!"wang".equals(username)) {
			throw new UnknownAccountException();// 账户不存在
		}
		if (!"123".equals(password)) {
			throw new IncorrectCredentialsException();// 密码错误
		}
		logger.info(new SimpleAuthenticationInfo(username, password, getName()).toString());
		return new SimpleAuthenticationInfo(username, password, getName());// 获取身份认证信息
	}

}

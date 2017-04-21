package com.felix.myRealmTest;

import java.util.Collection;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.AuthenticationStrategy;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.util.CollectionUtils;

import com.sun.istack.internal.logging.Logger;
/**
 * 自定义Authenticator的策略
 * @author Felix
 *
 */
public class MyAuthenticationStrategy implements AuthenticationStrategy{
private Logger logger =Logger.getLogger(MyAuthenticationStrategy.class);
	@Override
	public AuthenticationInfo beforeAllAttempts(Collection<? extends Realm> realms, AuthenticationToken token)
			throws AuthenticationException {
		logger.info("在所有Realm验证之前");
//		for(Realm realm:realms){
//			if(realm.supports(token)){
//				 realm.getAuthenticationInfo(token);
//			}
//		}
		return null;
	}

	@Override
	public AuthenticationInfo beforeAttempt(Realm realm, AuthenticationToken token, AuthenticationInfo aggregate)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		logger.info("在每个Realm验证之前realm:"+realm.getName());
		logger.info("在每个Realm验证之前token:"+(String)token.getPrincipal());
		logger.info("在每个Realm验证之前aggregate:"+aggregate.toString());
//			if(realm.supports(token)){
//				return realm.getAuthenticationInfo(token);
//			}
//			logger.info(aggregate.toString());
		return null;
	}

	@Override
	public AuthenticationInfo afterAttempt(Realm realm, AuthenticationToken token, AuthenticationInfo singleRealmInfo,
			AuthenticationInfo aggregateInfo, Throwable t) throws AuthenticationException {
		// TODO Auto-generated method stub
		logger.info("在每个Realm验证之后realm:"+realm.getName());
		logger.info("在每个Realm验证之后token:"+(String)token.getPrincipal());
		logger.info("在每个Realm验证之后aggregate:"+aggregateInfo.toString());
		logger.info("在每个Realm验证之后Throwable:"+ t);
//			if(realm.supports(token)){
//				return realm.getAuthenticationInfo(token);
//			}
//			logger.info(aggregateInfo.toString());
//			logger.info(t.toString());
		return singleRealmInfo==null?null:singleRealmInfo;
	}

	@Override
	public AuthenticationInfo afterAllAttempts(AuthenticationToken token, AuthenticationInfo aggregate)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		logger.info("在所有Realm验证之后");
		logger.info("在所有Realm验证之后token:"+(String)token.getPrincipal());
		logger.info("在所有Realm验证之后aggregate:"+aggregate.toString());
		 if (aggregate == null || CollectionUtils.isEmpty(aggregate.getPrincipals())) {
	            throw new AuthenticationException("Authentication token of type [" + token.getClass() + "] " +
	                    "could not be authenticated by any configured realms.  Please ensure that at least one realm can " +
	                    "authenticate these tokens.");
	        }

	        return aggregate;
	}

}

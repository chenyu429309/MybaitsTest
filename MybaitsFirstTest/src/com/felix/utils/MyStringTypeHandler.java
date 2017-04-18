package com.felix.utils;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.apache.log4j.Logger;
@MappedTypes({String.class})//注解定义java类型，拦截那些java类型
@MappedJdbcTypes(JdbcType.VARCHAR)//定义jdbc类型，满足JdbcType所列的枚举类型
public class MyStringTypeHandler implements TypeHandler<String>{
private Logger log=Logger.getLogger(MyStringTypeHandler.class);
	@Override
	public String getResult(ResultSet rs, String colName) throws SQLException {
		log.info("使用我的typehandle,ResultSet列名获取字符串");
		return rs.getString(colName);
	}

	@Override
	public String getResult(ResultSet rs, int index) throws SQLException {
		log.info("使用我的typehandle,ResultSet下标获取字符串");
		return rs.getString(index);
	}

	@Override
	public String getResult(CallableStatement cs, int index) throws SQLException {
		log.info("使用我的typeHandle，CallableStatement下标获取字符串");
		return cs.getString(index);
	}

	@Override
	public void setParameter(PreparedStatement ps, int index, String value, JdbcType jt) throws SQLException {
		log.info("使用我的typeHandle，绑定参数");
		ps.setString(index, value);
		
	}
		
}

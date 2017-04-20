package com.felix.mapper;

import java.util.List;
import java.util.Map;

import com.felix.pojo.Clazz;
import com.felix.pojo.Goods;
import com.felix.pojo.Order;
import com.felix.pojo.Student;

public interface StudentMapper {
	/**
	 * 总结：1  在一对一中
	 * 	   2 在一对多中需要注意的是：一对多:有个外键显得简单很多，所以所谓的colcumn即外键很容易的传入到association中
	 						多对一：需要用两者的关联关系，通过一个查到另一个，其实是在collection的(colcumn是要传入的变量)，而返回的就是对应的多的列表(javaType=ArrayList)
	 						*collection的fetchType="lazy"(都这样设置)且在mybatis-config.xml的全局变量设置
	 *							<!-- 配置是否开启懒加载 -->
								<setting name="lazyLoadingEnabled" value="true" />
								<!-- 属性按需加载 -->
								<setting name="aggressiveLazyLoading" value="flase"/>
			3 多对多中，其实就是两个多对一，也是在collection的select中互换id
	 *
	 */						
	
	/**
	 * 一对一测试
	 * @param id
	 * @return
	 */
	public Student getStudentById(long id);
	public void insertIntoStudent(Map<String,Object> map);
	/**
	 * 一对多测试
	 * @param id
	 * @return
	 */
	//根据class的id来查询相应的student
	public List<Student> getStudentByClazzId(long id);
	//查询id
	public Clazz getClazzById(long id);
	
	/**
	 * 多对多测试
	 * @param id
	 * @return
	 */
	//根据goods的id查询order
	public List<Order> getOrderListByGoogsId(int id);
	//根据order的id查询goods
	public List<Goods> getGoodsListByOrderId(int id);
}

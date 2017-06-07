package org.spring.hibernate.persist;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.spring.hibernate.persist.singleton.DaoHelper;

/**
 * 描述：测试持久化DAO助手类
 * 
 * @author Aaric
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext-Test.xml", "classpath:applicationContextDataSource-Test.xml"})
public class DaoHelperTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	/**
	 * 持久化DAO助手类对象
	 */
	@Autowired
	@Qualifier("daoHelper")
	protected DaoHelper daoHelper1;
	@Autowired
	@Qualifier("daoHelper")
	protected DaoHelper daoHelper2;
	
	/**
	 * 测试DaoHelper单例模式
	 */
	@Test
	public void testSingletonDaoHelper() {
		/*测试是否为单例*/
		Assert.assertEquals(daoHelper1, daoHelper2);
		
	}

}

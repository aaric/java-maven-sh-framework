package org.spring.hibernate.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.spring.hibernate.service.singleton.ServiceHelper;

/**
 * 描述：测试业务操作Service助手类
 * 
 * @author Aaric
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext-Test.xml", "classpath:applicationContextDataSource-Test.xml"})
public class ServiceHelperTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	/**
	 * 业务操作Service助手对象
	 */
	@Autowired
	@Qualifier("serviceHelper")
	protected ServiceHelper serviceHelper1;
	@Autowired
	@Qualifier("serviceHelper")
	protected ServiceHelper serviceHelper2;
	
	/**
	 * 测试ServiceHelper单例模式
	 */
	@Test
	public void testSingletonServiceHelper() {
		/*测试是否为单例*/
		Assert.assertEquals(serviceHelper1, serviceHelper2);
		
	}

}

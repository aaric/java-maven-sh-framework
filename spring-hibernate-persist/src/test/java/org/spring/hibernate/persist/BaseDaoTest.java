package org.spring.hibernate.persist;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.spring.hibernate.entity.bpo.FileInfo;
import org.spring.hibernate.persist.BaseDao;

/**
 * 描述：测试持久化基础DAO操作实现类
 * 
 * @author Aaric
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext-Test.xml", "classpath:applicationContextDataSource-Test.xml"})
public class BaseDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

	/**
	 * 测试持久化基础DAO操作对象
	 */
	@Autowired
	protected BaseDao baseDao;
	
	/**
	 * 测试Spring注入BaseDao对象
	 */
	@Test
	public void testSpringInjectBaseDao() {
		/*测试Spring注入是否成功*/
		Assert.assertNotNull(baseDao);
	}
	
	/**
	 * 测试save方法
	 */
	@Test
	public void testSave() {
		/*构建虚拟文件信息对象*/
		FileInfo fileInfo = new FileInfo();
		fileInfo.setFileName("test.png");
		fileInfo.setFileOppPath("path/test.png");
		fileInfo.setFileSize(425L);
		fileInfo.setFileType("images/png");
		fileInfo.setRemarks("this is a test file.");
		fileInfo.setInsertTime(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		
		/*保持到数据库*/
		Serializable id = baseDao.save(fileInfo);
		Assert.assertNotNull(id);
		
	}

}

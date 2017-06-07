package org.spring.hibernate.persist;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.spring.hibernate.entity.bpo.FileInfo;
import org.spring.hibernate.persist.singleton.DaoHelper;

/**
 * 描述：测试文件信息持久化DAO操作类
 * 
 * @author Aaric
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext-Test.xml", "classpath:applicationContextDataSource-Test.xml"})
public class FileInfoDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	/**
	 * 持久化DAO助手类对象
	 */
	@Autowired
	@Qualifier("daoHelper")
	protected DaoHelper daoHelper;
	
	/**
	 * 测试保存文件信息操作
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
		Serializable id = daoHelper.getFileInfoDao().save(fileInfo);
		Assert.assertNotNull(id);
		
	}

}

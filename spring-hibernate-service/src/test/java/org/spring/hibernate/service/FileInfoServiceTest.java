package org.spring.hibernate.service;

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
import org.spring.hibernate.service.singleton.ServiceHelper;

/**
 * 描述：测试文件信息Service操作类
 * 
 * @author Aaric
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext-Test.xml", "classpath:applicationContextDataSource-Test.xml"})
public class FileInfoServiceTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	/**
	 * 业务操作Service助手对象
	 */
	@Autowired
	protected ServiceHelper serviceHelper;
	
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
		Serializable id = serviceHelper.getFileInfoService().save(fileInfo);
		Assert.assertNotNull(id);
		
	}

}

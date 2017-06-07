package org.spring.hibernate.service.singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import org.spring.hibernate.service.FileInfoService;

/**
 * 描述：业务操作Service助手类(单利模式)
 * 
 * @author Aaric
 *
 */
@Lazy(false)
@Scope("singleton")
@Service("serviceHelper")
public final class ServiceHelper {
	
	/**
	 * 文件信息Service操作对象
	 */
	@Autowired
	private FileInfoService fileInfoService;

	/**
	 * 获得文件信息Service操作对象
	 * 
	 * @return
	 */
	public FileInfoService getFileInfoService() {
		return fileInfoService;
	}

}

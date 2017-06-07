package org.spring.hibernate.service;

import java.io.Serializable;

import org.spring.hibernate.entity.bpo.FileInfo;

/**
 * 描述：文件信息Service操作接口
 * 
 * @author Aaric
 *
 */
public interface FileInfoService {
	
	/**
	 * 保存文件信息
	 * 
	 * @param fileInfo 文件信息对象
	 */
	public Serializable save(FileInfo fileInfo);

}

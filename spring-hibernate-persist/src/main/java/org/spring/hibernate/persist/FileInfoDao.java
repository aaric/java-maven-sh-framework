package org.spring.hibernate.persist;

import java.io.Serializable;

import org.spring.hibernate.entity.bpo.FileInfo;

/**
 * 描述：文件信息持久化DAO操作接口
 * 
 * @author Aaric
 *
 */
public interface FileInfoDao {
	
	/**
	 * 保持文件信息对象
	 * 
	 * @param fileInfo 文件信息对象
	 * @return
	 */
	public Serializable save(FileInfo fileInfo);

}

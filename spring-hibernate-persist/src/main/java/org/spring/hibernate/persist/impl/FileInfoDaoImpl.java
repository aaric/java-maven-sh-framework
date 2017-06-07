package org.spring.hibernate.persist.impl;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import org.spring.hibernate.entity.bpo.FileInfo;
import org.spring.hibernate.persist.FileInfoDao;
import org.spring.hibernate.persist.abs.AbstractDaoObject;

/**
 * 描述：文件信息持久化DAO操作实现类
 * 
 * @author Aaric
 *
 */
@Scope("singleton")
@Repository("fileInfoDao")
public class FileInfoDaoImpl extends AbstractDaoObject implements FileInfoDao {

	@Override
	public Serializable save(FileInfo fileInfo) {
		return super.getBaseDao().save(fileInfo);
	}

}

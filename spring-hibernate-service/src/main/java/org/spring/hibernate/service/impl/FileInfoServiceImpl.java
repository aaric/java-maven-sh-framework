package org.spring.hibernate.service.impl;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import org.spring.hibernate.entity.bpo.FileInfo;
import org.spring.hibernate.service.FileInfoService;
import org.spring.hibernate.service.abs.AbstractServiceObject;

/**
 * 描述：文件信息Service操作实现类
 * 
 * @author Aaric
 *
 */
@Scope("singleton")
@Service("fileInfoService")
public class FileInfoServiceImpl extends AbstractServiceObject implements FileInfoService {

	@Override
	public Serializable save(FileInfo fileInfo) {
		return super.getDaoHelper().getFileInfoDao().save(fileInfo);
	}

}

package org.spring.hibernate.entity.bpo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.spring.hibernate.entity.BaseEntity;

/**
 * 描述：文件信息对象
 * 
 * @author Aaric
 *
 */
@Entity
@Table(name="bpo_fileinfo")
public class FileInfo extends BaseEntity {

	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = -2436671528425537540L;
	
	/**
	 * 文件ID
	 */
	private Long id;
	/**
	 * 文件名称
	 */
	private String fileName;
	/**
	 * 文件相对路径
	 */
	private String fileOppPath;
	/**
	 * 文件类型
	 */
	private String fileType;
	/**
	 * 文件大小
	 */
	private Long fileSize;
	/**
	 * 备注
	 */
	private String remarks;
	/**
	 * 上传文件时间
	 */
	private Timestamp insertTime;
	
	/**
	 * 默认构造函数
	 */
	public FileInfo() {
		super();
	}
	
	/**
	 * 完整构造函数
	 * 
	 * @param id 文件ID
	 * @param fileName 文件名称
	 * @param fileOppPath 文件相对路径
	 * @param fileType 文件类型
	 * @param fileSize 文件大小
	 * @param remarks 备注
	 * @param insertTime 上传文件时间
	 */
	public FileInfo(Long id, String fileName, String fileOppPath,
			String fileType, Long fileSize, String remarks, Timestamp insertTime) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileOppPath = fileOppPath;
		this.fileType = fileType;
		this.fileSize = fileSize;
		this.remarks = remarks;
		this.insertTime = insertTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
	@Column(name="id", unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	@Column(name="fileName", nullable=false, length=128)
	public String getFileName() {
		return fileName;
	}

	@Column(name="fileOppPath", nullable=false, length=255)
	public String getFileOppPath() {
		return fileOppPath;
	}

	@Column(name="fileType", nullable=false, length=100)
	public String getFileType() {
		return fileType;
	}

	@Column(name="fileSize", nullable=false)
	public Long getFileSize() {
		return fileSize;
	}

	@Column(name="remarks")
	public String getRemarks() {
		return remarks;
	}

	@Column(name="insertTime")
	public Timestamp getInsertTime() {
		return insertTime;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setFileOppPath(String fileOppPath) {
		this.fileOppPath = fileOppPath;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public void setInsertTime(Timestamp insertTime) {
		this.insertTime = insertTime;
	}

}

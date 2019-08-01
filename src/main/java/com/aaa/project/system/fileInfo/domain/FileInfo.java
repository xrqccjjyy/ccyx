package com.aaa.project.system.fileInfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;

/**
 * 文件表 sys_file_info
 * 
 * @author CCYX-SZ34-02
 * @date 2019-07-31
 */
public class FileInfo extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 文件id */
	private Integer fileId;
	/** 文件名称 */
	private String fileName;
	/** 文件路径 */
	private String filePath;

	public void setFileId(Integer fileId) 
	{
		this.fileId = fileId;
	}

	public Integer getFileId() 
	{
		return fileId;
	}
	public void setFileName(String fileName) 
	{
		this.fileName = fileName;
	}

	public String getFileName() 
	{
		return fileName;
	}
	public void setFilePath(String filePath) 
	{
		this.filePath = filePath;
	}

	public String getFilePath() 
	{
		return filePath;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("fileId", getFileId())
            .append("fileName", getFileName())
            .append("filePath", getFilePath())
            .toString();
    }
}

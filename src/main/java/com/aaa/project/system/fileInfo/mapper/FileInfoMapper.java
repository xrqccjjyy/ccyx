package com.aaa.project.system.fileInfo.mapper;

import com.aaa.project.system.fileInfo.domain.FileInfo;
import java.util.List;	

/**
 * 文件 数据层
 * 
 * @author CCYX-SZ34-02
 * @date 2019-07-31
 */
public interface FileInfoMapper 
{
	/**
     * 查询文件信息
     * 
     * @param fileId 文件ID
     * @return 文件信息
     */
	public FileInfo selectFileInfoById(Integer fileId);
	
	/**
     * 查询文件列表
     * 
     * @param fileInfo 文件信息
     * @return 文件集合
     */
	public List<FileInfo> selectFileInfoList(FileInfo fileInfo);
	
	/**
     * 新增文件
     * 
     * @param fileInfo 文件信息
     * @return 结果
     */
	public int insertFileInfo(FileInfo fileInfo);
	
	/**
     * 修改文件
     * 
     * @param fileInfo 文件信息
     * @return 结果
     */
	public int updateFileInfo(FileInfo fileInfo);
	
	/**
     * 删除文件
     * 
     * @param fileId 文件ID
     * @return 结果
     */
	public int deleteFileInfoById(Integer fileId);
	
	/**
     * 批量删除文件
     * 
     * @param fileIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteFileInfoByIds(String[] fileIds);
	
}
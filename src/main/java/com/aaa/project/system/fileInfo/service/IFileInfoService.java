package com.aaa.project.system.fileInfo.service;

import com.aaa.project.system.fileInfo.domain.FileInfo;
import java.util.List;

/**
 * 文件 服务层
 * 
 * @author CCYX-SZ34-02
 * @date 2019-07-31
 */
public interface IFileInfoService 
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
     * 删除文件信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteFileInfoByIds(String ids);
	
}

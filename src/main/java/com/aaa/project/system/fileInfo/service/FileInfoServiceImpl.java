package com.aaa.project.system.fileInfo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.fileInfo.mapper.FileInfoMapper;
import com.aaa.project.system.fileInfo.domain.FileInfo;
import com.aaa.project.system.fileInfo.service.IFileInfoService;
import com.aaa.common.support.Convert;

/**
 * 文件 服务层实现
 * 
 * @author CCYX-SZ34-02
 * @date 2019-07-31
 */
@Service
public class FileInfoServiceImpl implements IFileInfoService 
{
	@Autowired
	private FileInfoMapper fileInfoMapper;

	/**
     * 查询文件信息
     * 
     * @param fileId 文件ID
     * @return 文件信息
     */
    @Override
	public FileInfo selectFileInfoById(Integer fileId)
	{
	    return fileInfoMapper.selectFileInfoById(fileId);
	}
	
	/**
     * 查询文件列表
     * 
     * @param fileInfo 文件信息
     * @return 文件集合
     */
	@Override
	public List<FileInfo> selectFileInfoList(FileInfo fileInfo)
	{
	    return fileInfoMapper.selectFileInfoList(fileInfo);
	}
	
    /**
     * 新增文件
     * 
     * @param fileInfo 文件信息
     * @return 结果
     */
	@Override
	public int insertFileInfo(FileInfo fileInfo)
	{
	    return fileInfoMapper.insertFileInfo(fileInfo);
	}
	
	/**
     * 修改文件
     * 
     * @param fileInfo 文件信息
     * @return 结果
     */
	@Override
	public int updateFileInfo(FileInfo fileInfo)
	{
	    return fileInfoMapper.updateFileInfo(fileInfo);
	}

	/**
     * 删除文件对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteFileInfoByIds(String ids)
	{
		return fileInfoMapper.deleteFileInfoByIds(Convert.toStrArray(ids));
	}
	
}

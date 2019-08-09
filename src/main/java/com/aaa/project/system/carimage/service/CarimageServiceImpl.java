package com.aaa.project.system.carimage.service;

import com.aaa.common.exception.file.FileNameLengthLimitExceededException;
import com.aaa.common.support.Convert;
import com.aaa.framework.config.FileUploadConfig;
import com.aaa.project.system.carimage.domain.Carimage;
import com.aaa.project.system.carimage.mapper.CarimageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.tomcat.util.http.fileupload.FileUploadBase;
import java.io.IOException;
import java.util.List;

import static com.aaa.common.utils.file.FileUploadUtils.upload;

/**
 * 车辆图片 服务层实现
 * 
 * @author CCYX-SZ34-02
 * @date 2019-08-06
 */
@Service
public class CarimageServiceImpl implements ICarimageService
{
	@Autowired
	private CarimageMapper carimageMapper;
	@Autowired
	private FileUploadConfig config;

	/**
     * 查询车辆图片信息
     * 
     * @param id 车辆图片ID
     * @return 车辆图片信息
     */
    @Override
	public Carimage selectCarimageById(Integer id)
	{
	    return carimageMapper.selectCarimageById(id);
	}
	
	/**
     * 查询车辆图片列表
     * 
     * @param carimage 车辆图片信息
     * @return 车辆图片集合
     */
	@Override
	public List<Carimage> selectCarimageList(Carimage carimage)
	{
	    return carimageMapper.selectCarimageList(carimage);
	}

    /**
     * 新增车辆图片
     * 
     * @param carimage 车辆图片信息
     * @return 结果
     */
	@Override
	public int insertCarimage(Carimage carimage) {
		return  carimageMapper.insertCarimage( carimage );

	}
	
	/**
     * 修改车辆图片
     * 
     * @param carimage 车辆图片信息
     * @return 结果
     */
	@Override
	public int updateCarimage(Carimage carimage)
	{
	    return carimageMapper.updateCarimage(carimage);
	}

	/**
     * 删除车辆图片对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCarimageByIds(String ids)
	{
		return carimageMapper.deleteCarimageByIds(Convert.toStrArray(ids));
	}
	
}

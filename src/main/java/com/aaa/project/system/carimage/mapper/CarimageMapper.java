package com.aaa.project.system.carimage.mapper;

import com.aaa.project.system.carimage.domain.Carimage;
import java.util.List;	

/**
 * 车辆图片 数据层
 * 
 * @author CCYX-SZ34-02
 * @date 2019-08-08
 */
public interface CarimageMapper 
{
	/**
     * 查询车辆图片信息
     * 
     * @param id 车辆图片ID
     * @return 车辆图片信息
     */
	public Carimage selectCarimageById(Integer id);
	
	/**
     * 查询车辆图片列表
     * 
     * @param carimage 车辆图片信息
     * @return 车辆图片集合
     */
	public List<Carimage> selectCarimageList(Carimage carimage);


	/**
	 * 按照carid查询结
	 * @return 汽车图片集合
	 */
	public List<Carimage> selectCarImageListByCarInfoId(int carinfoId);
	
	/**
     * 新增车辆图片
     * 
     * @param carimage 车辆图片信息
     * @return 结果
     */
	public int insertCarimage(Carimage carimage);
	
	/**
     * 修改车辆图片
     * 
     * @param carimage 车辆图片信息
     * @return 结果
     */
	public int updateCarimage(Carimage carimage);


	/**
	 * 根据carInfoId更新信息
	 * @return 结果
	 */
	public int updateCarImageByCarInfoId(Carimage carimage);
	
	/**
     * 删除车辆图片
     * 
     * @param id 车辆图片ID
     * @return 结果
     */
	public int deleteCarimageById(Integer id);
	
	/**
     * 批量删除车辆图片
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCarimageByIds(String[] ids);
	
}
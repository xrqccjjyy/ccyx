package com.aaa.project.system.carservice.service;

import com.aaa.project.system.carservice.domain.Carservice;
import java.util.List;
import java.util.Map;

/**
 * 车辆服务套餐 服务层
 * 
 * @author teacherChen
 * @date 2019-07-29
 */
public interface ICarserviceService 
{
	/**
	 * 查询所有汽车服务
	 * @return
	 */
	List<Map<String,Object>> selectAllCarService();

	/**
     * 查询车辆服务套餐信息
     * 
     * @param carserviceid 车辆服务套餐ID
     * @return 车辆服务套餐信息
     */
	public Carservice selectCarserviceById(Integer carserviceid);
	
	/**
     * 查询车辆服务套餐列表
     * 
     * @param carservice 车辆服务套餐信息
     * @return 车辆服务套餐集合
     */
	public List<Carservice> selectCarserviceList(Carservice carservice);
	
	/**
     * 新增车辆服务套餐
     * 
     * @param carservice 车辆服务套餐信息
     * @return 结果
     */
	public int insertCarservice(Carservice carservice);
	
	/**
     * 修改车辆服务套餐
     * 
     * @param carservice 车辆服务套餐信息
     * @return 结果
     */
	public int updateCarservice(Carservice carservice);
		
	/**
     * 删除车辆服务套餐信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCarserviceByIds(String ids);
	
}

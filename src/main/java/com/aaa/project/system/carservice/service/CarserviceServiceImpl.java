package com.aaa.project.system.carservice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.carservice.mapper.CarserviceMapper;
import com.aaa.project.system.carservice.domain.Carservice;
import com.aaa.project.system.carservice.service.ICarserviceService;
import com.aaa.common.support.Convert;

/**
 * 车辆服务套餐 服务层实现
 * 
 * @author teacherChen
 * @date 2019-07-29
 */
@Service
public class CarserviceServiceImpl implements ICarserviceService 
{
	@Autowired
	private CarserviceMapper carserviceMapper;

	/**
     * 查询车辆服务套餐信息
     * 
     * @param carserviceid 车辆服务套餐ID
     * @return 车辆服务套餐信息
     */
    @Override
	public Carservice selectCarserviceById(Integer carserviceid)
	{
	    return carserviceMapper.selectCarserviceById(carserviceid);
	}
	
	/**
     * 查询车辆服务套餐列表
     * 
     * @param carservice 车辆服务套餐信息
     * @return 车辆服务套餐集合
     */
	@Override
	public List<Carservice> selectCarserviceList(Carservice carservice)
	{
	    return carserviceMapper.selectCarserviceList(carservice);
	}
	
    /**
     * 新增车辆服务套餐
     * 
     * @param carservice 车辆服务套餐信息
     * @return 结果
     */
	@Override
	public int insertCarservice(Carservice carservice)
	{
	    return carserviceMapper.insertCarservice(carservice);
	}
	
	/**
     * 修改车辆服务套餐
     * 
     * @param carservice 车辆服务套餐信息
     * @return 结果
     */
	@Override
	public int updateCarservice(Carservice carservice)
	{
	    return carserviceMapper.updateCarservice(carservice);
	}

	/**
     * 删除车辆服务套餐对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCarserviceByIds(String ids)
	{
		return carserviceMapper.deleteCarserviceByIds(Convert.toStrArray(ids));
	}
	
}

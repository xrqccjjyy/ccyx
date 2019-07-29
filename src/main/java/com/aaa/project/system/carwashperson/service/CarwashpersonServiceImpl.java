package com.aaa.project.system.carwashperson.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.carwashperson.mapper.CarwashpersonMapper;
import com.aaa.project.system.carwashperson.domain.Carwashperson;
import com.aaa.project.system.carwashperson.service.ICarwashpersonService;
import com.aaa.common.support.Convert;

/**
 * 洗车人员 服务层实现
 * 
 * @author teacherChen
 * @date 2019-07-29
 */
@Service
public class CarwashpersonServiceImpl implements ICarwashpersonService 
{
	@Autowired
	private CarwashpersonMapper carwashpersonMapper;

	/**
     * 查询洗车人员信息
     * 
     * @param washpersonpid 洗车人员ID
     * @return 洗车人员信息
     */
    @Override
	public Carwashperson selectCarwashpersonById(Integer washpersonpid)
	{
	    return carwashpersonMapper.selectCarwashpersonById(washpersonpid);
	}
	
	/**
     * 查询洗车人员列表
     * 
     * @param carwashperson 洗车人员信息
     * @return 洗车人员集合
     */
	@Override
	public List<Carwashperson> selectCarwashpersonList(Carwashperson carwashperson)
	{
	    return carwashpersonMapper.selectCarwashpersonList(carwashperson);
	}
	
    /**
     * 新增洗车人员
     * 
     * @param carwashperson 洗车人员信息
     * @return 结果
     */
	@Override
	public int insertCarwashperson(Carwashperson carwashperson)
	{
	    return carwashpersonMapper.insertCarwashperson(carwashperson);
	}
	
	/**
     * 修改洗车人员
     * 
     * @param carwashperson 洗车人员信息
     * @return 结果
     */
	@Override
	public int updateCarwashperson(Carwashperson carwashperson)
	{
	    return carwashpersonMapper.updateCarwashperson(carwashperson);
	}

	/**
     * 删除洗车人员对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCarwashpersonByIds(String ids)
	{
		return carwashpersonMapper.deleteCarwashpersonByIds(Convert.toStrArray(ids));
	}
	
}

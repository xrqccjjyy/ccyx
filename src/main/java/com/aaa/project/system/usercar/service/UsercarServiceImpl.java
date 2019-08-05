package com.aaa.project.system.usercar.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.usercar.mapper.UsercarMapper;
import com.aaa.project.system.usercar.domain.Usercar;
import com.aaa.project.system.usercar.service.IUsercarService;
import com.aaa.common.support.Convert;

/**
 * 用户车辆 服务层实现
 * 
 * @author teacherChen
 * @date 2019-07-29
 */
@Service
public class UsercarServiceImpl implements IUsercarService 
{
	@Autowired
	private UsercarMapper usercarMapper;

	/**
     * 查询用户车辆信息
     * 
     * @param usercarid 用户车辆ID
     * @return 用户车辆信息
     */
    @Override
	public Usercar selectUsercarById(Integer usercarid)
	{
	    return usercarMapper.selectUsercarById(usercarid);
	}
	
	/**
     * 查询用户车辆列表
     * 
     * @param usercar 用户车辆信息
     * @return 用户车辆集合
     */
	@Override
	public List<Usercar> selectUsercarList(Usercar usercar)
	{
	    return usercarMapper.selectUsercarList(usercar);
	}
	
    /**
     * 新增用户车辆
     * 
     * @param usercar 用户车辆信息
     * @return 结果
     */
	@Override
	public int insertUsercar(Usercar usercar)
	{
	    return usercarMapper.insertUsercar(usercar);
	}
	
	/**
     * 修改用户车辆
     * 
     * @param usercar 用户车辆信息
     * @return 结果
     */
	@Override
	public int updateUsercar(Usercar usercar)
	{
	    return usercarMapper.updateUsercar(usercar);
	}

	/**
     * 删除用户车辆对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteUsercarByIds(String ids)
	{
		return usercarMapper.deleteUsercarByIds(Convert.toStrArray(ids));
	}

	@Override
	public Boolean updateUsercars(Usercar usercar) {
		return usercarMapper.updateUsercars(usercar);
	}

}

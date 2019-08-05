package com.aaa.project.system.usercar.mapper;

import com.aaa.project.system.user.domain.User;
import com.aaa.project.system.usercar.domain.Usercar;
import java.util.List;	

/**
 * 用户车辆 数据层
 * 
 * @author teacherChen
 * @date 2019-07-29
 */
public interface UsercarMapper 
{
	/**
     * 查询用户车辆信息
     * 
     * @param usercarid 用户车辆ID
     * @return 用户车辆信息
     */
	public Usercar selectUsercarById(Integer usercarid);
	
	/**
     * 查询用户车辆列表
     * 
     * @param usercar 用户车辆信息
     * @return 用户车辆集合
     */
	public List<Usercar> selectUsercarList(Usercar usercar);
	
	/**
     * 新增用户车辆
     * 
     * @param usercar 用户车辆信息
     * @return 结果
     */
	public int insertUsercar(Usercar usercar);
	
	/**
     * 修改用户车辆
     * 
     * @param usercar 用户车辆信息
     * @return 结果
     */
	public int updateUsercar(Usercar usercar);
	
	/**
     * 删除用户车辆
     * 
     * @param usercarid 用户车辆ID
     * @return 结果
     */
	public int deleteUsercarById(Integer usercarid);
	
	/**
     * 批量删除用户车辆
     * 
     * @param usercarids 需要删除的数据ID
     * @return 结果
     */
	public int deleteUsercarByIds(String[] usercarids);
	/**
	 * 修改车辆信息
	 * */
	public Boolean updateUsercars(Usercar usercar);
}
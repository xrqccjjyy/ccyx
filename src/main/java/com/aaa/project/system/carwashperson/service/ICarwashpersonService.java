package com.aaa.project.system.carwashperson.service;

import com.aaa.project.system.carwashperson.domain.Carwashperson;
import java.util.List;

/**
 * 洗车人员 服务层
 * 
 * @author teacherChen
 * @date 2019-07-29
 */
public interface ICarwashpersonService 
{

	/**
	 * 微信登录验证
	 */
	Carwashperson login(String washpersonphone);
	/**
     * 查询洗车人员信息
     * 
     * @param washpersonpid 洗车人员ID
     * @return 洗车人员信息
     */
	public Carwashperson selectCarwashpersonById(Integer washpersonpid);
	
	/**
     * 查询洗车人员列表
     * 
     * @param carwashperson 洗车人员信息
     * @return 洗车人员集合
     */
	public List<Carwashperson> selectCarwashpersonList(Carwashperson carwashperson);
	
	/**
     * 新增洗车人员
     * 
     * @param carwashperson 洗车人员信息
     * @return 结果
     */
	public int insertCarwashperson(Carwashperson carwashperson);
	
	/**
     * 修改洗车人员
     * 
     * @param carwashperson 洗车人员信息
     * @return 结果
     */
	public int updateCarwashperson(Carwashperson carwashperson);
		
	/**
     * 删除洗车人员信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCarwashpersonByIds(String ids);


	/**
	 * 查询状态为‘空闲’的洗车人员
	 * */
	public List<Carwashperson> selectCarwashpersonStatus();

	/**
	 * 更新洗车人员的状态
	 * */
	public int updateCarwashpersonStatus(Carwashperson carwashperson);
}

package com.aaa.project.system.customer.service;

import com.aaa.project.system.customer.domain.Customer;
import java.util.List;
import java.util.Map;

/**
 * 用户 服务层
 * 
 * @author teacherChen
 * @date 2019-07-29
 */
public interface ICustomerService 
{
	/**
	 * 获取顾客信息和对应的车辆(默认)
	 * @return
	 */
	List<Map<String,Object>> slectCustomerCar(String userphone);

	/**
     * 查询用户信息
     * 
     * @param userid 用户ID
     * @return 用户信息
     */
	public Customer selectCustomerById(Integer userid);
	
	/**
     * 查询用户列表
     * 
     * @param customer 用户信息
     * @return 用户集合
     */
	public List<Customer> selectCustomerList(Customer customer);
	
	/**
     * 新增用户
     * 
     * @param customer 用户信息
     * @return 结果
     */
	public int insertCustomer(Customer customer);
	
	/**
     * 修改用户
     * 
     * @param customer 用户信息
     * @return 结果
     */
	public int updateCustomer(Customer customer);
		
	/**
     * 删除用户信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCustomerByIds(String ids);
	/**
	 * 根据手机号查询用户数据
	 * */
	List<Customer> selectCustomer(String userphone);
	/**
	 * 注册手机号
	 * */
	public Boolean addCustomer(Customer customer);
	/**
	 * 修改个人信息
	 * */
	public Boolean updateCustomers(Customer customer);
	/**
	 * 查询用户个人信息
	 * */
	public Customer selectCustomerByUserid(Customer customer);
}

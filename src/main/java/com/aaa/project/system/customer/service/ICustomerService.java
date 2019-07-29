package com.aaa.project.system.customer.service;

import com.aaa.project.system.customer.domain.Customer;
import java.util.List;

/**
 * 用户 服务层
 * 
 * @author teacherChen
 * @date 2019-07-29
 */
public interface ICustomerService 
{
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
	
}

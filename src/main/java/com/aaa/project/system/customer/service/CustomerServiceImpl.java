package com.aaa.project.system.customer.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.customer.mapper.CustomerMapper;
import com.aaa.project.system.customer.domain.Customer;
import com.aaa.project.system.customer.service.ICustomerService;
import com.aaa.common.support.Convert;

/**
 * 用户 服务层实现
 * 
 * @author teacherChen
 * @date 2019-07-29
 */
@Service
public class CustomerServiceImpl implements ICustomerService 
{

	@Autowired
	private CustomerMapper customerMapper;

	/**
	 * 获取顾客信息和对应的车辆(默认)
	 * @return
	 */
	@Override
	public List<Map<String, Object>> slectCustomerCar(String userphone) {
        List<Map<String, Object>> mapList = customerMapper.slectCustomerCar(userphone);
		return mapList;
	}

	/**
     * 查询用户信息
     * 
     * @param userid 用户ID
     * @return 用户信息
     */
    @Override
	public Customer selectCustomerById(Integer userid)
	{
	    return customerMapper.selectCustomerById(userid);
	}
	
	/**
     * 查询用户列表
     * 
     * @param customer 用户信息
     * @return 用户集合
     */
	@Override
	public List<Customer> selectCustomerList(Customer customer)
	{
	    return customerMapper.selectCustomerList(customer);
	}
	
    /**
     * 新增用户
     * 
     * @param customer 用户信息
     * @return 结果
     */
	@Override
	public int insertCustomer(Customer customer)
	{
	    return customerMapper.insertCustomer(customer);
	}
	
	/**
     * 修改用户
     * 
     * @param customer 用户信息
     * @return 结果
     */
	@Override
	public int updateCustomer(Customer customer)
	{
	    return customerMapper.updateCustomer(customer);
	}

	/**
     * 删除用户对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCustomerByIds(String ids)
	{
		return customerMapper.deleteCustomerByIds(Convert.toStrArray(ids));
	}
	/**
	 * 根据手机号查询用户数据
	 * */
	@Override
	public List<Customer> selectCustomer(String userphone) {
		Customer customer=new Customer();
		customer.setUserphone(userphone);
		List<Customer> list = customerMapper.selectCustomer(userphone);
		if (list.size()>0){
			return list;
		}
		return null;
	}

	@Override
	public Boolean addCustomer(Customer customer) {
		return customerMapper.addCustomer(customer);
	}

	@Override
	public Boolean updateCustomers(Customer customer) {
		return customerMapper.updateCustomers(customer);
	}

	@Override
	public Customer selectCustomerByUserid(Customer customer) {
		return customerMapper.selectCustomerByUserid(customer);
	}

}

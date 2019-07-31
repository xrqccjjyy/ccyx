package com.aaa.project.system.orders.service;

import com.aaa.project.system.orders.domain.Orders;
import org.springframework.core.annotation.Order;

import java.util.List;

/**
 * 订单 服务层
 * 
 * @author teacherChen
 * @date 2019-07-29
 */
public interface IOrdersService 
{
	/**
     * 查询订单信息
     * 
     * @param orderid 订单ID
     * @return 订单信息
     */
	public Orders selectOrdersById(Integer orderid);
	
	/**
     * 查询订单列表
     * 
     * @param orders 订单信息
     * @return 订单集合
     */
	public List<Orders> selectOrdersList(Orders orders);
	
	/**
     * 新增订单
     * 
     * @param orders 订单信息
     * @return 结果
     */
	public int insertOrders(Orders orders);
	
	/**
     * 修改订单
     * 
     * @param orders 订单信息
     * @return 结果
     */
	public int updateOrders(Orders orders);
		
	/**
     * 删除订单信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteOrdersByIds(String ids);


	/**
	 * 更改订单状态信息‘已接单’
	 * */
	public int updateOrdersStatus(Orders orders);


	/**
	 * 更改订单状态信息为‘已拒单’
	 * */
	public int updateOrdersStatusReject(Orders orders);


	
}

package com.aaa.project.system.orders.mapper;

import com.aaa.project.system.orders.domain.Orders;
import java.util.List;	

/**
 * 订单 数据层
 * 
 * @author teacherChen
 * @date 2019-07-29
 */
public interface OrdersMapper 
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
     * 删除订单
     * 
     * @param orderid 订单ID
     * @return 结果
     */
	public int deleteOrdersById(Integer orderid);
	
	/**
     * 批量删除订单
     * 
     * @param orderids 需要删除的数据ID
     * @return 结果
     */
	public int deleteOrdersByIds(String[] orderids);

	/**
	 * 更改订单状态信息‘已接单’
	 * */
	public int updateOrdersStatus(Integer orderid);

	/**
	 *
	 *更改订单状态信息‘进行中’
	 */
	public int updateOrdersGoing(Integer orderid);
	/**
	 * 更改订单状态信息为‘已拒单’
	 * */
	public int updateOrdersStatusReject(Integer orderid);

    /**
	 * 更该订单状态信息为‘已完成’
	 * */
    public int updateOrdersStatusComfirm(Integer orderid);
	
}
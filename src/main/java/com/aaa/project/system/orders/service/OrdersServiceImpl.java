package com.aaa.project.system.orders.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.orders.mapper.OrdersMapper;
import com.aaa.project.system.orders.domain.Orders;
import com.aaa.project.system.orders.service.IOrdersService;
import com.aaa.common.support.Convert;

/**
 * 订单 服务层实现
 * 
 * @author teacherChen
 * @date 2019-07-29
 */
@Service
public class OrdersServiceImpl implements IOrdersService 
{
	@Autowired
	private OrdersMapper ordersMapper;

	/**
     * 查询订单信息
     * 
     * @param orderid 订单ID
     * @return 订单信息
     */
    @Override
	public Orders selectOrdersById(Integer orderid)
	{
	    return ordersMapper.selectOrdersById(orderid);
	}
	
	/**
     * 查询订单列表
     * 
     * @param orders 订单信息
     * @return 订单集合
     */
	@Override
	public List<Orders> selectOrdersList(Orders orders)
	{
	    return ordersMapper.selectOrdersList(orders);
	}
	
    /**
     * 新增订单
     * 
     * @param orders 订单信息
     * @return 结果
     */
	@Override
	public int insertOrders(Orders orders)
	{
	    return ordersMapper.insertOrders(orders);
	}
	
	/**
     * 修改订单
     * 
     * @param orders 订单信息
     * @return 结果
     */
	@Override
	public int updateOrders(Orders orders)
	{
	    return ordersMapper.updateOrders(orders);
	}

	/**
     * 删除订单对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteOrdersByIds(String ids)
	{
		return ordersMapper.deleteOrdersByIds(Convert.toStrArray(ids));
	}

	@Override
	public int updateOrdersStatus(Orders orders) {
		return ordersMapper.updateOrdersStatus(orders);
	}

}

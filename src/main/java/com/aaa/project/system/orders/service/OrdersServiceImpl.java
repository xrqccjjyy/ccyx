package com.aaa.project.system.orders.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import com.aaa.project.system.orders.mapper.OrdersMapper;
import com.aaa.project.system.orders.domain.Orders;
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
	 * 洗车人员归还车辆
	 * @param washpersonname
	 * @return
	 */
	@Override
	public int  updateWx(String washpersonname) {
        System.out.println(washpersonname);
		Orders orders = new Orders();
		orders.setWashpersonname(washpersonname);
        int i = ordersMapper.updateWx(washpersonname);
        System.out.println(i);
        return i;
	}

	@Override
	public List<Orders> selectWxByid(String ordernumber) {
		Orders orders = new Orders();
		orders.setOrdernumber(ordernumber);
		Orders selectWxByid = ordersMapper.selectWxByid(ordernumber);
		return (List<Orders>) selectWxByid;
	}

	/**
	 * 洗车人员订单列表
	 * @param washpersonname
	 * @return
	 */
	@Override
	public List<Orders> findAll(String washpersonname) {
		Orders orders = new Orders();
		orders.setWashpersonname(washpersonname);
		List<Orders> list = ordersMapper.findAll(washpersonname);
		if(list!=null){
			System.out.println(list);
			return list;
		}
		return null;
	}



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
	 *很据id查询套餐
	 **/
	@Override
	public Orders selectCarServiceName(Integer orderid) {
		return ordersMapper.selectCarServiceName(orderid);
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
	 * 更改状态信息为'进行中'
	 * */
	@Override
	public int updateOrdersGoing(Integer orderid) {
		return ordersMapper.updateOrdersGoing(orderid);
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

	/**
	 * 更改状态信息为'已接单'
	 * */
	@Override
	public int updateOrdersStatus(Integer orderid) {
		return ordersMapper.updateOrdersStatus(orderid);
	}


	/**
	 * 更改状态信息为'已拒单'
	 * */
	@Override
	public int updateOrdersStatusReject(Integer orderid) {
		return ordersMapper.updateOrdersStatusReject(orderid);
	}

	/**
	 * 将订单状态更改为已完成
	 * */
	@Override
	public int updateOrdersStatusComfirm(Integer orderid) {
		return ordersMapper.updateOrdersStatusComfirm(orderid);
	}

	/**
	 * 微信端 顾客查看所有订单
	 */
	@Override
	public List<Map<String, Object>> selectAllOrderByPhone(String userphone) {
		return ordersMapper.selectAllOrderByPhone(userphone);
	}

	/**
	 * 微信端 顾客查看待接单订单
	 */
	@Override
	public List<Map<String, Object>> selectAllWaitingOrder(String userphone) {
		return ordersMapper.selectAllWaitingOrder(userphone);
	}

	/**
	 * 微信端 顾客查看所有进行中订单
	 */
	@Override
	public List<Map<String, Object>> ingOrder(String userphone) {
		return ordersMapper.ingOrder(userphone);
	}

	/**
	 * 微信端 顾客查看已完成订单
	 */
	@Override
	public List<Map<String, Object>> finishOrder(String userphone) {
		return ordersMapper.finishOrder(userphone);
	}

	/**
	 * 微信端 顾客查看已取消订单
	 */
	@Override
	public List<Map<String, Object>> cancelledOrder(String userphone) {
		return ordersMapper.cancelledOrder(userphone);
	}

	/**
	 * 微信端 顾客取消订单
	 */
	@Override
	public int updateByOrdernumber(String ordernumber) {
		return ordersMapper.updateByOrdernumber(ordernumber);
	}

	/**
	 * 根据订单编号查询
	 * @param ordernumber
	 * @return
	 */
	@Override
	public List<Map<String, Object>> selectByOrderNumber(String ordernumber) {
		return ordersMapper.selectByOrderNumber(ordernumber);
	}


}

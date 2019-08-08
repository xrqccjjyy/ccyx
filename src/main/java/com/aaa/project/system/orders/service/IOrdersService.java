package com.aaa.project.system.orders.service;

import com.aaa.project.system.orders.domain.Orders;
import org.springframework.core.annotation.Order;

import java.util.List;
import java.util.Map;

/**
 * 订单 服务层
 * 
 * @author teacherChen
 * @date 2019-07-29
 */
public interface IOrdersService 
{

	/**
	 * 洗车人员历史订单
	 */
	List<Orders> history(Orders orders);

	/**
	 * 洗车人员取到车辆
	 */
	int updateCar(String ordernumber);

	/**
	 * 洗车人员归还车辆
	 */
	public int  updateWx(String washpersonname);

	/**
	 * 微信端查看订单详情
	 */
	List<Orders> selectWxByid(String ordernumber);

	/**
	 * 微信端查看订单
	 */
	List<Orders> findAll(String washpersonname);
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
	 *很据id查询套餐
	 **/
	public Orders selectCarServiceName(Integer orderid);
	
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


	/**
	 *  微信端顾客查看所有订单
	 */
	List<Map<String,Object>> selectAllOrderByPhone(String userphone);


	//    顾客获取待接单
	List<Map<String,Object>> selectAllWaitingOrder(String userphone);

	//    顾客进行中
	List<Map<String,Object>> ingOrder(String userphone);

	//    顾客已完成
	List<Map<String,Object>> finishOrder(String userphone);

	//   顾客 已取消
	List<Map<String,Object>> cancelledOrder(String userphone);

	//    顾客根据订单编号取消订单
	int updateByOrdernumber(String ordernumber);

	//	根据订单编号查询
	List<Map<String,Object>> selectByOrderNumber(String ordernumber);


}

package com.aaa.project.system.orderhistory.service;

import com.aaa.project.system.orderhistory.domain.Orderhistory;
import java.util.List;

/**
 * 订单历史记录/月 服务层
 * 
 * @author CCYX-SZ34-02
 * @date 2019-08-01
 */
public interface IOrderhistoryService 
{
	/**
     * 查询订单历史记录/月信息
     * 
     * @param orderhistoryid 订单历史记录/月ID
     * @return 订单历史记录/月信息
     */
	public Orderhistory selectOrderhistoryById(Integer orderhistoryid);
	
	/**
     * 查询订单历史记录/月列表
     * 
     * @param orderhistory 订单历史记录/月信息
     * @return 订单历史记录/月集合
     */
	public List<Orderhistory> selectOrderhistoryList(Orderhistory orderhistory);
	
	/**
     * 新增订单历史记录/月
     * 
     * @param orderhistory 订单历史记录/月信息
     * @return 结果
     */
	public int insertOrderhistory(Orderhistory orderhistory);
	
	/**
     * 修改订单历史记录/月
     * 
     * @param orderhistory 订单历史记录/月信息
     * @return 结果
     */
	public int updateOrderhistory(Orderhistory orderhistory);
		
	/**
     * 删除订单历史记录/月信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteOrderhistoryByIds(String ids);


	/**
	 * 插入历史记录
	 * */
	public int insertOrderhistoryTable( String ordernumber,  String orderstatus);
	
}

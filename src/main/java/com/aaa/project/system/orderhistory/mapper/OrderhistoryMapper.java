package com.aaa.project.system.orderhistory.mapper;

import com.aaa.project.system.orderhistory.domain.Orderhistory;
import java.util.List;	

/**
 * 订单历史记录/月 数据层
 * 
 * @author teacherChen
 * @date 2019-07-29
 */
public interface OrderhistoryMapper 
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
     * 删除订单历史记录/月
     * 
     * @param orderhistoryid 订单历史记录/月ID
     * @return 结果
     */
	public int deleteOrderhistoryById(Integer orderhistoryid);
	
	/**
     * 批量删除订单历史记录/月
     * 
     * @param orderhistoryids 需要删除的数据ID
     * @return 结果
     */
	public int deleteOrderhistoryByIds(String[] orderhistoryids);
	
}
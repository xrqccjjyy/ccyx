package com.aaa.project.system.ordernumberserviceid.mapper;

import com.aaa.project.system.ordernumberserviceid.domain.Ordernumberserviceid;
import java.util.List;	

/**
 * 订单编号和套餐服务id 数据层
 * 
 * @author CCYX-SZ34-02
 * @date 2019-08-07
 */
public interface OrdernumberserviceidMapper 
{
	/**
     * 查询订单编号和套餐服务id信息
     * 
     * @param ordernumber 订单编号和套餐服务idID
     * @return 订单编号和套餐服务id信息
     */
	public Ordernumberserviceid selectOrdernumberserviceidById(String ordernumber);
	
	/**
     * 查询订单编号和套餐服务id列表
     * 
     * @param ordernumberserviceid 订单编号和套餐服务id信息
     * @return 订单编号和套餐服务id集合
     */
	public List<Ordernumberserviceid> selectOrdernumberserviceidList(Ordernumberserviceid ordernumberserviceid);
	
	/**
     * 新增订单编号和套餐服务id
     * 
     * @param ordernumberserviceid 订单编号和套餐服务id信息
     * @return 结果
     */
	public int insertOrdernumberserviceid(Ordernumberserviceid ordernumberserviceid);
	
	/**
     * 修改订单编号和套餐服务id
     * 
     * @param ordernumberserviceid 订单编号和套餐服务id信息
     * @return 结果
     */
	public int updateOrdernumberserviceid(Ordernumberserviceid ordernumberserviceid);
	
	/**
     * 删除订单编号和套餐服务id
     * 
     * @param ordernumber 订单编号和套餐服务idID
     * @return 结果
     */
	public int deleteOrdernumberserviceidById(String ordernumber);
	
	/**
     * 批量删除订单编号和套餐服务id
     * 
     * @param ordernumbers 需要删除的数据ID
     * @return 结果
     */
	public int deleteOrdernumberserviceidByIds(String[] ordernumbers);
	
}
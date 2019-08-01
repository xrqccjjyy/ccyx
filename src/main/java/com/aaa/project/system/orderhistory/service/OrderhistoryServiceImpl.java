package com.aaa.project.system.orderhistory.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.orderhistory.mapper.OrderhistoryMapper;
import com.aaa.project.system.orderhistory.domain.Orderhistory;
import com.aaa.project.system.orderhistory.service.IOrderhistoryService;
import com.aaa.common.support.Convert;

/**
 * 订单历史记录/月 服务层实现
 * 
 * @author CCYX-SZ34-02
 * @date 2019-08-01
 */
@Service
public class OrderhistoryServiceImpl implements IOrderhistoryService 
{
	@Autowired
	private OrderhistoryMapper orderhistoryMapper;

	/**
     * 查询订单历史记录/月信息
     * 
     * @param orderhistoryid 订单历史记录/月ID
     * @return 订单历史记录/月信息
     */
    @Override
	public Orderhistory selectOrderhistoryById(Integer orderhistoryid)
	{
	    return orderhistoryMapper.selectOrderhistoryById(orderhistoryid);
	}
	
	/**
     * 查询订单历史记录/月列表
     * 
     * @param orderhistory 订单历史记录/月信息
     * @return 订单历史记录/月集合
     */
	@Override
	public List<Orderhistory> selectOrderhistoryList(Orderhistory orderhistory)
	{
	    return orderhistoryMapper.selectOrderhistoryList(orderhistory);
	}
	
    /**
     * 新增订单历史记录/月
     * 
     * @param orderhistory 订单历史记录/月信息
     * @return 结果
     */
	@Override
	public int insertOrderhistory(Orderhistory orderhistory)
	{
	    return orderhistoryMapper.insertOrderhistory(orderhistory);
	}
	
	/**
     * 修改订单历史记录/月
     * 
     * @param orderhistory 订单历史记录/月信息
     * @return 结果
     */
	@Override
	public int updateOrderhistory(Orderhistory orderhistory)
	{
	    return orderhistoryMapper.updateOrderhistory(orderhistory);
	}

	/**
     * 删除订单历史记录/月对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteOrderhistoryByIds(String ids)
	{
		return orderhistoryMapper.deleteOrderhistoryByIds(Convert.toStrArray(ids));
	}

	@Override
	public int insertOrderhistoryTable(String ordernumber, String orderstatus) {
		return orderhistoryMapper.insertOrderhistoryTable(ordernumber, orderstatus);
	}

}

package com.aaa.project.system.ordernumberserviceid.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.ordernumberserviceid.mapper.OrdernumberserviceidMapper;
import com.aaa.project.system.ordernumberserviceid.domain.Ordernumberserviceid;
import com.aaa.project.system.ordernumberserviceid.service.IOrdernumberserviceidService;
import com.aaa.common.support.Convert;

/**
 * 订单编号和套餐服务id 服务层实现
 * 
 * @author CCYX-SZ34-02
 * @date 2019-08-07
 */
@Service
public class OrdernumberserviceidServiceImpl implements IOrdernumberserviceidService 
{
	@Autowired
	private OrdernumberserviceidMapper ordernumberserviceidMapper;

	/**
     * 查询订单编号和套餐服务id信息
     * 
     * @param ordernumber 订单编号和套餐服务idID
     * @return 订单编号和套餐服务id信息
     */
    @Override
	public Ordernumberserviceid selectOrdernumberserviceidById(String ordernumber)
	{
	    return ordernumberserviceidMapper.selectOrdernumberserviceidById(ordernumber);
	}
	
	/**
     * 查询订单编号和套餐服务id列表
     * 
     * @param ordernumberserviceid 订单编号和套餐服务id信息
     * @return 订单编号和套餐服务id集合
     */
	@Override
	public List<Ordernumberserviceid> selectOrdernumberserviceidList(Ordernumberserviceid ordernumberserviceid)
	{
	    return ordernumberserviceidMapper.selectOrdernumberserviceidList(ordernumberserviceid);
	}
	
    /**
     * 新增订单编号和套餐服务id
     * 
     * @param ordernumberserviceid 订单编号和套餐服务id信息
     * @return 结果
     */
	@Override
	public int insertOrdernumberserviceid(Ordernumberserviceid ordernumberserviceid)
	{
	    return ordernumberserviceidMapper.insertOrdernumberserviceid(ordernumberserviceid);
	}
	
	/**
     * 修改订单编号和套餐服务id
     * 
     * @param ordernumberserviceid 订单编号和套餐服务id信息
     * @return 结果
     */
	@Override
	public int updateOrdernumberserviceid(Ordernumberserviceid ordernumberserviceid)
	{
	    return ordernumberserviceidMapper.updateOrdernumberserviceid(ordernumberserviceid);
	}

	/**
     * 删除订单编号和套餐服务id对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteOrdernumberserviceidByIds(String ids)
	{
		return ordernumberserviceidMapper.deleteOrdernumberserviceidByIds(Convert.toStrArray(ids));
	}
	
}

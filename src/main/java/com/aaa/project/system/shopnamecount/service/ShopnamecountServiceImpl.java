package com.aaa.project.system.shopnamecount.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.shopnamecount.mapper.ShopnamecountMapper;
import com.aaa.project.system.shopnamecount.domain.Shopnamecount;
import com.aaa.project.system.shopnamecount.service.IShopnamecountService;
import com.aaa.common.support.Convert;

/**
 * 商店订单数统计 服务层实现
 * 
 * @author CCYX-SZ34-02
 * @date 2019-08-07
 */
@Service
public class ShopnamecountServiceImpl implements IShopnamecountService 
{
	@Autowired
	private ShopnamecountMapper shopnamecountMapper;

	@Override
	public List<Map<String, Object>> selectOrdersCount() {
		return shopnamecountMapper.selectOrdersCount();
	}

	/**
     * 查询商店订单数统计信息
     * 
     * @param shopname 商店订单数统计ID
     * @return 商店订单数统计信息
     */
    @Override
	public Shopnamecount selectShopnamecountById(String shopname)
	{
	    return shopnamecountMapper.selectShopnamecountById(shopname);
	}
	
	/**
     * 查询商店订单数统计列表
     * 
     * @param shopnamecount 商店订单数统计信息
     * @return 商店订单数统计集合
     */
	@Override
	public List<Shopnamecount> selectShopnamecountList(Shopnamecount shopnamecount)
	{
	    return shopnamecountMapper.selectShopnamecountList(shopnamecount);
	}
	
    /**
     * 新增商店订单数统计
     * 
     * @param shopnamecount 商店订单数统计信息
     * @return 结果
     */
	@Override
	public int insertShopnamecount(Shopnamecount shopnamecount)
	{
	    return shopnamecountMapper.insertShopnamecount(shopnamecount);
	}
	
	/**
     * 修改商店订单数统计
     * 
     * @param shopnamecount 商店订单数统计信息
     * @return 结果
     */
	@Override
	public int updateShopnamecount(Shopnamecount shopnamecount)
	{
	    return shopnamecountMapper.updateShopnamecount(shopnamecount);
	}

	/**
     * 删除商店订单数统计对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteShopnamecountByIds(String ids)
	{
		return shopnamecountMapper.deleteShopnamecountByIds(Convert.toStrArray(ids));
	}
	
}

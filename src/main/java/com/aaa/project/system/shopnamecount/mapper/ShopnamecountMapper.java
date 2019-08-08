package com.aaa.project.system.shopnamecount.mapper;

import com.aaa.project.system.shopnamecount.domain.Shopnamecount;
import java.util.List;
import java.util.Map;

/**
 * 商店订单数统计 数据层
 * 
 * @author CCYX-SZ34-02
 * @date 2019-08-07
 */
public interface ShopnamecountMapper 
{
	//各商家订单总数
	List<Map<String,Object>> selectOrdersCount();

	/**
     * 查询商店订单数统计信息
     * 
     * @param shopname 商店订单数统计ID
     * @return 商店订单数统计信息
     */
	public Shopnamecount selectShopnamecountById(String shopname);
	
	/**
     * 查询商店订单数统计列表
     * 
     * @param shopnamecount 商店订单数统计信息
     * @return 商店订单数统计集合
     */
	public List<Shopnamecount> selectShopnamecountList(Shopnamecount shopnamecount);
	
	/**
     * 新增商店订单数统计
     * 
     * @param shopnamecount 商店订单数统计信息
     * @return 结果
     */
	public int insertShopnamecount(Shopnamecount shopnamecount);
	
	/**
     * 修改商店订单数统计
     * 
     * @param shopnamecount 商店订单数统计信息
     * @return 结果
     */
	public int updateShopnamecount(Shopnamecount shopnamecount);
	
	/**
     * 删除商店订单数统计
     * 
     * @param shopname 商店订单数统计ID
     * @return 结果
     */
	public int deleteShopnamecountById(String shopname);
	
	/**
     * 批量删除商店订单数统计
     * 
     * @param shopnames 需要删除的数据ID
     * @return 结果
     */
	public int deleteShopnamecountByIds(String[] shopnames);
	
}
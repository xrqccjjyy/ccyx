package com.aaa.project.system.shop.mapper;

import com.aaa.project.system.shop.domain.Shop;
import java.util.List;	

/**
 * 商家 数据层
 * 
 * @author CCYX-SZ34-02
 * @date 2019-08-03
 */
public interface ShopMapper 
{
	/**
     * 查询商家信息
     * 
     * @param shopid 商家ID
     * @return 商家信息
     */
	public Shop selectShopById(Integer shopid);
	
	/**
     * 查询商家列表
     * 
     * @param shop 商家信息
     * @return 商家集合
     */
	public List<Shop> selectShopList(Shop shop);
	
	/**
     * 新增商家
     * 
     * @param shop 商家信息
     * @return 结果
     */
	public int insertShop(Shop shop);
	
	/**
     * 修改商家
     * 
     * @param shop 商家信息
     * @return 结果
     */
	public int updateShop(Shop shop);
	
	/**
     * 删除商家
     * 
     * @param shopid 商家ID
     * @return 结果
     */
	public int deleteShopById(Integer shopid);
	
	/**
     * 批量删除商家
     * 
     * @param shopids 需要删除的数据ID
     * @return 结果
     */
	public int deleteShopByIds(String[] shopids);
	
}
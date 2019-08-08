package com.aaa.project.system.shopnamecountprice.service;

import com.aaa.project.system.shopnamecountprice.domain.Shopnamecountprice;
import java.util.List;
import java.util.Map;

/**
 * 商家收入 服务层
 * 
 * @author CCYX-SZ34-02
 * @date 2019-08-08
 */
public interface IShopnamecountpriceService 
{
	//各商家总收入
	List<Map<String,Object>> selectOrdersCountPrice();

	/**
     * 查询商家收入信息
     * 
     * @param shopname 商家收入ID
     * @return 商家收入信息
     */
	public Shopnamecountprice selectShopnamecountpriceById(String shopname);
	
	/**
     * 查询商家收入列表
     * 
     * @param shopnamecountprice 商家收入信息
     * @return 商家收入集合
     */
	public List<Shopnamecountprice> selectShopnamecountpriceList(Shopnamecountprice shopnamecountprice);
	
	/**
     * 新增商家收入
     * 
     * @param shopnamecountprice 商家收入信息
     * @return 结果
     */
	public int insertShopnamecountprice(Shopnamecountprice shopnamecountprice);
	
	/**
     * 修改商家收入
     * 
     * @param shopnamecountprice 商家收入信息
     * @return 结果
     */
	public int updateShopnamecountprice(Shopnamecountprice shopnamecountprice);
		
	/**
     * 删除商家收入信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteShopnamecountpriceByIds(String ids);
	
}

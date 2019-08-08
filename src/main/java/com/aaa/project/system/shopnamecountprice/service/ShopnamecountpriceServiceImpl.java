package com.aaa.project.system.shopnamecountprice.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.shopnamecountprice.mapper.ShopnamecountpriceMapper;
import com.aaa.project.system.shopnamecountprice.domain.Shopnamecountprice;
import com.aaa.project.system.shopnamecountprice.service.IShopnamecountpriceService;
import com.aaa.common.support.Convert;

/**
 * 商家收入 服务层实现
 * 
 * @author CCYX-SZ34-02
 * @date 2019-08-08
 */
@Service
public class ShopnamecountpriceServiceImpl implements IShopnamecountpriceService 
{
	@Autowired
	private ShopnamecountpriceMapper shopnamecountpriceMapper;

	/**
	 * 各商家总收入
	 * @return
	 */
	@Override
	public List<Map<String, Object>> selectOrdersCountPrice() {
		return shopnamecountpriceMapper.selectOrdersCountPrice();
	}

	/**
     * 查询商家收入信息
     * 
     * @param shopname 商家收入ID
     * @return 商家收入信息
     */
    @Override
	public Shopnamecountprice selectShopnamecountpriceById(String shopname)
	{
	    return shopnamecountpriceMapper.selectShopnamecountpriceById(shopname);
	}
	
	/**
     * 查询商家收入列表
     * 
     * @param shopnamecountprice 商家收入信息
     * @return 商家收入集合
     */
	@Override
	public List<Shopnamecountprice> selectShopnamecountpriceList(Shopnamecountprice shopnamecountprice)
	{
	    return shopnamecountpriceMapper.selectShopnamecountpriceList(shopnamecountprice);
	}
	
    /**
     * 新增商家收入
     * 
     * @param shopnamecountprice 商家收入信息
     * @return 结果
     */
	@Override
	public int insertShopnamecountprice(Shopnamecountprice shopnamecountprice)
	{
	    return shopnamecountpriceMapper.insertShopnamecountprice(shopnamecountprice);
	}
	
	/**
     * 修改商家收入
     * 
     * @param shopnamecountprice 商家收入信息
     * @return 结果
     */
	@Override
	public int updateShopnamecountprice(Shopnamecountprice shopnamecountprice)
	{
	    return shopnamecountpriceMapper.updateShopnamecountprice(shopnamecountprice);
	}

	/**
     * 删除商家收入对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteShopnamecountpriceByIds(String ids)
	{
		return shopnamecountpriceMapper.deleteShopnamecountpriceByIds(Convert.toStrArray(ids));
	}
	
}

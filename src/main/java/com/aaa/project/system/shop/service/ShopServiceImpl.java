package com.aaa.project.system.shop.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.shop.mapper.ShopMapper;
import com.aaa.project.system.shop.domain.Shop;
import com.aaa.project.system.shop.service.IShopService;
import com.aaa.common.support.Convert;

/**
 * 商家 服务层实现
 * 
 * @author CCYX-SZ34-02
 * @date 2019-08-03
 */
@Service
public class ShopServiceImpl implements IShopService 
{
	@Autowired
	private ShopMapper shopMapper;

    @Override
    public List<Map<String, Object>> selectAllShop() {
        return shopMapper.selectAllShop();
    }

    @Override
    public List<Map<String, Object>> selectSearch(String shopname) {
        return shopMapper.selectSearch(shopname);
    }

    /**
     * 查询商家信息
     * 
     * @param shopid 商家ID
     * @return 商家信息
     */
    @Override
	public Shop selectShopById(Integer shopid)
	{
	    return shopMapper.selectShopById(shopid);
	}
	
	/**
     * 查询商家列表
     * 
     * @param shop 商家信息
     * @return 商家集合
     */
	@Override
	public List<Shop> selectShopList(Shop shop)
	{
	    return shopMapper.selectShopList(shop);
	}
	
    /**
     * 新增商家
     * 
     * @param shop 商家信息
     * @return 结果
     */
	@Override
	public int insertShop(Shop shop)
	{
	    return shopMapper.insertShop(shop);
	}
	
	/**
     * 修改商家
     * 
     * @param shop 商家信息
     * @return 结果
     */
	@Override
	public int updateShop(Shop shop)
	{
	    return shopMapper.updateShop(shop);
	}

	/**
     * 删除商家对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteShopByIds(String ids)
	{
		return shopMapper.deleteShopByIds(Convert.toStrArray(ids));
	}
	
}

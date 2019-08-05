package com.aaa.project.system.shop.service;

import java.io.IOException;
import java.util.List;

import com.aaa.common.exception.file.FileNameLengthLimitExceededException;
import com.aaa.common.utils.file.FileUploadUtils;
import com.aaa.framework.config.FileUploadConfig;
import org.apache.tomcat.util.http.fileupload.FileUploadBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.shop.mapper.ShopMapper;
import com.aaa.project.system.shop.domain.Shop;
import com.aaa.project.system.shop.service.IShopService;
import com.aaa.common.support.Convert;
import org.springframework.web.multipart.MultipartFile;

import static com.aaa.common.utils.file.FileUploadUtils.upload;


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

	@Autowired
	private FileUploadConfig config;

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
	public int insertShop(Shop shop) {

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

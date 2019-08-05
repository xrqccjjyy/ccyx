package com.aaa.project.system.shop.service;

import com.aaa.common.exception.file.FileNameLengthLimitExceededException;
import com.aaa.project.system.shop.domain.Shop;
import org.apache.tomcat.util.http.fileupload.FileUploadBase;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * 商家 服务层
 * 
 * @author CCYX-SZ34-02
 * @date 2019-08-03
 */
public interface IShopService 
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
	public int insertShop(Shop shop) ;
	
	/**
     * 修改商家
     * 
     * @param shop 商家信息
     * @return 结果
     */
	public int updateShop(Shop shop);
		
	/**
     * 删除商家信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteShopByIds(String ids);
	
}

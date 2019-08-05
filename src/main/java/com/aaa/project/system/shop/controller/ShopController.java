package com.aaa.project.system.shop.controller;

import java.io.IOException;
import java.util.List;

import com.aaa.common.exception.file.FileNameLengthLimitExceededException;
import com.aaa.common.utils.file.FileUploadUtils;
import com.aaa.framework.config.DouDouConfig;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.tomcat.util.http.fileupload.FileUploadBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.aaa.framework.aspectj.lang.annotation.Log;
import com.aaa.framework.aspectj.lang.enums.BusinessType;
import com.aaa.project.system.shop.domain.Shop;
import com.aaa.project.system.shop.service.IShopService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 商家 信息操作处理
 * 
 * @author CCYX-SZ34-02
 * @date 2019-08-03
 */
@Controller
@RequestMapping("/system/shop")
public class ShopController extends BaseController
{
    private String prefix = "system/shop";
	
	@Autowired
	private IShopService shopService;
	
	@RequiresPermissions("system:shop:view")
	@GetMapping()
	public String shop()
	{
	    return prefix + "/shop";
	}
	
	/**
	 * 查询商家列表
	 */
	@RequiresPermissions("system:shop:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Shop shop)
	{
		startPage();
        List<Shop> list = shopService.selectShopList(shop);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出商家列表
	 */
	@RequiresPermissions("system:shop:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Shop shop)
    {
    	List<Shop> list = shopService.selectShopList(shop);
        ExcelUtil<Shop> util = new ExcelUtil<Shop>(Shop.class);
        return util.exportExcel(list, "shop");
    }
	
	/**
	 * 新增商家
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存商家
	 */
	@RequiresPermissions("system:shop:add")
	@Log(title = "商家", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Shop shop,
							  @RequestParam(name = "shopname") String shopname,
							  @RequestParam(name = "file") MultipartFile file,
							  @RequestParam(name = "shopaddress") String shopaddress,
							  @RequestParam(name = "longLot") String longLot
	) throws IOException {
		shop.setShopname(shopname);
		shop.setShopaddress(shopaddress);
		shop.setLongLot(longLot);
		String filePath = DouDouConfig.getProfile();
		String fileName = FileUploadUtils.upload(filePath,file);
		shop.setShoplicense(fileName);
		return toAjax(shopService.insertShop(shop));
	}

	/**
	 * 修改商家
	 */
	@GetMapping("/edit/{shopid}")
	public String edit(@PathVariable("shopid") Integer shopid, ModelMap mmap)
	{
		Shop shop = shopService.selectShopById(shopid);
		mmap.put("shop", shop);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存商家
	 */
	@RequiresPermissions("system:shop:edit")
	@Log(title = "商家", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Shop shop,
							   @RequestParam(name = "shopid") Integer shopid,
							   @RequestParam(name = "shopname") String shopname,
							   @RequestParam(name = "file") MultipartFile file,
							   @RequestParam(name = "shopaddress") String shopaddress,
							   @RequestParam(name = "longLot") String longLot
							   ) throws IOException {
		shop.setShopid(shopid);
		shop.setShopname(shopname);
		shop.setShopaddress(shopaddress);
		shop.setLongLot(longLot);
		String filePath = DouDouConfig.getProfile();
		String fileName = FileUploadUtils.upload(filePath,file);
		shop.setShoplicense(fileName);
		return toAjax(shopService.updateShop(shop));
	}
	
	/**
	 * 删除商家
	 */
	@RequiresPermissions("system:shop:remove")
	@Log(title = "商家", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(shopService.deleteShopByIds(ids));
	}
	
}

package com.aaa.project.system.shopnamecountprice.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.aaa.framework.aspectj.lang.annotation.Log;
import com.aaa.framework.aspectj.lang.enums.BusinessType;
import com.aaa.project.system.shopnamecountprice.domain.Shopnamecountprice;
import com.aaa.project.system.shopnamecountprice.service.IShopnamecountpriceService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;

/**
 * 商家收入 信息操作处理
 * 
 * @author CCYX-SZ34-02
 * @date 2019-08-08
 */
@Controller
@RequestMapping("/system/shopnamecountprice")
public class ShopnamecountpriceController extends BaseController
{
    private String prefix = "system/shopnamecountprice";
	
	@Autowired
	private IShopnamecountpriceService shopnamecountpriceService;
	
	@RequiresPermissions("system:shopnamecountprice:view")
	@GetMapping()
	public String shopnamecountprice()
	{
	    return prefix + "/shopnamecountprice";
	}
	
	/**
	 * 查询商家收入列表
	 */
	@RequiresPermissions("system:shopnamecountprice:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Shopnamecountprice shopnamecountprice)
	{
		startPage();
        List<Shopnamecountprice> list = shopnamecountpriceService.selectShopnamecountpriceList(shopnamecountprice);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出商家收入列表
	 */
	@RequiresPermissions("system:shopnamecountprice:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Shopnamecountprice shopnamecountprice)
    {
    	List<Shopnamecountprice> list = shopnamecountpriceService.selectShopnamecountpriceList(shopnamecountprice);
        ExcelUtil<Shopnamecountprice> util = new ExcelUtil<Shopnamecountprice>(Shopnamecountprice.class);
        return util.exportExcel(list, "shopnamecountprice");
    }
	
	/**
	 * 新增商家收入
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存商家收入
	 */
	@RequiresPermissions("system:shopnamecountprice:add")
	@Log(title = "商家收入", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Shopnamecountprice shopnamecountprice)
	{		
		return toAjax(shopnamecountpriceService.insertShopnamecountprice(shopnamecountprice));
	}

	/**
	 * 修改商家收入
	 */
	@GetMapping("/edit/{shopname}")
	public String edit(@PathVariable("shopname") String shopname, ModelMap mmap)
	{
		Shopnamecountprice shopnamecountprice = shopnamecountpriceService.selectShopnamecountpriceById(shopname);
		mmap.put("shopnamecountprice", shopnamecountprice);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存商家收入
	 */
	@RequiresPermissions("system:shopnamecountprice:edit")
	@Log(title = "商家收入", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Shopnamecountprice shopnamecountprice)
	{		
		return toAjax(shopnamecountpriceService.updateShopnamecountprice(shopnamecountprice));
	}
	
	/**
	 * 删除商家收入
	 */
	@RequiresPermissions("system:shopnamecountprice:remove")
	@Log(title = "商家收入", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(shopnamecountpriceService.deleteShopnamecountpriceByIds(ids));
	}

	/**
	 *
	 * @return计算总收入
	 */
	@RequestMapping("/selectOrdersCountPrice")
	@ResponseBody
	public List selectOrdersCountPrice(){
		List<Map<String, Object>> list = shopnamecountpriceService.selectOrdersCountPrice();
		return list;
	}

}

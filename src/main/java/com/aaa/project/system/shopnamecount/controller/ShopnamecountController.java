package com.aaa.project.system.shopnamecount.controller;

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
import com.aaa.project.system.shopnamecount.domain.Shopnamecount;
import com.aaa.project.system.shopnamecount.service.IShopnamecountService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;

/**
 * 商店订单数统计 信息操作处理
 * 
 * @author CCYX-SZ34-02
 * @date 2019-08-07
 */
@Controller
@RequestMapping("/system/shopnamecount")
public class ShopnamecountController extends BaseController
{
    private String prefix = "system/shopnamecount";
	
	@Autowired
	private IShopnamecountService shopnamecountService;
	
	@RequiresPermissions("system:shopnamecount:view")
	@GetMapping()
	public String shopnamecount()
	{
	    return prefix + "/shopnamecount";
	}

	/**
	 * 计算订单总数量
	 * @return
	 */
	@RequestMapping("/selectOrdersCount")
	@ResponseBody
	public List selectOrdersCount(){
		List<Map<String, Object>> list = shopnamecountService.selectOrdersCount();
		return list;
	}
}

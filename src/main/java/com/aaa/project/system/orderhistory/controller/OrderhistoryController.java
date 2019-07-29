package com.aaa.project.system.orderhistory.controller;

import java.util.List;
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
import com.aaa.project.system.orderhistory.domain.Orderhistory;
import com.aaa.project.system.orderhistory.service.IOrderhistoryService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;

/**
 * 订单历史记录/月 信息操作处理
 * 
 * @author teacherChen
 * @date 2019-07-29
 */
@Controller
@RequestMapping("/system/orderhistory")
public class OrderhistoryController extends BaseController
{
    private String prefix = "system/orderhistory";
	
	@Autowired
	private IOrderhistoryService orderhistoryService;
	
	@RequiresPermissions("system:orderhistory:view")
	@GetMapping()
	public String orderhistory()
	{
	    return prefix + "/orderhistory";
	}
	
	/**
	 * 查询订单历史记录/月列表
	 */
	@RequiresPermissions("system:orderhistory:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Orderhistory orderhistory)
	{
		startPage();
        List<Orderhistory> list = orderhistoryService.selectOrderhistoryList(orderhistory);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出订单历史记录/月列表
	 */
	@RequiresPermissions("system:orderhistory:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Orderhistory orderhistory)
    {
    	List<Orderhistory> list = orderhistoryService.selectOrderhistoryList(orderhistory);
        ExcelUtil<Orderhistory> util = new ExcelUtil<Orderhistory>(Orderhistory.class);
        return util.exportExcel(list, "orderhistory");
    }
	
	/**
	 * 新增订单历史记录/月
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存订单历史记录/月
	 */
	@RequiresPermissions("system:orderhistory:add")
	@Log(title = "订单历史记录/月", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Orderhistory orderhistory)
	{		
		return toAjax(orderhistoryService.insertOrderhistory(orderhistory));
	}

	/**
	 * 修改订单历史记录/月
	 */
	@GetMapping("/edit/{orderhistoryid}")
	public String edit(@PathVariable("orderhistoryid") Integer orderhistoryid, ModelMap mmap)
	{
		Orderhistory orderhistory = orderhistoryService.selectOrderhistoryById(orderhistoryid);
		mmap.put("orderhistory", orderhistory);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存订单历史记录/月
	 */
	@RequiresPermissions("system:orderhistory:edit")
	@Log(title = "订单历史记录/月", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Orderhistory orderhistory)
	{		
		return toAjax(orderhistoryService.updateOrderhistory(orderhistory));
	}
	
	/**
	 * 删除订单历史记录/月
	 */
	@RequiresPermissions("system:orderhistory:remove")
	@Log(title = "订单历史记录/月", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(orderhistoryService.deleteOrderhistoryByIds(ids));
	}
	
}

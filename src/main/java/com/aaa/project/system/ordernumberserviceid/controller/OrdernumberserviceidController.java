package com.aaa.project.system.ordernumberserviceid.controller;

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
import com.aaa.project.system.ordernumberserviceid.domain.Ordernumberserviceid;
import com.aaa.project.system.ordernumberserviceid.service.IOrdernumberserviceidService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;

/**
 * 订单编号和套餐服务id 信息操作处理
 * 
 * @author CCYX-SZ34-02
 * @date 2019-08-07
 */
@Controller
@RequestMapping("/system/ordernumberserviceid")
public class OrdernumberserviceidController extends BaseController
{
    private String prefix = "system/ordernumberserviceid";
	
	@Autowired
	private IOrdernumberserviceidService ordernumberserviceidService;
	
	@RequiresPermissions("system:ordernumberserviceid:view")
	@GetMapping()
	public String ordernumberserviceid()
	{
	    return prefix + "/ordernumberserviceid";
	}
	
	/**
	 * 查询订单编号和套餐服务id列表
	 */
	@RequiresPermissions("system:ordernumberserviceid:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Ordernumberserviceid ordernumberserviceid)
	{
		startPage();
        List<Ordernumberserviceid> list = ordernumberserviceidService.selectOrdernumberserviceidList(ordernumberserviceid);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出订单编号和套餐服务id列表
	 */
	@RequiresPermissions("system:ordernumberserviceid:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Ordernumberserviceid ordernumberserviceid)
    {
    	List<Ordernumberserviceid> list = ordernumberserviceidService.selectOrdernumberserviceidList(ordernumberserviceid);
        ExcelUtil<Ordernumberserviceid> util = new ExcelUtil<Ordernumberserviceid>(Ordernumberserviceid.class);
        return util.exportExcel(list, "ordernumberserviceid");
    }
	
	/**
	 * 新增订单编号和套餐服务id
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存订单编号和套餐服务id
	 */
	@RequiresPermissions("system:ordernumberserviceid:add")
	@Log(title = "订单编号和套餐服务id", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Ordernumberserviceid ordernumberserviceid)
	{		
		return toAjax(ordernumberserviceidService.insertOrdernumberserviceid(ordernumberserviceid));
	}

	/**
	 * 修改订单编号和套餐服务id
	 */
	@GetMapping("/edit/{ordernumber}")
	public String edit(@PathVariable("ordernumber") String ordernumber, ModelMap mmap)
	{
		Ordernumberserviceid ordernumberserviceid = ordernumberserviceidService.selectOrdernumberserviceidById(ordernumber);
		mmap.put("ordernumberserviceid", ordernumberserviceid);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存订单编号和套餐服务id
	 */
	@RequiresPermissions("system:ordernumberserviceid:edit")
	@Log(title = "订单编号和套餐服务id", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Ordernumberserviceid ordernumberserviceid)
	{		
		return toAjax(ordernumberserviceidService.updateOrdernumberserviceid(ordernumberserviceid));
	}
	
	/**
	 * 删除订单编号和套餐服务id
	 */
	@RequiresPermissions("system:ordernumberserviceid:remove")
	@Log(title = "订单编号和套餐服务id", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(ordernumberserviceidService.deleteOrdernumberserviceidByIds(ids));
	}
	
}

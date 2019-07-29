package com.aaa.project.system.carservice.controller;

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
import com.aaa.project.system.carservice.domain.Carservice;
import com.aaa.project.system.carservice.service.ICarserviceService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;

/**
 * 车辆服务套餐 信息操作处理
 * 
 * @author teacherChen
 * @date 2019-07-29
 */
@Controller
@RequestMapping("/system/carservice")
public class CarserviceController extends BaseController
{
    private String prefix = "system/carservice";
	
	@Autowired
	private ICarserviceService carserviceService;
	
	@RequiresPermissions("system:carservice:view")
	@GetMapping()
	public String carservice()
	{
	    return prefix + "/carservice";
	}
	
	/**
	 * 查询车辆服务套餐列表
	 */
	@RequiresPermissions("system:carservice:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Carservice carservice)
	{
		startPage();
        List<Carservice> list = carserviceService.selectCarserviceList(carservice);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出车辆服务套餐列表
	 */
	@RequiresPermissions("system:carservice:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Carservice carservice)
    {
    	List<Carservice> list = carserviceService.selectCarserviceList(carservice);
        ExcelUtil<Carservice> util = new ExcelUtil<Carservice>(Carservice.class);
        return util.exportExcel(list, "carservice");
    }
	
	/**
	 * 新增车辆服务套餐
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存车辆服务套餐
	 */
	@RequiresPermissions("system:carservice:add")
	@Log(title = "车辆服务套餐", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Carservice carservice)
	{		
		return toAjax(carserviceService.insertCarservice(carservice));
	}

	/**
	 * 修改车辆服务套餐
	 */
	@GetMapping("/edit/{carserviceid}")
	public String edit(@PathVariable("carserviceid") Integer carserviceid, ModelMap mmap)
	{
		Carservice carservice = carserviceService.selectCarserviceById(carserviceid);
		mmap.put("carservice", carservice);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存车辆服务套餐
	 */
	@RequiresPermissions("system:carservice:edit")
	@Log(title = "车辆服务套餐", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Carservice carservice)
	{		
		return toAjax(carserviceService.updateCarservice(carservice));
	}
	
	/**
	 * 删除车辆服务套餐
	 */
	@RequiresPermissions("system:carservice:remove")
	@Log(title = "车辆服务套餐", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(carserviceService.deleteCarserviceByIds(ids));
	}
	
}

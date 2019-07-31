package com.aaa.project.system.carwashperson.controller;

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
import com.aaa.project.system.carwashperson.domain.Carwashperson;
import com.aaa.project.system.carwashperson.service.ICarwashpersonService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;

/**
 * 洗车人员 信息操作处理
 * 
 * @author teacherChen
 * @date 2019-07-29
 */
@Controller
@RequestMapping("/system/carwashperson")
public class CarwashpersonController extends BaseController
{
    private String prefix = "system/carwashperson";
	
	@Autowired
	private ICarwashpersonService carwashpersonService;
	
	@RequiresPermissions("system:carwashperson:view")
	@GetMapping()
	public String carwashperson()
	{
	    return prefix + "/carwashperson";
	}
	
	/**
	 * 查询洗车人员列表
	 */
	@RequiresPermissions("system:carwashperson:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Carwashperson carwashperson)
	{
		startPage();
        List<Carwashperson> list = carwashpersonService.selectCarwashpersonList(carwashperson);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出洗车人员列表
	 */
	@RequiresPermissions("system:carwashperson:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Carwashperson carwashperson)
    {
    	List<Carwashperson> list = carwashpersonService.selectCarwashpersonList(carwashperson);
        ExcelUtil<Carwashperson> util = new ExcelUtil<Carwashperson>(Carwashperson.class);
        return util.exportExcel(list, "carwashperson");
    }
	
	/**
	 * 新增洗车人员
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存洗车人员
	 */
	@RequiresPermissions("system:carwashperson:add")
	@Log(title = "洗车人员", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Carwashperson carwashperson)
	{

		return toAjax(carwashpersonService.insertCarwashperson(carwashperson));
	}

	/**
	 * 修改洗车人员
	 */
	@GetMapping("/edit/{washpersonpid}")
	public String edit(@PathVariable("washpersonpid") Integer washpersonpid, ModelMap mmap)
	{
		Carwashperson carwashperson = carwashpersonService.selectCarwashpersonById(washpersonpid);
		mmap.put("carwashperson", carwashperson);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存洗车人员
	 */
	@RequiresPermissions("system:carwashperson:edit")
	@Log(title = "洗车人员", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Carwashperson carwashperson)
	{		
		return toAjax(carwashpersonService.updateCarwashperson(carwashperson));
	}
	
	/**
	 * 删除洗车人员
	 */
	@RequiresPermissions("system:carwashperson:remove")
	@Log(title = "洗车人员", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(carwashpersonService.deleteCarwashpersonByIds(ids));
	}
	
}

package com.aaa.project.system.usercar.controller;

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
import com.aaa.project.system.usercar.domain.Usercar;
import com.aaa.project.system.usercar.service.IUsercarService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;

/**
 * 用户车辆 信息操作处理
 * 
 * @author teacherChen
 * @date 2019-07-29
 */
@Controller
@RequestMapping("/system/usercar")
public class UsercarController extends BaseController
{
    private String prefix = "system/usercar";
	
	@Autowired
	private IUsercarService usercarService;
	
	@RequiresPermissions("system:usercar:view")
	@GetMapping()
	public String usercar()
	{
	    return prefix + "/usercar";
	}
	
	/**
	 * 查询用户车辆列表
	 */
	@RequiresPermissions("system:usercar:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Usercar usercar)
	{
		startPage();
        List<Usercar> list = usercarService.selectUsercarList(usercar);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出用户车辆列表
	 */
	@RequiresPermissions("system:usercar:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Usercar usercar)
    {
    	List<Usercar> list = usercarService.selectUsercarList(usercar);
        ExcelUtil<Usercar> util = new ExcelUtil<Usercar>(Usercar.class);
        return util.exportExcel(list, "usercar");
    }
	
	/**
	 * 新增用户车辆
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存用户车辆
	 */
	@RequiresPermissions("system:usercar:add")
	@Log(title = "用户车辆", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Usercar usercar)
	{		
		return toAjax(usercarService.insertUsercar(usercar));
	}

	/**
	 * 修改用户车辆
	 */
	@GetMapping("/edit/{usercarid}")
	public String edit(@PathVariable("usercarid") Integer usercarid, ModelMap mmap)
	{
		Usercar usercar = usercarService.selectUsercarById(usercarid);
		mmap.put("usercar", usercar);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存用户车辆
	 */
	@RequiresPermissions("system:usercar:edit")
	@Log(title = "用户车辆", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Usercar usercar)
	{		
		return toAjax(usercarService.updateUsercar(usercar));
	}
	
	/**
	 * 删除用户车辆
	 */
	@RequiresPermissions("system:usercar:remove")
	@Log(title = "用户车辆", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(usercarService.deleteUsercarByIds(ids));
	}
	
}

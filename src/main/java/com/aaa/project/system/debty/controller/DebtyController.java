package com.aaa.project.system.debty.controller;

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
import com.aaa.project.system.debty.domain.Debty;
import com.aaa.project.system.debty.service.IDebtyService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;

/**
 * 财务 信息操作处理
 * 
 * @author CCYX-SZ34-02
 * @date 2019-08-01
 */
@Controller
@RequestMapping("/system/debty")
public class DebtyController extends BaseController
{
    private String prefix = "system/debty";
	
	@Autowired
	private IDebtyService debtyService;
	
	@RequiresPermissions("system:debty:view")
	@GetMapping()
	public String debty()
	{
	    return prefix + "/debty";
	}
	
	/**
	 * 查询财务列表
	 */
	@RequiresPermissions("system:debty:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Debty debty)
	{
		startPage();
        List<Debty> list = debtyService.selectDebtyList(debty);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出财务列表
	 */
	@RequiresPermissions("system:debty:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Debty debty)
    {
    	List<Debty> list = debtyService.selectDebtyList(debty);
        ExcelUtil<Debty> util = new ExcelUtil<Debty>(Debty.class);
        return util.exportExcel(list, "debty");
    }
	
	/**
	 * 新增财务
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存财务
	 */
	@RequiresPermissions("system:debty:add")
	@Log(title = "财务", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Debty debty)
	{		
		return toAjax(debtyService.insertDebty(debty));
	}

	/**
	 * 修改财务
	 */
	@GetMapping("/edit/{debtyid}")
	public String edit(@PathVariable("debtyid") Integer debtyid, ModelMap mmap)
	{
		Debty debty = debtyService.selectDebtyById(debtyid);
		mmap.put("debty", debty);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存财务
	 */
	@RequiresPermissions("system:debty:edit")
	@Log(title = "财务", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Debty debty)
	{		
		return toAjax(debtyService.updateDebty(debty));
	}
	
	/**
	 * 删除财务
	 */
	@RequiresPermissions("system:debty:remove")
	@Log(title = "财务", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(debtyService.deleteDebtyByIds(ids));
	}
	
}

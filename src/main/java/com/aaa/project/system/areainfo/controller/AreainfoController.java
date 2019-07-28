package com.aaa.project.system.areainfo.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.aaa.framework.aspectj.lang.annotation.Log;
import com.aaa.framework.aspectj.lang.enums.BusinessType;
import com.aaa.project.system.areainfo.domain.Areainfo;
import com.aaa.project.system.areainfo.service.IAreainfoService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;

/**
 * 户口所在地 信息操作处理
 * 
 * @author teacherChen
 * @date 2019-07-23
 */
@Controller
@RequestMapping("/system/areainfo")
public class AreainfoController extends BaseController
{
    private String prefix = "system/areainfo";
	
	@Autowired
	private IAreainfoService areainfoService;
	
	@RequiresPermissions("system:areainfo:view")
	@GetMapping()
	public String areainfo()
	{
	    return prefix + "/areainfo";
	}
	
	/**
	 * 查询户口所在地列表
	 */
	@RequiresPermissions("system:areainfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Areainfo areainfo)
	{
		startPage();
        List<Areainfo> list = areainfoService.selectAreainfoList(areainfo);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出户口所在地列表
	 */
	@RequiresPermissions("system:areainfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Areainfo areainfo)
    {
    	List<Areainfo> list = areainfoService.selectAreainfoList(areainfo);
        ExcelUtil<Areainfo> util = new ExcelUtil<Areainfo>(Areainfo.class);
        return util.exportExcel(list, "areainfo");
    }
	
	/**
	 * 新增户口所在地
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存户口所在地
	 */
	@RequiresPermissions("system:areainfo:add")
	@Log(title = "户口所在地", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Areainfo areainfo)
	{		
		return toAjax(areainfoService.insertAreainfo(areainfo));
	}

	/**
	 * 修改户口所在地
	 */
	@GetMapping("/edit/{areaid}")
	public String edit(@PathVariable("areaid") Integer areaid, ModelMap mmap)
	{
		Areainfo areainfo = areainfoService.selectAreainfoById(areaid);
		mmap.put("areainfo", areainfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存户口所在地
	 */
	@RequiresPermissions("system:areainfo:edit")
	@Log(title = "户口所在地", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Areainfo areainfo)
	{		
		return toAjax(areainfoService.updateAreainfo(areainfo));
	}
	
	/**
	 * 删除户口所在地
	 */
	@RequiresPermissions("system:areainfo:remove")
	@Log(title = "户口所在地", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(areainfoService.deleteAreainfoByIds(ids));
	}
	
}

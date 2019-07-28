package com.aaa.project.system.personinfo.controller;

import java.util.List;

import com.aaa.project.system.areainfo.domain.Areainfo;
import com.aaa.project.system.areainfo.service.IAreainfoService;
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
import com.aaa.project.system.personinfo.domain.Personinfo;
import com.aaa.project.system.personinfo.service.IPersoninfoService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;

/**
 * 人员 信息操作处理
 * 
 * @author teacherChen
 * @date 2019-07-23
 */
@Controller
@RequestMapping("/system/personinfo")
public class PersoninfoController extends BaseController
{
    private String prefix = "system/personinfo";
	
	@Autowired
	private IPersoninfoService personinfoService;

	@Autowired
	private IAreainfoService areainfoService;
	
	@RequiresPermissions("system:personinfo:view")
	@GetMapping()
	public String personinfo()
	{
	    return prefix + "/personinfo";
	}
	
	/**
	 * 查询人员列表
	 */
	@RequiresPermissions("system:personinfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Personinfo personinfo)
	{
		startPage();
        List<Personinfo> list = personinfoService.selectPersoninfoList(personinfo);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出人员列表
	 */
	@RequiresPermissions("system:personinfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Personinfo personinfo)
    {
    	List<Personinfo> list = personinfoService.selectPersoninfoList(personinfo);
        ExcelUtil<Personinfo> util = new ExcelUtil<Personinfo>(Personinfo.class);
        return util.exportExcel(list, "personinfo");
    }
	
	/**
	 * 新增人员
	 */
	@GetMapping("/add")
	public String add(Model model)
	{
	     List<Areainfo> b = areainfoService.selectAreainfoList(null);
	     model.addAttribute("list", b);
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存人员
	 */
	@RequiresPermissions("system:personinfo:add")
	@Log(title = "人员", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Personinfo personinfo)
	{
		return toAjax(personinfoService.insertPersoninfo(personinfo));
	}

	/**
	 * 修改人员
	 */
	@GetMapping("/edit/{personid}")
	public String edit(@PathVariable("personid") Integer personid, ModelMap mmap, Model model)
	{
		Personinfo personinfo = personinfoService.selectPersoninfoById(personid);
		mmap.put("personinfo", personinfo);
		List<Areainfo> a =  areainfoService.selectAreainfoList(null);
		model.addAttribute("areainfoList", a);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存人员
	 */
	@RequiresPermissions("system:personinfo:edit")
	@Log(title = "人员", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Personinfo personinfo)
	{		
		return toAjax(personinfoService.updatePersoninfo(personinfo));
	}
	
	/**
	 * 删除人员
	 */
	@RequiresPermissions("system:personinfo:remove")
	@Log(title = "人员", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(personinfoService.deletePersoninfoByIds(ids));
	}
	
}

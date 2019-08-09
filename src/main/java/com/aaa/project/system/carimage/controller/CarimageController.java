package com.aaa.project.system.carimage.controller;

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
import com.aaa.project.system.carimage.domain.Carimage;
import com.aaa.project.system.carimage.service.ICarimageService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;

/**
 * 车辆图片 信息操作处理
 * 
 * @author CCYX-SZ34-02
 * @date 2019-08-08
 */
@Controller
@RequestMapping("/system/carimage")
public class CarimageController extends BaseController
{
    private String prefix = "system/carimage";
	
	@Autowired
	private ICarimageService carimageService;
	
	@RequiresPermissions("system:carimage:view")
	@GetMapping()
	public String carimage()
	{
	    return prefix + "/carimage";
	}
	
	/**
	 * 查询车辆图片列表
	 */
	@RequiresPermissions("system:carimage:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Carimage carimage)
	{
		startPage();
        List<Carimage> list = carimageService.selectCarimageList(carimage);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出车辆图片列表
	 */
	@RequiresPermissions("system:carimage:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Carimage carimage)
    {
    	List<Carimage> list = carimageService.selectCarimageList(carimage);
        ExcelUtil<Carimage> util = new ExcelUtil<Carimage>(Carimage.class);
        return util.exportExcel(list, "carimage");
    }
	
	/**
	 * 新增车辆图片
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存车辆图片
	 */
	@RequiresPermissions("system:carimage:add")
	@Log(title = "车辆图片", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Carimage carimage)
	{		
		return toAjax(carimageService.insertCarimage(carimage));
	}

	/**
	 * 修改车辆图片
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Carimage carimage = carimageService.selectCarimageById(id);
		mmap.put("carimage", carimage);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存车辆图片
	 */
	@RequiresPermissions("system:carimage:edit")
	@Log(title = "车辆图片", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Carimage carimage)
	{		
		return toAjax(carimageService.updateCarimage(carimage));
	}
	
	/**
	 * 删除车辆图片
	 */
	@RequiresPermissions("system:carimage:remove")
	@Log(title = "车辆图片", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(carimageService.deleteCarimageByIds(ids));
	}
	
}

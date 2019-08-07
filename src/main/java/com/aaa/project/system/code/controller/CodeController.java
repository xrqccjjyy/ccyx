package com.aaa.project.system.code.controller;

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
import com.aaa.project.system.code.domain.Code;
import com.aaa.project.system.code.service.ICodeService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;

/**
 * 验证码 信息操作处理
 * 
 * @author CCYX-SZ34-02
 * @date 2019-08-05
 */
@Controller
@RequestMapping("/system/code")
public class CodeController extends BaseController
{
    private String prefix = "system/code";
	
	@Autowired
	private ICodeService codeService;
	
	@RequiresPermissions("system:code:view")
	@GetMapping()
	public String code()
	{
	    return prefix + "/code";
	}
	
	/**
	 * 查询验证码列表
	 */
	@RequiresPermissions("system:code:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Code code)
	{
		startPage();
        List<Code> list = codeService.selectCodeList(code);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出验证码列表
	 */
	@RequiresPermissions("system:code:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Code code)
    {
    	List<Code> list = codeService.selectCodeList(code);
        ExcelUtil<Code> util = new ExcelUtil<Code>(Code.class);
        return util.exportExcel(list, "code");
    }
	
	/**
	 * 新增验证码
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存验证码
	 */
	@RequiresPermissions("system:code:add")
	@Log(title = "验证码", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Code code)
	{		
		return toAjax(codeService.insertCode(code));
	}

	/**
	 * 修改验证码
	 */
	@GetMapping("/edit/{codeid}")
	public String edit(@PathVariable("codeid") Integer codeid, ModelMap mmap)
	{
		Code code = codeService.selectCodeById(codeid);
		mmap.put("code", code);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存验证码
	 */
	@RequiresPermissions("system:code:edit")
	@Log(title = "验证码", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Code code)
	{		
		return toAjax(codeService.updateCode(code));
	}
	
	/**
	 * 删除验证码
	 */
	@RequiresPermissions("system:code:remove")
	@Log(title = "验证码", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(codeService.deleteCodeByIds(ids));
	}
	
}

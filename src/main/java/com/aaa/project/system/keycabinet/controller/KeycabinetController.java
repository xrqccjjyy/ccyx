package com.aaa.project.system.keycabinet.controller;

import java.util.Date;
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
import com.aaa.project.system.keycabinet.domain.Keycabinet;
import com.aaa.project.system.keycabinet.service.IKeycabinetService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;

/**
 * 钥匙柜 信息操作处理
 * 
 * @author CCYX-SZ34-02
 * @date 2019-08-02
 */
@Controller
@RequestMapping("/system/keycabinet")
public class KeycabinetController extends BaseController
{
    private String prefix = "system/keycabinet";
	
	@Autowired
	private IKeycabinetService keycabinetService;
	
	@RequiresPermissions("system:keycabinet:view")
	@GetMapping()
	public String keycabinet()
	{
	    return prefix + "/keycabinet";
	}
	
	/**
	 * 查询钥匙柜列表
	 */
	@RequiresPermissions("system:keycabinet:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Keycabinet keycabinet)
	{
		startPage();
        List<Keycabinet> list = keycabinetService.selectKeycabinetList(keycabinet);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出钥匙柜列表
	 */
	@RequiresPermissions("system:keycabinet:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Keycabinet keycabinet)
    {
    	List<Keycabinet> list = keycabinetService.selectKeycabinetList(keycabinet);
        ExcelUtil<Keycabinet> util = new ExcelUtil<Keycabinet>(Keycabinet.class);
        return util.exportExcel(list, "keycabinet");
    }
	
	/**
	 * 新增钥匙柜
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存钥匙柜
	 */
	@RequiresPermissions("system:keycabinet:add")
	@Log(title = "钥匙柜", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Keycabinet keycabinet)
	{
		keycabinet.setKeycabinettime(new Date());
		return toAjax(keycabinetService.insertKeycabinet(keycabinet));
	}

	/**
	 * 修改钥匙柜
	 */
	@GetMapping("/edit/{keycabinetid}")
	public String edit(@PathVariable("keycabinetid") Integer keycabinetid, ModelMap mmap)
	{
		Keycabinet keycabinet = keycabinetService.selectKeycabinetById(keycabinetid);
		mmap.put("keycabinet", keycabinet);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存钥匙柜
	 */
	@RequiresPermissions("system:keycabinet:edit")
	@Log(title = "钥匙柜", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Keycabinet keycabinet)
	{		
		return toAjax(keycabinetService.updateKeycabinet(keycabinet));
	}
	
	/**
	 * 删除钥匙柜
	 */
	@RequiresPermissions("system:keycabinet:remove")
	@Log(title = "钥匙柜", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(keycabinetService.deleteKeycabinetByIds(ids));
	}
	
}

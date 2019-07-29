package com.aaa.project.system.evaluation.controller;

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
import com.aaa.project.system.evaluation.domain.Evaluation;
import com.aaa.project.system.evaluation.service.IEvaluationService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;

/**
 * 客户评价/投诉 信息操作处理
 * 
 * @author teacherChen
 * @date 2019-07-29
 */
@Controller
@RequestMapping("/system/evaluation")
public class EvaluationController extends BaseController
{
    private String prefix = "system/evaluation";
	
	@Autowired
	private IEvaluationService evaluationService;
	
	@RequiresPermissions("system:evaluation:view")
	@GetMapping()
	public String evaluation()
	{
	    return prefix + "/evaluation";
	}
	
	/**
	 * 查询客户评价/投诉列表
	 */
	@RequiresPermissions("system:evaluation:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Evaluation evaluation)
	{
		startPage();
        List<Evaluation> list = evaluationService.selectEvaluationList(evaluation);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出客户评价/投诉列表
	 */
	@RequiresPermissions("system:evaluation:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Evaluation evaluation)
    {
    	List<Evaluation> list = evaluationService.selectEvaluationList(evaluation);
        ExcelUtil<Evaluation> util = new ExcelUtil<Evaluation>(Evaluation.class);
        return util.exportExcel(list, "evaluation");
    }
	
	/**
	 * 新增客户评价/投诉
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存客户评价/投诉
	 */
	@RequiresPermissions("system:evaluation:add")
	@Log(title = "客户评价/投诉", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Evaluation evaluation)
	{		
		return toAjax(evaluationService.insertEvaluation(evaluation));
	}

	/**
	 * 修改客户评价/投诉
	 */
	@GetMapping("/edit/{clientid}")
	public String edit(@PathVariable("clientid") Integer clientid, ModelMap mmap)
	{
		Evaluation evaluation = evaluationService.selectEvaluationById(clientid);
		mmap.put("evaluation", evaluation);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存客户评价/投诉
	 */
	@RequiresPermissions("system:evaluation:edit")
	@Log(title = "客户评价/投诉", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Evaluation evaluation)
	{		
		return toAjax(evaluationService.updateEvaluation(evaluation));
	}
	
	/**
	 * 删除客户评价/投诉
	 */
	@RequiresPermissions("system:evaluation:remove")
	@Log(title = "客户评价/投诉", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(evaluationService.deleteEvaluationByIds(ids));
	}
	
}

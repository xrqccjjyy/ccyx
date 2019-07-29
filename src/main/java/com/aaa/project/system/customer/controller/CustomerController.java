package com.aaa.project.system.customer.controller;

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
import com.aaa.project.system.customer.domain.Customer;
import com.aaa.project.system.customer.service.ICustomerService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;

/**
 * 用户 信息操作处理
 * 
 * @author teacherChen
 * @date 2019-07-29
 */
@Controller
@RequestMapping("/system/customer")
public class CustomerController extends BaseController
{
    private String prefix = "system/customer";
	
	@Autowired
	private ICustomerService customerService;
	
	@RequiresPermissions("system:customer:view")
	@GetMapping()
	public String customer()
	{
	    return prefix + "/customer";
	}
	
	/**
	 * 查询用户列表
	 */
	@RequiresPermissions("system:customer:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Customer customer)
	{
		startPage();
        List<Customer> list = customerService.selectCustomerList(customer);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出用户列表
	 */
	@RequiresPermissions("system:customer:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Customer customer)
    {
    	List<Customer> list = customerService.selectCustomerList(customer);
        ExcelUtil<Customer> util = new ExcelUtil<Customer>(Customer.class);
        return util.exportExcel(list, "customer");
    }
	
	/**
	 * 新增用户
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存用户
	 */
	@RequiresPermissions("system:customer:add")
	@Log(title = "用户", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Customer customer)
	{		
		return toAjax(customerService.insertCustomer(customer));
	}

	/**
	 * 修改用户
	 */
	@GetMapping("/edit/{userid}")
	public String edit(@PathVariable("userid") Integer userid, ModelMap mmap)
	{
		Customer customer = customerService.selectCustomerById(userid);
		mmap.put("customer", customer);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存用户
	 */
	@RequiresPermissions("system:customer:edit")
	@Log(title = "用户", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Customer customer)
	{		
		return toAjax(customerService.updateCustomer(customer));
	}
	
	/**
	 * 删除用户
	 */
	@RequiresPermissions("system:customer:remove")
	@Log(title = "用户", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(customerService.deleteCustomerByIds(ids));
	}
	
}

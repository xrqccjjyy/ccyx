package com.aaa.project.system.fileInfo.controller;

import java.io.IOException;
import java.util.List;

import com.aaa.common.utils.file.FileUploadUtils;
import com.aaa.framework.config.DouDouConfig;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.aaa.framework.aspectj.lang.annotation.Log;
import com.aaa.framework.aspectj.lang.enums.BusinessType;
import com.aaa.project.system.fileInfo.domain.FileInfo;
import com.aaa.project.system.fileInfo.service.IFileInfoService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件 信息操作处理
 * 
 * @author CCYX-SZ34-02
 * @date 2019-07-31
 */
@Controller
@RequestMapping("/system/fileInfo")
public class FileInfoController extends BaseController
{
    private String prefix = "system/fileInfo";
	
	@Autowired
	private IFileInfoService fileInfoService;
	
	@RequiresPermissions("system:fileInfo:view")
	@GetMapping()
	public String fileInfo()
	{
	    return prefix + "/fileInfo";
	}
	
	/**
	 * 查询文件列表
	 */
	@RequiresPermissions("system:fileInfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(FileInfo fileInfo)
	{
		startPage();
        List<FileInfo> list = fileInfoService.selectFileInfoList(fileInfo);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出文件列表
	 */
	@RequiresPermissions("system:fileInfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FileInfo fileInfo)
    {
    	List<FileInfo> list = fileInfoService.selectFileInfoList(fileInfo);
        ExcelUtil<FileInfo> util = new ExcelUtil<FileInfo>(FileInfo.class);
        return util.exportExcel(list, "fileInfo");
    }
	
	/**
	 * 新增文件
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存文件
	 */
	@RequiresPermissions("system:fileInfo:add")
	@Log(title = "文件", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(@RequestParam("file") MultipartFile file, FileInfo fileInfo) throws IOException {
		// 上传文件路径
		String filePath = DouDouConfig.getAvatarPath();
		// 上传并返回新文件名称
		String fileName = FileUploadUtils.upload(filePath, file);
		fileInfo.setFilePath(fileName);
		return toAjax(fileInfoService.insertFileInfo(fileInfo));
	}

	/**
	 * 修改文件
	 */
	@GetMapping("/edit/{fileId}")
	public String edit(@PathVariable("fileId") Integer fileId, ModelMap mmap)
	{
		FileInfo fileInfo = fileInfoService.selectFileInfoById(fileId);
		mmap.put("fileInfo", fileInfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存文件
	 */
	@RequiresPermissions("system:fileInfo:edit")
	@Log(title = "文件", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(FileInfo fileInfo)
	{		
		return toAjax(fileInfoService.updateFileInfo(fileInfo));
	}
	
	/**
	 * 删除文件
	 */
	@RequiresPermissions("system:fileInfo:remove")
	@Log(title = "文件", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(fileInfoService.deleteFileInfoByIds(ids));
	}
	
}

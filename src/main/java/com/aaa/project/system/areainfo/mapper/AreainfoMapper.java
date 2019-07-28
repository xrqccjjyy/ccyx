package com.aaa.project.system.areainfo.mapper;

import com.aaa.project.system.areainfo.domain.Areainfo;
import java.util.List;	

/**
 * 户口所在地 数据层
 * 
 * @author teacherChen
 * @date 2019-07-23
 */
public interface AreainfoMapper 
{
	/**
     * 查询户口所在地信息
     * 
     * @param areaid 户口所在地ID
     * @return 户口所在地信息
     */
	public Areainfo selectAreainfoById(Integer areaid);
	
	/**
     * 查询户口所在地列表
     * 
     * @param areainfo 户口所在地信息
     * @return 户口所在地集合
     */
	public List<Areainfo> selectAreainfoList(Areainfo areainfo);
	
	/**
     * 新增户口所在地
     * 
     * @param areainfo 户口所在地信息
     * @return 结果
     */
	public int insertAreainfo(Areainfo areainfo);
	
	/**
     * 修改户口所在地
     * 
     * @param areainfo 户口所在地信息
     * @return 结果
     */
	public int updateAreainfo(Areainfo areainfo);
	
	/**
     * 删除户口所在地
     * 
     * @param areaid 户口所在地ID
     * @return 结果
     */
	public int deleteAreainfoById(Integer areaid);
	
	/**
     * 批量删除户口所在地
     * 
     * @param areaids 需要删除的数据ID
     * @return 结果
     */
	public int deleteAreainfoByIds(String[] areaids);
	
}
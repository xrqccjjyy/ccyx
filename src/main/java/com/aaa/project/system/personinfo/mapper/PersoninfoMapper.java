package com.aaa.project.system.personinfo.mapper;

import com.aaa.project.system.personinfo.domain.Personinfo;
import java.util.List;	

/**
 * 人员 数据层
 * 
 * @author teacherChen
 * @date 2019-07-23
 */
public interface PersoninfoMapper 
{
	/**
     * 查询人员信息
     * 
     * @param personid 人员ID
     * @return 人员信息
     */
	public Personinfo selectPersoninfoById(Integer personid);
	
	/**
     * 查询人员列表
     * 
     * @param personinfo 人员信息
     * @return 人员集合
     */
	public List<Personinfo> selectPersoninfoList(Personinfo personinfo);
	
	/**
     * 新增人员
     * 
     * @param personinfo 人员信息
     * @return 结果
     */
	public int insertPersoninfo(Personinfo personinfo);
	
	/**
     * 修改人员
     * 
     * @param personinfo 人员信息
     * @return 结果
     */
	public int updatePersoninfo(Personinfo personinfo);
	
	/**
     * 删除人员
     * 
     * @param personid 人员ID
     * @return 结果
     */
	public int deletePersoninfoById(Integer personid);
	
	/**
     * 批量删除人员
     * 
     * @param personids 需要删除的数据ID
     * @return 结果
     */
	public int deletePersoninfoByIds(String[] personids);
	
}
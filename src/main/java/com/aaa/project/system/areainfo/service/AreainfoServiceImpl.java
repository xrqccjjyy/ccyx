package com.aaa.project.system.areainfo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.areainfo.mapper.AreainfoMapper;
import com.aaa.project.system.areainfo.domain.Areainfo;
import com.aaa.project.system.areainfo.service.IAreainfoService;
import com.aaa.common.support.Convert;

/**
 * 户口所在地 服务层实现
 * 
 * @author teacherChen
 * @date 2019-07-23
 */
@Service
public class AreainfoServiceImpl implements IAreainfoService 
{
	@Autowired
	private AreainfoMapper areainfoMapper;

	/**
     * 查询户口所在地信息
     * 
     * @param areaid 户口所在地ID
     * @return 户口所在地信息
     */
    @Override
	public Areainfo selectAreainfoById(Integer areaid)
	{
	    return areainfoMapper.selectAreainfoById(areaid);
	}
	
	/**
     * 查询户口所在地列表
     * 
     * @param areainfo 户口所在地信息
     * @return 户口所在地集合
     */
	@Override
	public List<Areainfo> selectAreainfoList(Areainfo areainfo)
	{
	    return areainfoMapper.selectAreainfoList(areainfo);
	}
	
    /**
     * 新增户口所在地
     * 
     * @param areainfo 户口所在地信息
     * @return 结果
     */
	@Override
	public int insertAreainfo(Areainfo areainfo)
	{
	    return areainfoMapper.insertAreainfo(areainfo);
	}
	
	/**
     * 修改户口所在地
     * 
     * @param areainfo 户口所在地信息
     * @return 结果
     */
	@Override
	public int updateAreainfo(Areainfo areainfo)
	{
	    return areainfoMapper.updateAreainfo(areainfo);
	}

	/**
     * 删除户口所在地对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteAreainfoByIds(String ids)
	{
		return areainfoMapper.deleteAreainfoByIds(Convert.toStrArray(ids));
	}
	
}

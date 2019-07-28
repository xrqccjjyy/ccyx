package com.aaa.project.system.personinfo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.personinfo.mapper.PersoninfoMapper;
import com.aaa.project.system.personinfo.domain.Personinfo;
import com.aaa.project.system.personinfo.service.IPersoninfoService;
import com.aaa.common.support.Convert;

/**
 * 人员 服务层实现
 * 
 * @author teacherChen
 * @date 2019-07-23
 */
@Service
public class PersoninfoServiceImpl implements IPersoninfoService 
{
	@Autowired
	private PersoninfoMapper personinfoMapper;

	/**
     * 查询人员信息
     * 
     * @param personid 人员ID
     * @return 人员信息
     */
    @Override
	public Personinfo selectPersoninfoById(Integer personid)
	{
	    return personinfoMapper.selectPersoninfoById(personid);
	}
	
	/**
     * 查询人员列表
     * 
     * @param personinfo 人员信息
     * @return 人员集合
     */
	@Override
	public List<Personinfo> selectPersoninfoList(Personinfo personinfo)
	{
	    return personinfoMapper.selectPersoninfoList(personinfo);
	}
	
    /**
     * 新增人员
     * 
     * @param personinfo 人员信息
     * @return 结果
     */
	@Override
	public int insertPersoninfo(Personinfo personinfo)
	{
	    return personinfoMapper.insertPersoninfo(personinfo);
	}
	
	/**
     * 修改人员
     * 
     * @param personinfo 人员信息
     * @return 结果
     */
	@Override
	public int updatePersoninfo(Personinfo personinfo)
	{
	    return personinfoMapper.updatePersoninfo(personinfo);
	}

	/**
     * 删除人员对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePersoninfoByIds(String ids)
	{
		return personinfoMapper.deletePersoninfoByIds(Convert.toStrArray(ids));
	}
	
}

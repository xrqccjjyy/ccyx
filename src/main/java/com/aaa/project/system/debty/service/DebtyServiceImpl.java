package com.aaa.project.system.debty.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.debty.mapper.DebtyMapper;
import com.aaa.project.system.debty.domain.Debty;
import com.aaa.common.support.Convert;

/**
 * 财务 服务层实现
 * 
 * @author CCYX-SZ34-02
 * @date 2019-08-01
 */
@Service
public class DebtyServiceImpl implements IDebtyService 
{
	@Autowired
	private DebtyMapper debtyMapper;

	/**
     * 查询财务信息
     * 
     * @param debtyid 财务ID
     * @return 财务信息
     */
    @Override
	public Debty selectDebtyById(Integer debtyid)
	{
	    return debtyMapper.selectDebtyById(debtyid);
	}
	
	/**
     * 查询财务列表
     * 
     * @param debty 财务信息
     * @return 财务集合
     */
	@Override
	public List<Debty> selectDebtyList(Debty debty)
	{
	    return debtyMapper.selectDebtyList(debty);
	}
	
    /**
     * 新增财务
     * 
     * @param debty 财务信息
     * @return 结果
     */
	@Override
	public int insertDebty(Debty debty)
	{
	    return debtyMapper.insertDebty(debty);
	}
	
	/**
     * 修改财务
     * 
     * @param debty 财务信息
     * @return 结果
     */
	@Override
	public int updateDebty(Debty debty)
	{
	    return debtyMapper.updateDebty(debty);
	}


	@Override
	public int updateDebtyMoney(Debty debty) {
		return debtyMapper.updateDebtyMoney(debty);
	}

	/**
     * 删除财务对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteDebtyByIds(String ids)
	{
		return debtyMapper.deleteDebtyByIds(Convert.toStrArray(ids));
	}


	/**
	 * 查询订单数量和总金额
	 * */
	@Override
	public List<Debty> selectStatisticalTable() {
		return debtyMapper.selectStatisticalTable();
	}




}

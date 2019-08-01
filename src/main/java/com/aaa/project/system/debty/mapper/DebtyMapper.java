package com.aaa.project.system.debty.mapper;

import com.aaa.project.system.debty.domain.Debty;
import java.util.List;	

/**
 * 财务 数据层
 * 
 * @author CCYX-SZ34-02
 * @date 2019-08-01
 */
public interface DebtyMapper 
{
	/**
     * 查询财务信息
     * 
     * @param debtyid 财务ID
     * @return 财务信息
     */
	public Debty selectDebtyById(Integer debtyid);
	
	/**
     * 查询财务列表
     * 
     * @param debty 财务信息
     * @return 财务集合
     */
	public List<Debty> selectDebtyList(Debty debty);
	
	/**
     * 新增财务
     * 
     * @param debty 财务信息
     * @return 结果
     */
	public int insertDebty(Debty debty);
	
	/**
     * 修改财务
     * 
     * @param debty 财务信息
     * @return 结果
     */
	public int updateDebty(Debty debty);


	/**
	 * 更新金额
	 * */
	public int updateDebtyMoney(Debty debty);


	/**
     * 删除财务
     * 
     * @param debtyid 财务ID
     * @return 结果
     */
	public int deleteDebtyById(Integer debtyid);




	/**
     * 批量删除财务
     * 
     * @param debtyids 需要删除的数据ID
     * @return 结果
     */
	public int deleteDebtyByIds(String[] debtyids);
	
}
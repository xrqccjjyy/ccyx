package com.aaa.project.system.debty.service;

import com.aaa.project.system.debty.domain.Debty;
import java.util.List;

/**
 * 财务 服务层
 * 
 * @author CCYX-SZ34-02
 * @date 2019-08-01
 */
public interface IDebtyService 
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
     * 删除财务信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteDebtyByIds(String ids);

	/**
	 * 查询订单数量和总金额
	 * */
	public List<Debty> selectStatisticalTable();
}

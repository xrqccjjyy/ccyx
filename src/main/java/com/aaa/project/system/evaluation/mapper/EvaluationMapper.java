package com.aaa.project.system.evaluation.mapper;

import com.aaa.project.system.evaluation.domain.Evaluation;
import java.util.List;	

/**
 * 客户评价/投诉 数据层
 * 
 * @author teacherChen
 * @date 2019-07-29
 */
public interface EvaluationMapper 
{
	/**
     * 查询客户评价/投诉信息
     * 
     * @param clientid 客户评价/投诉ID
     * @return 客户评价/投诉信息
     */
	public Evaluation selectEvaluationById(Integer clientid);
	
	/**
     * 查询客户评价/投诉列表
     * 
     * @param evaluation 客户评价/投诉信息
     * @return 客户评价/投诉集合
     */
	public List<Evaluation> selectEvaluationList(Evaluation evaluation);
	
	/**
     * 新增客户评价/投诉
     * 
     * @param evaluation 客户评价/投诉信息
     * @return 结果
     */
	public int insertEvaluation(Evaluation evaluation);
	
	/**
     * 修改客户评价/投诉
     * 
     * @param evaluation 客户评价/投诉信息
     * @return 结果
     */
	public int updateEvaluation(Evaluation evaluation);
	
	/**
     * 删除客户评价/投诉
     * 
     * @param clientid 客户评价/投诉ID
     * @return 结果
     */
	public int deleteEvaluationById(Integer clientid);
	
	/**
     * 批量删除客户评价/投诉
     * 
     * @param clientids 需要删除的数据ID
     * @return 结果
     */
	public int deleteEvaluationByIds(String[] clientids);
	
}
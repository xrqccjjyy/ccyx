package com.aaa.project.system.evaluation.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.evaluation.mapper.EvaluationMapper;
import com.aaa.project.system.evaluation.domain.Evaluation;
import com.aaa.project.system.evaluation.service.IEvaluationService;
import com.aaa.common.support.Convert;

/**
 * 客户评价/投诉 服务层实现
 * 
 * @author teacherChen
 * @date 2019-07-29
 */
@Service
public class EvaluationServiceImpl implements IEvaluationService 
{
	@Autowired
	private EvaluationMapper evaluationMapper;

	/**
     * 查询客户评价/投诉信息
     * 
     * @param clientid 客户评价/投诉ID
     * @return 客户评价/投诉信息
     */
    @Override
	public Evaluation selectEvaluationById(Integer clientid)
	{
	    return evaluationMapper.selectEvaluationById(clientid);
	}
	
	/**
     * 查询客户评价/投诉列表
     * 
     * @param evaluation 客户评价/投诉信息
     * @return 客户评价/投诉集合
     */
	@Override
	public List<Evaluation> selectEvaluationList(Evaluation evaluation)
	{
	    return evaluationMapper.selectEvaluationList(evaluation);
	}
	
    /**
     * 新增客户评价/投诉
     * 
     * @param evaluation 客户评价/投诉信息
     * @return 结果
     */
	@Override
	public int insertEvaluation(Evaluation evaluation)
	{
	    return evaluationMapper.insertEvaluation(evaluation);
	}
	
	/**
     * 修改客户评价/投诉
     * 
     * @param evaluation 客户评价/投诉信息
     * @return 结果
     */
	@Override
	public int updateEvaluation(Evaluation evaluation)
	{
	    return evaluationMapper.updateEvaluation(evaluation);
	}

	/**
     * 删除客户评价/投诉对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteEvaluationByIds(String ids)
	{
		return evaluationMapper.deleteEvaluationByIds(Convert.toStrArray(ids));
	}
	
}

package com.aaa.project.system.code.mapper;

import com.aaa.project.system.code.domain.Code;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 验证码 数据层
 * 
 * @author CCYX-SZ34-02
 * @date 2019-08-05
 */
public interface CodeMapper 
{
	/**
     * 查询验证码信息
     * 
     * @param codeid 验证码ID
     * @return 验证码信息
     */
	public Code selectCodeById(Integer codeid);
	
	/**
     * 查询验证码列表
     * 
     * @param code 验证码信息
     * @return 验证码集合
     */
	public List<Code> selectCodeList(Code code);
	
	/**
     * 新增验证码
     * 
     * @param code 验证码信息
     * @return 结果
     */
	public int insertCode(Code code);
	
	/**
     * 修改验证码
     * 
     * @param code 验证码信息
     * @return 结果
     */
	public int updateCode(Code code);
	
	/**
     * 删除验证码
     * 
     * @param codeid 验证码ID
     * @return 结果
     */
	public int deleteCodeById(Integer codeid);
	
	/**
     * 批量删除验证码
     * 
     * @param codeids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCodeByIds(String[] codeids);

	public void addUserVerify(@Param("userphone")String userphone, @Param("codenum")Integer codenum);
	
}
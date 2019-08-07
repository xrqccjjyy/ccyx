package com.aaa.project.system.code.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.code.mapper.CodeMapper;
import com.aaa.project.system.code.domain.Code;
import com.aaa.project.system.code.service.ICodeService;
import com.aaa.common.support.Convert;

/**
 * 验证码 服务层实现
 * 
 * @author CCYX-SZ34-02
 * @date 2019-08-05
 */
@Service
public class CodeServiceImpl implements ICodeService
{
	@Autowired
	private CodeMapper codeMapper;

	/**
     * 查询验证码信息
     * 
     * @param codeid 验证码ID
     * @return 验证码信息
     */
    @Override
	public Code selectCodeById(Integer codeid)
	{
	    return codeMapper.selectCodeById(codeid);
	}
	
	/**
     * 查询验证码列表
     * 
     * @param code 验证码信息
     * @return 验证码集合
     */
	@Override
	public List<Code> selectCodeList(Code code)
	{
	    return codeMapper.selectCodeList(code);
	}
	
    /**
     * 新增验证码
     * 
     * @param code 验证码信息
     * @return 结果
     */
	@Override
	public int insertCode(Code code)
	{
	    return codeMapper.insertCode(code);
	}
	
	/**
     * 修改验证码
     * 
     * @param code 验证码信息
     * @return 结果
     */
	@Override
	public int updateCode(Code code)
	{
	    return codeMapper.updateCode(code);
	}

	/**
     * 删除验证码对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCodeByIds(String ids)
	{
		return codeMapper.deleteCodeByIds(Convert.toStrArray(ids));
	}

	@Override
	public void addUserVerify(String userphone,Integer codenum) {
		codeMapper.addUserVerify(userphone,codenum);
	}

}

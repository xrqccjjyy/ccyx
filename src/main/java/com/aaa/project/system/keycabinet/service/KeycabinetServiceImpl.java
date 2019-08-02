package com.aaa.project.system.keycabinet.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.keycabinet.mapper.KeycabinetMapper;
import com.aaa.project.system.keycabinet.domain.Keycabinet;
import com.aaa.project.system.keycabinet.service.IKeycabinetService;
import com.aaa.common.support.Convert;

/**
 * 钥匙柜 服务层实现
 * 
 * @author CCYX-SZ34-02
 * @date 2019-08-02
 */
@Service
public class KeycabinetServiceImpl implements IKeycabinetService 
{
	@Autowired
	private KeycabinetMapper keycabinetMapper;

	/**
     * 查询钥匙柜信息
     * 
     * @param keycabinetid 钥匙柜ID
     * @return 钥匙柜信息
     */
    @Override
	public Keycabinet selectKeycabinetById(Integer keycabinetid)
	{
	    return keycabinetMapper.selectKeycabinetById(keycabinetid);
	}
	
	/**
     * 查询钥匙柜列表
     * 
     * @param keycabinet 钥匙柜信息
     * @return 钥匙柜集合
     */
	@Override
	public List<Keycabinet> selectKeycabinetList(Keycabinet keycabinet)
	{
	    return keycabinetMapper.selectKeycabinetList(keycabinet);
	}
	
    /**
     * 新增钥匙柜
     * 
     * @param keycabinet 钥匙柜信息
     * @return 结果
     */
	@Override
	public int insertKeycabinet(Keycabinet keycabinet)
	{
	    return keycabinetMapper.insertKeycabinet(keycabinet);
	}
	
	/**
     * 修改钥匙柜
     * 
     * @param keycabinet 钥匙柜信息
     * @return 结果
     */
	@Override
	public int updateKeycabinet(Keycabinet keycabinet)
	{
	    return keycabinetMapper.updateKeycabinet(keycabinet);
	}

	/**
     * 删除钥匙柜对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteKeycabinetByIds(String ids)
	{
		return keycabinetMapper.deleteKeycabinetByIds(Convert.toStrArray(ids));
	}
	
}

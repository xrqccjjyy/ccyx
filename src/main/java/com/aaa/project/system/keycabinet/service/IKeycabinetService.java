package com.aaa.project.system.keycabinet.service;

import com.aaa.project.system.keycabinet.domain.Keycabinet;
import java.util.List;

/**
 * 钥匙柜 服务层
 * 
 * @author CCYX-SZ34-02
 * @date 2019-08-02
 */
public interface IKeycabinetService 
{
	/**
     * 查询钥匙柜信息
     * 
     * @param keycabinetid 钥匙柜ID
     * @return 钥匙柜信息
     */
	public Keycabinet selectKeycabinetById(Integer keycabinetid);
	
	/**
     * 查询钥匙柜列表
     * 
     * @param keycabinet 钥匙柜信息
     * @return 钥匙柜集合
     */
	public List<Keycabinet> selectKeycabinetList(Keycabinet keycabinet);
	
	/**
     * 新增钥匙柜
     * 
     * @param keycabinet 钥匙柜信息
     * @return 结果
     */
	public int insertKeycabinet(Keycabinet keycabinet);
	
	/**
     * 修改钥匙柜
     * 
     * @param keycabinet 钥匙柜信息
     * @return 结果
     */
	public int updateKeycabinet(Keycabinet keycabinet);
		
	/**
     * 删除钥匙柜信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteKeycabinetByIds(String ids);
	
}

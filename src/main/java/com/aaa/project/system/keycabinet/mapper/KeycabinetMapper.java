package com.aaa.project.system.keycabinet.mapper;

import com.aaa.project.system.keycabinet.domain.Keycabinet;
import java.util.List;	

/**
 * 钥匙柜 数据层
 * 
 * @author CCYX-SZ34-02
 * @date 2019-08-02
 */
public interface KeycabinetMapper 
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
     * 删除钥匙柜
     * 
     * @param keycabinetid 钥匙柜ID
     * @return 结果
     */
	public int deleteKeycabinetById(Integer keycabinetid);
	
	/**
     * 批量删除钥匙柜
     * 
     * @param keycabinetids 需要删除的数据ID
     * @return 结果
     */
	public int deleteKeycabinetByIds(String[] keycabinetids);
	
}
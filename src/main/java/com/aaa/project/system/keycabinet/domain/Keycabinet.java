package com.aaa.project.system.keycabinet.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 钥匙柜表 keycabinet
 * 
 * @author CCYX-SZ34-02
 * @date 2019-08-02
 */
public class Keycabinet extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 钥匙柜id */
	private Integer keycabinetid;
	/** 钥匙柜所在详细地 */
	private String keycabinetname;
	/** 钥匙柜所在城市 */
	private String keycabinetcity;
	/** 入柜时间 */
	private Date keycabinettime;
	/** 经纬度 */
	private String longLot;

	public void setKeycabinetid(Integer keycabinetid) 
	{
		this.keycabinetid = keycabinetid;
	}

	public Integer getKeycabinetid() 
	{
		return keycabinetid;
	}
	public void setKeycabinetname(String keycabinetname) 
	{
		this.keycabinetname = keycabinetname;
	}

	public String getKeycabinetname() 
	{
		return keycabinetname;
	}
	public void setKeycabinetcity(String keycabinetcity) 
	{
		this.keycabinetcity = keycabinetcity;
	}

	public String getKeycabinetcity() 
	{
		return keycabinetcity;
	}
	public void setKeycabinettime(Date keycabinettime) 
	{
		this.keycabinettime = keycabinettime;
	}

	public Date getKeycabinettime() 
	{
		return keycabinettime;
	}
	public void setLongLot(String longLot) 
	{
		this.longLot = longLot;
	}

	public String getLongLot() 
	{
		return longLot;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("keycabinetid", getKeycabinetid())
            .append("keycabinetname", getKeycabinetname())
            .append("keycabinetcity", getKeycabinetcity())
            .append("keycabinettime", getKeycabinettime())
            .append("longLot", getLongLot())
            .toString();
    }
}

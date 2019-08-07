package com.aaa.project.system.ordernumberserviceid.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;

/**
 * 订单编号和套餐服务id表 ordernumberserviceid
 * 
 * @author CCYX-SZ34-02
 * @date 2019-08-07
 */
public class Ordernumberserviceid extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 订单编号 */
	private String ordernumber;
	/** 套餐服务id */
	private Integer carserviceid;

	public void setOrdernumber(String ordernumber) 
	{
		this.ordernumber = ordernumber;
	}

	public String getOrdernumber() 
	{
		return ordernumber;
	}
	public void setCarserviceid(Integer carserviceid) 
	{
		this.carserviceid = carserviceid;
	}

	public Integer getCarserviceid() 
	{
		return carserviceid;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("ordernumber", getOrdernumber())
            .append("carserviceid", getCarserviceid())
            .toString();
    }
}

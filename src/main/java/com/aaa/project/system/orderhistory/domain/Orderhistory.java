package com.aaa.project.system.orderhistory.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;

/**
 * 订单历史记录/月表 orderhistory
 * 
 * @author teacherChen
 * @date 2019-07-29
 */
public class Orderhistory extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 订单历史记录id */
	private Integer orderhistoryid;
	/** 订单号 */
	private Integer ordernumber;
	/** 订单状态 */
	private String orderstatus;

	public void setOrderhistoryid(Integer orderhistoryid) 
	{
		this.orderhistoryid = orderhistoryid;
	}

	public Integer getOrderhistoryid() 
	{
		return orderhistoryid;
	}
	public void setOrdernumber(Integer ordernumber) 
	{
		this.ordernumber = ordernumber;
	}

	public Integer getOrdernumber() 
	{
		return ordernumber;
	}
	public void setOrderstatus(String orderstatus) 
	{
		this.orderstatus = orderstatus;
	}

	public String getOrderstatus() 
	{
		return orderstatus;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orderhistoryid", getOrderhistoryid())
            .append("ordernumber", getOrdernumber())
            .append("orderstatus", getOrderstatus())
            .toString();
    }
}

package com.aaa.project.system.orderhistory.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 订单历史记录/月表 orderhistory
 * 
 * @author CCYX-SZ34-02
 * @date 2019-08-01
 */
public class Orderhistory extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 订单历史记录id */
	private Integer orderhistoryid;
	/** 订单号 */
	private String ordernumber;
	/**  */
	private Date historytime;
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
	public void setOrdernumber(String ordernumber) 
	{
		this.ordernumber = ordernumber;
	}

	public String getOrdernumber() 
	{
		return ordernumber;
	}
	public void setHistorytime(Date historytime) 
	{
		this.historytime = historytime;
	}

	public Date getHistorytime() 
	{
		return historytime;
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
            .append("historytime", getHistorytime())
            .append("orderstatus", getOrderstatus())
            .toString();
    }
}

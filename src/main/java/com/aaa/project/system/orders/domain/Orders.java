package com.aaa.project.system.orders.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 订单表 orders
 * 
 * @author teacherChen
 * @date 2019-07-29
 */
public class Orders extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 订单id */
	private Integer orderid;
	/** 订单编号 */
	private String ordernumber;
	/** 下单时间 */
	private Date ordertime;
	/** 洗车时间 */
	private Date washtime;
	/** 钥匙柜取件码 */
	private String cabinetcode;
	/** 柜子位置信息 */
	private String chestsite;
	/** 订单状态 */
	private String orderstatus;
	/** 车辆信息id */
	private Integer usercarid;
	/** 商家id */
	private Integer shopid;
	/** 用户id */
	private Integer userid;
	/** 洗车人员id */
	private Integer washpersonpid;

	public void setOrderid(Integer orderid) 
	{
		this.orderid = orderid;
	}

	public Integer getOrderid() 
	{
		return orderid;
	}
	public void setOrdernumber(String ordernumber) 
	{
		this.ordernumber = ordernumber;
	}

	public String getOrdernumber() 
	{
		return ordernumber;
	}
	public void setOrdertime(Date ordertime) 
	{
		this.ordertime = ordertime;
	}

	public Date getOrdertime() 
	{
		return ordertime;
	}
	public void setWashtime(Date washtime) 
	{
		this.washtime = washtime;
	}

	public Date getWashtime() 
	{
		return washtime;
	}
	public void setCabinetcode(String cabinetcode) 
	{
		this.cabinetcode = cabinetcode;
	}

	public String getCabinetcode() 
	{
		return cabinetcode;
	}
	public void setChestsite(String chestsite) 
	{
		this.chestsite = chestsite;
	}

	public String getChestsite() 
	{
		return chestsite;
	}
	public void setOrderstatus(String orderstatus) 
	{
		this.orderstatus = orderstatus;
	}

	public String getOrderstatus() 
	{
		return orderstatus;
	}
	public void setUsercarid(Integer usercarid) 
	{
		this.usercarid = usercarid;
	}

	public Integer getUsercarid() 
	{
		return usercarid;
	}
	public void setShopid(Integer shopid) 
	{
		this.shopid = shopid;
	}

	public Integer getShopid() 
	{
		return shopid;
	}
	public void setUserid(Integer userid) 
	{
		this.userid = userid;
	}

	public Integer getUserid() 
	{
		return userid;
	}
	public void setWashpersonpid(Integer washpersonpid) 
	{
		this.washpersonpid = washpersonpid;
	}

	public Integer getWashpersonpid() 
	{
		return washpersonpid;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orderid", getOrderid())
            .append("ordernumber", getOrdernumber())
            .append("ordertime", getOrdertime())
            .append("washtime", getWashtime())
            .append("cabinetcode", getCabinetcode())
            .append("chestsite", getChestsite())
            .append("orderstatus", getOrderstatus())
            .append("usercarid", getUsercarid())
            .append("shopid", getShopid())
            .append("userid", getUserid())
            .append("washpersonpid", getWashpersonpid())
            .toString();
    }
}

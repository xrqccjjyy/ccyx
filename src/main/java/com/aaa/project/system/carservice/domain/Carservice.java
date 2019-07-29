package com.aaa.project.system.carservice.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * 车辆服务套餐表 carservice
 * 
 * @author teacherChen
 * @date 2019-07-29
 */
public class Carservice extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 车辆服务套餐id */
	private Integer carserviceid;
	/** 套餐价格 */
	private BigDecimal carsereviceprice;
	/** 套餐内容 */
	private String carservicename;
	/** 商家id */
	private Integer shopid;

	public void setCarserviceid(Integer carserviceid) 
	{
		this.carserviceid = carserviceid;
	}

	public Integer getCarserviceid() 
	{
		return carserviceid;
	}
	public void setCarsereviceprice(BigDecimal carsereviceprice) 
	{
		this.carsereviceprice = carsereviceprice;
	}

	public BigDecimal getCarsereviceprice() 
	{
		return carsereviceprice;
	}
	public void setCarservicename(String carservicename) 
	{
		this.carservicename = carservicename;
	}

	public String getCarservicename() 
	{
		return carservicename;
	}
	public void setShopid(Integer shopid) 
	{
		this.shopid = shopid;
	}

	public Integer getShopid() 
	{
		return shopid;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("carserviceid", getCarserviceid())
            .append("carsereviceprice", getCarsereviceprice())
            .append("carservicename", getCarservicename())
            .append("shopid", getShopid())
            .toString();
    }
}

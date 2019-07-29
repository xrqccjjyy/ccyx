package com.aaa.project.system.shop.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * 商家表 shop
 * 
 * @author teacherChen
 * @date 2019-07-29
 */
public class Shop extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 商家id */
	private Integer shopid;
	/** 商家名称 */
	private String shopname;
	/** 经度 */
	private BigDecimal shoplongitude;
	/** 纬度 */
	private BigDecimal shoplatitude;
	/** 营业执照 */
	private String shoplicense;
	/** 身份证号 */
	private String shopidno;
	/** 商家地址 */
	private String shopaddress;

	public void setShopid(Integer shopid) 
	{
		this.shopid = shopid;
	}

	public Integer getShopid() 
	{
		return shopid;
	}
	public void setShopname(String shopname) 
	{
		this.shopname = shopname;
	}

	public String getShopname() 
	{
		return shopname;
	}
	public void setShoplongitude(BigDecimal shoplongitude) 
	{
		this.shoplongitude = shoplongitude;
	}

	public BigDecimal getShoplongitude() 
	{
		return shoplongitude;
	}
	public void setShoplatitude(BigDecimal shoplatitude) 
	{
		this.shoplatitude = shoplatitude;
	}

	public BigDecimal getShoplatitude() 
	{
		return shoplatitude;
	}
	public void setShoplicense(String shoplicense) 
	{
		this.shoplicense = shoplicense;
	}

	public String getShoplicense() 
	{
		return shoplicense;
	}
	public void setShopidno(String shopidno) 
	{
		this.shopidno = shopidno;
	}

	public String getShopidno() 
	{
		return shopidno;
	}
	public void setShopaddress(String shopaddress) 
	{
		this.shopaddress = shopaddress;
	}

	public String getShopaddress() 
	{
		return shopaddress;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("shopid", getShopid())
            .append("shopname", getShopname())
            .append("shoplongitude", getShoplongitude())
            .append("shoplatitude", getShoplatitude())
            .append("shoplicense", getShoplicense())
            .append("shopidno", getShopidno())
            .append("shopaddress", getShopaddress())
            .toString();
    }
}

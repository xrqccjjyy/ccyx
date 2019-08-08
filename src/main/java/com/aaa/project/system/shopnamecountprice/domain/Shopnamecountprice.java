package com.aaa.project.system.shopnamecountprice.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * 商家收入表 shopnamecountprice
 * 
 * @author CCYX-SZ34-02
 * @date 2019-08-08
 */
public class Shopnamecountprice extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 商家名称 */
	private String shopname;
	/** 订单总金额 */
	private BigDecimal countprice;

	public void setShopname(String shopname) 
	{
		this.shopname = shopname;
	}

	public String getShopname() 
	{
		return shopname;
	}
	public void setCountprice(BigDecimal countprice) 
	{
		this.countprice = countprice;
	}

	public BigDecimal getCountprice() 
	{
		return countprice;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("shopname", getShopname())
            .append("countprice", getCountprice())
            .toString();
    }
}

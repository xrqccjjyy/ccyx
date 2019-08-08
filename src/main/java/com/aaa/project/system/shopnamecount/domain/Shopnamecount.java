package com.aaa.project.system.shopnamecount.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;

/**
 * 商店订单数统计表 shopnamecount
 * 
 * @author CCYX-SZ34-02
 * @date 2019-08-07
 */
public class Shopnamecount extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 商店名称 */
	private String shopname;
	/** 订单总数量 */
	private Integer count;

	public void setShopname(String shopname) 
	{
		this.shopname = shopname;
	}

	public String getShopname() 
	{
		return shopname;
	}
	public void setCount(Integer count) 
	{
		this.count = count;
	}

	public Integer getCount() 
	{
		return count;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("shopname", getShopname())
            .append("count", getCount())
            .toString();
    }
}

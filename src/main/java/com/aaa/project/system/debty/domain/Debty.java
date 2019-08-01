package com.aaa.project.system.debty.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * 财务表 debty
 * 
 * @author CCYX-SZ34-02
 * @date 2019-08-01
 */
public class Debty extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 财务表id */
	private Integer debtyid;
	/** 收入 */
	private BigDecimal income;
	/** 亏损 */
	private BigDecimal loss;
	/** 商家id */
	private Integer shopid;

	/**套餐id*/
	private Integer carserviceid;

	/**订单id*/
	private Integer orderid;

	/**套餐价格*/
	private BigDecimal carsereviceprice;

	public Integer getCarserviceid() {
		return carserviceid;
	}

	public void setCarserviceid(Integer carserviceid) {
		this.carserviceid = carserviceid;
	}

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public BigDecimal getCarsereviceprice() {
		return carsereviceprice;
	}

	public void setCarsereviceprice(BigDecimal carsereviceprice) {
		this.carsereviceprice = carsereviceprice;
	}

	public void setDebtyid(Integer debtyid)
	{
		this.debtyid = debtyid;
	}

	public Integer getDebtyid() 
	{
		return debtyid;
	}
	public void setIncome(BigDecimal income) 
	{
		this.income = income;
	}

	public BigDecimal getIncome() 
	{
		return income;
	}
	public void setLoss(BigDecimal loss) 
	{
		this.loss = loss;
	}

	public BigDecimal getLoss() 
	{
		return loss;
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
            .append("debtyid", getDebtyid())
            .append("income", getIncome())
            .append("loss", getLoss())
            .append("shopid", getShopid())
            .toString();
    }
}

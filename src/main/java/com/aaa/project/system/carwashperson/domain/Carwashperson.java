package com.aaa.project.system.carwashperson.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;

/**
 * 洗车人员表 carwashperson
 * 
 * @author teacherChen
 * @date 2019-07-29
 */
public class Carwashperson extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 洗车人员id */
	private Integer washpersonpid;
	/** 洗车人员手机号 */
	private String washpersonphone;
	/** 洗车人员姓名 */
	private String washpersonname;
	/** 商家id */
	private Integer shopid;
	/** 洗车人员状态 */
	private String washpersonstatus;

	public void setWashpersonpid(Integer washpersonpid) 
	{
		this.washpersonpid = washpersonpid;
	}

	public Integer getWashpersonpid() 
	{
		return washpersonpid;
	}
	public void setWashpersonphone(String washpersonphone) 
	{
		this.washpersonphone = washpersonphone;
	}

	public String getWashpersonphone() 
	{
		return washpersonphone;
	}
	public void setWashpersonname(String washpersonname) 
	{
		this.washpersonname = washpersonname;
	}

	public String getWashpersonname() 
	{
		return washpersonname;
	}
	public void setShopid(Integer shopid) 
	{
		this.shopid = shopid;
	}

	public Integer getShopid() 
	{
		return shopid;
	}
	public void setWashpersonstatus(String washpersonstatus) 
	{
		this.washpersonstatus = washpersonstatus;
	}

	public String getWashpersonstatus() 
	{
		return washpersonstatus;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("washpersonpid", getWashpersonpid())
            .append("washpersonphone", getWashpersonphone())
            .append("washpersonname", getWashpersonname())
            .append("shopid", getShopid())
            .append("washpersonstatus", getWashpersonstatus())
            .toString();
    }
}

package com.aaa.project.system.customer.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;

/**
 * 用户表 customer
 * 
 * @author teacherChen
 * @date 2019-07-29
 */
public class Customer extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 用户id */
	private Integer userid;
	/** 用户名 */
	private String username;
	/** 用户手机号 */
	private String userphone;
	/** 用户车辆信息id */
	private Integer usercarid;

	public void setUserid(Integer userid) 
	{
		this.userid = userid;
	}

	public Integer getUserid() 
	{
		return userid;
	}
	public void setUsername(String username) 
	{
		this.username = username;
	}

	public String getUsername() 
	{
		return username;
	}
	public void setUserphone(String userphone) 
	{
		this.userphone = userphone;
	}

	public String getUserphone() 
	{
		return userphone;
	}
	public void setUsercarid(Integer usercarid) 
	{
		this.usercarid = usercarid;
	}

	public Integer getUsercarid() 
	{
		return usercarid;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userid", getUserid())
            .append("username", getUsername())
            .append("userphone", getUserphone())
            .append("usercarid", getUsercarid())
            .toString();
    }
}

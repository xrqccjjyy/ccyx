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

	private String usercarnumber;

	private String usercarbrandname;

	private String usercarphoto;

	private String usercarcolor;

	private String usercarlocation;

	public String getUsercarnumber() {
		return usercarnumber;
	}

	public void setUsercarnumber(String usercarnumber) {
		this.usercarnumber = usercarnumber;
	}

	public String getUsercarbrandname() {
		return usercarbrandname;
	}

	public void setUsercarbrandname(String usercarbrandname) {
		this.usercarbrandname = usercarbrandname;
	}

	public String getUsercarphoto() {
		return usercarphoto;
	}

	public void setUsercarphoto(String usercarphoto) {
		this.usercarphoto = usercarphoto;
	}

	public String getUsercarcolor() {
		return usercarcolor;
	}

	public void setUsercarcolor(String usercarcolor) {
		this.usercarcolor = usercarcolor;
	}

	public String getUsercarlocation() {
		return usercarlocation;
	}

	public void setUsercarlocation(String usercarlocation) {
		this.usercarlocation = usercarlocation;
	}

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

	@Override
	public String toString() {
		return "Customer{" +
				"userid=" + userid +
				", username='" + username + '\'' +
				", userphone='" + userphone + '\'' +
				", usercarid=" + usercarid +
				", usercarnumber='" + usercarnumber + '\'' +
				", usercarbrandname='" + usercarbrandname + '\'' +
				", usercarphoto='" + usercarphoto + '\'' +
				", usercarcolor='" + usercarcolor + '\'' +
				", usercarlocation='" + usercarlocation + '\'' +
				'}';
	}
}

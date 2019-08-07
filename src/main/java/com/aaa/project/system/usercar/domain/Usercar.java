package com.aaa.project.system.usercar.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;

/**
 * 用户车辆表 usercar
 * 
 * @author teacherChen
 * @date 2019-07-29
 */
public class Usercar extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 车辆id */
	private Integer usercarid;
	/** 车牌号 */
	private String usercarnumber;
	/** 车辆品牌名称 */
	private String usercarbrandname;
	/** 车辆照片 */
	private String usercarphoto;
	/** 车辆颜色 */
	private String usercarcolor;
	/** 车辆停放位置 */
	private String usercarlocation;

	private Integer userid;

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public void setUsercarid(Integer usercarid)
	{
		this.usercarid = usercarid;
	}

	public Integer getUsercarid() 
	{
		return usercarid;
	}
	public void setUsercarnumber(String usercarnumber) 
	{
		this.usercarnumber = usercarnumber;
	}

	public String getUsercarnumber() 
	{
		return usercarnumber;
	}
	public void setUsercarbrandname(String usercarbrandname) 
	{
		this.usercarbrandname = usercarbrandname;
	}

	public String getUsercarbrandname() 
	{
		return usercarbrandname;
	}
	public void setUsercarphoto(String usercarphoto) 
	{
		this.usercarphoto = usercarphoto;
	}

	public String getUsercarphoto() 
	{
		return usercarphoto;
	}
	public void setUsercarcolor(String usercarcolor) 
	{
		this.usercarcolor = usercarcolor;
	}

	public String getUsercarcolor() 
	{
		return usercarcolor;
	}
	public void setUsercarlocation(String usercarlocation) 
	{
		this.usercarlocation = usercarlocation;
	}

	public String getUsercarlocation() 
	{
		return usercarlocation;
	}

	@Override
	public String toString() {
		return "Usercar{" +
				"usercarid=" + usercarid +
				", usercarnumber='" + usercarnumber + '\'' +
				", usercarbrandname='" + usercarbrandname + '\'' +
				", usercarphoto='" + usercarphoto + '\'' +
				", usercarcolor='" + usercarcolor + '\'' +
				", usercarlocation='" + usercarlocation + '\'' +
				", userid=" + userid +
				'}';
	}
}

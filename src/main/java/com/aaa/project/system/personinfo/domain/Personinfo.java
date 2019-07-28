package com.aaa.project.system.personinfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;

/**
 * 人员表 personinfo
 * 
 * @author teacherChen
 * @date 2019-07-23
 */
public class Personinfo extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 人员编号 */
	private Integer personid;
	/** 人员名称 */
	private String personname;
	/** 户口所在地id */
	private Integer personareaid;
	/** 人员年龄 */
	private Integer personage;
	/** 家庭地址 */
	private String personaddress;

	private String areaname;

	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

	public void setPersonid(Integer personid)
	{
		this.personid = personid;
	}

	public Integer getPersonid() 
	{
		return personid;
	}
	public void setPersonname(String personname) 
	{
		this.personname = personname;
	}

	public String getPersonname() 
	{
		return personname;
	}
	public void setPersonareaid(Integer personareaid) 
	{
		this.personareaid = personareaid;
	}

	public Integer getPersonareaid() 
	{
		return personareaid;
	}
	public void setPersonage(Integer personage) 
	{
		this.personage = personage;
	}

	public Integer getPersonage() 
	{
		return personage;
	}
	public void setPersonaddress(String personaddress) 
	{
		this.personaddress = personaddress;
	}

	public String getPersonaddress() 
	{
		return personaddress;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("personid", getPersonid())
            .append("personname", getPersonname())
            .append("personareaid", getPersonareaid())
            .append("personage", getPersonage())
            .append("personaddress", getPersonaddress())
            .toString();
    }
}

package com.aaa.project.system.areainfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;

/**
 * 户口所在地表 areainfo
 * 
 * @author teacherChen
 * @date 2019-07-23
 */
public class Areainfo extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 地区编号 */
	private Integer areaid;
	/** 地区名称 */
	private String areaname;

	public void setAreaid(Integer areaid) 
	{
		this.areaid = areaid;
	}

	public Integer getAreaid() 
	{
		return areaid;
	}
	public void setAreaname(String areaname) 
	{
		this.areaname = areaname;
	}

	public String getAreaname() 
	{
		return areaname;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("areaid", getAreaid())
            .append("areaname", getAreaname())
            .toString();
    }
}

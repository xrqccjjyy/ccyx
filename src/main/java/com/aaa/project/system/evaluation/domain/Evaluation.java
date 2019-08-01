package com.aaa.project.system.evaluation.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;

/**
 * 客户评价/投诉表 evaluation
 * 
 * @author teacherChen
 * @date 2019-07-29
 */
public class Evaluation extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 评价表id */
	private Integer clientid;
	/** 评价信息 */
	private String clientmessage;
	/** 投诉信息 */
	private String complain;
	/** 洗车人员id */
	private Integer washpersonpid;

	/** 洗车人员姓名 */
	private String washpersonname;

	public String getWashpersonname() {
		return washpersonname;
	}

	public void setWashpersonname(String washpersonname) {
		this.washpersonname = washpersonname;
	}

	public void setClientid(Integer clientid)
	{
		this.clientid = clientid;
	}

	public Integer getClientid() 
	{
		return clientid;
	}
	public void setClientmessage(String clientmessage) 
	{
		this.clientmessage = clientmessage;
	}

	public String getClientmessage() 
	{
		return clientmessage;
	}
	public void setComplain(String complain) 
	{
		this.complain = complain;
	}

	public String getComplain() 
	{
		return complain;
	}
	public void setWashpersonpid(Integer washpersonpid) 
	{
		this.washpersonpid = washpersonpid;
	}

	public Integer getWashpersonpid() 
	{
		return washpersonpid;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("clientid", getClientid())
            .append("clientmessage", getClientmessage())
            .append("complain", getComplain())
            .append("washpersonpid", getWashpersonpid())
            .toString();
    }
}

package com.aaa.project.system.code.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;

/**
 * 验证码表 code
 * 
 * @author CCYX-SZ34-02
 * @date 2019-08-05
 */
public class Code extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 验证码id */
	private Integer codeid;
	/** 手机号 */
	private String userphone;
	/** 验证号 */
	private Integer codenum;

	public void setCodeid(Integer codeid) 
	{
		this.codeid = codeid;
	}

	public Integer getCodeid() 
	{
		return codeid;
	}
	public void setUserphone(String userphone) 
	{
		this.userphone = userphone;
	}

	public String getUserphone() 
	{
		return userphone;
	}
	public void setCodenum(Integer codenum) 
	{
		this.codenum = codenum;
	}

	public Integer getCodenum() 
	{
		return codenum;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("codeid", getCodeid())
            .append("userphone", getUserphone())
            .append("codenum", getCodenum())
            .toString();
    }
}

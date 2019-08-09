package com.aaa.project.system.carimage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;

/**
 * 车辆图片表 carimage
 * 
 * @author CCYX-SZ34-02
 * @date 2019-08-06
 */
public class Carimage extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 编号 */
	private Integer id;
	/** 车辆信息编号 */
	private Integer carinfoid;
	/** 图片url */
	private String imageurl;

	@Override
	public String getSearchValue() {
		return super.getSearchValue();
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setCarinfoid(Integer carinfoid) 
	{
		this.carinfoid = carinfoid;
	}

	public Integer getCarinfoid() 
	{
		return carinfoid;
	}
	public void setImageurl(String imageurl) 
	{
		this.imageurl = imageurl;
	}

	public String getImageurl() 
	{
		return imageurl;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("carinfoid", getCarinfoid())
            .append("imageurl", getImageurl())
            .toString();
    }

}

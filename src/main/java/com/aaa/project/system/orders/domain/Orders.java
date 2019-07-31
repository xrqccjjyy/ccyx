package com.aaa.project.system.orders.domain;

import com.aaa.project.system.customer.domain.Customer;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 订单表 orders
 * 
 * @author teacherChen
 * @date 2019-07-29
 */
public class Orders extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 订单id */
	private Integer orderid;
	/** 订单编号 */
	private String ordernumber;
	/** 下单时间 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date ordertime;
	/** 洗车时间 */
	private Date washtime;
	/** 钥匙柜取件码 */
	private String cabinetcode;
	/** 柜子位置信息 */
	private String chestsite;
	/** 订单状态 */
	private String orderstatus;
	/** 车辆信息id */
	private Integer usercarid;
	/** 商家id */
	private Integer shopid;
	/** 用户id */
	private Integer userid;
	/** 洗车人员id */
	private Integer washpersonpid;
	/** 套餐id */
	private Integer carserviceid;

	/**客户名*/
	private String  username;
	/**客户电话*/
	private String userphone;
	/**车牌号*/
	private String  usercarnumber;
	/**车品牌*/
	private String usercarbrandname;
	/**车颜色*/
	private String usercarcolor;
	/**车位置*/
	private String  usercarlocation;
	/**套餐*/
	private String carservicename;
	/**商家地址*/
	private String shopaddress;
	/**洗车人*/
	private String washpersonname;

	private String carsereviceprice;

	public String getCarsereviceprice() {
		return carsereviceprice;
	}

	public void setCarsereviceprice(String carsereviceprice) {
		this.carsereviceprice = carsereviceprice;
	}



	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserphone() {
		return userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

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

	public String getCarservicename() {
		return carservicename;
	}

	public void setCarservicename(String carservicename) {
		this.carservicename = carservicename;
	}

	public String getShopaddress() {
		return shopaddress;
	}

	public void setShopaddress(String shopaddress) {
		this.shopaddress = shopaddress;
	}

	public String getWashpersonname() {
		return washpersonname;
	}

	public void setWashpersonname(String washpersonname) {
		this.washpersonname = washpersonname;
	}

	public void setOrderid(Integer orderid)
	{
		this.orderid = orderid;
	}

	public Integer getOrderid() 
	{
		return orderid;
	}
	public void setOrdernumber(String ordernumber) 
	{
		this.ordernumber = ordernumber;
	}

	public String getOrdernumber() 
	{
		return ordernumber;
	}
	public void setOrdertime(Date ordertime) 
	{
		this.ordertime = ordertime;
	}

	public Date getOrdertime() 
	{
		return ordertime;
	}
	public void setWashtime(Date washtime) 
	{
		this.washtime = washtime;
	}

	public Date getWashtime() 
	{
		return washtime;
	}
	public void setCabinetcode(String cabinetcode) 
	{
		this.cabinetcode = cabinetcode;
	}

	public String getCabinetcode() 
	{
		return cabinetcode;
	}
	public void setChestsite(String chestsite) 
	{
		this.chestsite = chestsite;
	}

	public String getChestsite() 
	{
		return chestsite;
	}
	public void setOrderstatus(String orderstatus) 
	{
		this.orderstatus = orderstatus;
	}

	public String getOrderstatus() 
	{
		return orderstatus;
	}
	public void setUsercarid(Integer usercarid) 
	{
		this.usercarid = usercarid;
	}

	public Integer getUsercarid() 
	{
		return usercarid;
	}
	public void setShopid(Integer shopid) 
	{
		this.shopid = shopid;
	}

	public Integer getShopid() 
	{
		return shopid;
	}
	public void setUserid(Integer userid) 
	{
		this.userid = userid;
	}

	public Integer getUserid() 
	{
		return userid;
	}
	public void setWashpersonpid(Integer washpersonpid) 
	{
		this.washpersonpid = washpersonpid;
	}

	public Integer getWashpersonpid() 
	{
		return washpersonpid;
	}
	public void setCarserviceid(Integer carserviceid) 
	{
		this.carserviceid = carserviceid;
	}

	public Integer getCarserviceid() 
	{
		return carserviceid;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orderid", getOrderid())
            .append("ordernumber", getOrdernumber())
            .append("ordertime", getOrdertime())
            .append("washtime", getWashtime())
            .append("cabinetcode", getCabinetcode())
            .append("chestsite", getChestsite())
            .append("orderstatus", getOrderstatus())
            .append("usercarid", getUsercarid())
            .append("shopid", getShopid())
            .append("userid", getUserid())
            .append("washpersonpid", getWashpersonpid())
            .append("carserviceid", getCarserviceid())
            .toString();
    }
}

package com.baomidou.springwind.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import java.io.Serializable;


/**
 * <p>
 * 
 * </p>
 *
 * @author zhyonk
 * @since 2018-04-07
 */
public class Customer extends Model<Customer> {

    private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer credits;
	@TableField("name_default")
	private String nameDefault;
	@TableField("name_custom")
	private String nameCustom;
	@TableField("head_img_default")
	private String headImgDefault;
	@TableField("head_img_custom")
	private String headImgCustom;
	private Integer orderid;
	private Integer addressid;
	private String location;
	private Date crTime;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCredits() {
		return credits;
	}

	public void setCredits(Integer credits) {
		this.credits = credits;
	}

	public String getNameDefault() {
		return nameDefault;
	}

	public void setNameDefault(String nameDefault) {
		this.nameDefault = nameDefault;
	}

	public String getNameCustom() {
		return nameCustom;
	}

	public void setNameCustom(String nameCustom) {
		this.nameCustom = nameCustom;
	}

	public String getHeadImgDefault() {
		return headImgDefault;
	}

	public void setHeadImgDefault(String headImgDefault) {
		this.headImgDefault = headImgDefault;
	}

	public String getHeadImgCustom() {
		return headImgCustom;
	}

	public void setHeadImgCustom(String headImgCustom) {
		this.headImgCustom = headImgCustom;
	}

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public Integer getAddressid() {
		return addressid;
	}

	public void setAddressid(Integer addressid) {
		this.addressid = addressid;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getCrTime() {
		return crTime;
	}

	public void setCrTime(Date crTime) {
		this.crTime = crTime;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}

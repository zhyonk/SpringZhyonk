package com.baomidou.springwind.entity;

import com.baomidou.mybatisplus.activerecord.Model;
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
public class Address extends Model<Address> {

    private static final long serialVersionUID = 1L;

	private Integer id;
	@TableField("consignee_name")
	private String consigneeName;
	private String phone;
	private String province;
	private String city;
	private String area;
	@TableField("street_detail")
	private String streetDetail;
	private Integer defalut;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getConsigneeName() {
		return consigneeName;
	}

	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getStreetDetail() {
		return streetDetail;
	}

	public void setStreetDetail(String streetDetail) {
		this.streetDetail = streetDetail;
	}

	public Integer getDefalut() {
		return defalut;
	}

	public void setDefalut(Integer defalut) {
		this.defalut = defalut;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}

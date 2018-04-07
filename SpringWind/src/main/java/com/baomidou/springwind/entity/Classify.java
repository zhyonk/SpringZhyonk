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
public class Classify extends Model<Classify> {

    private static final long serialVersionUID = 1L;

	private Integer id;
	@TableField("c_name")
	private String cName;
	@TableField("c_img")
	private String cImg;
	@TableField("c_status")
	private Integer cStatus;
	@TableField("c_sort")
	private Integer cSort;
	@TableField("c_url")
	private String cUrl;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCName() {
		return cName;
	}

	public void setCName(String cName) {
		this.cName = cName;
	}

	public String getCImg() {
		return cImg;
	}

	public void setCImg(String cImg) {
		this.cImg = cImg;
	}

	public Integer getCStatus() {
		return cStatus;
	}

	public void setCStatus(Integer cStatus) {
		this.cStatus = cStatus;
	}

	public Integer getCSort() {
		return cSort;
	}

	public void setCSort(Integer cSort) {
		this.cSort = cSort;
	}

	public String getCUrl() {
		return cUrl;
	}

	public void setCUrl(String cUrl) {
		this.cUrl = cUrl;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}

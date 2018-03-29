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
 * @since 2018-03-28
 */
public class Yuyue extends Model<Yuyue> {

    private static final long serialVersionUID = 1L;

	private Integer id;
	private String jishiid;
	private String kehuid;
	private Date crTime;
	private Integer yyType;
	private Integer status;
	private Integer yytime;
	private String location;
	@TableField("type_id")
	private Integer typeId;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getJishiid() {
		return jishiid;
	}

	public void setJishiid(String jishiid) {
		this.jishiid = jishiid;
	}

	public String getKehuid() {
		return kehuid;
	}

	public void setKehuid(String kehuid) {
		this.kehuid = kehuid;
	}

	public Date getCrTime() {
		return crTime;
	}

	public void setCrTime(Date crTime) {
		this.crTime = crTime;
	}

	public Integer getYyType() {
		return yyType;
	}

	public void setYyType(Integer yyType) {
		this.yyType = yyType;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getYytime() {
		return yytime;
	}

	public void setYytime(Integer yytime) {
		this.yytime = yytime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}

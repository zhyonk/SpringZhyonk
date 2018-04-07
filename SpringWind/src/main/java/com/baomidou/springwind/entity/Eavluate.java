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
public class Eavluate extends Model<Eavluate> {

    private static final long serialVersionUID = 1L;

	private Integer id;
	@TableField("coustomer_id")
	private Integer coustomerId;
	private String type;
	private String countent;
	private Date crTime;
    /**
     * 0(默认不匿名)1匿名
     */
	@TableField("is_anonymous")
	private Integer isAnonymous;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCoustomerId() {
		return coustomerId;
	}

	public void setCoustomerId(Integer coustomerId) {
		this.coustomerId = coustomerId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCountent() {
		return countent;
	}

	public void setCountent(String countent) {
		this.countent = countent;
	}

	public Date getCrTime() {
		return crTime;
	}

	public void setCrTime(Date crTime) {
		this.crTime = crTime;
	}

	public Integer getIsAnonymous() {
		return isAnonymous;
	}

	public void setIsAnonymous(Integer isAnonymous) {
		this.isAnonymous = isAnonymous;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}

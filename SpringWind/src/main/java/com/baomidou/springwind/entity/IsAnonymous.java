package com.baomidou.springwind.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;


/**
 * <p>
 * 
 * </p>
 *
 * @author zhyonk
 * @since 2018-04-07
 */
@TableName("is_anonymous")
public class IsAnonymous extends Model<IsAnonymous> {

    private static final long serialVersionUID = 1L;

	@TableId("coustomer_id")
	private Integer coustomerId;
	private Integer type;
	private String countent;
	private Date crTime;
	@TableField("is_anonymous")
	private Integer isAnonymous;


	public Integer getCoustomerId() {
		return coustomerId;
	}

	public void setCoustomerId(Integer coustomerId) {
		this.coustomerId = coustomerId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
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
		return this.coustomerId;
	}

}

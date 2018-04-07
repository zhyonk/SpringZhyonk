package com.baomidou.springwind.entity;

import com.baomidou.mybatisplus.activerecord.Model;
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
@TableName("credits_type")
public class CreditsType extends Model<CreditsType> {

    private static final long serialVersionUID = 1L;

	private Integer id;
	private String value;
	private String explan;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getExplan() {
		return explan;
	}

	public void setExplan(String explan) {
		this.explan = explan;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}

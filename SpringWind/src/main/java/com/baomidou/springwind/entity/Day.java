package com.baomidou.springwind.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;


/**
 * <p>
 * 
 * </p>
 *
 * @author zhyonk
 * @since 2018-04-07
 */
public class Day extends Model<Day> {

    private static final long serialVersionUID = 1L;

	private Integer id;
	private String day;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}

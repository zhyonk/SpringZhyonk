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
@TableName("local_user_relation")
public class LocalUserRelation extends Model<LocalUserRelation> {

    private static final long serialVersionUID = 1L;

	private String fuid;
	private String ziid;


	public String getFuid() {
		return fuid;
	}

	public void setFuid(String fuid) {
		this.fuid = fuid;
	}

	public String getZiid() {
		return ziid;
	}

	public void setZiid(String ziid) {
		this.ziid = ziid;
	}

	@Override
	protected Serializable pkVal() {
		return this.ziid;
	}

}

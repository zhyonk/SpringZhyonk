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
public class Dresser extends Model<Dresser> {

    private static final long serialVersionUID = 1L;

	private Integer id;
	@TableField("p_name")
	private String pName;
	@TableField("p_sex")
	private Integer pSex;
	@TableField("p_head_image")
	private String pHeadImage;
	@TableField("p_describe")
	private String pDescribe;
    /**
     * 0未认证1已认证
     */
	@TableField("p_certification")
	private Integer pCertification;
	@TableField("p_status")
	private Integer pStatus;
	@TableField("p_appraise_info_id")
	private Integer pAppraiseInfoId;
	@TableField("p_belongto_shop")
	private String pBelongtoShop;
    /**
     * 美容，低级，高级，资深
     */
	@TableField("p_name_type")
	private Integer pNameType;
	@TableField("p_work_year")
	private String pWorkYear;
	@TableField("p_be_good_at_info")
	private String pBeGoodAtInfo;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPName() {
		return pName;
	}

	public void setPName(String pName) {
		this.pName = pName;
	}

	public Integer getPSex() {
		return pSex;
	}

	public void setPSex(Integer pSex) {
		this.pSex = pSex;
	}

	public String getPHeadImage() {
		return pHeadImage;
	}

	public void setPHeadImage(String pHeadImage) {
		this.pHeadImage = pHeadImage;
	}

	public String getPDescribe() {
		return pDescribe;
	}

	public void setPDescribe(String pDescribe) {
		this.pDescribe = pDescribe;
	}

	public Integer getPCertification() {
		return pCertification;
	}

	public void setPCertification(Integer pCertification) {
		this.pCertification = pCertification;
	}

	public Integer getPStatus() {
		return pStatus;
	}

	public void setPStatus(Integer pStatus) {
		this.pStatus = pStatus;
	}

	public Integer getPAppraiseInfoId() {
		return pAppraiseInfoId;
	}

	public void setPAppraiseInfoId(Integer pAppraiseInfoId) {
		this.pAppraiseInfoId = pAppraiseInfoId;
	}

	public String getPBelongtoShop() {
		return pBelongtoShop;
	}

	public void setPBelongtoShop(String pBelongtoShop) {
		this.pBelongtoShop = pBelongtoShop;
	}

	public Integer getPNameType() {
		return pNameType;
	}

	public void setPNameType(Integer pNameType) {
		this.pNameType = pNameType;
	}

	public String getPWorkYear() {
		return pWorkYear;
	}

	public void setPWorkYear(String pWorkYear) {
		this.pWorkYear = pWorkYear;
	}

	public String getPBeGoodAtInfo() {
		return pBeGoodAtInfo;
	}

	public void setPBeGoodAtInfo(String pBeGoodAtInfo) {
		this.pBeGoodAtInfo = pBeGoodAtInfo;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}

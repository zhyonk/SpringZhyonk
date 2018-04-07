package com.baomidou.springwind.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import java.math.BigDecimal;
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
public class Goods extends Model<Goods> {

    private static final long serialVersionUID = 1L;

	private Integer id;
	@TableField("g_name")
	private String gName;
	@TableField("g_classify_id")
	private Integer gClassifyId;
	@TableField("g_old_price")
	private BigDecimal gOldPrice;
	@TableField("g_now_price")
	private BigDecimal gNowPrice;
	@TableField("g_banner")
	private String gBanner;
	@TableField("g_shop_number")
	private Integer gShopNumber;
	@TableField("g_package_number")
	private Integer gPackageNumber;
	@TableField("cost_time")
	private String costTime;
	@TableField("keep_time")
	private String keepTime;
	@TableField("order_count")
	private Integer orderCount;
	@TableField("g_url")
	private String gUrl;
	@TableField("g_status")
	private Integer gStatus;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGName() {
		return gName;
	}

	public void setGName(String gName) {
		this.gName = gName;
	}

	public Integer getGClassifyId() {
		return gClassifyId;
	}

	public void setGClassifyId(Integer gClassifyId) {
		this.gClassifyId = gClassifyId;
	}

	public BigDecimal getGOldPrice() {
		return gOldPrice;
	}

	public void setGOldPrice(BigDecimal gOldPrice) {
		this.gOldPrice = gOldPrice;
	}

	public BigDecimal getGNowPrice() {
		return gNowPrice;
	}

	public void setGNowPrice(BigDecimal gNowPrice) {
		this.gNowPrice = gNowPrice;
	}

	public String getGBanner() {
		return gBanner;
	}

	public void setGBanner(String gBanner) {
		this.gBanner = gBanner;
	}

	public Integer getGShopNumber() {
		return gShopNumber;
	}

	public void setGShopNumber(Integer gShopNumber) {
		this.gShopNumber = gShopNumber;
	}

	public Integer getGPackageNumber() {
		return gPackageNumber;
	}

	public void setGPackageNumber(Integer gPackageNumber) {
		this.gPackageNumber = gPackageNumber;
	}

	public String getCostTime() {
		return costTime;
	}

	public void setCostTime(String costTime) {
		this.costTime = costTime;
	}

	public String getKeepTime() {
		return keepTime;
	}

	public void setKeepTime(String keepTime) {
		this.keepTime = keepTime;
	}

	public Integer getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(Integer orderCount) {
		this.orderCount = orderCount;
	}

	public String getGUrl() {
		return gUrl;
	}

	public void setGUrl(String gUrl) {
		this.gUrl = gUrl;
	}

	public Integer getGStatus() {
		return gStatus;
	}

	public void setGStatus(Integer gStatus) {
		this.gStatus = gStatus;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}

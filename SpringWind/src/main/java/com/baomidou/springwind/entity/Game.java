package com.baomidou.springwind.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;


/**
 * <p>
 * 
 * </p>
 *
 * @author zhyonk
 * @since 2018-02-04
 */
public class Game extends Model<Game> {

    private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String image;
	private String url;
	private String title;
	private String description;
	private String type;
	private Integer status;
	private Long playcount;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getPlaycount() {
		return playcount;
	}

	public void setPlaycount(Long playcount) {
		this.playcount = playcount;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}

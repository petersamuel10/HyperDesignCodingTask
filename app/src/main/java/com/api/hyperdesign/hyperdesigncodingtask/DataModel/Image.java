package com.api.hyperdesign.hyperdesigncodingtask.DataModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image{
	@SerializedName("width")
	@Expose
	private Integer width;
	@SerializedName("height")
	@Expose
	private Integer height;
	@SerializedName("url")
	@Expose
	private String url;

	public void setWidth(int width){
		this.width = width;
	}

	public int getWidth(){
		return width;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setHeight(int height){
		this.height = height;
	}

	public int getHeight(){
		return height;
	}

}

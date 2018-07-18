package com.api.hyperdesign.hyperdesigncodingtask.DataModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {

	@SerializedName("id")
	@Expose
	private Object id;
	@SerializedName("productDescription")
	@Expose
	private String productDescription;
	@SerializedName("image")
	@Expose
	private Image image;
	@SerializedName("price")
	@Expose
	private Integer price;

	public void setImage(Image image){
		this.image = image;
	}

	public Image getImage(){
		return image;
	}

	public void setPrice(int price){
		this.price = price;
	}

	public int getPrice(){
		return price;
	}

	public void setId(Object id){
		this.id = id;
	}

	public Object getId(){
		return id;
	}

	public void setProductDescription(String productDescription){
		this.productDescription = productDescription;
	}

	public String getProductDescription(){
		return productDescription;
	}

}

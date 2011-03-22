package com.androidpeople.xml.parsing;

import java.util.ArrayList;
import java.lang.String;

/** Contains getter and setter method for varialbles  */
public class SitesList {

	/** Variables */
	private String imageUrl = new String();
	private String description = new String();
	private ArrayList<String> category = new ArrayList<String>();
	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param currentValue the category to set
	 */
	public void setCategory(String currentValue) {
		this.category.add(currentValue);
	}
	/**
	 * @return the category
	 */
	public ArrayList<String> getCategory() {
		return category;
	}

	
	

}

package com.animal.commons.pojo;

import com.animal.pojo.DwItem;

public class DwItemChild extends DwItem {
	private String [] images;
	
	/**
	 * 库存是否足
	 */
	private Boolean enough;
	
	public Boolean getEnough() {
		return enough;
	}

	public void setEnough(Boolean enough) {
		this.enough = enough;
	}

	public String[] getImages() {
		return images;
	}

	public void setImages(String[] images) {
		this.images = images;
	}
	
}

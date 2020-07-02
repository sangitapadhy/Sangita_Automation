package com.TestResources;

public enum APIResources {
	
	AddplaceAPI("/maps/api/place/add/json"),
	PutplaceAPI("/maps/api/place/update/json"),
	DeleteplaceAPI("/maps/api/place/delete/json"),
	GetplaceAPI("/maps/api/place/get/json");
	
	private String Resources;

	private APIResources(String resources) {
		
		Resources = resources;
		
	}
	
	public String getResources() {
		
		return Resources;
		
	}
}

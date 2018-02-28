package com.cts.search.model;

import java.util.List;

public class SearchRequest {

	String location;
	
	List<String> listSearchKey;
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<String> getListSearchKey() {
		return listSearchKey;
	}

	public void setListSearchKey(List<String> listSearchKey) {
		this.listSearchKey = listSearchKey;
	}

}

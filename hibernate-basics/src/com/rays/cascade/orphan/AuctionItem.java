package com.rays.cascade.orphan;

import java.util.Set;

public class AuctionItem {

	private int id;
	private Set bids;
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set getBids() {
		return bids;
	}

	public void setBids(Set bids) {
		this.bids = bids;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

package com.estate.model.response;

import java.math.BigDecimal;

public class BuildingSearchResponse {
	private String nameBuilding;
	private String address;
	private String nameManager;
	private String phoneManager;
	private int floorArea;
	private int rentPrice;
	private String serviceFee;
	private BigDecimal brokerageFee;
	private String rentArea;
	
	public String getNameBuilding() {
		return nameBuilding;
	}
	public void setNameBuilding(String nameBuilding) {
		this.nameBuilding = nameBuilding;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNameManager() {
		return nameManager;
	}
	public void setNameManager(String nameManager) {
		this.nameManager = nameManager;
	}
	public String getPhoneManager() {
		return phoneManager;
	}
	public void setPhoneManager(String phoneManager) {
		this.phoneManager = phoneManager;
	}
	public int getFloorArea() {
		return floorArea;
	}
	public void setFloorArea(int floorArea) {
		this.floorArea = floorArea;
	}
	public int getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(int rentPrice) {
		this.rentPrice = rentPrice;
	}
	public String getServiceFee() {
		return serviceFee;
	}
	public void setServiceFee(String serviceFee) {
		this.serviceFee = serviceFee;
	}
	public BigDecimal getBrokerageFee() {
		return brokerageFee;
	}
	public void setBrokerageFee(BigDecimal brokerageFee) {
		this.brokerageFee = brokerageFee;
	}
	public String getRentArea() {
		return rentArea;
	}
	public void setRentArea(String rentArea) {
		this.rentArea = rentArea;
	}
}

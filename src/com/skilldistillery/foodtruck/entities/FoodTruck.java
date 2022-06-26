package com.skilldistillery.foodtruck.entities;

public class FoodTruck {

	private static int nextTruckId = 1;
	private int truckId;
	private String truckName;
	private String foodType;
	private int truckRating;
	

	public FoodTruck() {
	}
	
	public FoodTruck(String truckName, String foodType, int truckRating) {
		this.truckName = truckName;
		this.foodType = foodType;
		this.truckRating = truckRating;
		this.truckId = nextTruckId;
		
		nextTruckId++;
	}
	
	public String getTruckName() {
		return truckName;
	}

	public void setTruckName(String truckName) {
		this.truckName = truckName;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public int getTruckRating() {
		return truckRating;
	}

	public void setTruckRating(int truckRating) {
		this.truckRating = truckRating;
	}

	public String toString() {
		return  truckName + " serves " + foodType
				+ " and has a rating of " + truckRating + ". TruckId : " + truckId;
	}


	
	
	
	

}

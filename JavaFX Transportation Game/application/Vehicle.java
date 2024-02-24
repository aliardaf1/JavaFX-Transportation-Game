package application;

public class Vehicle {
	public int currentCityId;
	public int passengerCapacity;
	
	public Vehicle(int currentCityId, int passengerCapacity) {
		this.passengerCapacity = passengerCapacity;
		this.currentCityId = currentCityId;
	}

	public int getCurrentCityId() {
		return currentCityId;
	}

	public int getPassengerCapacity() {
		return passengerCapacity;
	}
}

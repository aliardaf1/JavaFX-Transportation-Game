package application;

public class City {
	private int cellId;
	private int cityId;
	private String cityName;
	
	public City(String city, int cell, int id) {
		cellId = cell;
		cityName = city;
		cityId = id;
	}

	public int getCellId() {
		return cellId;
	}

	public int getCityId() {
		return cityId;
	}

}

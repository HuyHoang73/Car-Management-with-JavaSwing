package productmanagement.model.entity;

import java.io.Serializable;

public class Car extends Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numberOfSeats;
	private String manufacturer;
	private String color;
	
	public Car() {
		super();
	}

	public Car(int product_id, String product_name, double product_price, int product_total, int numberOfSeats,
			String manufacturer, String color) {
		super(product_id, product_name, product_price, product_total);
		this.numberOfSeats = numberOfSeats;
		this.manufacturer = manufacturer;
		this.color = color;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getColor() {
		return color;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return super.toString() +  "," + numberOfSeats + "," + manufacturer + "," + color;
	}
	
	public static Car fromStringToCar(String str) {
        String[] parts = str.split(",");
        int product_id = Integer.parseInt(parts[0]);
        String product_name = parts[1];
        double price = Double.parseDouble(parts[2]);
        int product_total = Integer.parseInt(parts[3]);
        int numberOfSeats = Integer.parseInt(parts[4]);
        String manufacturer = parts[5];
        String color = parts[6];
        return new Car(product_id, product_name, price, product_total, numberOfSeats, manufacturer, color);
    }
	
}

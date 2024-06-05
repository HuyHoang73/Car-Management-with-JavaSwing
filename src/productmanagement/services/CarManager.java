package productmanagement.services;

import java.util.List;

import productmanagement.model.dto.CarSearchDTO;
import productmanagement.model.entity.Car;

public interface CarManager {
	public void addCar(Car c);

	public void editCar(Car c);

	public void delCar(int id);
	
	public List<Car> searchCar(CarSearchDTO modelSearch);
	
	public List<Car> sortedCar();
	
	public List<Car> sortedCarByPrice();
	
	public List<Car> sortedCarByNumberOfSeats();
	
	List<Car> getAllCars();
}

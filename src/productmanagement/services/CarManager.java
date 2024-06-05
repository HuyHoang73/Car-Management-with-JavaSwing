package productmanagement.services;

import java.util.List;

import productmanagement.model.dto.CarSearchDTO;
import productmanagement.model.entity.Car;

public interface CarManager {
	public boolean addCar(Car c);

	public boolean editCar(Car c);

	public boolean delCar(int id);
	
	public List<Car> searchCar(CarSearchDTO modelSearch);
	
	public List<Car> sortedCar();
	
	public List<Car> sortedCarByPrice();
	
	public List<Car> sortedCarByNumberOfSeats();
	
	List<Car> getAllCars();
}

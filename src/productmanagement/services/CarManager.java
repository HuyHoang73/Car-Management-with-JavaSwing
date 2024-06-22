package productmanagement.services;

import java.util.List;

import productmanagement.model.dto.CarAddDTO;
import productmanagement.model.dto.CarSearchDTO;
import productmanagement.model.entity.Car;

public interface CarManager {
	public boolean addCar(CarAddDTO c);

	public boolean editCar(CarAddDTO c);

	public boolean delCar(int id);

	public List<Car> searchCar(CarSearchDTO modelSearch);

	public List<Car> sortedCar();

	public List<Car> sortedCarByPrice();

	public List<Car> sortedCarByNumberOfSeats();

	List<Car> getAllCars();

	Car searchCarById(int id);

	int statisticsTotal();
}

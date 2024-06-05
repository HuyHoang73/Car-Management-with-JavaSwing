package productmanagement.services.impl;

import java.util.ArrayList;
import java.util.List;

import productmanagement.dao.CarDao;
import productmanagement.dao.impl.CarDaoImpl;
import productmanagement.model.dto.CarSearchDTO;
import productmanagement.model.entity.Car;
import productmanagement.services.CarManager;

public class CarManagerImpl implements CarManager {
	private CarDao carDao = new CarDaoImpl();

	@Override
	public boolean addCar(Car c) {
		carDao.addCar(c);
		return true;
		//return carList.add(c);
	}

	@Override
	public boolean editCar(Car c) {
//		for (int i = 0; i < carList.size(); i++) {
//			if (carList.get(i).getProduct_id() == c.getProduct_id()) {
//				carList.set(i, c);
//				return true;
//			}
//		}
//		return false;
		carDao.updateCar(c);
		return true;
	}

	@Override
	public boolean delCar(int id) {
//		for (int i = 0; i < carList.size(); i++) {
//			if (carList.get(i).getProduct_id() == id) {
//				carList.remove(i);
//				return true;
//			}
//		}
//		return false;
		carDao.deleteCar(id);
		return true;
	}

	@Override
	public List<Car> searchCar(CarSearchDTO modelSearch) {
		List<Car> result = carDao.searchCar(modelSearch);
		return result;
	}

	@Override
	public List<Car> sortedCar() {
		List<Car> carList = carDao.getAllCars();
		carList.sort((c1, c2) -> Double.compare(c2.getProduct_id(), c1.getProduct_id()));
		return carList;
	}

	@Override
	public List<Car> sortedCarByPrice() {
		List<Car> carList = carDao.getAllCars();
		carList.sort((c1, c2) -> Double.compare(c1.getProduct_price(), c2.getProduct_price()));
		return carList;
	}

	@Override
	public List<Car> sortedCarByNumberOfSeats() {
		List<Car> carList = carDao.getAllCars();
		carList.sort((c1, c2) -> Double.compare(c1.getNumberOfSeats(), c2.getNumberOfSeats()));
		return carList;
	}

	@Override
	public List<Car> getAllCars() {
		return carDao.getAllCars();
	}
}

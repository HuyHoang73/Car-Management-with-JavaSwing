package productmanagement.dao;

import java.util.List;

import productmanagement.model.dto.CarSearchDTO;
import productmanagement.model.entity.Car;

public interface CarDao {
    void addCar(Car car);
    void updateCar(Car car);
    void deleteCar(int id);
    List<Car> getAllCars();
    List<Car> searchCar(CarSearchDTO modelSearch);
}


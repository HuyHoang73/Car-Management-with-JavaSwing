package productmanagement.dao.impl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import productmanagement.dao.CarDao;
import productmanagement.model.dto.CarSearchDTO;
import productmanagement.model.entity.Car;
import productmanagement.utils.StringUtils;

public class CarDaoImpl implements CarDao {
    private List<Car> carList;
    private static final String FILE_NAME = "Car.bin";
    private static int currentId;

    public CarDaoImpl() {
        carList = new ArrayList<>();
        loadCarList();
        if (!carList.isEmpty()) {
            currentId = carList.get(carList.size() - 1).getProduct_id();
        } else {
            currentId = 0;
        }
    }

    @Override
    public void addCar(Car car) {
    	car.setProduct_id(generateId());
        carList.add(car);
        saveCarList();
    }

    @Override
    public void updateCar(Car car) {
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getProduct_id() == car.getProduct_id()) {
                carList.set(i, car);
                saveCarList();
                return;
            }
        }
    }

    @Override
    public void deleteCar(int id) {
        carList.removeIf(car -> car.getProduct_id() == id);
        saveCarList();
    }

    @Override
    public List<Car> getAllCars() {
        return new ArrayList<>(carList);
    }
    
	@Override
	public List<Car> searchCar(CarSearchDTO modelSearch) {
		List<Car> result = new ArrayList<>();
		System.out.println(modelSearch.toString());
		carList.forEach(item -> {
			boolean flag = true;
			if (StringUtils.checkString(modelSearch.getName())) {
				if(!item.getProduct_name().equalsIgnoreCase(modelSearch.getName())){
					flag = false;
				}
			}
			if (modelSearch.getMinPrice() != -1.0) {
				if(item.getProduct_price() < modelSearch.getMinPrice()) {
					flag = false;
				}
			}
			if (modelSearch.getMaxPrice() != -1.0) {
				if(item.getProduct_price() > modelSearch.getMaxPrice()) {
					flag = false;
				}
			}
			if (modelSearch.getMinSeats() != -1) {
				if(item.getNumberOfSeats() < modelSearch.getMinSeats()) {
					flag = false;
				}
			}
			if (modelSearch.getMaxSeats() != -1) {
				if(item.getNumberOfSeats() > modelSearch.getMaxSeats()) {
					flag = false;
				}
			}
			if (StringUtils.checkString(modelSearch.getManufacturer())) {
				if( !item.getManufacturer().equalsIgnoreCase(modelSearch.getManufacturer())) {
					flag = false;
				}
			}
			if (StringUtils.checkString(modelSearch.getColor())) {
				if(!item.getColor().equalsIgnoreCase(modelSearch.getColor())) {
					flag = false;
				}
			}
			if (flag) {
				result.add(item);
			}
		});
		System.out.println(result);
		return result;
	}

//    private void saveCarList() {
//        try (OutputStream os = new FileOutputStream(FILE_NAME);
//             ObjectOutputStream oos = new ObjectOutputStream(os)) {
//            oos.writeObject(carList);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    
    private void saveCarList() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Car car : carList) {
                writer.write(car.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadCarList() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String data;
            while ((data = reader.readLine()) != null) {
                Car car = Car.fromStringToCar(data);
                carList.add(car);
            }
        } catch (IOException e) {
            carList = new ArrayList<>();
        }
    }
    
    private int generateId() {
		return ++currentId;
	}
}


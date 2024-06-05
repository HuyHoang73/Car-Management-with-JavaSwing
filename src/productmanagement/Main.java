package productmanagement;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Scanner;

import productmanagement.model.entity.Car;
import productmanagement.services.impl.CarManagerImpl;
import productmanagement.services.CarManager;

public class Main {
	public static void main(String[] args) {
		CarManager carManager = new CarManagerImpl();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\n--- Car Manager Menu ---");
			System.out.println("1. Add Car");
			System.out.println("2. Edit Car");
			System.out.println("3. Delete Car");
			System.out.println("4. Search Car");
			System.out.println("5. Sort Car");
			System.out.println("6. Display All Cars");
			System.out.println("7. Exit");
			System.out.print("Please choose an option: ");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
			case 1:
				System.out.print("Enter product name: ");
				String name = scanner.nextLine();

				System.out.print("Enter product price: ");
				double price = scanner.nextDouble();

				System.out.print("Enter product total: ");
				int total = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Enter number of seats: ");
				int numberOfSeats = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Enter manufacturer: ");
				String manufacturer = scanner.nextLine();

				System.out.print("Enter color: ");
				String color = scanner.nextLine();

				Car car = new Car();
				car.setProduct_name(name);
				car.setProduct_price(price);
				car.setProduct_total(total);
				car.setNumberOfSeats(numberOfSeats);
				car.setManufacturer(manufacturer);
				car.setColor(color);
				if (carManager.addCar(car)) {
					System.out.println("Car added successfully.");
				} else {
					System.out.println("Failed to add Car.");
				}
				break;

			case 2:
				System.out.print("Enter product ID to edit: ");
				int editId = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Enter new product name: ");
				String newName = scanner.nextLine();

				System.out.print("Enter new product price: ");
				double newPrice = scanner.nextDouble();

				System.out.print("Enter new product total: ");
				int newTotal = scanner.nextInt();

				System.out.print("Enter number of seats: ");
				int newNumberOfSeats = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Enter manufacturer: ");
				String newManufacturer = scanner.nextLine();

				System.out.print("Enter color: ");
				String newColor = scanner.nextLine();

				Car editedCar = new Car(editId, newName, newPrice, newTotal, newNumberOfSeats, newManufacturer,
						newColor);
				if (carManager.editCar(editedCar)) {
					System.out.println("Car edited successfully.");
				} else {
					System.out.println("Could not find car with id " + editId);
				}
				break;

			case 3:
				System.out.print("Enter product ID to delete: ");
				int deleteId = scanner.nextInt();
				if (carManager.delCar(deleteId)) {
					System.out.println("Car deleted successfully.");
				} else {
					System.out.println("Failed to delete Car.");
				}
				break;

			case 4:
				Map<String, Object> searchInput = new HashMap<>();
				System.out.print("Enter product name (leave blank to skip): ");
				String searchName = scanner.nextLine();
				if (!searchName.isEmpty()) {
					searchInput.put("product_name", searchName);
				}

				System.out.print("Enter product min price (leave blank to skip): ");
				String minPriceInput = scanner.nextLine();
				if (!minPriceInput.isEmpty()) {
					double searchMinPrice = Double.parseDouble(minPriceInput);
					searchInput.put("min_price", searchMinPrice);
				}

				System.out.print("Enter product max price (leave blank to skip): ");
				String maxPriceInput = scanner.nextLine();
				if (!maxPriceInput.isEmpty()) {
					double searchMaxPrice = Double.parseDouble(maxPriceInput);
					searchInput.put("max_price", searchMaxPrice);
				}

				System.out.print("Enter product min seats (leave blank to skip): ");
				String minSeatsInput = scanner.nextLine();
				if (!minSeatsInput.isEmpty()) {
					double searchMinSeats = Double.parseDouble(minSeatsInput);
					searchInput.put("min_seats", searchMinSeats);
				}

				System.out.print("Enter product max seats (leave blank to skip): ");
				String maxSeatsInput = scanner.nextLine();
				if (!maxSeatsInput.isEmpty()) {
					double searchMaxSeats = Double.parseDouble(maxSeatsInput);
					searchInput.put("max_seats", searchMaxSeats);
				}

				System.out.print("Enter manufacturer (leave blank to skip): ");
				String searchManufacturer = scanner.nextLine();
				if (!searchManufacturer.isEmpty()) {
					searchInput.put("manufacturer", searchManufacturer);
				}

				System.out.print("Enter color (leave blank to skip): ");
				String searchColor = scanner.nextLine();
				if (!searchColor.isEmpty()) {
					searchInput.put("color", searchColor);
				}

//				List<Car> searchResults = carManager.searchCar();
//				System.out.println("Search results:");
//				for (Car c : searchResults) {
//					System.out.println(c);
//				}
				break;

			case 5:
				System.out.println("\n--- Choose sort options ---");
				System.out.println("a. Default");
				System.out.println("b. Price");
				System.out.println("c. Number of seats");
				System.out.println("d. Back to menu");
				System.out.print("Please choose an option: ");

				String sortChoice = scanner.nextLine();
//				scanner.nextLine();

				switch (sortChoice) {
				case "a":
					System.out.println("Default sort:");
					List<Car> sortedCars = carManager.sortedCar();
					for (Car c : sortedCars) {
						System.out.println(c);
					}
					break;
				case "b":
					System.out.println("Sort by price:");
					List<Car> sortedCarsByPrice = carManager.sortedCarByPrice();
					for (Car c : sortedCarsByPrice) {
						System.out.println(c);
					}
					break;
				case "c":
					System.out.println("Sort by number of seats:");
					List<Car> sortedCarsByNumberOfSeats = carManager.sortedCarByNumberOfSeats();
					for (Car c : sortedCarsByNumberOfSeats) {
						System.out.println(c);
					}
					break;

				case "d":
					System.out.println("Back to menu...");
					break;

				default:
					System.out.println("Invalid choice. Please try again.");
					break;
				}
			case 6:
				System.out.println("All Cars:");
				List<Car> allCars = carManager.getAllCars();
				for (Car c : allCars) {
					System.out.println(c);
				}
				break;

			case 7:
				System.out.println("Exiting...");
				scanner.close();
				return;

			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

}





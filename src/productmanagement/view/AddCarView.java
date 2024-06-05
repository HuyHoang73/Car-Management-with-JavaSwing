package productmanagement.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import productmanagement.model.entity.Car;
import productmanagement.services.CarManager;
import productmanagement.services.impl.CarManagerImpl;
import productmanagement.utils.NumberUtils;

public class AddCarView {
	private CarManager carManager;
	private Car car;
	private JFrame frmAddCar;
	private JTextField txtAddName;
	private JTextField txtAddPrice;
	private JTextField txtAddTotal;
	private JTextField txtAddSeats;
	private JTextField txtAddManufacturer;
	private JTextField txtAddColor;
	private JLabel labelAddManufacturer;
	private JLabel labelAddColor;

	/**
	 * Create the application.
	 */
	public AddCarView() {
		initialize();
		carManager = new CarManagerImpl();
		car = new Car();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddCar = new JFrame();
		frmAddCar.setTitle("Add car");
		frmAddCar.setBounds(100, 100, 551, 370);
		frmAddCar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddCar.getContentPane().setLayout(null);
		
		JLabel labelTitleAdd = new JLabel("Add Car");
		labelTitleAdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelTitleAdd.setBounds(250, 0, 69, 38);
		frmAddCar.getContentPane().add(labelTitleAdd);
		
		JLabel labelAddName = new JLabel("Name:");
		labelAddName.setHorizontalAlignment(SwingConstants.RIGHT);
		labelAddName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelAddName.setBounds(68, 39, 46, 14);
		frmAddCar.getContentPane().add(labelAddName);
		
		txtAddName = new JTextField();
		labelAddName.setLabelFor(txtAddName);
		txtAddName.setBounds(124, 33, 375, 31);
		frmAddCar.getContentPane().add(txtAddName);
		txtAddName.setColumns(10);
		
		txtAddPrice = new JTextField();
		txtAddPrice.setBounds(124, 77, 375, 31);
		frmAddCar.getContentPane().add(txtAddPrice);
		txtAddPrice.setColumns(10);
		
		JLabel labelAddPrice = new JLabel("Price:");
		labelAddPrice.setLabelFor(txtAddPrice);
		labelAddPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		labelAddPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelAddPrice.setBounds(68, 83, 46, 14);
		frmAddCar.getContentPane().add(labelAddPrice);
		
		txtAddTotal = new JTextField();
		txtAddTotal.setColumns(10);
		txtAddTotal.setBounds(124, 119, 152, 31);
		frmAddCar.getContentPane().add(txtAddTotal);
		
		txtAddSeats = new JTextField();
		txtAddSeats.setColumns(10);
		txtAddSeats.setBounds(349, 119, 152, 31);
		frmAddCar.getContentPane().add(txtAddSeats);
		
		txtAddManufacturer = new JTextField();
		txtAddManufacturer.setColumns(10);
		txtAddManufacturer.setBounds(124, 161, 375, 31);
		frmAddCar.getContentPane().add(txtAddManufacturer);
		
		txtAddColor = new JTextField();
		txtAddColor.setColumns(10);
		txtAddColor.setBounds(124, 203, 375, 31);
		frmAddCar.getContentPane().add(txtAddColor);
		
		JLabel labelAddTotal = new JLabel("Total:");
		labelAddTotal.setLabelFor(txtAddTotal);
		labelAddTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		labelAddTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelAddTotal.setBounds(68, 125, 46, 14);
		frmAddCar.getContentPane().add(labelAddTotal);
		
		JLabel labelAddSeats = new JLabel("Seats:");
		labelAddSeats.setLabelFor(txtAddSeats);
		labelAddSeats.setHorizontalAlignment(SwingConstants.RIGHT);
		labelAddSeats.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelAddSeats.setBounds(286, 125, 46, 14);
		frmAddCar.getContentPane().add(labelAddSeats);
		
		labelAddManufacturer = new JLabel("Manufacturer:");
		labelAddManufacturer.setLabelFor(txtAddManufacturer);
		labelAddManufacturer.setHorizontalAlignment(SwingConstants.RIGHT);
		labelAddManufacturer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelAddManufacturer.setBounds(10, 167, 104, 14);
		frmAddCar.getContentPane().add(labelAddManufacturer);
		
		labelAddColor = new JLabel("Color:");
		labelAddColor.setLabelFor(txtAddColor);
		labelAddColor.setHorizontalAlignment(SwingConstants.RIGHT);
		labelAddColor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelAddColor.setBounds(68, 209, 46, 14);
		frmAddCar.getContentPane().add(labelAddColor);
		
		JButton btnFromAddBackMain = new JButton("Cancel");
		btnFromAddBackMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CarManagerView().setVisible(true);
				frmAddCar.dispose();
			}
		});
		btnFromAddBackMain.setBackground(new Color(204, 0, 0));
		btnFromAddBackMain.setForeground(new Color(255, 255, 255));
		btnFromAddBackMain.setBounds(148, 270, 89, 31);
		frmAddCar.getContentPane().add(btnFromAddBackMain);
		
		JButton btnAddCar = new JButton("Add");
		btnAddCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtAddName.getText().trim();
				String price = txtAddPrice.getText().trim();
				String total = txtAddTotal.getText().trim();
				String seats = txtAddSeats.getText().trim();
				String manufacturer = txtAddManufacturer.getText().trim();
				String color = txtAddColor.getText().trim();
				
				if(name.isEmpty() || price.isEmpty() || total.isEmpty() || seats.isEmpty() || manufacturer.isEmpty() || color.isEmpty()) {
					JOptionPane.showMessageDialog(frmAddCar, "Fields cannot be left blank", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if (!NumberUtils.isDouble(price)) {
		            JOptionPane.showMessageDialog(frmAddCar, "Price must be number", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!NumberUtils.positiveNumber(Double.parseDouble(price))) {
					JOptionPane.showMessageDialog(frmAddCar, "Price must > 0", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!NumberUtils.isInteger(total)) {
					JOptionPane.showMessageDialog(frmAddCar, "Total must be number", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!NumberUtils.positiveNumber(Integer.parseInt(total))) {
					JOptionPane.showMessageDialog(frmAddCar, "Total must > 0", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!NumberUtils.isInteger(seats)) {
					JOptionPane.showMessageDialog(frmAddCar, "Number of seats must be number", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!NumberUtils.positiveNumber(Integer.parseInt(seats))) {
					JOptionPane.showMessageDialog(frmAddCar, "Number of seats must > 0", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					car.setProduct_name(name);
					car.setProduct_price(Double.parseDouble(price));
					car.setProduct_total(Integer.parseInt(total));
					car.setNumberOfSeats(Integer.parseInt(seats));
					car.setManufacturer(manufacturer);
					car.setColor(color);
					carManager.addCar(car);
					JOptionPane.showMessageDialog(frmAddCar, "Success", "Message", JOptionPane.INFORMATION_MESSAGE);
					new CarManagerView().setVisible(true);
					frmAddCar.dispose();
				}
			}
		});
		btnAddCar.setForeground(new Color(255, 255, 255));
		btnAddCar.setBackground(new Color(0, 204, 51));
		btnAddCar.setBounds(315, 270, 89, 31);
		frmAddCar.getContentPane().add(btnAddCar);
	}

	public void setVisible(boolean b) {
		frmAddCar.setVisible(b);
	}
}

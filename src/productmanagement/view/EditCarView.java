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

public class EditCarView {
	private CarManager carManager;
	private Car car;
	private int carId;
	private JFrame frmEditCar;
	private JTextField txtEditName;
	private JTextField txtEditPrice;
	private JTextField txtEditTotal;
	private JTextField txtEditSeats;
	private JTextField txtEditManufacturer;
	private JTextField txtEditColor;
	private JLabel labelEditManufacturer;
	private JLabel labelEditColor;
	private JLabel labelTitleEdit;
	private JLabel labelEditName;
	private JLabel labelEditPrice;
	private JLabel labelEditSeats;
	private JLabel labelEditTotal;
	private JButton btnFromEditBackMain;
	private JButton btnEditCar;

	/**
	 * Create the application.
	 */
	public EditCarView() {
		initialize();
		carManager = new CarManagerImpl();
		car = new Car();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEditCar = new JFrame();
		frmEditCar.setTitle("Edit car");
		frmEditCar.setBounds(100, 100, 551, 370);
		frmEditCar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEditCar.getContentPane().setLayout(null);

		labelTitleEdit = new JLabel("Edit Car");
		labelTitleEdit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelTitleEdit.setBounds(250, 0, 69, 38);
		frmEditCar.getContentPane().add(labelTitleEdit);

		labelEditName = new JLabel("Name:");
		labelEditName.setHorizontalAlignment(SwingConstants.RIGHT);
		labelEditName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelEditName.setBounds(68, 39, 46, 14);
		frmEditCar.getContentPane().add(labelEditName);

		txtEditName = new JTextField();
		labelEditName.setLabelFor(txtEditName);
		txtEditName.setBounds(124, 33, 375, 31);
		frmEditCar.getContentPane().add(txtEditName);
		txtEditName.setColumns(10);

		txtEditPrice = new JTextField();
		txtEditPrice.setBounds(124, 77, 375, 31);
		frmEditCar.getContentPane().add(txtEditPrice);
		txtEditPrice.setColumns(10);

		labelEditPrice = new JLabel("Price:");
		labelEditPrice.setLabelFor(txtEditPrice);
		labelEditPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		labelEditPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelEditPrice.setBounds(68, 83, 46, 14);
		frmEditCar.getContentPane().add(labelEditPrice);

		txtEditTotal = new JTextField();
		txtEditTotal.setColumns(10);
		txtEditTotal.setBounds(124, 119, 152, 31);
		frmEditCar.getContentPane().add(txtEditTotal);

		txtEditSeats = new JTextField();
		txtEditSeats.setColumns(10);
		txtEditSeats.setBounds(349, 119, 152, 31);
		frmEditCar.getContentPane().add(txtEditSeats);

		txtEditManufacturer = new JTextField();
		txtEditManufacturer.setColumns(10);
		txtEditManufacturer.setBounds(124, 161, 375, 31);
		frmEditCar.getContentPane().add(txtEditManufacturer);

		txtEditColor = new JTextField();
		txtEditColor.setColumns(10);
		txtEditColor.setBounds(124, 203, 375, 31);
		frmEditCar.getContentPane().add(txtEditColor);

		labelEditTotal = new JLabel("Total:");
		labelEditTotal.setLabelFor(txtEditTotal);
		labelEditTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		labelEditTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelEditTotal.setBounds(68, 125, 46, 14);
		frmEditCar.getContentPane().add(labelEditTotal);

		labelEditSeats = new JLabel("Seats:");
		labelEditSeats.setLabelFor(txtEditSeats);
		labelEditSeats.setHorizontalAlignment(SwingConstants.RIGHT);
		labelEditSeats.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelEditSeats.setBounds(286, 125, 46, 14);
		frmEditCar.getContentPane().add(labelEditSeats);

		labelEditManufacturer = new JLabel("Manufacturer:");
		labelEditManufacturer.setLabelFor(txtEditManufacturer);
		labelEditManufacturer.setHorizontalAlignment(SwingConstants.RIGHT);
		labelEditManufacturer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelEditManufacturer.setBounds(10, 167, 104, 14);
		frmEditCar.getContentPane().add(labelEditManufacturer);

		labelEditColor = new JLabel("Color:");
		labelEditColor.setLabelFor(txtEditColor);
		labelEditColor.setHorizontalAlignment(SwingConstants.RIGHT);
		labelEditColor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelEditColor.setBounds(68, 209, 46, 14);
		frmEditCar.getContentPane().add(labelEditColor);

		btnFromEditBackMain = new JButton("Cancel");
		btnFromEditBackMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CarManagerView().setVisible(true);
				frmEditCar.dispose();
			}
		});
		btnFromEditBackMain.setBackground(new Color(204, 0, 0));
		btnFromEditBackMain.setForeground(new Color(255, 255, 255));
		btnFromEditBackMain.setBounds(148, 270, 89, 31);
		frmEditCar.getContentPane().add(btnFromEditBackMain);

		btnEditCar = new JButton("Edit");
		btnEditCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtEditName.getText().trim();
				String price = txtEditPrice.getText().trim();
				String total = txtEditTotal.getText().trim();
				String seats = txtEditSeats.getText().trim();
				String manufacturer = txtEditManufacturer.getText().trim();
				String color = txtEditColor.getText().trim();

				if (name.isEmpty() || price.isEmpty() || total.isEmpty() || seats.isEmpty() || manufacturer.isEmpty() || color.isEmpty()) {
					JOptionPane.showMessageDialog(frmEditCar, "Fields cannot be left blank", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if (!NumberUtils.isDouble(price)) {
			        JOptionPane.showMessageDialog(frmEditCar, "Price must be number", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!NumberUtils.positiveNumber(Double.parseDouble(price))) {
					JOptionPane.showMessageDialog(frmEditCar, "Price must > 0", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!NumberUtils.isInteger(total)) {
					JOptionPane.showMessageDialog(frmEditCar, "Total must be number", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!NumberUtils.positiveNumber(Integer.parseInt(total))) {
					JOptionPane.showMessageDialog(frmEditCar, "Total must > 0", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!NumberUtils.isInteger(seats)) {
					JOptionPane.showMessageDialog(frmEditCar, "Number of seats must be number", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!NumberUtils.positiveNumber(Integer.parseInt(seats))) {
					JOptionPane.showMessageDialog(frmEditCar, "Number of seats must > 0", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					car.setProduct_id(carId);
					car.setProduct_name(name);
					car.setProduct_price(Double.parseDouble(price));
					car.setProduct_total(Integer.parseInt(total));
					car.setNumberOfSeats(Integer.parseInt(seats));
					car.setManufacturer(manufacturer);
					car.setColor(color);
					carManager.editCar(car);
					JOptionPane.showMessageDialog(frmEditCar, "Success", "Message", JOptionPane.INFORMATION_MESSAGE);
					new CarManagerView().setVisible(true);
					frmEditCar.dispose();
				}
			}
		});
		btnEditCar.setForeground(new Color(255, 255, 255));
		btnEditCar.setBackground(new Color(0, 102, 255));
		btnEditCar.setBounds(315, 270, 89, 31);
		frmEditCar.getContentPane().add(btnEditCar);
	}

	public void setVisible(boolean b) {
		frmEditCar.setVisible(b);
	}

	public void getCar(Car carSelected) {
		txtEditName.setText(carSelected.getProduct_name());
		txtEditPrice.setText(String.valueOf(carSelected.getProduct_price()));
		txtEditTotal.setText(String.valueOf(carSelected.getProduct_total()));
		txtEditSeats.setText(String.valueOf(carSelected.getNumberOfSeats()));
		txtEditManufacturer.setText(carSelected.getManufacturer());
		txtEditColor.setText(carSelected.getColor());
		carId = carSelected.getProduct_id();
	}
}

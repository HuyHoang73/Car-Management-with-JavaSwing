package productmanagement.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class AdminSidebarView extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public AdminSidebarView(Navigate navigate) {
		setBackground(new Color(102, 51, 204));
		setLayout(null);

		JLabel labelMenuTitle = new JLabel("Admin Page");
		labelMenuTitle.setForeground(new Color(255, 255, 255));
		labelMenuTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelMenuTitle.setHorizontalAlignment(SwingConstants.CENTER);
		labelMenuTitle.setBounds(10, 5, 180, 45);
		add(labelMenuTitle);

		JButton btnNavigateDashboard = new JButton("Dashboard");
		btnNavigateDashboard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel adminDashboard = new AdminDashboardView();
				navigate.navigateTo(adminDashboard);
			}
		});
		btnNavigateDashboard.setToolTipText("Tổng quan");
		btnNavigateDashboard.setBackground(new Color(102, 51, 204));
		btnNavigateDashboard.setForeground(new Color(255, 255, 255));
		btnNavigateDashboard.setBounds(10, 61, 180, 35);
		add(btnNavigateDashboard);

		JButton btnNavigateCar = new JButton("Ô tô");
		btnNavigateCar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel adminCar = new AdminCarView();
				navigate.navigateTo(adminCar);
			}
		});
		btnNavigateCar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNavigateCar.setBackground(new Color(102, 51, 204));
		btnNavigateCar.setToolTipText("Quản lý xe");
		btnNavigateCar.setForeground(new Color(255, 255, 255));
		btnNavigateCar.setBounds(10, 107, 180, 35);
		add(btnNavigateCar);

		JButton btnNavigateUser = new JButton("Tài khoản");
		btnNavigateUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel adminUser = new AdminUserView();
				navigate.navigateTo(adminUser);
			}
		});
		btnNavigateUser.setForeground(new Color(255, 255, 255));
		btnNavigateUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNavigateUser.setBackground(new Color(102, 51, 204));
		btnNavigateUser.setToolTipText("Quản lý người dùng");
		btnNavigateUser.setBounds(10, 153, 180, 35);
		add(btnNavigateUser);

		JButton btnNavigateShowroom = new JButton("Showroom");
		btnNavigateShowroom.setForeground(new Color(255, 255, 255));
		btnNavigateShowroom.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNavigateShowroom.setToolTipText("Quản lý Showroom");
		btnNavigateShowroom.setBackground(new Color(102, 51, 204));
		btnNavigateShowroom.setBounds(10, 199, 180, 35);
		add(btnNavigateShowroom);

		JButton btnNavigateBank = new JButton("Ngân hàng");
		btnNavigateBank.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel adminBank = new AdminBankView();
				navigate.navigateTo(adminBank
						);
			}
		});
		btnNavigateBank.setForeground(new Color(255, 255, 255));
		btnNavigateBank.setBackground(new Color(102, 51, 204));
		btnNavigateBank.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNavigateBank.setToolTipText("Quản lý ngân hàng");
		btnNavigateBank.setBounds(10, 245, 180, 35);
		add(btnNavigateBank);

		JButton btnSettings = new JButton("Cài đặt");
		btnSettings.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel adminSettings = new AdminSettingsView();
				navigate.navigateTo(adminSettings);
			}
		});
		btnSettings.setForeground(new Color(102, 51, 204));
		btnSettings.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSettings.setBackground(new Color(255, 255, 255));
		btnSettings.setToolTipText("Cài đặt");
		btnSettings.setBounds(10, 291, 180, 35);
		add(btnSettings);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(200, 0); // Đặt kích thước chiều rộng mặc định cho sidebar
	}

	public static JPanel getPage(JPanel page) {
		return page;
	}
}

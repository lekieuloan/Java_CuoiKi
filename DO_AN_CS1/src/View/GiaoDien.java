package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controler.ChuyenManHinh;
import List.Home_List;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.FlowLayout;

public class GiaoDien extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelView;
	private JPanel panelMenu;
	private JPanel jpHome;
	private JLabel jlHome;
	private JPanel jpBanHang;
	private JLabel jlBanHang;
	private JPanel jpTaiKhoan;
	private JLabel jlTaiKhoan;
	private JPanel jpQuanLy;
	private JLabel jlQuanLy;
	private JPanel jpCaiDat;
	private JLabel jlCaiDai;
	private JPanel jpThongKe;
	private JLabel jlThongKe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDien window  = new GiaoDien();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GiaoDien() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HP\\Downloads\\Oxygen-Icons.org-Oxygen-Apps-java.256.png"));
		setTitle("Giao Diện Chính");
		init();
		
		
		ChuyenManHinh controller= new ChuyenManHinh(panelView);
		controller.setView(jpHome, jlHome);
		
		List<Home_List> listItem = new ArrayList<>();
		listItem.add(new Home_List(jpHome, jlHome, "Home"));
		listItem.add(new Home_List(jpBanHang, jlBanHang, "BanHang"));
		listItem.add(new Home_List(jpTaiKhoan, jlTaiKhoan, "TaiKhoan"));
		listItem.add(new Home_List(jpQuanLy, jlQuanLy, "QuanLy"));
		listItem.add(new Home_List(jpCaiDat, jlCaiDai, "CaiDat"));
		listItem.add(new Home_List(jpThongKe, jlThongKe, "ThongKe"));
		
		controller.setEvent(listItem);
		
	}
	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1400, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelMenu = new JPanel();
		panelMenu.setBackground(new Color(105, 105, 105));
		panelMenu.setBounds(0, 0, 160, 700);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		jpHome = new JPanel();
		jpHome.setBackground(new Color(160, 82, 45));
		jpHome.setBounds(0, 0, 160, 103);
		panelMenu.add(jpHome);
		
		jlHome = new JLabel("HOME");
		jpHome.add(jlHome);
		jlHome.setForeground(new Color(244, 164, 96));
		jlHome.setBackground(new Color(255, 228, 196));
		jlHome.setFont(new Font("Tahoma", Font.BOLD, 20));
		jlHome.setIcon(new ImageIcon("D:\\java\\DO_AN_CS1\\image\\home-icon.png"));
		
		jpBanHang = new JPanel();
		jpBanHang.setBackground(new Color(139, 69, 19));
		jpBanHang.setBounds(0, 115, 160, 73);
		panelMenu.add(jpBanHang);
		jpBanHang.setLayout(null);
		
		jlBanHang = new JLabel("Bán Hàng");
		jlBanHang.setForeground(new Color(244, 164, 96));
		jlBanHang.setFont(new Font("Tahoma", Font.BOLD, 15));
		jlBanHang.setBounds(0, 11, 160, 48);
		jlBanHang.setIcon(new ImageIcon("D:\\java\\DO_AN_CS1\\image\\Basket-icon.png"));
		jpBanHang.add(jlBanHang);
		
		jpTaiKhoan = new JPanel();
		jpTaiKhoan.setBackground(new Color(139, 69, 19));
		jpTaiKhoan.setBounds(0, 199, 160, 73);
		panelMenu.add(jpTaiKhoan);
		jpTaiKhoan.setLayout(null);
		
		jlTaiKhoan = new JLabel("Tài Khoản");
		jlTaiKhoan.setForeground(new Color(244, 164, 96));
		jlTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 15));
		jlTaiKhoan.setIcon(new ImageIcon("D:\\java\\DO_AN_CS1\\image\\account-circle-icon.png"));
		jlTaiKhoan.setBounds(0, 0, 160, 66);
		jpTaiKhoan.add(jlTaiKhoan);
		
		jpQuanLy = new JPanel();
		jpQuanLy.setBackground(new Color(139, 69, 19));
		jpQuanLy.setBounds(0, 283, 160, 73);
		panelMenu.add(jpQuanLy);
		jpQuanLy.setLayout(null);
		
		jlQuanLy = new JLabel("Quản Lý");
		jlQuanLy.setForeground(new Color(244, 164, 96));
		jlQuanLy.setFont(new Font("Tahoma", Font.BOLD, 15));
		jlQuanLy.setIcon(new ImageIcon("D:\\java\\DO_AN_CS1\\image\\file-manager-icon.png"));
		jlQuanLy.setBounds(0, 5, 160, 66);
		jpQuanLy.add(jlQuanLy);
		
		jpCaiDat = new JPanel();
		jpCaiDat.setBackground(new Color(139, 69, 19));
		jpCaiDat.setBounds(0, 367,160, 73);
		panelMenu.add(jpCaiDat);
		jpCaiDat.setLayout(null);
		
		jlCaiDai = new JLabel("Cài Đặt");
		jlCaiDai.setForeground(new Color(244, 164, 96));
		jlCaiDai.setFont(new Font("Tahoma", Font.BOLD, 15));
		jlCaiDai.setIcon(new ImageIcon("D:\\java\\DO_AN_CS1\\image\\Settings-2-icon.png"));
		jlCaiDai.setBounds(0, 0, 160, 66);
		jpCaiDat.add(jlCaiDai);
		
		jpThongKe = new JPanel();
		jpThongKe.setBackground(new Color(139, 69, 19));
		jpThongKe.setBounds(0, 451,160, 73);
		panelMenu.add(jpThongKe);
		jpThongKe.setLayout(null);
		
		jlThongKe = new JLabel("Thống Kê");
		jlThongKe.setForeground(new Color(244, 164, 96));
		jlThongKe.setFont(new Font("Tahoma", Font.BOLD, 15));
		jlThongKe.setIcon(new ImageIcon("D:\\java\\DO_AN_CS1\\image\\statistic-up-icon.png"));
		jlThongKe.setBounds(0, 0, 160, 66);
		jpThongKe.add(jlThongKe);
		
		panelView = new JPanel();
		panelView.setBounds(164, 0, 1206, 700);
		contentPane.add(panelView);
	}
}

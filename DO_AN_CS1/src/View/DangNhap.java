package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controler.DangNhap_ctl;
import DAO.NhanVien_DAO;
import Model.NhanVien;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class DangNhap extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DangNhap frame = new DangNhap();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public DangNhap() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HP\\Downloads\\Oxygen-Icons.org-Oxygen-Apps-java.256.png"));
        setTitle("Quản Lý Quán Cafe CARIA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 871, 501);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        DangNhap_ctl controllerDN = new DangNhap_ctl(this);

        JPanel panel = new JPanel();
        panel.setForeground(new Color(255, 255, 255));
        panel.setBackground(new Color(139, 69, 19));
        panel.setBounds(0, 0, 335, 462);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("My Coffe");
        lblNewLabel.setFont(new Font("VNcommercial Script", Font.BOLD, 95));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(21, 79, 304, 123);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setBounds(102, 218, 137, 175);
        panel.add(lblNewLabel_1);
        lblNewLabel_1.setIcon(new ImageIcon("D:\\java\\DO_AN_CS1\\image\\java-coffee-icon.png"));

        JLabel lblNewLabel_2 = new JLabel("Đăng Nhập");
        lblNewLabel_2.setFont(new Font("Times", Font.BOLD | Font.ITALIC, 30));
        lblNewLabel_2.setForeground(new Color(139, 69, 19));
        lblNewLabel_2.setBounds(536, 57, 208, 47);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Mã Nhân Viên:");
        lblNewLabel_3.setBounds(450, 157, 124, 14);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Mật Khẩu:");
        lblNewLabel_4.setBounds(450, 242, 76, 14);
        contentPane.add(lblNewLabel_4);

        textField = new JTextField();
        textField.setToolTipText("");
        textField.setBounds(450, 191, 312, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setToolTipText("");
        passwordField.setBounds(450, 277, 312, 20);
        contentPane.add(passwordField);

        JButton btnDangKy = new JButton("Đăng ký");
        btnDangKy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Mở cửa sổ đăng ký khi nhấn nút "Đăng ký"
                DangKy dangKyFrame = new DangKy();
                dangKyFrame.setVisible(true);
            }
        });
        btnDangKy.setBounds(476, 369, 108, 23);
        contentPane.add(btnDangKy);

        JButton btnDangNhap = new JButton("Đăng Nhập");
        btnDangNhap.setBounds(636, 369, 108, 23);
        btnDangNhap.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thucHienDangNhap();
            }
        });
        contentPane.add(btnDangNhap);
    }

    public void thucHienDangNhap() {
        String taiKhoan = textField.getText();
        String matKhau = new String(passwordField.getPassword());

        if (taiKhoan.isEmpty() || matKhau.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã nhân viên và mật khẩu", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean kiemtraNgDung = NhanVien_DAO.getInstance().kiemTraTaiKhoanMatKhauNguoiDung(taiKhoan, matKhau);
        if (kiemtraNgDung) {
            // Mở cửa sổ giao diện chính
            GiaoDien giaoDienChinh = new GiaoDien();
            giaoDienChinh.setVisible(true);
            dispose(); // Đóng cửa sổ đăng nhập
        } else {
            JOptionPane.showMessageDialog(this, "Nhập sai tài khoản/mật khẩu", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        passwordField.setText("");
    }
}

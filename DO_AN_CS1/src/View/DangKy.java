package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DAO.NhanVien_DAO;
import Model.NhanVien;

public class DangKy extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtMaNV;
    private JTextField txtTenNV;
    private JTextField txtSDT;
    private JTextField txtMatKhau;
    private JTextField txtDiaChi;
    private JTextField txtNgayVaoLam;
    private JTextField txtChucVu;
    private JRadioButton rdbtnNam;
    private JRadioButton rdbtnNu;
    private ButtonGroup gioiTinhGroup;
    private String gioiTinh; // Biến để lưu giới tính

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DangKy frame = new DangKy();
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
    public DangKy() {
        init();
    }

    private void init() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 736, 504);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        Font font = new Font("Tahoma", Font.PLAIN, 13);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Mã Nhân Viên");
        lblNewLabel.setFont(font);
        lblNewLabel.setBounds(52, 119, 79, 16);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Tên Nhân Viên");
        lblNewLabel_1.setFont(font);
        lblNewLabel_1.setBounds(52, 195, 84, 16);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Giới tính");
        lblNewLabel_2.setFont(font);
        lblNewLabel_2.setBounds(52, 276, 46, 16);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Chức vụ");
        lblNewLabel_3.setFont(font);
        lblNewLabel_3.setBounds(52, 338, 46, 16);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel(" Ngày vào làm");
        lblNewLabel_4.setFont(font);
        lblNewLabel_4.setBounds(405, 338, 81, 16);
        contentPane.add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("Địa chỉ");
        lblNewLabel_5.setFont(font);
        lblNewLabel_5.setBounds(405, 262, 39, 16);
        contentPane.add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("Số điện thoại");
        lblNewLabel_6.setFont(font);
        lblNewLabel_6.setBounds(405, 195, 75, 16);
        contentPane.add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("Mật Khẩu");
        lblNewLabel_7.setFont(font);
        lblNewLabel_7.setBounds(405, 119, 53, 16);
        contentPane.add(lblNewLabel_7);

        JLabel lblNewLabel_8 = new JLabel("Đăng ký");
        lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_8.setBounds(303, 35, 95, 50);
        contentPane.add(lblNewLabel_8);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(148, 420, 89, 23);
        contentPane.add(btnCancel);

        JButton btnOK = new JButton("OK");
        btnOK.setBounds(452, 420, 89, 23);
        contentPane.add(btnOK);

        txtTenNV = new JTextField();
        txtTenNV.setBounds(171, 194, 130, 20);
        contentPane.add(txtTenNV);
        txtTenNV.setColumns(10);

        txtMaNV = new JTextField();
        txtMaNV.setColumns(10);
        txtMaNV.setBounds(171, 118, 130, 20);
        contentPane.add(txtMaNV);

        txtSDT = new JTextField();
        txtSDT.setColumns(10);
        txtSDT.setBounds(524, 194, 130, 20);
        contentPane.add(txtSDT);

        txtMatKhau = new JTextField();
        txtMatKhau.setColumns(10);
        txtMatKhau.setBounds(524, 118, 130, 20);
        contentPane.add(txtMatKhau);

        rdbtnNam = new JRadioButton("Nam");
        rdbtnNam.setBounds(184, 274, 53, 23);
        rdbtnNam.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rdbtnNam.isSelected()) {
                    gioiTinh = "0"; // Lưu giá trị là "Nam" khi chọn Nam
                }
            }
        });
        contentPane.add(rdbtnNam);

        rdbtnNu = new JRadioButton("Nữ");
        rdbtnNu.setBounds(257, 274, 46, 23);
        rdbtnNu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rdbtnNu.isSelected()) {
                    gioiTinh = "1"; // Lưu giá trị là "Nữ" khi chọn Nữ
                }
            }
        });
        contentPane.add(rdbtnNu);

        gioiTinhGroup = new ButtonGroup();
        gioiTinhGroup.add(rdbtnNam);
        gioiTinhGroup.add(rdbtnNu);

        txtDiaChi = new JTextField();
        txtDiaChi.setColumns(10);
        txtDiaChi.setBounds(524, 261, 130, 20);
        contentPane.add(txtDiaChi);

        txtNgayVaoLam = new JTextField();
        txtNgayVaoLam.setEditable(false); // Chỉ cho phép đọc
        txtNgayVaoLam.setColumns(10);
        txtNgayVaoLam.setBounds(524, 337, 130, 20);
        contentPane.add(txtNgayVaoLam);

        txtChucVu = new JTextField();
        txtChucVu.setColumns(10);
        txtChucVu.setBounds(171, 337, 130, 20);
        contentPane.add(txtChucVu);

        // Set current date for txtNgayVaoLam
        LocalDate ngayVaoLam = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = ngayVaoLam.format(formatter);
        txtNgayVaoLam.setText(formattedDate);

        // Action listener for Cancel button
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the registration form
            }
        });

        // Action listener for OK button
        btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thucHienDangKyTaiKhoan();
            }
        });
    }

    public void thucHienDangKyTaiKhoan() {
        String maNV = txtMaNV.getText();
        String tenNV = txtTenNV.getText();
        String matKhau = txtMatKhau.getText();
        String diaChi = txtDiaChi.getText();
        String sdt = txtSDT.getText();
        String chucVu = txtChucVu.getText();
        String gioiTinh = this.gioiTinh; // Lấy giới tính từ biến instance đã được lưu khi người dùng chọn

        // Kiểm tra các trường có trống không
        if (maNV.isEmpty() || tenNV.isEmpty() || matKhau.isEmpty() || diaChi.isEmpty() || sdt.isEmpty() || chucVu.isEmpty() || gioiTinh.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int soDienThoai = Integer.parseInt(sdt);
            LocalDate ngayVaoLam = LocalDate.now();

            // Tạo đối tượng NhanVien từ các thông tin đã nhập
            NhanVien nhanVien = new NhanVien(maNV, tenNV, soDienThoai, diaChi, matKhau, chucVu, ngayVaoLam, gioiTinh);

            // Gọi đến phương thức đăng ký tài khoản từ lớp DAO
            int result = NhanVien_DAO.getInstance().dangKyTaiKhoan(nhanVien);

            if (result == 1) {
                String thongBao = "Đăng ký tài khoản: " + maNV + " thành công!";
                JOptionPane.showMessageDialog(this, thongBao, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                dispose(); // Đóng cửa sổ đăng ký sau khi đăng ký thành công
                new DangNhap().setVisible(true); // Mở lại cửa sổ đăng nhập sau khi đăng ký thành công
            } else {
                JOptionPane.showMessageDialog(this, "Đăng ký thất bại!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}

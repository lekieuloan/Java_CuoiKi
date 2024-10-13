package View;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CaiDat extends JPanel {

    private static final long serialVersionUID = 1L;
    
    private JTextField txtMaNhanVien;
    private JTextField txtTenNhanVien;
    private JTextField txtGioiTinh;
    private JTextField txtChucVu;
    private JTextField txtNgayVaoLam;
    private JTextField txtDiaChi;
    private JTextField txtSoDienThoai;

    /**
     * Create the panel.
     */
    public CaiDat() {
        setLayout(null);
        setSize(1206, 700);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(139, 69, 19));
        panel.setBounds(0, 0, 1200, 70);
        add(panel);

        JLabel lblNewLabel = new JLabel("TÀI KHOẢN");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
        panel.add(lblNewLabel);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 75, 1200, 620);
        panel_1.setLayout(null);
        add(panel_1);
        
        JLabel lblMaNhanVien = new JLabel("Mã nhân viên:");
        lblMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 19));
        lblMaNhanVien.setBounds(30, 40, 180, 30);
        panel_1.add(lblMaNhanVien);
        
        txtMaNhanVien = new JTextField();
        txtMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 19));
        txtMaNhanVien.setBounds(220, 40, 200, 30);
        panel_1.add(txtMaNhanVien);
        txtMaNhanVien.setColumns(10);

        JLabel lblNgayVaoLam = new JLabel("Ngày vào làm:");
        lblNgayVaoLam.setFont(new Font("Tahoma", Font.PLAIN, 19));
        lblNgayVaoLam.setBounds(640, 40, 180, 30);
        panel_1.add(lblNgayVaoLam);
        
        txtNgayVaoLam = new JTextField();
        txtNgayVaoLam.setFont(new Font("Tahoma", Font.PLAIN, 19));
        txtNgayVaoLam.setBounds(820, 40, 200, 30);
        panel_1.add(txtNgayVaoLam);
        txtNgayVaoLam.setColumns(10);

        JLabel lblTenNhanVien = new JLabel("Họ tên:");
        lblTenNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 19));
        lblTenNhanVien.setBounds(30, 145, 180, 30);
        panel_1.add(lblTenNhanVien);
        
        txtTenNhanVien = new JTextField();
        txtTenNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 19));
        txtTenNhanVien.setBounds(220, 145, 200, 30);
        panel_1.add(txtTenNhanVien);
        txtTenNhanVien.setColumns(10);

        JLabel lblGioiTinh = new JLabel("Giới tính:");
        lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 19));
        lblGioiTinh.setBounds(30, 235, 180, 30);
        panel_1.add(lblGioiTinh);
        
        txtGioiTinh = new JTextField();
        txtGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 19));
        txtGioiTinh.setBounds(220, 235, 200, 30);
        panel_1.add(txtGioiTinh);
        txtGioiTinh.setColumns(10);

        JLabel lblDiaChi = new JLabel("Địa chỉ:");
        lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 19));
        lblDiaChi.setBounds(640, 145, 180, 30);
        panel_1.add(lblDiaChi);
        
        txtDiaChi = new JTextField();
        txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 19));
        txtDiaChi.setBounds(820, 145, 200, 30);
        panel_1.add(txtDiaChi);
        txtDiaChi.setColumns(10);

        JLabel lblChucVu = new JLabel("Chức vụ:");
        lblChucVu.setFont(new Font("Tahoma", Font.PLAIN, 19));
        lblChucVu.setBounds(30, 325, 180, 30);
        panel_1.add(lblChucVu);
        
        txtChucVu = new JTextField();
        txtChucVu.setFont(new Font("Tahoma", Font.PLAIN, 19));
        txtChucVu.setBounds(220, 325, 200, 30);
        panel_1.add(txtChucVu);
        txtChucVu.setColumns(10);

        JLabel lblSoDienThoai = new JLabel("Số điện thoại:");
        lblSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 19));
        lblSoDienThoai.setBounds(640, 235, 180, 30);
        panel_1.add(lblSoDienThoai);
        
        txtSoDienThoai = new JTextField();
        txtSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 19));
        txtSoDienThoai.setBounds(820, 235, 200, 30);
        panel_1.add(txtSoDienThoai);
        txtSoDienThoai.setColumns(10);

        JButton btnSave = new JButton("Lưu");
        btnSave.setFont(new Font("Tahoma", Font.PLAIN, 19));
        btnSave.setBounds(820, 325, 100, 30);
        panel_1.add(btnSave);

        JButton btnCancel = new JButton("Hủy");
        btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 19));
        btnCancel.setBounds(930, 325, 100, 30);
        panel_1.add(btnCancel);

        // Tải thông tin nhân viên (giả lập)
        loadEmployeeData();
    }

    private void loadEmployeeData() {
        // Giả sử bạn có một lớp Employee và một phương thức để lấy dữ liệu của nhân viên đang đăng nhập
        Employee employee = getLoggedInEmployee();

        txtMaNhanVien.setText(employee.getMaNhanVien());
        txtTenNhanVien.setText(employee.getTenNhanVien());
        txtGioiTinh.setText(employee.getGioiTinh() == 1 ? "Nam" : "Nữ");
        txtChucVu.setText(employee.getChucVu());
        txtNgayVaoLam.setText(employee.getNgayVaoLam());
        txtDiaChi.setText(employee.getDiaChi());
        txtSoDienThoai.setText(String.valueOf(employee.getSoDienThoai()));
    }

    private Employee getLoggedInEmployee() {
        // Phương thức giả lập để lấy thông tin nhân viên đang đăng nhập
        // Bạn nên thay thế bằng logic thực tế để lấy dữ liệu của nhân viên đang đăng nhập
        return new Employee("NV1", "Nguyen Van A", 1, "Nhan Vien", "2005-08-13", "Da Nang", 123234345);
    }

    // Lớp Employee giả lập, thay thế bằng lớp Employee thực tế của bạn
    class Employee {
        private String maNhanVien;
        private String tenNhanVien;
        private int gioiTinh;
        private String chucVu;
        private String ngayVaoLam;
        private String diaChi;
        private int soDienThoai;

        public Employee(String maNhanVien, String tenNhanVien, int gioiTinh, String chucVu, String ngayVaoLam, String diaChi, int soDienThoai) {
            this.maNhanVien = maNhanVien;
            this.tenNhanVien = tenNhanVien;
            this.gioiTinh = gioiTinh;
            this.chucVu = chucVu;
            this.ngayVaoLam = ngayVaoLam;
            this.diaChi = diaChi;
            this.soDienThoai = soDienThoai;
        }

        public String getMaNhanVien() {
            return maNhanVien;
        }

        public String getTenNhanVien() {
            return tenNhanVien;
        }

        public int getGioiTinh() {
            return gioiTinh;
        }

        public String getChucVu() {
            return chucVu;
        }

        public String getNgayVaoLam() {
            return ngayVaoLam;
        }

        public String getDiaChi() {
            return diaChi;
        }

        public int getSoDienThoai() {
            return soDienThoai;
        }
    }
}

package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JFrame;

public class TaiKhoan extends JPanel {

    private static final long serialVersionUID = 1L;

    /**
     * Create the panel.
     */
    public TaiKhoan() {
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
        
        // Create and add labels for each field
        JLabel lblMaNhanVienLabel = createLabel("Mã nhân viên:", 30, 40, 180, 30, panel_1);
        JLabel lblNgayVaoLamLabel = createLabel("Ngày vào làm:", 640, 40, 180, 30, panel_1);
        JLabel lblHoTenLabel = createLabel("Họ tên:", 30, 145, 180, 30, panel_1);
        JLabel lblGioiTinhLabel = createLabel("Giới tính:", 30, 235, 180, 30, panel_1);
        JLabel lblDiaChiLabel = createLabel("Địa chỉ:", 640, 145, 180, 30, panel_1);
        JLabel lblChucVuLabel = createLabel("Chức vụ:", 30, 325, 180, 30, panel_1);
        JLabel lblSoDienThoaiLabel = createLabel("Số điện thoại:", 640, 235, 180, 30, panel_1);
        
        // Create and add labels for displaying data
        JLabel lblMaNhanVien = createDataLabel("NV1", 230, 40, 300, 30, panel_1);
        JLabel lblNgayVaoLam = createDataLabel("2005-08-13", 840, 40, 300, 30, panel_1);
        JLabel lblHoTen = createDataLabel("Nguyen Van A", 230, 145, 300, 30, panel_1);
        JLabel lblGioiTinh = createDataLabel("Nam", 230, 235, 300, 30, panel_1);
        JLabel lblDiaChi = createDataLabel("Da Nang", 840, 145, 300, 30, panel_1);
        JLabel lblChucVu = createDataLabel("Nhan Vien", 230, 325, 300, 30, panel_1);
        JLabel lblSoDienThoai = createDataLabel("123234345", 840, 235, 300, 30, panel_1);
        
        JButton btnNewButton = new JButton("đăng xuất");
        btnNewButton.setBounds(770, 430, 100, 30);
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 int chon = JOptionPane.showConfirmDialog(null, "Xác nhận đăng xuất?", "Messenger", JOptionPane.YES_NO_OPTION);
			        if (chon == JOptionPane.YES_OPTION) {
			            // Đóng cửa sổ hiện tại
			            JFrame currentWindow = (JFrame) SwingUtilities.getWindowAncestor(panel_1);
			            currentWindow.dispose();
			            
			            // Mở lại cửa sổ đăng nhập
			            DangNhap dangNhap = new DangNhap();
			            dangNhap.setVisible(true);
                }
            
				
			}
		});
        panel_1.add(btnNewButton);
        
    }

    private JLabel createLabel(String text, int x, int y, int width, int height, JPanel panel) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Tahoma", Font.PLAIN, 19));
        label.setBounds(x, y, width, height);
        panel.add(label);
        return label;
    }

    private JLabel createDataLabel(String text, int x, int y, int width, int height, JPanel panel) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Tahoma", Font.PLAIN, 19));
        label.setBounds(x, y, width, height);
        panel.add(label);
        return label;
    }
}

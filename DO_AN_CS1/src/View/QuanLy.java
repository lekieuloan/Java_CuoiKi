package View;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class QuanLy extends JPanel {

    private static final long serialVersionUID = 1L;
    private JPanel panelHienThi;
    private CardLayout cardLayout;
    private JTable table;
    private DefaultTableModel model;
    private int selectedRow = -1;

    public QuanLy() {
        setLayout(null);
        setSize(1206, 700);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(139, 69, 19));
        panel.setBounds(0, 0, 1200, 70);
        add(panel);

        JLabel lblNewLabel = new JLabel("Quản lý");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
        panel.add(lblNewLabel);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 75, 1200, 620);
        panel_1.setLayout(null);
        add(panel_1);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(211, 211, 211));
        panel_2.setBounds(0, 0, 224, 620);
        panel_1.add(panel_2);
        panel_2.setLayout(null);

        createNavigationPanel(panel_2);

        panelHienThi = new JPanel();
        panelHienThi.setBounds(234, 0, 970, 620);
        cardLayout = new CardLayout();
        panelHienThi.setLayout(cardLayout);
        panel_1.add(panelHienThi);

        initializeCardPanels();
    }

    private void createNavigationPanel(JPanel panel) {
        String[] labels = {"Nhân viên", "Thực đơn", "Hoá đơn", "Bàn"};
        for (int i = 0; i < labels.length; i++) {
            JPanel panelItem = new JPanel();
            panelItem.setBackground(new Color(222, 184, 135));
            panelItem.setBounds(10, 11 + i * 85, 200, 60);
            panelItem.setLayout(null);

            JLabel lbl = new JLabel(labels[i]);
            lbl.setHorizontalAlignment(SwingConstants.CENTER);
            lbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
            lbl.setBounds(10, 11, 170, 35);
            lbl.addMouseListener(new LabelMouseListener(i));
            panelItem.add(lbl);

            panel.add(panelItem);
        }

        JButton btnCapNhat = new JButton("Cập nhật");
        btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnCapNhat.setBounds(10, 562, 89, 40);
        btnCapNhat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedRow != -1) {
                    updateEmployeeInfo();
                } else {
                    JOptionPane.showMessageDialog(null, "Hãy chọn một đối tượng để cập nhật.");
                }
            }
        });
        panel.add(btnCapNhat);

        JButton btnXoa = new JButton("Xóa");
        btnXoa.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnXoa.setBounds(125, 562, 89, 40);
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedRow != -1) {
                    deleteEmployee();
                } else {
                    JOptionPane.showMessageDialog(null, "Hãy chọn một đối tượng để xóa.");
                }
            }
        });
        panel.add(btnXoa);
    }

    private void initializeCardPanels() {
        JPanel panelNhanVien = new JPanel();
        panelNhanVien.setLayout(null);

        String[] columnNames = {"Mã NV", "Tên NV", "Giới tính", "Chức vụ", "Ngày vào làm", "Địa chỉ", "Số ĐT", "Mật khẩu"};
        Object[][] data = {
            {"NV1", "Nguyen Van A", 1, "Nhan Vien", "2005-08-13", "Da Nang", 123234345, "123456"},
            {"NV2", "Nguyen Van B", 1, "Nhan Vien", "2004-07-07", "Da Nang", 123234345, "123456"},
            {"NV3", "Nguyen Van C", 1, "Nhan Vien", "2003-10-06", "Da Nang", 123234345, "123456"},
            {"NV4", "Nguyen Van D", 1, "Nhan Vien", "2002-03-24", "Da Nang", 123234345, "123456"}
        };

        model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectedRow = table.getSelectedRow();
            }
        });
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 10, 950, 600);
        panelNhanVien.add(scrollPane);

        panelHienThi.add(panelNhanVien, "NhanVien");

        
//        
        JPanel panelThucDon = new JPanel();
        panelThucDon.setBackground(Color.CYAN);
        panelHienThi.add(panelThucDon, "ThucDon");
        

        JPanel panelHoaDon = new JPanel();
        panelHoaDon.setBackground(Color.PINK);
        panelHienThi.add(panelHoaDon, "HoaDon");

        JPanel panelBan = new JPanel();
        panelBan.setBackground(Color.ORANGE);
        panelHienThi.add(panelBan, "Ban");

       
        
//        
        
    }

    private void updateEmployeeInfo() {
        String maNV = (String) table.getValueAt(selectedRow, 0);
        String tenNV = (String) table.getValueAt(selectedRow, 1);
        int gioiTinh = (int) table.getValueAt(selectedRow, 2);
        String chucVu = (String) table.getValueAt(selectedRow, 3);
        String ngayVaoLam = (String) table.getValueAt(selectedRow, 4);
        String diaChi = (String) table.getValueAt(selectedRow, 5);
        int soDT = (int) table.getValueAt(selectedRow, 6);
        String matKhau = (String) table.getValueAt(selectedRow, 7);

        JPanel panelUpdate = new JPanel();
        panelUpdate.setLayout(null);
        panelUpdate.setSize(400, 300);

        JLabel lblMaNV = new JLabel("Mã NV:");
        lblMaNV.setBounds(10, 10, 80, 25);
        panelUpdate.add(lblMaNV);
        JLabel lblMaNVValue = new JLabel(maNV);
        lblMaNVValue.setBounds(100, 10, 160, 25);
        panelUpdate.add(lblMaNVValue);

        JLabel lblTenNV = new JLabel("Tên NV:");
        lblTenNV.setBounds(10, 40, 80, 25);
        panelUpdate.add(lblTenNV);
        JTextField txtTenNV = new JTextField(tenNV);
        txtTenNV.setBounds(100, 40, 160, 25);
        panelUpdate.add(txtTenNV);

        JLabel lblGioiTinh = new JLabel("Giới tính:");
        lblGioiTinh.setBounds(10, 70, 80, 25);
        panelUpdate.add(lblGioiTinh);
        JTextField txtGioiTinh = new JTextField(String.valueOf(gioiTinh));
        txtGioiTinh.setBounds(100, 70, 160, 25);
        panelUpdate.add(txtGioiTinh);

        JLabel lblChucVu = new JLabel("Chức vụ:");
        lblChucVu.setBounds(10, 100, 80, 25);
        panelUpdate.add(lblChucVu);
        JTextField txtChucVu = new JTextField(chucVu);
        txtChucVu.setBounds(100, 100, 160, 25);
        panelUpdate.add(txtChucVu);

        JLabel lblNgayVaoLam = new JLabel("Ngày vào làm:");
        lblNgayVaoLam.setBounds(10, 130, 100, 25);
        panelUpdate.add(lblNgayVaoLam);
        JTextField txtNgayVaoLam = new JTextField(ngayVaoLam);
        txtNgayVaoLam.setBounds(120, 130, 140, 25);
        panelUpdate.add(txtNgayVaoLam);

        JLabel lblDiaChi = new JLabel("Địa chỉ:");
        lblDiaChi.setBounds(10, 160, 80, 25);
        panelUpdate.add(lblDiaChi);
        JTextField txtDiaChi = new JTextField(diaChi);
        txtDiaChi.setBounds(100, 160, 160, 25);
        panelUpdate.add(txtDiaChi);

        JLabel lblSoDT = new JLabel("Số ĐT:");
        lblSoDT.setBounds(10, 190, 80, 25);
        panelUpdate.add(lblSoDT);
        JTextField txtSoDT = new JTextField(String.valueOf(soDT));
        txtSoDT.setBounds(100, 190, 160, 25);
        panelUpdate.add(txtSoDT);

        JLabel lblMatKhau = new JLabel("Mật khẩu:");
        lblMatKhau.setBounds(10, 220, 80, 25);
        panelUpdate.add(lblMatKhau);
        JTextField txtMatKhau = new JTextField(matKhau);
        txtMatKhau.setBounds(100, 220, 160, 25);
        panelUpdate.add(txtMatKhau);

        int result = JOptionPane.showConfirmDialog(null, panelUpdate, "Cập nhật thông tin nhân viên", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            model.setValueAt(txtTenNV.getText(), selectedRow, 1);
            model.setValueAt(Integer.parseInt(txtGioiTinh.getText()), selectedRow, 2);
            model.setValueAt(txtChucVu.getText(), selectedRow, 3);
            model.setValueAt(txtNgayVaoLam.getText(), selectedRow, 4);
            model.setValueAt(txtDiaChi.getText(), selectedRow, 5);
            model.setValueAt(Integer.parseInt(txtSoDT.getText()), selectedRow, 6);
            model.setValueAt(txtMatKhau.getText(), selectedRow, 7);
        }
    }

    private void deleteEmployee() {
        String tenNV = (String) table.getValueAt(selectedRow, 1);
        int confirm = JOptionPane.showConfirmDialog(null, "Bạn muốn xóa nhân viên " + tenNV + " khỏi ứng dụng?", "Xác nhận xóa", JOptionPane.OK_CANCEL_OPTION);
        if (confirm == JOptionPane.OK_OPTION) {
            model.removeRow(selectedRow);
            selectedRow = -1;
        }
    }

    private class LabelMouseListener extends MouseAdapter {
        private int index;

        public LabelMouseListener(int index) {
            this.index = index;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (index) {
                case 0:
                    cardLayout.show(panelHienThi, "NhanVien");
                    break;
                case 1:
                    cardLayout.show(panelHienThi, "ThucDon");
                    break;
                case 2:
                    cardLayout.show(panelHienThi, "HoaDon");
                    break;
                case 3:
                    cardLayout.show(panelHienThi, "Ban");
                    break;
                
            }
        }
    }
}

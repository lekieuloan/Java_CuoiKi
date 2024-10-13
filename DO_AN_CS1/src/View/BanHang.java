package View;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.BanHang_DAO;
import Model.ThuDon;

import javax.swing.JScrollPane;

public class BanHang extends JPanel {

    private static final long serialVersionUID = 1L;
    private CardLayout cardLayout;
    private JPanel card_panel;
    private JLabel lblTenBan;
    private JTextField txtGiamGia;
    private JTable table;
    private DefaultTableModel tableModel;
    private JLabel lblTongTien;
    private JLabel lblThoiGian;

    /**
     * Create the panel.
     */
    public BanHang() {
        setBackground(new Color(244, 164, 96));
        setLayout(null);
        setSize(1200, 700);

        card_panel = new JPanel();
        card_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        cardLayout = new CardLayout(0, 0);
        card_panel.setLayout(cardLayout);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(139, 69, 19));
        panel.setBounds(0, 0, 1200, 70);
        add(panel);

        JLabel lblNewLabel = new JLabel("BÁN HÀNG");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
        panel.add(lblNewLabel);

        createFloorPanel(card_panel, "Tang1", 1, 6);
        createFloorPanel(card_panel, "Tang2", 7, 12);
        createFloorPanel(card_panel, "Tang3", 13, 18);

        card_panel.setBounds(0, 74, 300, 550);
        add(card_panel);

        JPanel panelTang = new JPanel();
        panelTang.setLayout(null);
        panelTang.setBounds(0, 640, 300, 60);
        add(panelTang);

        createFloorButton(panelTang, "Tầng 1", "Tang1", 0, 11);
        createFloorButton(panelTang, "Tầng 2", "Tang2", 105, 11);
        createFloorButton(panelTang, "Tầng 3", "Tang3", 211, 11);

        cardLayout.show(card_panel, "Tang1");

        // Tạo panel_4 cho hóa đơn
        JPanel panel_4 = new JPanel();
        panel_4.setBackground(new Color(211, 211, 211));
        panel_4.setBounds(300, 74, 500, 550);
        add(panel_4);
        panel_4.setLayout(null);

        JLabel lblHoaDon = new JLabel("Hóa đơn");
        lblHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblHoaDon.setBounds(200, 5, 85, 25);
        panel_4.add(lblHoaDon);

        JLabel lblBan = new JLabel("Bàn:");
        lblBan.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblBan.setBounds(20, 40, 50, 25);
        panel_4.add(lblBan);

        lblTenBan = new JLabel("Tên bàn");
        lblTenBan.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblTenBan.setBounds(70, 40, 200, 25);
        panel_4.add(lblTenBan);

        JLabel lblGiamGia = new JLabel("Giảm giá (%):");
        lblGiamGia.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblGiamGia.setBounds(20, 75, 120, 25);
        panel_4.add(lblGiamGia);

        txtGiamGia = new JTextField();
        txtGiamGia.setBounds(155, 76, 100, 25);
        panel_4.add(txtGiamGia);
        txtGiamGia.setColumns(10);

        JLabel lblMonAn = new JLabel("Món ăn đã gọi:");
        lblMonAn.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblMonAn.setBounds(20, 110, 120, 25);
        panel_4.add(lblMonAn);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 140, 460, 200);
        panel_4.add(scrollPane);

        tableModel = new DefaultTableModel(
            new Object[][] {},
            new String[] {"Tên món", "Số lượng", "Giá", "Thành tiền"}
        );
        table = new JTable(tableModel);
        scrollPane.setViewportView(table);

        JLabel lblTong = new JLabel("Tổng tiền:");
        lblTong.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblTong.setBounds(20, 350, 100, 25);
        panel_4.add(lblTong);

        lblTongTien = new JLabel("0 VND");
        lblTongTien.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblTongTien.setBounds(130, 350, 200, 25);
        panel_4.add(lblTongTien);

        JLabel lblThoiGianTao = new JLabel("Thời gian tạo:");
        lblThoiGianTao.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblThoiGianTao.setBounds(20, 385, 120, 25);
        panel_4.add(lblThoiGianTao);

        lblThoiGian = new JLabel();
        lblThoiGian.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblThoiGian.setBounds(150, 385, 200, 25);
        panel_4.add(lblThoiGian);

        // Khởi tạo thời gian tạo hóa đơn
        lblThoiGian.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        
        JButton btnNewButton = new JButton("áp dụng");
        btnNewButton.setBounds(316, 75, 89, 23);
        panel_4.add(btnNewButton);
        
        JLabel lblTnhTrng = new JLabel("Tình Trạng:");
        lblTnhTrng.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblTnhTrng.setBounds(20, 421, 120, 25);
        panel_4.add(lblTnhTrng);
        
        JLabel lblTrng = new JLabel("Trống");
        lblTrng.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblTrng.setBounds(130, 421, 120, 25);
        panel_4.add(lblTrng);
        
        JButton btnNewButton_1 = new JButton("Thanh toan");
        btnNewButton_1.setBounds(282, 494, 100, 30);
        panel_4.add(btnNewButton_1);

//        // Giả lập thêm món ăn
//        addMonAn("Phở", 2, 30000);
//        addMonAn("Bún bò", 1, 35000);

        // Tạo panel_1 cho menu

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(810, 74, 380, 620); // Điều chỉnh kích thước và vị trí phù hợp
        add(panel_1);
        panel_1.setLayout(null);

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(128, 128, 128));
        panel_3.setBounds(0, 0, 380, 40); // Điều chỉnh kích thước và vị trí phù hợp
        panel_1.add(panel_3);
        panel_3.setLayout(new GridLayout(9, 2)); 
        panel_3.setLayout(null);

        JLabel lblNewLabel_3 = new JLabel("MENU");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_3.setBounds(147, 5, 85, 25); // Điều chỉnh vị trí phù hợp
        panel_3.add(lblNewLabel_3);

        // Lấy danh sách tên các món ăn từ cơ sở dữ liệu
     // Lấy danh sách tên các món ăn từ cơ sở dữ liệu
        BanHang_DAO monAnDAO = new BanHang_DAO();
        ArrayList<String> danhSachMonAn = monAnDAO.layTenMonAn();

        // Thêm các món ăn vào menu
        int yPos = 50;
        for (String mon : danhSachMonAn) {
            JButton btnMonAn = new JButton(mon);
            btnMonAn.setBounds(10, yPos, 360, 50); // Điều chỉnh kích thước và vị trí phù hợp
            panel_1.add(btnMonAn);
            yPos += 60;

            // Thêm sự kiện khi click vào món ăn
            btnMonAn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Lấy thông tin chi tiết của món ăn từ tên món
                    ThuDon monAn = monAnDAO.layThongTinMonAn(mon);
                    if (monAn != null) {
                        // Thêm món ăn vào bảng
                        addMonAn(monAn.getTenMon(), 1, monAn.getDonGia());
                    } else {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin món ăn!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    }
                }
            });
        }
    }

    private void createFloorPanel(JPanel parentPanel, String name, int startBan, int endBan) {
        JPanel floorPanel = new JPanel();
        floorPanel.setLayout(null);

        JPanel panelHeader = new JPanel();
        panelHeader.setBackground(new Color(128, 128, 128));
        panelHeader.setBounds(0, 0, 300, 40);
        floorPanel.add(panelHeader);
        panelHeader.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Chọn Bàn");
        lblNewLabel_1.setBounds(107, 5, 85, 25);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panelHeader.add(lblNewLabel_1);

        int yPos = 73;
        for (int i = startBan; i <= endBan; i++) {
            JPanel jpban = new JPanel();
            jpban.setBackground(new Color(100, 149, 237));
            jpban.setBounds((i % 2 == 1) ? 10 : 160, yPos, 130, 130);
            floorPanel.add(jpban);
            jpban.setLayout(null);

            JLabel lblNewLabel_2 = new JLabel("Bàn " + i);
            lblNewLabel_2.setBounds(10, 20, 110, 90);
            lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
            lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
            jpban.add(lblNewLabel_2);

            final int banNumber = i;
            jpban.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    lblTenBan.setText("Bàn " + banNumber);
                }
            });

            if (i % 2 == 0) yPos += 150;
        }

        parentPanel.add(floorPanel, name);
    }

    private void createFloorButton(JPanel panelTang, String name, String floorName, int x, int y) {
        JButton btnTang = new JButton(name);
        btnTang.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnTang.setBounds(x, y, 89, 38);
        panelTang.add(btnTang);
        btnTang.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(card_panel, floorName);
            }
        });
    }

    private void addMonAn(String tenMon, int soLuong, int gia) {
        int rowCount = tableModel.getRowCount();
        boolean found = false;

        for (int i = 0; i < rowCount; i++) {
            String existingTenMon = (String) tableModel.getValueAt(i, 0);
            if (existingTenMon.equals(tenMon)) {
                int existingSoLuong = (int) tableModel.getValueAt(i, 1);
                tableModel.setValueAt(existingSoLuong + soLuong, i, 1);
                tableModel.setValueAt((existingSoLuong + soLuong) * gia, i, 3);
                found = true;
                break;
            }
        }

        if (!found) {
            int thanhTien = soLuong * gia;
            tableModel.addRow(new Object[]{tenMon, soLuong, gia, thanhTien});
        }

        updateTongTien();
    }


    private void updateTongTien() {
        int rowCount = tableModel.getRowCount();
        int tongTien = 0;
        for (int i = 0; i < rowCount; i++) {
            tongTien += (int) tableModel.getValueAt(i, 3);
        }
        lblTongTien.setText(String.format("%,d VND", tongTien));
    }
}

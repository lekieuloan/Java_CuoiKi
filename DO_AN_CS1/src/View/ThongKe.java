package View;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThongKe extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField txtTimKiemNgay;
    private JTextField txtTimKiemThang;
    private DefaultTableModel modelNgay;
    private DefaultTableModel modelThang;
    private JPanel panelNgay;
    private JPanel panelThang;

    /**
     * Create the panel.
     */
    public ThongKe() {
        setLayout(null);
        setSize(1206, 700);

        JLabel lblTitle = new JLabel("THỐNG KÊ DOANH THU");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblTitle.setBounds(400, 20, 400, 50);
        add(lblTitle);

        panelNgay = new JPanel();
        panelNgay.setBounds(30, 80, 550, 300);
        panelNgay.setLayout(new GridLayout(1, 1));
        add(panelNgay);

        JLabel lblNgay = new JLabel("Thống kê theo ngày");
        lblNgay.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNgay.setBounds(30, 50, 200, 30);
        add(lblNgay);

        modelNgay = new DefaultTableModel(
                new Object[][]{
                        {"2024-06-01", 1000000},
                        {"2024-06-02", 1500000},
                        {"2024-06-03", 1200000},
                        {"2024-06-04", 1300000},
                },
                new String[]{
                        "Ngày", "Doanh thu (VNĐ)"
                }
        );

        txtTimKiemNgay = new JTextField();
        txtTimKiemNgay.setBounds(630, 80, 150, 30);
        add(txtTimKiemNgay);

        JButton btnTimKiemNgay = new JButton("Tìm kiếm");
        btnTimKiemNgay.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnTimKiemNgay.setBounds(800, 80, 150, 30);
        add(btnTimKiemNgay);

        btnTimKiemNgay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ngay = txtTimKiemNgay.getText();
              
                drawNgayChart(); // Vẽ biểu đồ ngay khi tìm kiếm
            }
        });

        panelThang = new JPanel();
        panelThang.setBounds(30, 450, 550, 300);
        panelThang.setLayout(new GridLayout(1, 1));
        add(panelThang);

        JLabel lblThang = new JLabel("Thống kê theo tháng");
        lblThang.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblThang.setBounds(30, 400, 280, 30);
        add(lblThang);

        modelThang = new DefaultTableModel(
                new Object[][]{
                        {"2024-01", 30000000},
                        {"2024-02", 28000000},
                        {"2024-03", 32000000},
                        {"2024-04", 31000000},
                },
                new String[]{
                        "Tháng", "Doanh thu (VNĐ)"
                }
        );

        txtTimKiemThang = new JTextField();
        txtTimKiemThang.setBounds(630, 450, 150, 30);
        add(txtTimKiemThang);

        JButton btnTimKiemThang = new JButton("Tìm kiếm");
        btnTimKiemThang.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnTimKiemThang.setBounds(800, 450, 150, 30);
        add(btnTimKiemThang);

        btnTimKiemThang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String thang = txtTimKiemThang.getText();
               
                drawThangChart(); // Vẽ biểu đồ thang khi tìm kiếm
            }
        });

        drawNgayChart(); // Vẽ biểu đồ ngay khi khởi động panel
        drawThangChart(); // Vẽ biểu đồ thang khi khởi động panel
    }

   
    private void drawNgayChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < modelNgay.getRowCount(); i++) {
            String ngay = (String) modelNgay.getValueAt(i, 0);
            int doanhThu = (int) modelNgay.getValueAt(i, 1);
            dataset.setValue(doanhThu, "Doanh thu", ngay);
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Doanh thu theo ngày",
                "Ngày",
                "Doanh thu (VNĐ)",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(550, 300));

        panelNgay.removeAll();
        panelNgay.add(chartPanel);
        panelNgay.revalidate();
        panelNgay.repaint();
    }

    private void drawThangChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < modelThang.getRowCount(); i++) {
            String thang = (String) modelThang.getValueAt(i, 0);
            int doanhThu = (int) modelThang.getValueAt(i, 1);
            dataset.setValue(doanhThu, "Doanh thu", thang);
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Doanh thu theo tháng",
                "Tháng",
                "Doanh thu (VNĐ)",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(550, 300));

        panelThang.removeAll();
        panelThang.add(chartPanel);
        chartPanel.setLayout(null);
        panelThang.revalidate();
        panelThang.repaint();
    }
}

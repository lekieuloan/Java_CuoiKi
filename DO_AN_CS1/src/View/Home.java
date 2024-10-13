package View;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Home extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Home() {
		
		setBackground(new Color(210, 180, 140));
		setLayout(null);
		setSize(1206, 750);
		
		JLabel lblNewLabel = new JLabel("ỨNG DỤNG QUẢN LÝ ");
		lblNewLabel.setForeground(new Color(255, 102, 0));
		JLabel lblNewLabel2 = new JLabel(" QUÁN CAFE CARIA");
		lblNewLabel2.setForeground(new Color(255, 102, 0));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 80));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(100, 150, 900, 204);
		lblNewLabel2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 83));
		lblNewLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel2.setBounds(270, 370, 900, 204);
		add(lblNewLabel);
		add(lblNewLabel2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\HTML-CSS-WED\\Đồ_Án_cafe\\image\\cherry.jpg"));
		lblNewLabel_1.setBounds(0, 0, 888, 439);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\HTML-CSS-WED\\Đồ_Án_cafe\\image\\home.jpg"));
		lblNewLabel_2.setBounds(0, 439, 600, 310);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\HTML-CSS-WED\\Đồ_Án_cafe\\image\\americano.jpg"));
		lblNewLabel_3.setBounds(799, 0, 400, 300);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\HTML-CSS-WED\\Đồ_Án_cafe\\image\\home3.jpg"));
		lblNewLabel_4.setBounds(597, 303, 600, 450);
		add(lblNewLabel_4);

	}
}

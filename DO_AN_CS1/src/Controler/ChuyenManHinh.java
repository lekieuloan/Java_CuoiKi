package Controler;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;



import List.Home_List;
import View.BanHang;
import View.CaiDat;
import View.Home;
import View.QuanLy;
import View.TaiKhoan;
import View.ThongKe;

public class ChuyenManHinh  {
	private JPanel panel;
	private String node = "";
	private List<Home_List> list;
	
	
	public ChuyenManHinh(JPanel panel) {
		this.panel= panel;
	}


	public void setView(JPanel panelItem, JLabel lableItem) {
		
		node= "Home";
		panelItem.setBackground(new Color(255, 228, 181));
		lableItem.setBackground(new Color(255, 228, 181));
		
		panel.removeAll();
		panel.setLayout(new BorderLayout());
		panel.add(new Home());
		panel.validate();
		panel.repaint();
	}
	
	public void setEvent(List<Home_List> listItem)  {
		this.list= listItem;
		for(Home_List item : listItem ) {
			 item.getLabel().addMouseListener(new LabelEvent(item.getNote(), item.getPanel(), item.getLabel()));
			
		}
		
	}
	
	class LabelEvent implements MouseListener{
		private JPanel note;
		private String kind;
		
		private JPanel jpnItem;
		private JLabel jlbItem;
		
		
		
		

		public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
		
			this.kind = kind;
			this.jpnItem = jpnItem;
			this.jlbItem = jlbItem;
		}
		

		@Override
		public void mouseClicked(MouseEvent e) {
			switch(kind) {
				case "Home" :
					note = new Home();
					break;
				case "BanHang" :
					note= new BanHang();
					break;
				case "TaiKhoan" :
					note = new TaiKhoan();
					break;
				case "QuanLy" :
					note= new QuanLy();
					break;
				case "CaiDat" :
					note = new CaiDat();
					break;
				case "ThongKe" :
					note = new ThongKe();
					break;
				default :
					break;
	
			}
			
			panel.removeAll();
			panel.setLayout(new BorderLayout());
			panel.add(note);
			panel.validate();
			panel.repaint();
			setColor(kind);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			node= kind;
			jpnItem.setBackground(new Color(255, 228, 181));
	        jlbItem.setBackground(new Color(255, 228, 181));
			
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			jpnItem.setBackground(new Color(255, 228, 181));
	        jlbItem.setBackground(new Color(255, 228, 181));
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (!node.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(139, 69, 19));
                jlbItem.setBackground(new Color(139, 69, 19));
			
			}
		
		}
	}
	
	private void setColor(String kind) {
		for(Home_List item : list) {
			if(item.getNote().equalsIgnoreCase(kind)) {
				item.getLabel().setBackground(new Color(255, 228, 181));
		        item.getPanel().setBackground(new Color(255, 228, 181));
			}else {
				item.getLabel().setBackground(new Color(139, 69, 19));
		        item.getPanel().setBackground(new Color(139, 69, 19));
			}
			
			
		}
		
		
	}
	

}

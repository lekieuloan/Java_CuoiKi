package List;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Home_List {
	
	private JPanel panel;
	private JLabel label;
	private String note;
	
	public Home_List() {
		
	}
	
	public Home_List(JPanel panel, JLabel label, String note) {
		
		this.panel = panel;
		this.label = label;
		this.note = note;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	
	
	
	

}

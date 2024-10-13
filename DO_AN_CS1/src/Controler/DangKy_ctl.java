package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.NhanVien;
import View.DangKy;

public class DangKy_ctl implements ActionListener {
    private NhanVien nhanVien;
    private DangKy dangKy;
    
    public DangKy_ctl(NhanVien nhanVien){
        this.nhanVien = nhanVien;
    }
    public DangKy_ctl(DangKy dangKy){
        this.dangKy = dangKy;
    }
    
    
    
	@Override
	public void actionPerformed(ActionEvent e) {
		 String src = e.getActionCommand();
       
       if (src.equals("Đăng ký")){
           this.dangKy.thucHienDangKyTaiKhoan();
       
   
		
       }
	}
}

	



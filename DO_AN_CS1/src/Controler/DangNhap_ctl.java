package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.NhanVien;
import View.DangKy;
import View.DangNhap;

public class DangNhap_ctl implements ActionListener {
    private NhanVien nhanVien;
    private DangNhap dangNhap;
    
    public DangNhap_ctl(NhanVien nhanVien){
        this.nhanVien = nhanVien;
    }
    public DangNhap_ctl(DangNhap dangNhap){
        this.dangNhap = dangNhap;
    }
    
    
    
	@Override
	public void actionPerformed(ActionEvent e) {
		 String src = e.getActionCommand();
       if (src.equals("Đăng nhập")){
           this.dangNhap.thucHienDangNhap();
       }
     
//       if (src.equals("Xác nhận")){
//           this.dangNhap.thucHienXoaTaiKhoan();
//       }
//   
//		
	}
}

	



package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.sql.ResultSet;

import Connection.JDCBCUtil;
import Model.NhanVien;

public class NhanVien_DAO {
	public static NhanVien_DAO getInstance(){
    return new NhanVien_DAO();
	}
	
	 public int dangKyTaiKhoan(NhanVien ngDung){
	        try{
	            Connection connection = JDCBCUtil.getConnection();
	            String sql = "INSERT INTO nhanvien (MaNV, TenNV, GioiTinh, ChucVu, NgayVaoLam, DiaChi, SDT, MatKhau)"
	            		+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, )";
	            PreparedStatement pst = connection.prepareStatement(sql);
	            pst.setString(1, ngDung.getMaNV());
	            pst.setString(2, ngDung.getTenNV());
	            pst.setInt(3, ngDung.getGioiTinh());
	            pst.setString(4, ngDung.getChucVu());
	            pst.setDate(5, ngDung.getNgayVaoLam());
	            pst.setString(6, ngDung.getDiaChi());
	            pst.setString(7, ngDung.getDiaChi());
	            pst.setInt(8, ngDung.getSoDienThoai());
	            pst.setString(9, ngDung.getMatKhau());
	            
	            pst.executeUpdate();
	            JDCBCUtil.closeConnection(connection);
	        }catch (SQLException e){
	            e.printStackTrace();
	        }
	        return 0;
	    }
	 
	 public int xoaTaiKhoan(NhanVien tkNgDung){
	        try{
	            Connection connection = JDCBCUtil.getConnection();
	            String sql = "DELETE FROM nhanvien WHERE MaNV = ? AND MatKhau = ?";
	            PreparedStatement pst = connection.prepareStatement(sql);
	            pst.setString(1, tkNgDung.getMaNV());
	            pst.setString(2, tkNgDung.getMatKhau());
	            pst.executeUpdate();
	            JDCBCUtil.closeConnection(connection);
	        }catch (SQLException e){
	            e.printStackTrace();
	        }
	        return 0;
	    }
	 
	 public ArrayList<NhanVien> dsTkNguoiDung(){
	        ArrayList<NhanVien> dsTraVe = new ArrayList<NhanVien>();
	        try{
	            Connection connection = JDCBCUtil.getConnection();
	            String sql = "SELECT * FROM nhanvien";
	            PreparedStatement pst = connection.prepareStatement(sql);
	            ResultSet resultSet = pst.executeQuery();
	            while (resultSet.next()){
	            	//MaNV, TenNV, GioiTinh, ChucVu, NgayVaoLam, DiaChi, SDT, MatKhau
	            	 String maNV = resultSet.getString("MaNV");
	            	    String tenNV = resultSet.getString("TenNV");
	            	    int gioiTinh = resultSet.getInt("GioiTinh"); // Thay đổi thành int
	            	    String chucVu = resultSet.getString("ChucVu");
	            	    Date ngayVaoLam = resultSet.getDate("NgayVaoLam"); // Thay đổi thành Date
	            	    String diaChi = resultSet.getString("DiaChi");
	            	    int soDienThoai = resultSet.getInt("SDT"); // Thay đổi thành int
	            	    String matKhau = resultSet.getString("MatKhau");
	                NhanVien ngDung = new NhanVien (maNV, tenNV,gioiTinh, chucVu,ngayVaoLam, diaChi, soDienThoai, matKhau);
	                
	                
	                dsTraVe.add(ngDung);
	            }
	            JDCBCUtil.closeConnection(connection);
	        }catch (SQLException e){
	            e.printStackTrace();
	        }
	        return dsTraVe;
	 }
	 
	 public boolean kiemTraTaiKhoanMatKhauNguoiDung(String taiKhoan, String matKhau) {
	        Connection connection = null;
	        try {
	            connection = JDCBCUtil.getConnection();
	            String sql= "SELECT * FROM nhanvien WHERE MaNV = ? AND MatKhau = ?";
	            PreparedStatement pts = connection.prepareStatement(sql);
	            pts.setString(1, taiKhoan);
	            pts.setString(2, matKhau);

	            ResultSet resultSet = pts.executeQuery();

	            if (resultSet.next()) {
	                return true;
	            } else {
	                return false;
	            }
	        } catch (SQLException e) {
	            return false;
	        }finally {
	            JDCBCUtil.closeConnection(connection);
	        }
	    }
	 public boolean kiemTraTaiKhoanTonTai(String taiKhoan) {
	        Connection connection = null;
	        try {
	            connection = JDCBCUtil.getConnection();
	            String sql= "SELECT * FROMnhanvien WHERE MaNV = ?";
	            PreparedStatement pts = connection.prepareStatement(sql);
	            pts.setString(1, taiKhoan);

	            ResultSet resultSet2 = pts.executeQuery();

	            if (resultSet2.next()) {
	                return true;
	            } else {
	                return false;
	            }
	        } catch (SQLException e) {
	            return false;
	        }finally {
	            JDCBCUtil.closeConnection(connection);
	        }
	    }
	
	

}

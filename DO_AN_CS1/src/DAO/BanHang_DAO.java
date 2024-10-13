package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import Connection.JDCBCUtil;
import Model.NhanVien;
import Model.ThuDon;

public class BanHang_DAO {
	public static BanHang_DAO getInstance(){
	    return new BanHang_DAO();
		}
	 public ArrayList<ThuDon> dsMonAn() {
	        ArrayList<ThuDon> menu = new ArrayList<ThuDon>();
	        Connection connection = null;

	        try {
	            connection = JDCBCUtil.getConnection();
	            String sql = "SELECT * FROM thucdon";
	            PreparedStatement pst = connection.prepareStatement(sql);
	            ResultSet resultSet = pst.executeQuery();

	            while (resultSet.next()) {
	                int maMon = resultSet.getInt("MaMon");
	                String tenMon = resultSet.getString("TenMon");
	                int maLoai = resultSet.getInt("MaLoai");
	                int donGia = resultSet.getInt("DonGia");
	                String donViTinh = resultSet.getString("DonViTinh");

	                ThuDon monAn = new ThuDon(maMon, tenMon, maLoai, donGia, donViTinh);
	                menu.add(monAn);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	        	JDCBCUtil.closeConnection(connection);
	        }
	        
	        return menu;
	    }
	            
	 public ArrayList<String> layTenMonAn() {
	        ArrayList<String> tenMonAnList = new ArrayList<String>();
	        Connection connection = null;

	        try {
	            connection = JDCBCUtil.getConnection();
	            String sql = "SELECT TenMon FROM thucdon";
	            PreparedStatement pst = connection.prepareStatement(sql);
	            ResultSet resultSet = pst.executeQuery();

	            while (resultSet.next()) {
	                String tenMon = resultSet.getString("TenMon");
	                tenMonAnList.add(tenMon);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	        	JDCBCUtil.closeConnection(connection);
	        }

	        return tenMonAnList;
	    }
	 
	 public boolean themMonAn(ThuDon monAn) {
	        Connection connection = null;
	        try {
	            connection = JDCBCUtil.getConnection();
	            String sql = "INSERT INTO thucdon (MaMon, TenMon, MaLoai, DonGia, DonViTinh) VALUES (?, ?, ?, ?, ?)";
	            PreparedStatement pst = connection.prepareStatement(sql);
	            pst.setInt(1, monAn.getMaMon());
	            pst.setString(2, monAn.getTenMon());
	            pst.setInt(3, monAn.getMaLoai());
	            pst.setInt(4, monAn.getDonGia());
	            pst.setString(5, monAn.getDonViTing());
	            pst.executeUpdate();

	            int rowsInserted = pst.executeUpdate();
	            return rowsInserted > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        } finally {
	        	JDCBCUtil.closeConnection(connection);
	        }
	    }
	 public ThuDon layThongTinMonAn(String tenMon) {
	        ThuDon monAn = null;
	        Connection connection = null;

	        try {
	            connection = JDCBCUtil.getConnection();
	            String sql = "SELECT TenMon, DonGia FROM thucdon WHERE TenMon = ?";
	            PreparedStatement pst = connection.prepareStatement(sql);
	            pst.setString(1, tenMon);
	            ResultSet resultSet = pst.executeQuery();

	            if (resultSet.next()) {
	                String tenMonAn = resultSet.getString("TenMon");
	                int donGia = resultSet.getInt("DonGia");
	                

	                // Chỉ lấy tên và giá, mặc định số lượng là 1
	                monAn = new ThuDon(tenMonAn, donGia,1 );
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            JDCBCUtil.closeConnection(connection);
	        }

	        return monAn;
	    }
	
}


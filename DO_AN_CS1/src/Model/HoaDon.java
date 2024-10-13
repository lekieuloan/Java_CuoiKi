package Model;

import java.sql.Date;

public class HoaDon {
	private int maHoaDon;
	private String maNV;
	private int giamGia;
	private int maBan;
	private Date gioDen;
	private int tongTien;
	private String trangThai;
	
	public HoaDon()
	{
		
	}
	public HoaDon(int maHoaDon, String maNV, int giamGia, int maBan, Date gioDen, int tongTien, String trangThai) {
		this.maHoaDon = maHoaDon;
		this.maNV = maNV;
		this.giamGia = giamGia;
		this.maBan = maBan;
		this.gioDen = gioDen;
		this.tongTien = tongTien;
		this.trangThai = trangThai;
	}

	public int getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(int maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public int getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(int giamGia) {
		this.giamGia = giamGia;
	}

	public int getMaBan() {
		return maBan;
	}

	public void setMaBan(int maBan) {
		this.maBan = maBan;
	}

	public Date getGioDen() {
		return gioDen;
	}

	public void setGioDen(Date gioDen) {
		this.gioDen = gioDen;
	}

	public int getTongTien() {
		return tongTien;
	}

	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	
	

}

package Model;

public class ChiTietHoaDon {
	private int maChiTietHD;
	private int maHoaDon;
	private int maMon;
	private int soLuong;
	private int gia;
	
	public ChiTietHoaDon(int maChiTietHD, int maHoaDon, int maMon, int soLuong, int gia) {
		this.maChiTietHD = maChiTietHD;
		this.maHoaDon = maHoaDon;
		this.maMon = maMon;
		this.soLuong = soLuong;
		this.gia = gia;
	}

	public int getMaChiTietHD() {
		return maChiTietHD;
	}

	public void setMaChiTietHD(int maChiTietHD) {
		this.maChiTietHD = maChiTietHD;
	}

	public int getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(int maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public int getMaMon() {
		return maMon;
	}

	public void setMaMon(int maMon) {
		this.maMon = maMon;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}
	
	
	

}

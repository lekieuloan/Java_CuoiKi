package Model;

public class ThuDon {
	private int maMon;
	private String tenMon;
	private int maLoai;
	private int donGia;
	private String donViTing;
	 private int soLuong;
	
	public ThuDon(int maMon, String tenMon, int maLoai, int donGia, String donViTing) {
		this.maMon = maMon;
		this.tenMon = tenMon;
		this.maLoai = maLoai;
		this.donGia = donGia;
		this.donViTing = donViTing;
		this.soLuong = 1;
	}

	public ThuDon(String tenMon, int donGia, int i) {
		// TODO Auto-generated constructor stub
		this.tenMon = tenMon;
		this.donGia = donGia;
		i= 1;
	}

	public int getMaMon() {
		return maMon;
	}

	public void setMaMon(int maMon) {
		this.maMon = maMon;
	}

	public String getTenMon() {
		return tenMon;
	}

	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}

	public int getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(int maLoai) {
		this.maLoai = maLoai;
	}

	public int getDonGia() {
		return donGia;
	}

	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}

	public String getDonViTing() {
		return donViTing;
	}

	public void setDonViTing(String donViTing) {
		this.donViTing = donViTing;
	}
	
	public void tangSoLuong() {
        this.soLuong++;
    }
	public int getThanhTien() {
        return soLuong * donGia;
    }

	
	
	

}

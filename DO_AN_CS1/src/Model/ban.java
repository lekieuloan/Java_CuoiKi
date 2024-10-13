package Model;

public class ban {
	private int maBan;
	private int maKhuVuc;
	private String tenBan;
	private String trangThai;
	
	public ban(int maBan, int maKhuVuc, String tenBan, String trangThai) {
		this.maBan = maBan;
		this.maKhuVuc = maKhuVuc;
		this.tenBan = tenBan;
		this.trangThai = trangThai;
	}

	public int getMaBan() {
		return maBan;
	}

	public void setMaBan(int maBan) {
		this.maBan = maBan;
	}

	public int getMaKhuVuc() {
		return maKhuVuc;
	}

	public void setMaKhuVuc(int maKhuVuc) {
		this.maKhuVuc = maKhuVuc;
	}

	public String getTenBan() {
		return tenBan;
	}

	public void setTenBan(String tenBan) {
		this.tenBan = tenBan;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	
	
	
	

}

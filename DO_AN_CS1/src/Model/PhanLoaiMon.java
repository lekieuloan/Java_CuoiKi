package Model;

public class PhanLoaiMon {
	private int maLoai;
	private String tenLoai;
	public PhanLoaiMon(int maLoai, String tenLoai) {
		this.maLoai = maLoai;
		this.tenLoai = tenLoai;
	}
	
	public int getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(int maLoai) {
		this.maLoai = maLoai;
	}
	public String getTenLoai() {
		return tenLoai;
	}
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	@Override
	public String toString() {
		return "PhanLoaiMon [maLoai=" + maLoai + ", tenLoai=" + tenLoai + "]";
	}
	
	
	

}

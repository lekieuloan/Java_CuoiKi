package Model;


import java.sql.Date;
import java.time.LocalDate;

public class NhanVien {
	private int phanQuyen, soDienThoai, gioiTinh;
	private String maNV, chucVu, diaChi, matKhau, tenNV;
	private Date ngayVaoLam;
	
	public NhanVien(String maNV2, String tenNV2, int gioiTinh2, String chucVu2, String matKhau3, String diaChi2, LocalDate ngayVaoLam2, String matKhau2) {
		
		
		this.phanQuyen = phanQuyen;
		this.soDienThoai = soDienThoai;
		this.gioiTinh = gioiTinh;
		this.maNV = maNV;
		this.chucVu = chucVu;
		this.diaChi = diaChi;
		this.matKhau = matKhau;
		this.tenNV = tenNV;
		this.ngayVaoLam = ngayVaoLam;
		
	}

	public NhanVien(String maNV2, String tenNV2, int gioiTinh2, String chucVu2, java.util.Date ngayVaoLam2,
			String diaChi2, int soDienThoai2, String matKhau2) {
		this.phanQuyen = phanQuyen;
		this.soDienThoai = soDienThoai;
		this.gioiTinh = gioiTinh;
		this.maNV = maNV;
		this.chucVu = chucVu;
		this.diaChi = diaChi;
		this.matKhau = matKhau;
		this.tenNV = tenNV;
		this.ngayVaoLam = ngayVaoLam;
	}

	public int getPhanQuyen() {
		return phanQuyen;
	}

	public void setPhanQuyen(int phanQuyen) {
		this.phanQuyen = phanQuyen;
	}

	public int getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(int soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public int getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public Date getNgayVaoLam() {
		return ngayVaoLam;
	}

	public void setNgayVaoLam(Date ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	}
	
	
}

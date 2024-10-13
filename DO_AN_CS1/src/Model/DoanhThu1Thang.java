package Model;

import java.util.Date;



class DoanhThu1Thang {
    private int MaHoaDon,TongTien;
    private Date ngay;

     public DoanhThu1Thang(){
        this.MaHoaDon = 0;
        this.TongTien = 0;
     }
    
    public DoanhThu1Thang(int MaHoaDon, int TongTien, Date ngay) {
        this.MaHoaDon = MaHoaDon;
        this.TongTien = TongTien;
        this.ngay = ngay;
    }
    
    public DoanhThu1Thang(int TongTien, Date ngay) {
        this.TongTien = TongTien;
        this.ngay = ngay;
    }
    
    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }

    
    public int getMaHoaDon() {
        return MaHoaDon;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setMaHoaDon(int MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }
    
}

	



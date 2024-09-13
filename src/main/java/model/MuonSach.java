package model;

import java.util.Date;

public class MuonSach {
    private int maMuonSach;
    private String maSach;
    private String maHocSinh;
    private Date ngayMuon;
    private Date ngayTra;
    private boolean trangThai;

    public MuonSach() {
    }

    public MuonSach(int maMuonSach, String maSach, String maHocSinh, Date ngayMuon, Date ngayTra, boolean trangThai) {
        this.maMuonSach = maMuonSach;
        this.maSach = maSach;
        this.maHocSinh = maHocSinh;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
        this.trangThai = trangThai;
    }

    public int getMaMuonSach() {
        return maMuonSach;
    }

    public void setMaMuonSach(int maMuonSach) {
        this.maMuonSach = maMuonSach;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getMaHocSinh() {
        return maHocSinh;
    }

    public void setMaHocSinh(String maHocSinh) {
        this.maHocSinh = maHocSinh;
    }

    public Date getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "MuonSach{" +
                "maMuonSach=" + maMuonSach +
                ", maSach='" + maSach + '\'' +
                ", maHocSinh='" + maHocSinh + '\'' +
                ", ngayMuon=" + ngayMuon +
                ", ngayTra=" + ngayTra +
                ", trangThai=" + trangThai +
                '}';
    }
}


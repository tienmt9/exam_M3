package model;


import java.util.Date;

public class MatBang {
    private String maMatBang;
    private double dienTich;
    private String trangThai;
    private int tang;
    private String loaiVanPhong;
    private String moTa;
    private double giaThue;
    private Date ngayBatDau;
    private Date ngayKetThuc;

    // Constructor, getter và setter

    public MatBang(String maMatBang, double dienTich, String trangThai, int tang, String loaiVanPhong,
                   String moTa, double giaThue, Date ngayBatDau, Date ngayKetThuc) {
        this.maMatBang = maMatBang;
        this.dienTich = dienTich;
        this.trangThai = trangThai;
        this.tang = tang;
        this.loaiVanPhong = loaiVanPhong;
        this.moTa = moTa;
        this.giaThue = giaThue;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    // Các getter và setter cho từng thuộc tính

    public String getMaMatBang() {
        return maMatBang;
    }

    public void setMaMatBang(String maMatBang) {
        this.maMatBang = maMatBang;
    }

    public double getDienTich() {
        return dienTich;
    }

    public void setDienTich(double dienTich) {
        this.dienTich = dienTich;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getTang() {
        return tang;
    }

    public void setTang(int tang) {
        this.tang = tang;
    }

    public String getLoaiVanPhong() {
        return loaiVanPhong;
    }

    public void setLoaiVanPhong(String loaiVanPhong) {
        this.loaiVanPhong = loaiVanPhong;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public double getGiaThue() {
        return giaThue;
    }

    public void setGiaThue(double giaThue) {
        this.giaThue = giaThue;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    @Override
    public String toString() {
        return "MatBang{" +
                "maMatBang='" + maMatBang + '\'' +
                ", dienTich=" + dienTich +
                ", trangThai='" + trangThai + '\'' +
                ", tang=" + tang +
                ", loaiVanPhong='" + loaiVanPhong + '\'' +
                ", moTa='" + moTa + '\'' +
                ", giaThue=" + giaThue +
                ", ngayBatDau=" + ngayBatDau +
                ", ngayKetThuc=" + ngayKetThuc +
                '}';
    }
}


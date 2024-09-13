package dao;

import model.HocSinh;

import java.util.List;

public interface HocSinhDAO {
    void addHocSinh(HocSinh hocSinh);
    void updateHocSinh(HocSinh hocSinh);
    void deleteHocSinh(String maHocSinh);
    HocSinh getHocSinhById(String maHocSinh);
    List<HocSinh> getAllHocSinh();
}


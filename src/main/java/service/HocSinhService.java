package service;

import model.HocSinh;

import java.util.List;

public interface HocSinhService {
    void addHocSinh(HocSinh hocSinh);
    void updateHocSinh(HocSinh hocSinh);
    void deleteHocSinh(String maHocSinh);
    HocSinh getHocSinhById(String maHocSinh);
    List<HocSinh> getAllHocSinh();
}


package dao;

import model.Sach;

import java.util.List;

public interface SachDAO {
    void addSach(Sach sach);
    void updateSach(Sach sach);
    void deleteSach(String maSach);
    Sach getSachById(String maSach);
    List<Sach> getAllSach();
}


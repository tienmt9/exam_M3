package service.impl;

import dao.HocSinhDAO;
import model.HocSinh;
import service.HocSinhService;

import java.util.List;

public class HocSinhServiceImpl implements HocSinhService {
    private HocSinhDAO hocSinhDAO;

    // Constructor để khởi tạo HocSinhDAO
    public HocSinhServiceImpl(HocSinhDAO hocSinhDAO) {
        this.hocSinhDAO = hocSinhDAO;
    }

    // Thêm học sinh
    @Override
    public void addHocSinh(HocSinh hocSinh) {
        hocSinhDAO.addHocSinh(hocSinh);
    }

    // Cập nhật học sinh
    @Override
    public void updateHocSinh(HocSinh hocSinh) {
        hocSinhDAO.updateHocSinh(hocSinh);
    }

    // Xóa học sinh
    @Override
    public void deleteHocSinh(String maHocSinh) {
        hocSinhDAO.deleteHocSinh(maHocSinh);
    }

    // Lấy thông tin học sinh theo mã
    @Override
    public HocSinh getHocSinhById(String maHocSinh) {
        return hocSinhDAO.getHocSinhById(maHocSinh);
    }

    // Lấy danh sách tất cả học sinh
    @Override
    public List<HocSinh> getAllHocSinh() {
        return hocSinhDAO.getAllHocSinh();
    }
}


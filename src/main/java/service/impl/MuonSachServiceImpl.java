package service.impl;

import dao.MuonSachDAO;
import model.MuonSach;
import service.MuonSachService;

import java.util.List;

public class MuonSachServiceImpl implements MuonSachService {
    private MuonSachDAO muonSachDAO;

    // Constructor để khởi tạo DAO
    public MuonSachServiceImpl(MuonSachDAO muonSachDAO) {
        this.muonSachDAO = muonSachDAO;
    }

    // Phương thức mượn sách
    @Override
    public void muonSach(MuonSach muonSach) {
        muonSachDAO.addMuonSach(muonSach);
    }

    // Phương thức trả sách (cập nhật trạng thái)
    @Override
    public void traSach(int maMuonSach) {
        MuonSach muonSach = muonSachDAO.getMuonSachById(maMuonSach);
        if (muonSach != null) {
            muonSach.setTrangThai(true); // Đổi trạng thái thành "Đã trả"
            muonSach.setNgayTra(new java.util.Date()); // Cập nhật ngày trả
            muonSachDAO.updateMuonSach(muonSach); // Cập nhật trong cơ sở dữ liệu
        }
    }

    // Phương thức lấy thông tin mượn sách theo ID
    @Override
    public MuonSach getMuonSachById(int maMuonSach) {
        return muonSachDAO.getMuonSachById(maMuonSach);
    }

    // Phương thức lấy tất cả thông tin mượn sách
    @Override
    public List<MuonSach> getAllMuonSach() {
        return muonSachDAO.getAllMuonSach();
    }
}


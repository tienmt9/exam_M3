package service;

import dao.MatBangDAO;
import model.MatBang;

import java.sql.SQLException;
import java.util.List;

public class MatBangService {
    private MatBangDAO matBangDAO;

    // Constructor khởi tạo đối tượng DAO
    public MatBangService() {
        this.matBangDAO = new MatBangDAO();
    }

    // Phương thức thêm mới mặt bằng
    public boolean addMatBang(MatBang matBang) throws SQLException {
        matBangDAO.addMatBang(matBang);
        return matBangDAO.addMatBang(matBang);
    }

    // Phương thức lấy tất cả mặt bằng
    public List<MatBang> getAllMatBang() {
        return matBangDAO.getAllMatBang();
    }

    // Phương thức tìm mặt bằng theo mã
    public MatBang findById(String maMatBang) {
        return matBangDAO.findById(maMatBang);
    }

    public boolean isMatBangExist(String maMatBang) {
        return matBangDAO.findById(maMatBang) != null;
    }
    // Các logic nghiệp vụ khác nếu cần
}


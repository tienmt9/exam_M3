package dao;

import model.MatBang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static utils.JDBCConnection.getConnection;

public class MatBangDAO {
    // Thêm mới một mặt bằng
    public boolean addMatBang(MatBang matBang) throws SQLException {
        String INSERT_MAT_BANG_SQL = "INSERT INTO mat_bang (ma_mat_bang, dien_tich, trang_thai, tang, loai_van_phong, mo_ta, gia_thue, ngay_bat_dau, ngay_ket_thuc) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MAT_BANG_SQL)) {

            preparedStatement.setString(1, matBang.getMaMatBang());
            preparedStatement.setDouble(2, matBang.getDienTich());
            preparedStatement.setString(3, matBang.getTrangThai());
            preparedStatement.setInt(4, matBang.getTang());
            preparedStatement.setString(5, matBang.getLoaiVanPhong());
            preparedStatement.setString(6, matBang.getMoTa());
            preparedStatement.setDouble(7, matBang.getGiaThue());
            preparedStatement.setDate(8, new java.sql.Date(matBang.getNgayBatDau().getTime()));
            preparedStatement.setDate(9, new java.sql.Date(matBang.getNgayKetThuc().getTime()));

            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows);
            return affectedRows > 0; // Trả về true nếu có hàng bị ảnh hưởng
        } catch (SQLException e) {
            e.printStackTrace();
            return false;  // Trả về false nếu có lỗi
        }
    }

    // Lấy danh sách tất cả các mặt bằng
    public List<MatBang> getAllMatBang() {
        List<MatBang> matBangList = new ArrayList<>();
        String SELECT_ALL_MAT_BANG = "SELECT * FROM mat_bang";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MAT_BANG)) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String maMatBang = rs.getString("ma_mat_bang");
                double dienTich = rs.getDouble("dien_tich");
                String trangThai = rs.getString("trang_thai");
                int tang = rs.getInt("tang");
                String loaiVanPhong = rs.getString("loai_van_phong");
                String moTa = rs.getString("mo_ta");
                double giaThue = rs.getDouble("gia_thue");
                Date ngayBatDau = rs.getDate("ngay_bat_dau");
                Date ngayKetThuc = rs.getDate("ngay_ket_thuc");

                MatBang matBang = new MatBang(maMatBang, dienTich, trangThai, tang, loaiVanPhong, moTa, giaThue, ngayBatDau, ngayKetThuc);
                matBangList.add(matBang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return matBangList;
    }

    // Tìm mặt bằng theo mã
    public MatBang findById(String maMatBang) {
        MatBang matBang = null;
        String SELECT_MAT_BANG_BY_ID = "SELECT * FROM mat_bang WHERE ma_mat_bang = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MAT_BANG_BY_ID)) {

            preparedStatement.setString(1, maMatBang);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                double dienTich = rs.getDouble("dien_tich");
                String trangThai = rs.getString("trang_thai");
                int tang = rs.getInt("tang");
                String loaiVanPhong = rs.getString("loai_van_phong");
                String moTa = rs.getString("mo_ta");
                double giaThue = rs.getDouble("gia_thue");
                Date ngayBatDau = rs.getDate("ngay_bat_dau");
                Date ngayKetThuc = rs.getDate("ngay_ket_thuc");

                matBang = new MatBang(maMatBang, dienTich, trangThai, tang, loaiVanPhong, moTa, giaThue, ngayBatDau, ngayKetThuc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return matBang;
    }
}


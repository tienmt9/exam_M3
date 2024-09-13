package dao.impl;

import dao.HocSinhDAO;
import model.HocSinh;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HocSinhDAOImpl implements HocSinhDAO {
    private Connection connection;

    public HocSinhDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addHocSinh(HocSinh hocSinh) {
        String query = "INSERT INTO hoc_sinh (ma_hoc_sinh, ho_ten, lop) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, hocSinh.getMaHocSinh());
            statement.setString(2, hocSinh.getHoTen());
            statement.setString(3, hocSinh.getLop());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateHocSinh(HocSinh hocSinh) {
        String query = "UPDATE hoc_sinh SET ho_ten = ?, lop = ? WHERE ma_hoc_sinh = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, hocSinh.getHoTen());
            statement.setString(2, hocSinh.getLop());
            statement.setString(3, hocSinh.getMaHocSinh());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteHocSinh(String maHocSinh) {
        String query = "DELETE FROM hoc_sinh WHERE ma_hoc_sinh = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, maHocSinh);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public HocSinh getHocSinhById(String maHocSinh) {
        String query = "SELECT * FROM hoc_sinh WHERE ma_hoc_sinh = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, maHocSinh);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new HocSinh(
                        resultSet.getString("ma_hoc_sinh"),
                        resultSet.getString("ho_ten"),
                        resultSet.getString("lop")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<HocSinh> getAllHocSinh() {
        List<HocSinh> hocSinhList = new ArrayList<>();
        String query = "SELECT * FROM hoc_sinh";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                HocSinh hocSinh = new HocSinh(
                        resultSet.getString("ma_hoc_sinh"),
                        resultSet.getString("ho_ten"),
                        resultSet.getString("lop")
                );
                hocSinhList.add(hocSinh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hocSinhList;
    }
}


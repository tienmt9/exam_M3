package dao.impl;

import dao.SachDAO;
import model.Sach;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SachDAOImpl implements SachDAO {
    private Connection connection;

    public SachDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addSach(Sach sach) {
        String query = "INSERT INTO sach (ma_sach, ten_sach, tac_gia, mo_ta, so_luong) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, sach.getMaSach());
            statement.setString(2, sach.getTenSach());
            statement.setString(3, sach.getTacGia());
            statement.setString(4, sach.getMoTa());
            statement.setInt(5, sach.getSoLuong());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateSach(Sach sach) {
        String query = "UPDATE sach SET ten_sach = ?, tac_gia = ?, mo_ta = ?, so_luong = ? WHERE ma_sach = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, sach.getTenSach());
            statement.setString(2, sach.getTacGia());
            statement.setString(3, sach.getMoTa());
            statement.setInt(4, sach.getSoLuong());
            statement.setString(5, sach.getMaSach());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSach(String maSach) {
        String query = "DELETE FROM sach WHERE ma_sach = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, maSach);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Sach getSachById(String maSach) {
        String query = "SELECT * FROM sach WHERE ma_sach = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, maSach);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Sach(
                        resultSet.getString("ma_sach"),
                        resultSet.getString("ten_sach"),
                        resultSet.getString("tac_gia"),
                        resultSet.getString("mo_ta"),
                        resultSet.getInt("so_luong")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Sach> getAllSach() {
        List<Sach> sachList = new ArrayList<>();
        String query = "SELECT * FROM sach";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Sach sach = new Sach(
                        resultSet.getString("ma_sach"),
                        resultSet.getString("ten_sach"),
                        resultSet.getString("tac_gia"),
                        resultSet.getString("mo_ta"),
                        resultSet.getInt("so_luong")
                );
                sachList.add(sach);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sachList;
    }
}


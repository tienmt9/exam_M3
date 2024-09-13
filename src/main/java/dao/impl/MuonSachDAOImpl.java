package dao.impl;

import dao.MuonSachDAO;
import model.MuonSach;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MuonSachDAOImpl implements MuonSachDAO {
    private Connection connection;

    public MuonSachDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addMuonSach(MuonSach muonSach) {
        String query = "INSERT INTO muon_sach (ma_sach, ma_hoc_sinh, ngay_muon, ngay_tra, trang_thai) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, muonSach.getMaSach());
            statement.setString(2, muonSach.getMaHocSinh());
            statement.setDate(3, new java.sql.Date(muonSach.getNgayMuon().getTime()));
            statement.setDate(4, muonSach.getNgayTra() != null ? new java.sql.Date(muonSach.getNgayTra().getTime()) : null);
            statement.setBoolean(5, muonSach.isTrangThai());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateMuonSach(MuonSach muonSach) {
        String query = "UPDATE muon_sach SET ma_sach = ?, ma_hoc_sinh = ?, ngay_muon = ?, ngay_tra = ?, trang_thai = ? WHERE ma_muon_sach = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, muonSach.getMaSach());
            statement.setString(2, muonSach.getMaHocSinh());
            statement.setDate(3, new java.sql.Date(muonSach.getNgayMuon().getTime()));
            statement.setDate(4, muonSach.getNgayTra() != null ? new java.sql.Date(muonSach.getNgayTra().getTime()) : null);
            statement.setBoolean(5, muonSach.isTrangThai());
            statement.setInt(6, muonSach.getMaMuonSach());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMuonSach(int maMuonSach) {
        String query = "DELETE FROM muon_sach WHERE ma_muon_sach = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, maMuonSach);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public MuonSach getMuonSachById(int maMuonSach) {
        String query = "SELECT * FROM muon_sach WHERE ma_muon_sach = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, maMuonSach);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new MuonSach(
                        resultSet.getInt("ma_muon_sach"),
                        resultSet.getString("ma_sach"),
                        resultSet.getString("ma_hoc_sinh"),
                        resultSet.getDate("ngay_muon"),
                        resultSet.getDate("ngay_tra"),
                        resultSet.getBoolean("trang_thai")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<MuonSach> getAllMuonSach() {
        List<MuonSach> muonSachList = new ArrayList<>();
        String query = "SELECT * FROM muon_sach";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                MuonSach muonSach = new MuonSach(
                        resultSet.getInt("ma_muon_sach"),
                        resultSet.getString("ma_sach"),
                        resultSet.getString("ma_hoc_sinh"),
                        resultSet.getDate("ngay_muon"),
                        resultSet.getDate("ngay_tra"),
                        resultSet.getBoolean("trang_thai")
                );
                muonSachList.add(muonSach);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return muonSachList;
    }
}


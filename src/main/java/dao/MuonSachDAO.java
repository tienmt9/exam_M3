package dao;

import model.MuonSach;

import java.util.List;

public interface MuonSachDAO {
    void addMuonSach(MuonSach muonSach);
    void updateMuonSach(MuonSach muonSach);
    void deleteMuonSach(int maMuonSach);
    MuonSach getMuonSachById(int maMuonSach);
    List<MuonSach> getAllMuonSach();
}


package service;

import model.MuonSach;

import java.util.List;

public interface MuonSachService {
    void muonSach(MuonSach muonSach);
    void traSach(int maMuonSach);
    MuonSach getMuonSachById(int maMuonSach);
    List<MuonSach> getAllMuonSach();
}


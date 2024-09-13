package service.impl;

import dao.SachDAO;
import model.Sach;
import service.SachService;

import java.util.List;

public class SachServiceImpl implements SachService {
    private SachDAO sachDAO;

    public SachServiceImpl(SachDAO sachDAO) {
        this.sachDAO = sachDAO;
    }

    @Override
    public void addSach(Sach sach) {
        sachDAO.addSach(sach);
    }

    @Override
    public void updateSach(Sach sach) {
        sachDAO.updateSach(sach);
    }

    @Override
    public void deleteSach(String maSach) {
        sachDAO.deleteSach(maSach);
    }

    @Override
    public Sach getSachById(String maSach) {
        return sachDAO.getSachById(maSach);
    }

    @Override
    public List<Sach> getAllSach() {
        return sachDAO.getAllSach();
    }
}


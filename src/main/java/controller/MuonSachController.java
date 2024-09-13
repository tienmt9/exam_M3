package controller;

import dao.MuonSachDAO;
import dao.impl.MuonSachDAOImpl;
import model.MuonSach;
import service.MuonSachService;
import service.impl.MuonSachServiceImpl;
import utils.JDBCConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MuonSachController", value = "/muonsach")
public class MuonSachController extends HttpServlet {
    private MuonSachService muonSachService;

    @Override
    public void init() throws ServletException {
        MuonSachDAO muonSachDAO = new MuonSachDAOImpl(JDBCConnection.getConnection());
        muonSachService = new MuonSachServiceImpl(muonSachDAO);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "list":
                listMuonSach(request, response);
                break;
            case "add":
                showAddForm(request, response);
                break;
            case "tra":
                traSach(request, response);
                break;
            default:
                listMuonSach(request, response);
                break;
        }
    }

    // Hiển thị danh sách mượn sách
    private void listMuonSach(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MuonSach> muonSachList = muonSachService.getAllMuonSach();
        request.setAttribute("muonSachList", muonSachList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("muon_sach_list.jsp");
        dispatcher.forward(request, response);
    }

    // Hiển thị form mượn sách
    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("muon_sach_form.jsp");
        dispatcher.forward(request, response);
    }

    // Trả sách (cập nhật trạng thái)
    private void traSach(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int maMuonSach = Integer.parseInt(request.getParameter("maMuonSach"));
        muonSachService.traSach(maMuonSach);
        response.sendRedirect("MuonSachController?action=list");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maSach = request.getParameter("maSach");
        String maHocSinh = request.getParameter("maHocSinh");
        java.util.Date ngayMuon = new java.util.Date();

        MuonSach muonSach = new MuonSach(0, maSach, maHocSinh, ngayMuon, null, false);
        muonSachService.muonSach(muonSach);

        response.sendRedirect("MuonSachController?action=list");
    }
}


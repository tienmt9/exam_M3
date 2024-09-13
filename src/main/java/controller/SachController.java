package controller;

import dao.SachDAO;
import dao.impl.SachDAOImpl;
import model.Sach;
import service.SachService;
import service.impl.SachServiceImpl;
import utils.JDBCConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SachController", value = "/sach")
public class SachController extends HttpServlet {
    private SachService sachService;

    @Override
    public void init() throws ServletException {
        SachDAO sachDAO = new SachDAOImpl(JDBCConnection.getConnection());
        sachService = new SachServiceImpl(sachDAO);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "list":
                listSach(request, response);
                break;
            case "add":
                showAddForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteSach(request, response);
                break;
            default:
                listSach(request, response);
                break;
        }
    }

    private void listSach(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Sach> sachList = sachService.getAllSach();
        request.setAttribute("sachList", sachList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/sach_list.jsp");
        dispatcher.forward(request, response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/sach_form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maSach = request.getParameter("maSach");
        Sach sach = sachService.getSachById(maSach);
        request.setAttribute("sach", sach);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/sach_form.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteSach(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String maSach = request.getParameter("maSach");
        sachService.deleteSach(maSach);
        response.sendRedirect(request.getContextPath() + "/sach?action=list");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maSach = request.getParameter("maSach");
        String tenSach = request.getParameter("tenSach");
        String tacGia = request.getParameter("tacGia");
        String moTa = request.getParameter("moTa");
        int soLuong = Integer.parseInt(request.getParameter("soLuong"));

        Sach sach = new Sach(maSach, tenSach, tacGia, moTa, soLuong);

        if (maSach == null || maSach.isEmpty()) {
            sachService.addSach(sach);
        } else {
            sachService.updateSach(sach);
        }

        response.sendRedirect(request.getContextPath() + "/sach?action=list");
    }
}

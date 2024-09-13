package controller;



import dao.HocSinhDAO;
import dao.impl.HocSinhDAOImpl;
import model.HocSinh;
import service.HocSinhService;
import service.impl.HocSinhServiceImpl;
import utils.JDBCConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HocSinhController", value = "/hocsinh")
public class HocSinhController extends HttpServlet {
    private HocSinhService hocSinhService;

    @Override
    public void init() throws ServletException {
        HocSinhDAO hocSinhDAO = new HocSinhDAOImpl(JDBCConnection.getConnection());
        hocSinhService = new HocSinhServiceImpl(hocSinhDAO);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "list":
                listHocSinh(request, response);
                break;
            case "add":
                showAddForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteHocSinh(request, response);
                break;
            default:
                listHocSinh(request, response);
                break;
        }
    }

    // Hiển thị danh sách học sinh
    private void listHocSinh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<HocSinh> hocSinhList = hocSinhService.getAllHocSinh();
        request.setAttribute("hocSinhList", hocSinhList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("hoc_sinh_list.jsp");
        dispatcher.forward(request, response);
    }

    // Hiển thị form thêm học sinh
    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("hoc_sinh_form.jsp");
        dispatcher.forward(request, response);
    }

    // Hiển thị form chỉnh sửa học sinh
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maHocSinh = request.getParameter("maHocSinh");
        HocSinh hocSinh = hocSinhService.getHocSinhById(maHocSinh);
        request.setAttribute("hocSinh", hocSinh);
        RequestDispatcher dispatcher = request.getRequestDispatcher("hoc_sinh_form.jsp");
        dispatcher.forward(request, response);
    }

    // Xóa học sinh
    private void deleteHocSinh(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String maHocSinh = request.getParameter("maHocSinh");
        hocSinhService.deleteHocSinh(maHocSinh);
        response.sendRedirect("HocSinhController?action=list");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maHocSinh = request.getParameter("maHocSinh");
        String hoTen = request.getParameter("hoTen");
        String lop = request.getParameter("lop");

        HocSinh hocSinh = new HocSinh(maHocSinh, hoTen, lop);

        if (maHocSinh == null || maHocSinh.isEmpty()) {
            hocSinhService.addHocSinh(hocSinh);
        } else {
            hocSinhService.updateHocSinh(hocSinh);
        }

        response.sendRedirect("HocSinhController?action=list");
    }
}


package controller;

import model.MatBang;
import service.MatBangService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "MatBangController", value = "/matbang")
public class MatBangController extends HttpServlet {
    private MatBangService matBangService;

    @Override
    public void init() {
        matBangService = new MatBangService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Ví dụ: Lấy danh sách tất cả các mặt bằng và chuyển tiếp đến trang JSP để hiển thị
        List<MatBang> matBangList = matBangService.getAllMatBang();
        request.setAttribute("matBangList", matBangList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("mat_bang_list.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maMatBang = request.getParameter("maMatBang");
        double dienTich = Double.parseDouble(request.getParameter("dienTich"));
        String trangThai = request.getParameter("trangThai");
        int tang = Integer.parseInt(request.getParameter("tang"));
        String loaiVanPhong = request.getParameter("loaiVanPhong");
        String moTa = request.getParameter("moTa");
        double giaThue = Double.parseDouble(request.getParameter("giaThue"));
        Date ngayBatDau = Date.valueOf(request.getParameter("ngayBatDau"));
        Date ngayKetThuc = Date.valueOf(request.getParameter("ngayKetThuc"));

        MatBang matBang = new MatBang(maMatBang, dienTich, trangThai, tang, loaiVanPhong, moTa, giaThue, ngayBatDau, ngayKetThuc);

        try {
            // Kiểm tra mã mặt bằng trùng
//            if (matBangService.isMatBangExist(maMatBang)) {
//                request.setAttribute("error", "Mã mặt bằng vừa thêm đã tồn tại.");
//                RequestDispatcher dispatcher = request.getRequestDispatcher("add_mat_bang.jsp");
//                dispatcher.forward(request, response);
//                return;
//            }

            // Kiểm tra ngày kết thúc phải cách ngày bắt đầu ít nhất 6 tháng
            if (ngayKetThuc.getTime() - ngayBatDau.getTime() < 180L * 24 * 60 * 60 * 1000) {
                request.setAttribute("error", "Ngày kết thúc phải cách ngày bắt đầu ít nhất 6 tháng.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("add_mat_bang.jsp");
                dispatcher.forward(request, response);
                return;
            }
            System.out.println("Trạng thái: " + trangThai);
            System.out.println("Adding mat bang with maMatBang: " + matBang.getMaMatBang());
            System.out.println("Mã mặt bằng kiểm tra: " + maMatBang);
            // Nếu mọi thứ hợp lệ, thêm mặt bằng
            boolean isSuccess = matBangService.addMatBang(matBang);
            if (!isSuccess) {
                request.setAttribute("error", "Thêm mặt bằng không thành công.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("add_mat_bang.jsp");
                dispatcher.forward(request, response);
                return;
            }

            // Nếu thêm thành công, điều hướng về trang danh sách
            response.sendRedirect(request.getContextPath() + "/matbang");
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Có lỗi xảy ra khi thêm mặt bằng: " + e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("add_mat_bang.jsp");
            dispatcher.forward(request, response);
        }
    }

}


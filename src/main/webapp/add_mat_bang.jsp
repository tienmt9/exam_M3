<%--
  Created by IntelliJ IDEA.
  User: tienm
  Date: 9/13/2024
  Time: 3:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Thêm mặt bằng</title>
</head>
<body>
<h2>Thêm mặt bằng mới</h2>

<!-- Hiển thị thông báo lỗi nếu có lỗi từ phía server -->
<c:if test="${not empty error}">
    <p style="color: red;">${error}</p>
</c:if>

<!-- Form thêm mới mặt bằng -->
<form action="${pageContext.request.contextPath}/matbang" method="post" onsubmit="return validateForm()">
    Mã mặt bằng (định dạng XXX-XX-X):
    <input type="text" id="maMatBang" name="maMatBang" ><br>

    Diện tích (> 20m²):
    <input type="number" id="dienTich" name="dienTich" required><br>

    Trạng thái:
    <select id="trangThai" name="trangThai" required>
        <option value="trong">Trống</option>
        <option value="da thue">Đã thuê</option>
    </select><br>

    Tầng (1 - 15):
    <input type="number" id="tang" name="tang" min="1" max="15" required><br>

    Loại văn phòng:
    <select id="loaiVanPhong" name="loaiVanPhong" required>
        <option value="chia se">Chia sẻ</option>
        <option value="tron goi">Trọn gói</option>
    </select><br>

    Mô tả chi tiết:
    <textarea id="moTa" name="moTa"></textarea><br>

    Giá thuê (> 1.000.000 VND):
    <input type="number" id="giaThue" name="giaThue" min="1000000" required><br>

    Ngày bắt đầu (dd/mm/yyyy):
    <input type="date" id="ngayBatDau" name="ngayBatDau" required><br>

    Ngày kết thúc (dd/mm/yyyy):
    <input type="date" id="ngayKetThuc" name="ngayKetThuc" required><br>

    <input type="submit" value="Thêm mới">
</form>

<!-- Script kiểm tra dữ liệu phía Client-side -->
<script>
    function validateForm() {
        // // Kiểm tra mã mặt bằng có đúng định dạng không
        // const maMatBangPattern = /^[A-Z]{3}-[A-Z]{2}-[A-Z]{1}$/;
        // const maMatBang = document.getElementById("maMatBang").value;
        // if (!maMatBangPattern.test(maMatBang)) {
        //     alert("Mã mặt bằng phải có định dạng XXX-XX-X với các ký tự là chữ hoa.");
        //     return false;
        // }

        // Kiểm tra diện tích lớn hơn 20m²
        const dienTich = document.getElementById("dienTich").value;
        if (dienTich <= 20) {
            alert("Diện tích phải lớn hơn 20m².");
            return false;
        }

        // Kiểm tra ngày bắt đầu và ngày kết thúc (phải cách nhau ít nhất 6 tháng)
        const ngayBatDau = new Date(document.getElementById("ngayBatDau").value);
        const ngayKetThuc = new Date(document.getElementById("ngayKetThuc").value);
        const sixMonthsInMs = 180 * 24 * 60 * 60 * 1000; // 6 tháng tính bằng milliseconds
        if (ngayKetThuc - ngayBatDau < sixMonthsInMs) {
            alert("Ngày kết thúc phải cách ngày bắt đầu ít nhất 6 tháng.");
            return false;
        }

        return true;
    }
</script>
</body>
</html>

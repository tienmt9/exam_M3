<%--
  Created by IntelliJ IDEA.
  User: tienm
  Date: 9/13/2024
  Time: 2:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh sách mặt bằng</title>
</head>
<body>
<h2>Danh sách mặt bằng cho thuê</h2>

<!-- Nút hoặc đường dẫn để chuyển đến trang thêm mới mặt bằng -->
<a href="add_mat_bang.jsp">
    <button>Thêm mặt bằng mới</button>
</a>

<table border="1">
    <tr>
        <th>Mã mặt bằng</th>
        <th>Diện tích (m²)</th>
        <th>Trạng thái</th>
        <th>Tầng</th>
        <th>Loại văn phòng</th>
        <th>Mô tả</th>
        <th>Giá thuê (VND)</th>
        <th>Ngày bắt đầu</th>
        <th>Ngày kết thúc</th>
    </tr>
    <c:forEach var="matBang" items="${matBangList}">
        <tr>
            <td>${matBang.maMatBang}</td>
            <td>${matBang.dienTich}</td>
            <td>${matBang.trangThai}</td>
            <td>${matBang.tang}</td>
            <td>${matBang.loaiVanPhong}</td>
            <td>${matBang.moTa}</td>
            <td>${matBang.giaThue}</td>
            <td>${matBang.ngayBatDau}</td>
            <td>${matBang.ngayKetThuc}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>


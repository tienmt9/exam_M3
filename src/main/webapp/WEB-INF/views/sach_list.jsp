<%--
  Created by IntelliJ IDEA.
  User: tienm
  Date: 9/13/2024
  Time: 10:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh Sách Sách</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1>Danh Sách Sách</h1>
    <a href="${pageContext.request.contextPath}/SachController?action=add" class="btn btn-primary mb-3">Thêm Sách</a>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Mã Sách</th>
            <th>Tên Sách</th>
            <th>Tác Giả</th>
            <th>Mô Tả</th>
            <th>Số Lượng</th>
            <th>Thao Tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="sach" items="${sachList}">
            <tr>
                <td>${sach.maSach}</td>
                <td>${sach.tenSach}</td>
                <td>${sach.tacGia}</td>
                <td>${sach.moTa}</td>
                <td>${sach.soLuong}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/SachController?action=edit&maSach=${sach.maSach}" class="btn btn-warning">Sửa</a>
                    <a href="${pageContext.request.contextPath}/SachController?action=delete&maSach=${sach.maSach}" class="btn btn-danger" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>


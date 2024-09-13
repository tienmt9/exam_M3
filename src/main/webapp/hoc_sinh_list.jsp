<%--
  Created by IntelliJ IDEA.
  User: tienm
  Date: 9/13/2024
  Time: 10:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh Sách Học Sinh</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1>Danh Sách Học Sinh</h1>
    <a href="hocsinh?action=add" class="btn btn-primary mb-3">Thêm Học Sinh</a>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Mã Học Sinh</th>
            <th>Họ Tên</th>
            <th>Lớp</th>
            <th>Thao Tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="hocSinh" items="${hocSinhList}">
            <tr>
                <td>${hocSinh.maHocSinh}</td>
                <td>${hocSinh.hoTen}</td>
                <td>${hocSinh.lop}</td>
                <td>
                    <a href="hocsinh?action=edit&maHocSinh=${hocSinh.maHocSinh}" class="btn btn-warning">Sửa</a>
                    <a href="hocsinh?action=delete&maHocSinh=${hocSinh.maHocSinh}" class="btn btn-danger" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>


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
    <title>Thêm/Sửa Học Sinh</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1><c:choose>
        <c:when test="${hocSinh != null}">Sửa Học Sinh</c:when>
        <c:otherwise>Thêm Học Sinh</c:otherwise>
    </c:choose></h1>
    <form action="hocsinh" method="post">
        <div class="form-group">
            <label>Mã Học Sinh</label>
            <input type="text" class="form-control" name="maHocSinh" value="${hocSinh.maHocSinh}" readonly="${hocSinh != null}">
        </div>
        <div class="form-group">
            <label>Họ Tên</label>
            <input type="text" class="form-control" name="hoTen" value="${hocSinh.hoTen}">
        </div>
        <div class="form-group">
            <label>Lớp</label>
            <input type="text" class="form-control" name="lop" value="${hocSinh.lop}">
        </div>
        <button type="submit" class="btn btn-success">Lưu</button>
        <a href="hocsinh?action=list" class="btn btn-secondary">Quay Lại</a>
    </form>
</div>
</body>
</html>


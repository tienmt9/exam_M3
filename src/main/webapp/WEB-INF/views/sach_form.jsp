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
    <title>Thêm/Sửa Sách</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1><c:choose>
        <c:when test="${sach != null}">Sửa Sách</c:when>
        <c:otherwise>Thêm Sách</c:otherwise>
    </c:choose></h1>
    <form action="SachController" method="post">
        <div class="form-group">
            <label>Mã Sách</label>
            <input type="text" class="form-control" name="maSach" value="${sach.maSach}" readonly="${sach != null}">
        </div>
        <div class="form-group">
            <label>Tên Sách</label>
            <input type="text" class="form-control" name="tenSach" value="${sach.tenSach}">
        </div>
        <div class="form-group">
            <label>Tác Giả</label>
            <input type="text" class="form-control" name="tacGia" value="${sach.tacGia}">
        </div>
        <div class="form-group">
            <label>Mô Tả</label>
            <textarea class="form-control" name="moTa">${sach.moTa}</textarea>
        </div>
        <div class="form-group">
            <label>Số Lượng</label>
            <input type="number" class="form-control" name="soLuong" value="${sach.soLuong}">
        </div>
        <button type="submit" class="btn btn-success">Lưu</button>
        <a href="${pageContext.request.contextPath}/SachController?action=list" class="btn btn-secondary">Quay Lại</a>
    </form>
</div>
</body>
</html>


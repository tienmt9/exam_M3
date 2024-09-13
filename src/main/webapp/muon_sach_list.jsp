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
    <title>Danh Sách Mượn Sách</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1>Danh Sách Mượn Sách</h1>
    <a href="muonsach?action=add" class="btn btn-primary mb-3">Mượn Sách</a>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Mã Mượn Sách</th>
            <th>Mã Sách</th>
            <th>Mã Học Sinh</th>
            <th>Ngày Mượn</th>
            <th>Ngày Trả</th>
            <th>Trạng Thái</th>
            <th>Thao Tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="muonSach" items="${muonSachList}">
            <tr>
                <td>${muonSach.maMuonSach}</td>
                <td>${muonSach.maSach}</td>
                <td>${muonSach.maHocSinh}</td>
                <td>${muonSach.ngayMuon}</td>
                <td>${muonSach.ngayTra != null ? muonSach.ngayTra : "Chưa trả"}</td>
                <td>${muonSach.trangThai ? "Đã trả" : "Chưa trả"}</td>
                <td>
                    <c:if test="${!muonSach.trangThai}">
                        <a href="muonsach?action=tra&maMuonSach=${muonSach.maMuonSach}" class="btn btn-success">Trả Sách</a>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>


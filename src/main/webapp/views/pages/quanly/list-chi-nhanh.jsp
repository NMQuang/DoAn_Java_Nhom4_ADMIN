<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#">
                <em class="fa fa-home"></em>
            </a></li>
            <li class="active">Danh sách chi nhánh</li>
        </ol>
    </div><!--/.row-->

    <div class="panel panel-info">
        <div class="panel-heading">
            <a href="tao_chi_nhanh_moi.html" class="btn btn-default pull-right fix"><b>+</b> Thêm chi nhánh mới </a>
        </div>

        <table class="table table-striped custab">
            <thead>
            <tr>
                <th width="5%" class="text-center red-text-table">ID</th>
                <th width="20%">Tên chi nhánh</th>
                <th width="35%">Địa chỉ</th>
                <th width="15%">Số điện thoại</th>
                <th width="15%">Tỉnh thành</th>
                <th width="10%"></th>
            </tr>
            </thead>
            <c:forEach items="${listChiNhanh}" var="branch">
            <tr>
                <td class="text-center red-text-table">1</td>
                <td><a href="#">${branch.ten}</a></td>
                <td>${branch.diaChi}</td>
                <td>${branch.dienThoai}</td>
                <td>${branch.tinhthanh}</td>
                <td><a href="${pageContext.request.contextPath}/chinhanh/${branch.chiNhanhId}" class="btn btn-info pull-right">Xem thông tin</a></td>
            </tr>
            </c:forEach>

        </table>
    </div>
</div>
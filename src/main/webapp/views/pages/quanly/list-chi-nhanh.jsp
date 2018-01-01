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
            <a href="<c:url value="/quanly/chinhanh/themchinhanh"/>" class="btn btn-default pull-right fix"><b>+</b> Thêm chi nhánh mới </a>
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
                <td class="text-center red-text-table">${branch.chiNhanhId }</td>
                <td><a href="${pageContext.request.contextPath}/quanly/chinhanh-daydu/${branch.chiNhanhId}">${branch.ten}</a></td>
                <td>${branch.diaChi}</td>
                <td>${branch.dienThoai}</td>
                <td>${branch.tinhthanh.tenTinh}</td>
                <td>
                    <div class="dropdown pull-right" style="margin: 0">
                        <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">
                            <i class="fa fa-cogs" aria-hidden="true"></i>
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu dropdown-menu-right">
                            <li><a href="${pageContext.request.contextPath}/quanly/chinhanh/${branch.chiNhanhId}">Chỉnh sửa thông tin chi nhánh</a></li>
                            <li><a href="${pageContext.request.contextPath}/quanly/chinhanh-ban/${branch.chiNhanhId}">Chỉnh sửa thông tin bàn </a></li>
                            <li><a href="${pageContext.request.contextPath}/quanly/chinhanh-menu/${branch.chiNhanhId}">Chỉnh sửa menu</a></li>
                        </ul>
                    </div>
                </td>
            </tr>
            </c:forEach>

        </table>
        <div style="text-align: center">
        <ul id="pagination-demo" data-index="${index }" data-pages="${pages }" class="pagination-md" ></ul>
        </div>
    </div>
</div>
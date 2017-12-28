<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="utf-8" contentType="text/html" %>

<c:set var="index" value="${param.index != null ? param.index : 1}"/>
<c:set var="count" value="${0}"/>
<c:set var="itemOnePage" value="${12}"/>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#">
                <em class="fa fa-home"></em>
            </a></li>
            <li> <a href="<c:url value="/quanly/danhmuc"/>">Danh sách danh mục</a></li>
            <li class="active">${listMonByType[0].danhmuc.ten}</li>
        </ol>
    </div><!--/.row-->

    <div class="panel panel-info">
        <div class="panel-heading">
            <div class="col-md-6">
            Danh sách tất cả các món ăn
                <select class="" id="type_mon" style="background-color: #30a5ff" name="type">
                    <option ${type.equals("current") ? 'selected' : ''} value="current">hiện hành</option>
                    <option ${type.equals('deleted') ? 'selected' : ''} value="deleted">đã xóa</option>
                </select>
            </div>
            <div class="col-md-6">
                <div class="input-group col-md-12">
                    <input id="input-search-food-header-bar" type="text" class="form-control" placeholder="Tên món ăn">
                    <div class="input-group-btn">
                        <button id="btn-search-food-header-bar" class="btn btn-default fix" type="button">
                            Tìm kiếm
                        </button>
                    </div>
                </div>
            </div>
        </div>

        <table class="table table-striped custab" id="search-food-header-bar">
            <thead>
            <tr>
                <th class="text-center red-text-table">ID</th>
                <th>Danh mục</th>
                <th>Tên món ăn</th>
                <th>Đơn vị tính</th>
                <th>Số lượng bán</th>
            </tr>
            </thead>
            <tbody>

            <c:set var="begin" value="${itemOnePage * (index - 1)}"/>
            <c:set var="end" value="${begin + itemOnePage - 1}"/>
            <c:forEach items="${listMonByType}" var="mon" varStatus="status" begin="${begin}" end="${end}">
                <tr>
                    <td class="text-center red-text-table">${mon.monId}</td>
                    <td>${mon.danhmuc.ten}</td>
                    <td>${mon.ten}</td>
                    <td>${mon.donViTinh}</td>
                    <td>${mon.soLuongDaBan}</td>
                    <td width="5%">
                        <a href="<c:url value="/quanly/monan/${mon.monId}"/>" class="btn btn-info">Xem</a>
                    </td>
                    <td width="5%">
                        <c:choose>
                            <c:when test="${type.equals('current')}">
                                <a href="<c:url value="/quanly/monan/delete/${mon.monId}"/>" onclick="return confirm('Bạn có chắc muốn xóa')" class="btn btn-danger">Xóa</a>
                            </c:when>
                            <c:otherwise>
                                <a href="<c:url value="/quanly/monan/active/${mon.monId}"/>" onclick="return confirm('Bạn có chắc muốn hồi phục')" class="btn btn-success">Thêm</a>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <c:set var="count" value="${listMonByType.size()}"/>
        <c:set var="pages" value="${count / itemOnePage + (count % itemOnePage == 0 ? 0 : 1)}"/>

        <c:if test="${pages > 1 && index <= pages}">
        <div style="text-align: center">
            <ul id="pagination-demo" data-index="${index}" data-pages="${pages}" class="pagination-md" ></ul>
        </div>
        </c:if>
    </div>
</div>
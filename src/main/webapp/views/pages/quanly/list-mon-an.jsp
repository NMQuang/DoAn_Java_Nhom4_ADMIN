<%@ page pageEncoding="UTF-8" contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="<c:url value="/quanly" />">
                <em class="fa fa-home"></em>
            </a></li>
            <li class="active">Danh sách món ăn</li>
        </ol>
    </div><!--/.row-->

    <div class="panel panel-info">
        <div class="panel-heading">
            Danh sách tất cả các món ăn 
            <select class="" id="type_mon" style="background-color: #30a5ff" name="type">
			    <option value="current">hiện hành</option>
			    <option value="deleted"  ${ type == 'deleted' ? 'selected': ''}>đã xóa</option>
			</select>
            <a href="<c:url value="/quanly/monan/themmonan"/>" class="btn btn-default pull-right fix"><b>+</b> Thêm món ăn mới</a>
        </div>

        <table class="table table-striped custab">
            <thead>
            <tr>
                <th class="text-center red-text-table">ID</th>
                <th>Danh mục</th>
                <th>Tên món ăn</th>
                <th>Đơn vị tính</th>
                <th>Số lượng bán</th>
            </tr>
            </thead>
            <c:forEach items="${listmon }" var="item">
            	<tr>
                <td class="text-center red-text-table">${item.monId }</td>
                <td>${item.danhmuc.ten }</td>
                <td>${item.ten }</td>
                <td>${item.donViTinh }</td>
                <td>${item.soLuongDaBan }</td>
                <td width="5%">
                    <a href="<c:url value="/quanly/monan/1"/>" class="btn btn-info">Xem</a>
                </td>
                <td width="5%">
                    <a href="<c:url value="/quanly/monan/delete/${item.monId }"/>" onclick="return confirm('Bạn có chắc chắn muốn xóa')" class="btn btn-danger">Xóa</a>
                </td>
            </tr>
            </c:forEach>
            
            
        </table>
        <div style="text-align: center">
        <ul id="pagination-demo" data-index="${index }" data-pages="${pages }" class="pagination-md" ></ul>
        </div>
        
    </div>
</div>
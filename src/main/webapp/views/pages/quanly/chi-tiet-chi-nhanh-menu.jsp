<%@page pageEncoding="UTF-8" contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#">
                <em class="fa fa-home"></em>
            </a></li>
            <li>
                <a href="${pageContext.request.contextPath}/quanly/chinhanh/"> Danh sách chi nhánh </a></li>
            <li><a href="${pageContext.request.contextPath}/quanly/chinhanh-daydu/${branch.chiNhanhId}">Chi nhánh ${branch.ten}</a></li>
        </ol>
    </div><!--/.row-->

    <form method="post" class="form-horizontal">
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div class="col-lg-3">
                            Menu của chi nhánh
                        </div>
                        <div class="col-lg-5">
                            <div class="input-group col-md-12">
                                <input id="input-search-food-header-bar" type="text" class="form-control input-search-header-bar"
                                       placeholder="Tên món ăn">
                                <div class="input-group-btn">
                                    <button id="btn-search-food-header-bar" class="btn btn-default" type="button">
                                        <i class="fa fa-search" aria-hidden="true"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                        <a href="${pageContext.request.contextPath}/quanly/chinhanh-menu/${branch.chiNhanhId}/themmonan"  class="btn btn-primary pull-right fix">Thêm món ăn vào menu</a>
                    </div>
                    <div class="panel-body">
                        <table class="table table-striped custab" id="food-search-header-bar">
                            <thead>
                            <tr>
                                <th class="text-center red-text-table">ID</th>
                                <th>Danh mục</th>
                                <th>Tên món ăn</th>
                                <th width="10%" class="text-center">Giá tiền</th>
                                <th width="10%">Đơn vị tính</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${menu}" var="item">
                             <tr>
                                 <td class="text-center red-text-table">${item.pk.mon.monId }</td>

                                 <td>${item.pk.mon.danhmuc.ten}</td>
                                 <td>${item.pk.mon.ten}</td>
                                 <td>${item.gia}</td>
                                 <td>${item.pk.mon.donViTinh}</td>
                                 <td width="5%">
				                    <a href="<c:url value="/quanly/monan/${item.pk.mon.monId }"/>" class="btn btn-info">Xem</a>
				                </td>
                                 <td width="5%">
                                     <!-- <a href="" class="btn btn-info">Xem</a> -->
                                     <a href="${pageContext.request.contextPath}/quanly/chinhanh-menu/${branch.chiNhanhId}/suamonan/${item.pk.mon.monId}" class="btn btn-info">Sửa</a>
                                 </td>
                                 <td width="5%">
                                     <a href="${pageContext.request.contextPath}/quanly/chinhanh-menu/${branch.chiNhanhId}/xoamonan/${item.pk.mon.monId}" onclick="return confirm('Bạn có chắc chắn muốn xóa')" class="btn btn-danger">Xóa</a>
                                 </td>
                             </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <div style="text-align: center">
				        <ul id="pagination-demo" data-index="${index }" data-pages="${pages }" class="pagination-md" ></ul>
				        </div>
                    </div>
                </div>
                <!-- <div class="modal fade" id="modal-sua-gia" role="dialog">
                    <div class="modal-dialog modal-lg">
                        Modal content
                        <div class="modal-content">
                            <div class="modal-header">
                                <div class="modal-title">
                                    <div class="input-group col-md-10 col-md-offset-1">
                                        <div class="input-group-btn">
                                            <div id="btn-modal-search-food" class="btn btn-default fix" style="margin-top: 5px; border: 1px solid #E5E5E5" >
                                                <i class="fa fa-search" aria-hidden="true"></i>
                                            </div>
                                        </div>
                                        <input id="input-modal-search-food" type="text" class="form-control" placeholder="Tìm kiếm món ăn" style="margin-top: 5px">
                                    </div>
                                </div>
                            </div>
                            <div class="modal-body">
                                <table class="table table-striped custab" id="mon-an-search-header-bar">
                                    <thead>
                                    <tr>
                                        <th class="text-center red-text-table">ID</th>
                                        <th>Tên món ăn</th>
                                        <th>Danh mục</th>
                                        <th>Đơn vị tính</th>
                                        <th>Số lượng</th>
                                    </tr>
                                    </thead>
                                    <tbody>
									<tr>
                                        <th class="text-center red-text-table">ID</th>
                                        <th>Tên món ăn</th>
                                        <th>Danh mục</th>
                                        <th>Đơn vị tính</th>
                                        <th>Số lượng</th>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-success">Thêm món ăn đã chọn</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
                            </div>
                        </div>
                    </div>
                </div> -->
            </div>
        </div>

        <div class="text-center">
            <button type="submit" class="btn btn-lg btn-primary">Sửa thông tin</button>
        </div>
        <br>
    </form>
</div>
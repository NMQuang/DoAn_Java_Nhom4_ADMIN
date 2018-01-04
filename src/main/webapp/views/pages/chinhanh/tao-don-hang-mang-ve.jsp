<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#">
                <em class="fa fa-home"></em>
            </a></li>
            <li>Tạo đơn hàng mang về </li>
        </ol>
    </div><!--/.row-->

    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Tạo đơn hàng mang về
                    <a class="btn btn-primary fix pull-right" data-toggle="modal" data-target="#modal-them-mon">Thêm món ăn vào đơn hàng</a>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal">
                        <table class="table table-striped custab" id="table-don-hang-mang-ve">
                            <thead>
                            <tr>
                                <th width="5%" class="text-center red-text-table">ID</th>
                                <th width="20%">Danh mục</th>
                                <th>Tên món ăn</th>
                                <th width="10%" class="text-center">Số lượng</th>
                                <th width="12%" class="text-center">Giá tiền</th>
                                <th width="5%"></th>
                            </tr>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
                        <div class="form-group" style="margin-top: 12px">
                            <label class="control-label col-md-2">Tổng tiền</label>
                            <div class="col-md-3">
                                <input id="tong-tien-don-hang-mang-ve" type="text" class="form-control expanded-input" disabled/>
                            </div>
                            <button type="button" class="btn btn-primary pull-right" style="margin-right: 15px" id="btn-mang-ve-tao-don-hang">Tạo đơn hàng</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="modal fade" id="modal-them-mon" role="dialog">
            <div class="modal-dialog modal-lg">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" style="margin-top: 6px">&times;</button>
                        <div class="modal-title">
                            <div class="input-group col-md-9 col-md-offset-1">
                                <div class="input-group-btn">
                                    <div id="btn-modal-search-food" class="btn btn-default fix" style="margin-top: 5px; border: 1px solid #E5E5E5" >
                                        <i class="fa fa-search" aria-hidden="true"></i>
                                    </div>
                                </div>
                                <input id="input-modal-search-food-menu" type="text" class="form-control" placeholder="Tìm kiếm món ăn" style="margin-top: 5px">
                            </div>

                        </div>
                    </div>
                    <div class="modal-body">
                        <ul class="list-group">
                        	<c:forEach items="${dsDM}" var="dm">
                        		<li class="list-group-item">
                                <div class="row toggle" id="dropdown-detail-1" data-toggle="list-mon-an-${dm.danhMucId }">
                                    <div class="col-xs-10">
                                        <strong>${dm.ten }</strong>
                                    </div>
                                    <div class="col-xs-2"><i class="fa fa-chevron-down pull-right"></i></div>
                                </div>
                                <div id="list-mon-an-${dm.danhMucId }" class="collapse">
                                    <hr>
                                    <div class="container">
                                        <ul class="list-group ul-search-mon-an">
                                        <c:forEach items="${dsCnMon }" var="cnm">
                                        	<c:if test="${cnm.pk.mon.danhmuc.danhMucId == dm.danhMucId }">
                                        		<li  class="list-group-item col-lg-8 mon-item" data-id="${cnm.mon.monId }" data-price="${cnm.gia }">${cnm.mon.ten }</li>
                                        	</c:if>
                                        </c:forEach>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                        	</c:forEach>
                        </ul>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-success" id="btn-mang-ve-them-mon-da-chon">Thêm món ăn đã chọn</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
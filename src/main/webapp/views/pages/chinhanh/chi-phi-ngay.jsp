<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page pageEncoding="UTF-8" contentType="text/html" %>

<!-- Use for jquery -->
<input type="hidden" id="dateFindCpNgay" value="${param.date}"/>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#">
                <em class="fa fa-home"></em>
            </a></li>
            <li>Chi phí theo ngày</li>
        </ol>
    </div><!--/.row-->

    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-md-4">
                            Danh sách chi phí theo ngày
                        </div>
                        <div class="col-md-5 col-md-offset-1">
                            <div class="form-group form-inline">
                                <label class="control-label">Chọn ngày:</label>
                                <div class="input-group date" id="chon-ngay-cp-ngay">
                                    <input type="text" class="form-control" style="border: 1px solid #cccccc;">
                                    <div class="input-group-addon">
                                        <span class="fa fa-calendar"></span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <a href="<c:url value="/chinhanh/chiphi/ngay/create"/>" class="btn btn-primary fix pull-right">Thêm chi phí mới</a>
                        </div>
                    </div>
                </div>
                <div class="panel-body">
                    <table class="table table-striped custab table-don-hang">
                        <thead>
                        <tr>
                            <th width="10%" class="text-center red-text-table">ID</th>
                            <th>Tên chi phí</th>
                            <th width="25%" class="text-center">Thời gian</th>
                            <th width="10%" class="text-center">Tổng tiền</th>
                            <th width="5%"></th>
                            <th width="5%"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listChiPhiNgay}" var="chiPhiNgay">
                        <tr>
                            <td class="text-center red-text-table">${chiPhiNgay.chiPhiNgayId}</td>
                            <td>${chiPhiNgay.ten}</td>
                            <td class="text-center"><fmt:formatDate value="${chiPhiNgay.ngay}" pattern="dd/MM/yyyy HH:mm:ss"/></td>
                            <td class="text-center">${chiPhiNgay.tien}</td>
                            <td width="5%">
                                <a class="btn btn-warning" data-toggle="modal" data-target="#modal-sua-chi-phi-ngay">Sửa</a>
                            </td>
                            <td width="5%">
                                <a class="btn btn-danger">Xóa</a>
                            </td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!-- Dung cho jquery -->
<input type="hidden" id="dateFindCpThang" value="${param.year}"/>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#">
                <em class="fa fa-home"></em>
            </a></li>
            <li>Chi phí theo tháng</li>
        </ol>
    </div><!--/.row-->

    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-md-4">
                            Danh sách chi phí theo tháng
                        </div>
                        <div class="col-md-5 col-md-offset-1">
                            <div class="form-group form-inline">
                                <label class="control-label">Chọn năm:</label>
                                <div class="input-group date" id="chon-ngay-cp-thang">
                                    <input type="text" class="form-control" style="border: 1px solid #cccccc;">
                                    <div class="input-group-addon">
                                        <span class="fa fa-calendar"></span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <a href="<c:url value="/chinhanh/chiphi/thang/create"/>" class="btn btn-primary fix pull-right">Thêm chi phí mới</a>
                        </div>
                    </div>
                </div>
                <div class="panel-body">
                    <table class="table table-striped custab table-don-hang">
                        <thead>
                        <tr>
                            <th width="10%" class="text-center red-text-table">STT</th>
                            <th>Tên chi phí</th>
                            <th width="5%" class="text-center">Tháng</th>
                            <th width="5%" class="text-center">Năm</th>
                            <th width="15%" class="text-center">Ngày chi</th>
                            <th width="15%" class="text-center">Tổng tiền</th>
                            <th width="5%"></th>
                            <th width="5%"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listTienThueNha}" var="tienThueNha" varStatus="status">
                        <tr>
                            <td class="text-center red-text-table">${status.index + 1}</td>
                            <td>${tienThueNha.ten}</td>
                            <td class="text-center">${tienThueNha.thang}</td>
                            <td class="text-center">${tienThueNha.nam}</td>
                            <td class="text-center"><fmt:formatDate value="${tienThueNha.ngayChi}" pattern="dd/MM/yyyy"/></td>
                            <td class="text-center">${tienThueNha.tien} VNĐ</td>
                            <td>
                                <a href="<c:url value="/chinhanh/chiphi/thang/update?month=${tienThueNha.thang}&year=${tienThueNha.nam}"/>" class="btn btn-warning">Sửa</a>
                            </td>
                            <td>
                                <%--<a class="btn btn-danger">Xóa</a>--%>
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
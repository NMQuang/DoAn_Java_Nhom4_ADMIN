<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" contentType="text/html" %>

<!-- Dung cho jquery -->
<input type="hidden" id="dateChonThangThemLuong" value="${danhSachLuongNv.thoiGian}"/>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#">
                <em class="fa fa-home"></em>
            </a></li>
            <li><a href="<c:url value="/chinhanh/chiphi/luongnhanvien"/>">Xem thông tin lương nhân viên</a></li>
            <li>Tạo danh sách lương nhân viên</li>
        </ol>
    </div><!--/.row-->

    <div class="row">
        <div class="col-md-12">
            <c:url var="action" value="${type == 'update' ? '/chinhanh/chiphi/luongnhanvien/update' : '/chinhanh/chiphi/luongnhanvien/create'}"/>
            <form:form action="${action}" method="post" modelAttribute="danhSachLuongNv">
            <div class="form-horizontal">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <c:if test="${type == 'update'}">
                            Cập nhật lương nhân viên
                        </c:if>
                        <c:if test="${type != 'update'}">
                            Tạo danh sách lương nhân viên
                        </c:if>
                    </div>
                    <div class="panel-body">
                        <div class="form-group row">
                            <label class="control-label col-md-2">Chọn tháng</label>
                            <div class="col-md-4">
                                <div class="input-group date ${type == 'update' ? 'disabledbutton' : ''}" id="chon-thang-them-luong-nv" style="width:160px">
                                    <form:input path="thoiGian" type="text" class="form-control" style="border: 1px solid #cccccc;"/>
                                    <div class="input-group-addon">
                                        <span class="fa fa-calendar"></span>
                                    </div>
                                </div>
                                <form:errors path="thoiGian" cssClass="my_error"/>
                            </div>
                        </div>
                        <c:if test="${type == 'update'}">
                        <form:hidden path="thang"/>
                        <form:hidden path="nam"/>
                        </c:if>
                        <table class="table table-striped custab table-don-hang">
                            <thead>
                            <tr>
                                <th width="10%" class="text-center red-text-table">ID nhân viên</th>
                                <th width="20%">Tên nhân viên</th>
                                <th class="text-center">Mô tả</th>
                                <th width="20%" class="text-center">Lương tháng</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${danhSachLuongNv.listLuongNhanVien}" var="luongNv" varStatus="status">
                            <tr>
                                <form:hidden path="listLuongNhanVien[${status.index}].id"/>
                                <form:hidden path="listLuongNhanVien[${status.index}].ten"/>
                                <td class="text-center red-text-table">
                                    ${luongNv.id}
                                </td>
                                <td>
                                    ${luongNv.ten}
                                </td>
                                <td class="text-center">
                                    <form:input path="listLuongNhanVien[${status.index}].mota" class="expanded-input"/>
                                    <form:errors path="listLuongNhanVien[${status.index}].mota" cssClass="my_error"/>
                                </td>
                                <td class="text-center">
                                    <form:input type="number" path="listLuongNhanVien[${status.index}].luong" class="expanded-input" style="text-align: right"/>
                                    <form:errors path="listLuongNhanVien[${status.index}].luong" cssClass="my_error"/>
                                </td>
                            </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                </div>
            </div>
                <c:if test="${type == 'update'}">
                    <button class="btn btn-warning btn-lg center-block" type="submit">Cập nhật</button>
                </c:if>
                <c:if test="${type != 'update'}">
                    <button class="btn btn-primary btn-lg center-block" type="submit">Tạo danh sách lương mới</button>
                </c:if>
            <hr>
        </div>
            </form:form>
        </div>
    </div>
</div>
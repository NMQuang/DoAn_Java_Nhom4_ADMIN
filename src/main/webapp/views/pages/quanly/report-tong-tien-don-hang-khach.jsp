<%@page pageEncoding="UTF-8" contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="<c:url value='/quanly' />">
                <em class="fa fa-home"></em>
            </a></li>
            <li class="active">Báo cáo tổng số đơn hàng và tiền của khách</li>
        </ol>
    </div>

    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <form class="form-horizontal" method="get" action="<c:url value="/report/tongdonhang_hoadon_khachhang" />">
                    <div class="row">
                        <div class="panel-body">
                        <c:if test="${param.error !=null}"><div id="fail" class="alert alert-danger">Vui lòng nhập đúng các trường</div></c:if>
                        <c:if test="${param.notfound !=null}"><div id="fail" class="alert alert-danger">Không có khách hàng nào có số điện thoại này</div></c:if>
                            <div class="col-lg-6">
                                <div class="form-group form-inline">
                                    <label class="control-label col-md-4">SĐT Khách:</label>
                                    <input required="required" type="text" name="sdt" class="form-control expanded-input" style="border: 1px solid #cccccc; width: 250px;">
                                </div>
                                <div class="form-group form-inline">
                                    <label class="control-label col-md-4">Thống kê theo:</label>
                                    <select id="option-thong-ke" name="type" class="form-control expanded-input" style="border: 1px solid #cccccc; width: 250px;">
                                        <option value="option-all">Từ lúc bắt đầu</option>
                                        <option value="option-thang">Tháng</option>
                                    </select>
                                </div>
                                <div class="form-group form-inline">
                                    <label class="control-label col-md-4">Kiểu file xuất:</label>
                                    <select id="option-thong-ke" name="format" class="form-control expanded-input" style="border: 1px solid #cccccc; width: 250px;">
                                        <option value="html">HTML</option>
                                        <option value="pdf">PDF</option>
                                        <option value="png">Hình ảnh .PNG</option>
                                        <option value="xlsx">Excel</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="option-thong-ke" id="option-thang" style="display: none;">
                                    <div class="form-group form-inline">
                                        <label class="control-label col-md-5">Chọn tháng trong năm:</label>
                                        <div class="input-group date" data-provide="datepicker-month">
                                            <input id="id-thang" type="text" name="thang" class="form-control" style="border: 1px solid #cccccc;">
                                            <div class="input-group-addon">
                                                <span class="fa fa-calendar"></span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <button type="submit" class="btn btn-primary btn-lg center-block" style="margin-bottom: 15px;">Thống kê</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
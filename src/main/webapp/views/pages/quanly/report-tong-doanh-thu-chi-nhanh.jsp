<%@page pageEncoding="UTF-8" contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="<c:url value='/quanly' />">
                <em class="fa fa-home"></em>
            </a></li>
            <li class="active">Báo cáo doanh thu tổng</li>
        </ol>
    </div>

    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <form class="form-horizontal" method="get" action="<c:url value="/report/tongdoanhthuchinhanh" />">
                    <div class="row">
                        <div class="panel-body">
                        <c:if test="${param.error !=null}"><div id="fail" class="alert alert-danger">Có lỗi xảy ra với format dữ liệu</div></c:if>
                            <div class="col-lg-6">
                                <div class="form-group form-inline">
                                    <label class="control-label col-md-4">Thống kê theo:</label>
                                    <select id="option-thong-ke" name="type" class="form-control expanded-input" style="border: 1px solid #cccccc; width: 250px;">
                                        <option value="option-ngay">Ngày</option>
                                        <option value="option-tuan">Tuần</option>
                                        <option value="option-thang">Tháng</option>
                                        <option value="option-quy">Quý</option>
                                        <option value="option-nam">Năm</option>
                                    </select>
                                </div>
                                <div class="form-group form-inline">
                                    <label class="control-label col-md-4">Chọn chi nhánh:</label>
                                    <select id="option-thong-ke" name="chinhanh" class="form-control expanded-input" style="border: 1px solid #cccccc; width: 250px;">
                                        <c:forEach items="${AChiNhanh }" var="item">
                                        	<option value="${item.chiNhanhId }">${item.ten }</option>
                                        </c:forEach>
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
                                <div class="option-thong-ke" id="option-ngay" style="display: block;">
                                    <div class="form-group form-inline">
                                        <label class="control-label col-md-5">Chọn ngày:</label>
                                        <div class="input-group date" data-provide="datepicker">
                                            <input id="id_ngay" name="ngay" type="text" class="form-control" style="border: 1px solid #cccccc;">
                                            <div class="input-group-addon">
                                                <span class="fa fa-calendar"></span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="option-thong-ke" id="option-tuan" style="display: none;">
                                    <div class="form-group form-inline">
                                        <label class="control-label col-md-5">Chọn ngày trong tuần:</label>
                                        <div class="input-group date" data-provide="datepicker">
                                            <input id="id-ngay-trong-tuan"  name="tuan" type="text" class="form-control" style="border: 1px solid #cccccc;">
                                            <div class="input-group-addon">
                                                <span class="fa fa-calendar"></span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
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

                                <div class="option-thong-ke" id="option-quy" style="display: none;">
                                    <div class="form-group">
                                        <label class="control-label col-md-5">Chọn quý:</label>
                                        <select class="form-control expanded-input" name="quy" style="border: 1px solid #cccccc; width: 230px">
                                            <option value="1">Quý 1</option>
                                            <option value="2">Quý 2</option>
                                            <option value="3">Quý 3</option>
                                            <option value="4">Quý 4</option>
                                        </select>
                                    </div>
                                    <div class="form-group form-inline">
                                        <label class="control-label col-md-5">Chọn năm:</label>
                                        <div class="input-group date" data-provide="datepicker-year">
                                            <input id="id-quy" type="text" name="nam_quy" class="form-control" style="border: 1px solid #cccccc;">
                                            <div class="input-group-addon">
                                                <span class="fa fa-calendar"></span>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="option-thong-ke" id="option-nam" style="display: none;">
                                    <div class="form-group form-inline">
                                        <label class="control-label col-md-5">Chọn năm:</label>
                                        <div class="input-group date" data-provide="datepicker-year">
                                            <input id="id-nam" type="text" name="nam" class="form-control" style="border: 1px solid #cccccc;">
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
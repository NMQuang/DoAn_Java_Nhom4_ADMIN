<%@page pageEncoding="UTF-8" contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="<c:url value='/quanly' />">
                <em class="fa fa-home"></em>
            </a></li>
            <li class="active">Báo cáo số lượng khách mới theo thời gian</li>
        </ol>
    </div>

    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <form class="form-horizontal" method="get" action="<c:url value="/report/thongkekhachmoi" />">
                    <div class="row">
                        <div class="panel-body">
                        <c:if test="${param.error !=null}"><div id="fail" class="alert alert-danger">Vui lòng nhập các giá trị đúng</div></c:if>
                            <div class="col-lg-4 col-lg-offset-4" style="text-align: center">
                            	<label>Chọn kiểu xuất file</label>
                            </div>
                            <div class="col-lg-4 col-lg-offset-4">
                                <div class="form-group">
                                    
                                    <select id="option-thong-ke" name="format" class="form-control expanded-input" style="border: 1px solid #cccccc;">
                                        <option value="pdf">PDF</option>
                                        <option value="png">Hình ảnh .PNG</option>
                                        <option value="xlsx">Excel</option>
                                    </select>
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
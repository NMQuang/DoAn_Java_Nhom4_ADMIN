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
                            <button type="button" class="btn btn-primary fix pull-right" data-toggle="modal" data-target="#modal-them-chi-phi-ngay">Thêm chi phí mới</button>
                        </div>
                    </div>
                </div>
                <div class="modal fade" id="modal-them-chi-phi-ngay">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <b>Nhập thông tin chi phí mới</b>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>
                            <form class="form-horizontal">
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label class="control-label col-md-3" for="ten-chi-phi">Tên chi phí</label>
                                        <div class="col-md-7">
                                            <input class="form-control expanded-input" id="ten-chi-phi" name="ten-chi-phi">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-3" for="mo-ta">Mô tả</label>
                                        <div class="col-md-7">
                                            <textarea class="form-control expanded-input" id="mo-ta" name="mo-ta" rows="8"></textarea>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-3" for="tieu-hao">Tiêu hao</label>
                                        <div class="col-md-4">
                                            <input class="form-control expanded-input" id="tieu-hao" name="tieu-hao">
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default pull-right" style="margin-left: 16px" data-dismiss="modal">Đóng</button>
                                    <button type="submit" class="btn btn-success pull-right">Xác nhận</button>
                                </div>
                            </form>
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
                <div class="modal fade" id="modal-sua-chi-phi-ngay">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <b>Sửa thông tin chi phí #...</b>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>
                            <form class="form-horizontal">
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label class="control-label col-md-3" for="">Tên chi phí</label>
                                        <div class="col-md-7">
                                            <input class="form-control expanded-input" id="" name="">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-3" for="mo-ta">Mô tả</label>
                                        <div class="col-md-7">
                                            <textarea class="form-control expanded-input" id="" name="" rows="8"></textarea>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-3" for="tieu-hao">Tiêu hao</label>
                                        <div class="col-md-4">
                                            <input class="form-control expanded-input" id="" name="">
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default pull-right" style="margin-left: 16px" data-dismiss="modal">Đóng</button>
                                    <button type="submit" class="btn btn-success pull-right">Xác nhận</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
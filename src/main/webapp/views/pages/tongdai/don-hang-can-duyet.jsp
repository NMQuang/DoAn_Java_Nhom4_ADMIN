<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#">
                <em class="fa fa-home"></em>
            </a></li>
            <li>Xem danh sách đơn hàng </li>
        </ol>
    </div><!--/.row-->

    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="col-md-6">
                        Danh sách đơn hàng cần duyệt
                    </div>
                    <div class="col-md-4 pull-right">
                        <div class="input-group col-md-12">
                            <input id="input-tim-kiem-don-hang" type="text" class="form-control input-search-header-bar"
                                   placeholder="Thông tin đơn hàng">
                            <div class="input-group-btn">
                                <button id="btn-search-food-header-bar" class="btn btn-default" type="button">
                                    <i class="fa fa-search" aria-hidden="true"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel-body">
                    <div class="select-danh-sach-don-hang-tong-dai" id="option-don-hang-can-duyet">
                        <table class="table table-striped custab table-don-hang">
                            <thead>
                            <tr>
                                <th width="5%" class="text-center red-text-table">ID</th>
                                <th width="15%" class="text-center">SĐT người nhận</th>
                                <th>Tên người nhận</th>
                                <th width="10%" class="text-center">Tổng tiền</th>
                                <th width="15%" class="text-center">Tình trạng</th>
                                <th width="10%"></th>
                            </tr>
                            </thead>
                            <tbody>
                            
                            
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
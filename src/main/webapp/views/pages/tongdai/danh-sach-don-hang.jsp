<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="foodGroup4Quanly.common.state.*" %>
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
                        Danh sách
                        <select id="type_mon">
                            <option value="option-don-hang-qua-dt-tong-dai">đơn hàng qua điện thoại</option>
                            <option value="option-don-hang-online-tong-dai" ${ type == 'option-don-hang-online-tong-dai' ? 'selected': ''}>đơn hàng đặt online</option>
                        </select>
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
                    <div class="select-danh-sach-don-hang-tong-dai" id="option-don-hang-qua-dt-tong-dai">
                        <table class="table table-striped custab table-don-hang">
                            <thead>
                            <tr>
                                <th width="5%" class="text-center red-text-table">ID</th>
                                <th width="15%" class="text-center">SDT khách hàng</th>
                                <th>Tên khách hàng</th>
                                <th width="10%" class="text-center">Tổng tiền</th>
                                <th width="15%" class="text-center">Tình trạng</th>
                                <th width="5%"></th>
                                <th width="5%"></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${listhd }" var="item">
                            <tr>
                                <td class="text-center red-text-table">${item.hoaDonId }</td>
                                <td class="text-center">${item.khachhang.sdt }</td>
                                <td>${item.khachhang.ten }</td>
                                <td class="text-center"><span class=" _single_price" price="${item.tongTien }"></span></td>
                                <td class="text-center">${TinhTrangGiaoHang.codeToString(item.tinhTrangGiaoHang) }</td>
                                <td>
                                    <a href="<c:url value="/tongdai/hoadon/chi-tiet-don-hang/${item.hoaDonId }" />" class="btn btn-success">Xem</a>
                                </td>
                                <td>
                                	
                                    <a href="<c:url value="/tongdai/hoadon/xoa/${item.hoaDonId }" />" onclick="return confirm('Bạn có chắc chắn muốn xóa?')" class="btn btn-danger">Xóa</a>
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
            </div>
        </div>
    </div>
</div>
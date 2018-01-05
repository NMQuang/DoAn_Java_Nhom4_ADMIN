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
                        Danh sách
                        <select id="type_mon"  name="type">
                            <option ${type.equals('tong_dai') ? 'selected' : ''} value="tong_dai">đơn hàng từ tổng đài và đặt online</option>
                            <option ${type.equals('tai_cho') ? 'selected' : ''} value="tai_cho">đơn hàng tại quán</option>
                            <option ${type.equals('mang_ve') ? 'selected' : ''} value="mang_ve">đơn hàng mang về</option>
                        </select>
                    </div>
                    <div class="input-group col-md-4 pull-right">
                        <input id="input-tim-kiem-don-hang" type="text" class="form-control input-search-header-bar"
                               placeholder="Tên món ăn">
                        <div class="input-group-btn">
                            <button id="btn-search-food-header-bar" class="btn btn-default" type="button">
                                <i class="fa fa-search" aria-hidden="true"></i>
                            </button>
                        </div>
                    </div>
                </div>
                <div class="panel-body">
                    <div class="select-danh-sach-don-hang" id="option-don-hang-online">
                        <table class="table table-striped custab table-don-hang">
                            <thead>
                            <tr>
                                <th width="5%" class="text-center red-text-table">ID</th>
                                <th width="15%" class="text-center">Tên khách hàng</th>
                                <th>SĐT khách hàng</th>
                                <th width="10%" class="text-center">Tổng tiền</th>
                                <th width="15%" class="text-center">Tình trạng</th>
                                <th width="5%"></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${hoadon }" var="item">
                            <tr>
                                <td class="text-center red-text-table">${item.hoaDonId }</td>
                                <td class="text-center">${item.khachhang.ten }</td>
                                <td>${item.khachhang.sdt }</td>
                                <td>${item.tongTien}</td>
                                <c:choose>
								    <c:when test="${item.tinhTrangThanhToan =='0'}">
								      <td>Chưa thanh toán</td>
								    </c:when>
								    <c:otherwise>
								      <td>Thanh toán</td>
								    </c:otherwise>
								</c:choose>
                                <td width="5%">
                                    <a href="chi-tiet-don-hang.html" class="btn btn-info">Xem</a>
                                </td>
                                <td width="5%">
				                <c:choose>
				                	<c:when test="${type == 'tai_cho'}">
									     <a href="${pageContext.request.contextPath}/chinhanh/thanhtoandonhang/${item.hoaDonId}" class="btn btn-success">Thanh toán</a>
									</c:when>

				                </c:choose>
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
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
                        <select id="type_mon"  name="type">
                            <option ${type.equals('tong_dai') ? 'selected' : ''} value="tong_dai">đơn hàng từ tổng đài và đặt online</option>
                            <option ${type.equals('tai_cho') ? 'selected' : ''} value="tai_cho">đơn hàng tại quán</option>
                            <option ${type.equals('mang_ve') ? 'selected' : ''} value="mang_ve">đơn hàng mang về</option>
                        </select>
                    </div>
                    <div class="input-group col-md-4 pull-right">
                        <input id="input-tim-kiem-don-hang" type="text" class="form-control input-search-header-bar"
                               placeholder="Mã hóa đơn">
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
                                <th width="15%" class="text-center">Tên người nhận</th>
                                <th width="10%" class="text-center">SĐT người nhận</th>
                                <th width="10%" class="text-center">SĐT người đặt</th>
                                <th width="10%" class="text-center">Tổng tiền</th>
                                <th width="15%" class="text-center">Tình trạng thanh toán</th>
                                <th width="15%" class="text-center">Tình trạng</th>
                                <th width="15%" class="text-center"></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${hoadon }" var="item">
                            <tr>
                                <td class="text-center red-text-table">${item.hoaDonId }</td>
                                <td class="text-center">${item.hoTenNguoiNhan }</td>
                                <td class="text-center">${item.sdtNguoiNhan }</td>
                                <td class="text-center">${item.khachhang.sdt }</td>
                                <td class="text-center">${item.tongTien}</td>
                                <c:choose>
								    <c:when test="${item.tinhTrangThanhToan == 1}">
								      <td class="text-center">Chưa thanh toán</td>
								    </c:when>
								    <c:otherwise>
								      <td class="text-center">Đã thanh toán</td>
								    </c:otherwise>
								</c:choose>
								<td  class="text-center">
                                    ${TinhTrangGiaoHang.codeToString(item.tinhTrangGiaoHang) }
                                </td>
                                <td >
                                 <a class="btn btn-success" href="<c:url value='/chinhanh/chitietdonhang/${item.hoaDonId }' />" >Xem</a>
				                <c:choose>
				                	<c:when test="${type == 'mang_ve'}">
									     <c:if test="${ item.tinhTrangThanhToan !=0}">
									     	<a href="${pageContext.request.contextPath}/chinhanh/thanhtoandonhang/${item.hoaDonId}" class="btn btn-success">Thanh toán</a>
									     </c:if>
									</c:when>
									<c:when test="${type == 'tong_dai'}">
										<c:if test="${item.tinhTrangGiaoHang == TinhTrangGiaoHang.CHO_CHE_BIEN }">
											<a href="${pageContext.request.contextPath}/chinhanh/chuyendonhangxuongbep/${item.hoaDonId}" class="btn btn-success">Xuống bếp</a>
										</c:if>
										<c:if test="${item.tinhTrangGiaoHang == TinhTrangGiaoHang.DANG_CHE_BIEN }">
										<c:if test="${ item.tinhTrangThanhToan !=0}">
									     	<a href="${pageContext.request.contextPath}/chinhanh/thanhtoandonhang/${item.hoaDonId}" class="btn btn-success">Thanh toán</a>
									     </c:if>
										</c:if>
										
									</c:when>
									<c:when test="${type == 'tai_cho'}">
									</c:when>
									<c:otherwise>
									<c:if test="${ item.tinhTrangThanhToan !=0}">
									     	<a href="${pageContext.request.contextPath}/chinhanh/thanhtoandonhang/${item.hoaDonId}" class="btn btn-success">Thanh toán</a>
									     </c:if>
									</c:otherwise>
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
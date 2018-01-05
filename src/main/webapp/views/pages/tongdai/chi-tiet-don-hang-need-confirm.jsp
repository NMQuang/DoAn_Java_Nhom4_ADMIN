<%@ page pageEncoding="UTF-8" contentType="text/html" %>
<%@ page import="foodGroup4Quanly.common.state.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#">
                <em class="fa fa-home"></em>
            </a></li>
            <li><a href="danh-sach-don-hang.html"> Danh sách đơn hàng</a></li>
            <li class="active">Chi tiết đơn hàng </li>
        </ol>
    </div><!--/.row-->

    <div class="row">
        <div class="col-md-12">
            <form class="form-horizontal">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Thông tin đơn hàng
                    </div>
                    <div class="panel-body">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="control-label col-md-5" for="id-hoa-don">ID hóa đơn</label>
                                <div class="col-md-7">
                                    <input class="form-control expanded-input" id="id-hoa-don" name="id-hoa-don" value="${hoadon.hoaDonId }" disabled>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-5" for="ten-khach-hang">Họ tên người đặt</label>
                                <div class="col-md-7">
                                    <input class="form-control expanded-input" id="ten-khach-hang" name="ten-khach-hang" value="${hoadon.khachhang.ten }" disabled>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-5" for="sdt-khach-hang">Số điện thoại người đặt</label>
                                <div class="col-md-7">
                                    <input class="form-control expanded-input" id="sdt-khach-hang"  value="${hoadon.khachhang.sdt }" disabled>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-5" for="ngay-dat-hang">Ngày tạo</label>
                                <div class="col-md-5">
                                    <input class="form-control expanded-input" id="ngay-dat-hang" name="ngay-dat-hang" value="${hoadon.ngay }" disabled>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-5" for="tong-tien">Tổng tiền</label>
                                <div class="col-md-3">
                                    <input class="form-control expanded-input" id="tong-tien" name="tong-tien" value="${hoadon.tongTien }" disabled>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-5" for="hinh-thuc-mua">Hình thức mua</label>
                                <div class="col-md-7">
                                    <input class="form-control expanded-input" id="hinh-thuc-mua" name="hinh-thuc-mua" value="${hoadon.hinhThucMua }" disabled/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-5" for="hinh-thu-thanh-toan">Hình thức thanh toán</label>
                                <div class="col-md-7">
                                    <input class="form-control expanded-input" value="${hoadon.hinhThucThanhToan }" id="hinh-thu-thanh-toan" name="hinh-thuc-thanh-toan" disabled/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-5" for="tinh-trang-thanh-toan">Tình trạng thanh toán</label>
                                <div class="col-md-7">
                                    <select class="expanded-input" id="tinh-trang-thanh-toan" name="tinh-trang-thanh-toan" disabled>
                                        <option value="1" ${hoadon.tinhTrangThanhToan == 1 ? 'selected' : "" }>Chưa thanh toán</option>
                                        <option value="0" ${hoadon.tinhTrangThanhToan == 0 ? 'selected' : "" }>Đã thanh toán</option>
                                    </select>
                                </div>
                            </div>
                            
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="control-label col-md-5" for="sdt">Số điện thoại người nhận</label>
                                <div class="col-md-4">
                                    <input class="form-control expanded-input" id="sdt" name="sdt" value="${hoadon.sdtNguoiNhan }" disabled>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-5" for="sdt">Họ tên người nhận</label>
                                <div class="col-md-4">
                                    <input class="form-control expanded-input" id="sdt" name="sdt" value="${hoadon.hoTenNguoiNhan }" disabled>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-5" for="thoi-gian">Thời gian giao dự kiến</label>
                                <div class="col-md-7">
                                    <input class="form-control expanded-input" id="thoi-gian" name="thoi-gian" value="" disabled>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-5" for="dia-chi">Địa chỉ giao hàng</label>
                                <div class="col-md-7">
                                    <textarea class="form-control expanded-input" id="dia-chi" name="dia-chi"  rows="5" disabled>${hoadon.diaChiGiao }</textarea>
                                </div>
                            </div>
							<div class="form-group">
                                <label class="control-label col-md-5" for="dia-chi">Chi nhánh</label>
                                <div class="col-md-7">
                                    <input class="form-control expanded-input"  value="${hoadon.chinhanh.ten }" disabled>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-5" for="tinh-trang-don-hang">Tình trạng đơn hàng</label>
                                <div class="col-md-7">
                                    <input class="expanded-input" value="${TinhTrangGiaoHang.codeToString(hoadon.tinhTrangGiaoHang) }" id="tinh-trang-don-hang" name="tinh-trang-don-hang" disabled/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Danh sách món ăn trong đơn hàng
                    </div>
                    <div class="panel-body">
                        <table class="table table-striped custab" id="table-don-hang-mang-ve">
                            <thead>
                            <tr>
                                <th width="5%" class="text-center red-text-table">ID</th>
                                <th width="20%">Danh mục</th>
                                <th>Tên món ăn</th>
                                <th width="10%" class="text-center">Số lượng</th>
                                <th width="12%" class="text-center">Giá tiền</th>
                            </tr>
                            </thead>
                            <tbody>
                           <c:forEach items="${hoadon.chitiethoadons }" var="cthd">
                            	<tr>
                                <td class="text-center red-text-table">${cthd.pk.mon.monId }</td>
                                <td>${cthd.pk.mon.danhmuc.ten }</td>
                                <td>${ cthd.pk.mon.ten}</td>
                                <td><input class="input-sl-mon-an-dem-ve" value="${cthd.soLuong}"  type="number" style="width: 90px" disabled></td>
                                <td><input class="input-gia-mon-an" value="${cthd.tongTien}" type="text" style="width: 110px" disabled></td>
                            </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div style="text-align: center">
                	<a  class="btn btn-success btn-lg" href="<c:url value="/tongdai/hoadon/duyet/${hoadon.hoaDonId }" />">Duyệt</a>
                	<a  class="btn btn-danger btn-lg" href="<c:url value="/tongdai/hoadon/huy/${hoadon.hoaDonId }" />" onclick="return confirm('Bạn có chắc chắn?')">Hủy</a>
                </div>
                	
                	<br/>
                	<br/>
                	<br/>
            </form>
        </div>
    </div>

</div>
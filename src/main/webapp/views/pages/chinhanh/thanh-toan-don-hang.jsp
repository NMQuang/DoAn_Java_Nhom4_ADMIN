<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#">
                <em class="fa fa-home"></em>
            </a></li>
            <li class="active"> Thanh toán đơn hàng </li>
        </ol>
    </div><!--/.row-->
    <div class="row">
        <div class="col-md-12">
            <form class="form-horizontal" method="post">
                <div class="panel panel-default">
                <c:if test="${hoadon == null }">
                	<div id="fail" class="alert alert-danger">Hóa đơn không tồn tại</div>
                </c:if>
                <c:if test="${hoadon != null }">
                	<div class="panel-heading">
                        Thông tin đơn hàng
                    </div>
                    <div class="panel-body">
                        <div class="form-group">
                            <!-- Nếu không cần thiết thì xóa trường này đi -->
                            <label class="control-label col-md-4" for="ten-nhan-vien">Số điện thoại khách</label>
                            <div class="col-md-5">
                                <input class="form-control expanded-input" id="sdt_khach" name="sdt_khach" value="" placeholder="Tùy chọn">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-4" for="ten-khach-hang">Họ và tên khách hàng</label>
                            <div class="col-md-5">
                                <input class="form-control expanded-input" id="ten-khach-hang" name="ten_khach_hang" placeholder="Yêu cầu nhập số điện thoại" readonly="readonly">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-4" for="tong-tien">Tổng tiền hóa đơn</label>
                            <div class="col-md-2">
                                <input class="form-control expanded-input" id="tong-tien" value="${hoadon.tongTien }" readonly="readonly">
                            </div>
                        </div>
                        <div class="form-group">
                            <!-- Có thể set cứng trường này luôn nếu cần thiết -->
                            <label class="control-label col-md-4" for="hinh-thuc-mua">Hình thức mua</label>
                            <div class="col-md-5">
                                <input class="expanded-input" id="hinh-thuc-mua" readonly="readonly" value="${hoadon.hinhThucMua }"/>
                            </div>
                        </div>
                    </div>
                </c:if>
                    
                    
                </div>
				 <c:if test="${hoadon != null }">
                <!--nếu không cần thì cứ xóa table này đi luôn nhé-->
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
               	<button type="submit" class="btn btn-success btn-lg center-block">Thanh toán</button>
               </c:if>
                
                <hr>
            </form>
        </div>
    </div>

</div>

<%@ page pageEncoding="UTF-8" contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#">
                <em class="fa fa-home"></em>
            </a></li>
            <li>Tạo đơn hàng tại quán </li>
        </ol>
    </div><!--/.row-->

    <div class="content">
        <div class="row" style="display: flex;">
            <div class="col-lg-6" >
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Danh sách bàn trong quán
                    </div>
                    <div class="panel-body" style="height: 490px; overflow:auto;" >
                        <div class="row">
                        <c:forEach items="${dsBan }" var="item">
                         <div class="col-md-2">
                                <div class="btn-dat-ban ${item.tinhTrang == 1 ? 'btn-dat-ban-occupied':'' }" data-id="${item.banId }">
                                    <a href="javascript:">
                                        <img class="img-responsive"/>
                                        <p>${item.tenBan }</p>
                                    </a>
                                </div>
                            </div>
                        </c:forEach>
                           
                            
                        </div>
                    </div>
                </div>
            </div>

            <div class="modal fade" id="modal-dat-hang-tai-quan" role="dialog">
                <div class="modal-dialog modal-xl">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Chọn món ăn</h4>
                        </div>
                        <div class="modal-body" style="height: 500px">
                            <div class="col-md-5">
                                <div class="form-group">
                                    <label class="control-label col-md-3" style="margin-top: 6px">Danh mục:</label>
                                    <select id="select-danh-muc" class="form-control expanded-input"
                                            style="border: 1px solid #cccccc; width: 150px;">
                                            <c:forEach items="${dsDM }" var="item">
                                            	 <option value="danhmuc-${item.danhMucId }">${item.ten }</option>
                                            </c:forEach>
                                       
                                    </select>
                                </div>
                                <div class="well" style="height: 415px;">
                                    <div style="position: relative">
                                        <div style="height: 380px; overflow:auto;">
                                        <c:forEach items="${dsDM }" var="dm">
                                        	 <div class="select-danh-muc" id="danhmuc-${dm.danhMucId  }">
                                        	  <ul>
                                        	<c:forEach items="${dsCnMon}" var="cnm">
                                        	<c:if test="${cnm.pk.mon.danhmuc.danhMucId ==  dm.danhMucId }">
                                        	<li>
                                                 ${cnm.pk.mon.ten }
                                                    <button type="button"
                                                            class="btn btn-info btn-xs pull-right btn-them-mon-an"
                                                            id-sp="${cnm.pk.mon.monId }" name="${cnm.pk.mon.ten }"
                                                            price="${cnm.gia }">Chọn
                                                    </button>
                                                </li>
                                        	</c:if>
                                        		
                                        	</c:forEach>
                                        	</ul>
                                        	</div>
                                        </c:forEach>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-7">
                                <div class="text-center">
                                    <label class="control-label">Danh sách món ăn đã chọn</label>
                                </div>
                                <div class="well" style="margin-top: 18px; height: 415px;">
                                    <div style="position: relative">
                                        <div class="list-mon-an-da-chon" style="height: 380px; overflow:auto;">
                                            <ul id="danh-sach-mon-an-da-chon">
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-lg-6">
                <form class="form-horizontal">
                    <div class="panel panel-default" id="menu-ben-phai">
                        <div class="panel-heading">
                            <span id="menu-ben-phai-ten-ban"></span>
                            <a class="btn btn-primary fix pull-right" id="btn-mo-ban">Mở bàn</a>
                        </div>
                        <div class="panel-body" style="height: 436px;">
                            <div class="form-group">
                                <label class="control-label col-md-3 col-md-offset-1">Tình trạng </label>
                                <div class="col-md-5">
                                    <input class="form-control expanded-input" id="status-ban" readonly="readonly">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3 col-md-offset-1">Tổng tiền </label>
                                <div class="col-md-5">
                                    <input class="form-control expanded-input" id="menu-ben-phai-tong-tien" readonly="readonly">
                                </div>
                            </div>
                            <table id="table-don-hang-tai-quan">
                                <thead>
                                <tr>
                                    <th width="60%" style="padding-left: 10px; text-align: left">Tên món ăn</th>
                                    <th width="20%">Số lượng</th>
                                    <th width="20%">Tổng tiền</th>
                                </tr>
                                </thead>
                                <tbody>
                                
                                </tbody>
                            </table>
                        </div>
                        <div class="panel-footer text-center">
                            <button id="btn-chon-mon" type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-dat-hang-tai-quan">Chọn món</button>
                            <button id="btn-thanh-toan" type="button" class="btn btn-primary">Thanh toán</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
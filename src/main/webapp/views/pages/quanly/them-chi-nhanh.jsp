<%@ page pageEncoding="UTF-8" contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#">
                <em class="fa fa-home"></em>
            </a></li>
            <li>
                <a href="${pageContext.request.contextPath}/quanly/chinhanh"> Danh sách chi nhánh </a></li>
            <li>Tạo chi nhánh mới</li>
        </ol>
    </div><!--/.row-->

    <div class="row">
        <div class="col-lg-12">
            <h2>Tạo chi nhánh mới</h2>
        </div>
    </div>


    <form:form method="post" modelAttribute="chiNhanh" enctype="multipart/form-data">
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Thông tin chi nhánh
                    </div>
                    <div class="panel-body">
                        <div class="col-lg-5">
                            <div class="form-group">

								<img src="<c:url value="${chiNhanh.hinhAnh == null ? 'http://via.placeholder.com/350x220' : '/resources/images/mon-an/'+= mon.hinhAnh} " />" id="img-upload" class="img-mon-an" width="350px" height="220px"/>
								<div class="col-lg-5 cn-label label-right">
									<input type="file" accept="image/*" name="hinhanh" id="upload"/>
									<input type="text" value="${chiNhanh.hinhAnh }" hidden name="hinhanh_backup"/>
									<form:errors path="hinhAnh" cssClass="my_error"/>
								</div>
							</div>
                        </div>
                        <div class="col-lg-7">
                            <div class="form-group">
								<label class="col-sm-3 cn-label label-right" >Tên </label>
								<div class="col-lg-9">
									<form:input type="text" class="expanded-input" path="ten" placeholder="Tên"/>
									<form:errors path="ten" cssClass="my_error"/>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 cn-label label-right">Địa chỉ</label>
								<div class="col-sm-9">
									<form:textarea class="expanded-input" path="diaChi" placeholder="Địa chỉ" rows="3" style="resize: none"></form:textarea>
									<form:errors path="diaChi" cssClass="my_error"/>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 cn-label label-right">Điện thoại</label>
								<div class="col-sm-9">
									<form:input class="expanded-input" path="dienThoai" placeholder="Điện thoại" rows="3" style="resize: none"/>
									<form:errors path="dienThoai" cssClass="my_error"/>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 cn-label label-right" for="description">Tỉnh thành</label>
								<div class="col-lg-5">
									<form:select id="tinhthanh" class="expanded-input" path="tinhthanh.tinhThanhId">
										<form:option value="-1" label="--------- Select --------"></form:option>
										<form:options items="${tinhThanh}" itemValue="tinhThanhId" itemLabel="tenTinh"/>
									</form:select>
									<form:errors path="tinhthanh" cssClass="my_error"/>
								</div>
							</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <%-- <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div class="col-lg-3">
                            Thông tin bàn
                        </div>
                        <div class="col-lg-5">
                            <div class="input-group col-md-12">
                                <input id="input-search-table-header-bar" type="text" class="form-control"
                                       placeholder="ID, thông tin bàn">
                                <div class="input-group-btn">
                                    <button id="btn-search-table-header-bar" class="btn btn-default" type="button">
                                        <i class="fa fa-search" aria-hidden="true"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                        <a class="btn btn-primary fix pull-right" data-toggle="modal" data-target="#modal-tao-ban">Thêm bàn mới</a>
                        <div id="modal-tao-ban" class="modal fade" role="dialog">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title">Thêm bàn mới</h4>
                                    </div>
                                    <div class="modal-body">
                                        <input class="expanded-input" id="table-info" name="table-info" placeholder="Thông tin bàn">
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-success">Xác nhận</button>
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="panel-body">
                        <table class="table table-striped custab" id="table-search-header-bar">
                            <thead>
                                <tr>
                                    <th width="5%" class="text-center red-text-table">ID</th>
                                    <th>Thông tin bàn</th>
                                    <th width="5%"></th>
                                    <th width="5%"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td class="text-center red-text-table">1</td>
                                    <td>Thông tin bàn thứ nhất</td>
                                    <td>
                                        <button type="button" class="btn btn-info" data-toggle="modal"
                                                data-target="#modal-sua-ban" data-info="Thông tin bàn thứ nhất">Sửa</button>
                                    </td>
                                    <td>
                                        <a href="#" class="btn btn-danger">Xóa</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="text-center red-text-table">1</td>
                                    <td>Thông tin bàn thứ hai</td>
                                    <td>
                                        <button type="button" class="btn btn-info" data-toggle="modal"
                                                data-target="#modal-sua-ban" data-info="Thông tin bàn thứ hai">Sửa</button>
                                    </td>
                                    <td>
                                        <a href="#" class="btn btn-danger">Xóa</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="text-center red-text-table">1</td>
                                    <td>Thông tin bàn thứ ba</td>
                                    <td>
                                        <button type="button" class="btn btn-info" data-toggle="modal"
                                                data-target="#modal-sua-ban" data-info="Thông tin bàn thứ ba">Sửa</button>
                                    </td>
                                    <td>
                                        <a href="#" class="btn btn-danger">Xóa</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="text-center red-text-table">1</td>
                                    <td>Thông tin bàn thứ tư</td>
                                    <td>
                                        <buton type="button" class="btn btn-info" data-toggle="modal"
                                               data-target="#modal-sua-ban" data-info="Thông tin bàn thứ tư">Sửa</buton>
                                    </td>
                                    <td>
                                        <a href="#" class="btn btn-danger">Xóa</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="text-center red-text-table">1</td>
                                    <td>Thông tin bàn thứ năm</td>
                                    <td>
                                        <button type="button" class="btn btn-info" data-toggle="modal"
                                                data-target="#modal-sua-ban" data-info="Thông tin bàn thứ năm">Sửa</button>
                                    </td>
                                    <td>
                                        <a href="#" class="btn btn-danger">Xóa</a>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div id="modal-sua-ban" class="modal fade" role="dialog">
                        <form>
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title">Sửa thông tin bàn</h4>
                                    </div>
                                    <div class="modal-body">
                                        <input class="expanded-input" type="text" id="table-change-info">
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-success">Xác nhận</button>
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div class="col-lg-3">
                            Menu của chi nhánh
                        </div>
                        <div class="col-lg-5">
                            <div class="input-group col-md-12">
                                <input id="input-search-food-header-bar" type="text" class="form-control input-search-header-bar"
                                       placeholder="Tên món ăn">
                                <div class="input-group-btn">
                                    <button id="btn-search-food-header-bar" class="btn btn-default" type="button">
                                        <i class="fa fa-search" aria-hidden="true"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                        <button type="button" data-toggle="modal" data-target="#modal-them-mon" class="btn btn-primary pull-right fix">Thêm món ăn vào menu</button>
                    </div>
                    <div class="panel-body">
                        <table class="table table-striped custab" id="food-search-header-bar">
                            <thead>
                            <tr>
                                <th class="text-center red-text-table">ID</th>
                                <th>Danh mục</th>
                                <th>Tên món ăn</th>
                                <th width="10%" class="text-center">Giá tiền</th>
                                <th width="10%">Đơn vị tính</th>
                            </tr>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="modal fade" id="modal-them-mon" role="dialog">
                    <div class="modal-dialog modal-lg">
                        <!-- Modal content-->
                        <div class="modal-content">
                            <div class="modal-header">
                                <div class="modal-title">
                                    <div class="input-group col-md-10 col-md-offset-1">
                                        <div class="input-group-btn">
                                            <div id="btn-modal-search-food" class="btn btn-default fix" style="margin-top: 5px; border: 1px solid #E5E5E5" >
                                                <i class="fa fa-search" aria-hidden="true"></i>
                                            </div>
                                        </div>
                                        <input id="input-modal-search-food" type="text" class="form-control" placeholder="Tìm kiếm món ăn" style="margin-top: 5px">
                                    </div>
                                </div>
                            </div>
                            <div class="modal-body">
                                <table class="table table-striped custab" id="mon-an-search-header-bar">
                                    <thead>
                                        <tr>
                                            <th class="text-center red-text-table">ID</th>
                                            <th>Tên món ăn</th>
                                            <th>Danh mục</th>
                                            <th>Đơn vị tính</th>
                                            <th>Số lượng</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td class="text-center red-text-table">1</td>
                                            <td>ten san pham</td>
                                            <td>ten danh muc</td>
                                            <td>don vi tinh</td>
                                            <td>so luong</td>
                                            <td width="5%">
                                                <a href="" class="btn btn-info">Xem</a>
                                            </td>
                                            <td width="5%">
                                                <a href="" class="btn btn-danger">Xóa</a>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="text-center red-text-table">2</td>
                                            <td>ten san pham</td>
                                            <td>ten danh muc</td>
                                            <td>don vi tinh</td>
                                            <td>so luong </td>
                                            <td width="5%">
                                                <a href="" class="btn btn-info">Xem</a>
                                            </td>
                                            <td width="5%">
                                                <a href="" class="btn btn-danger">Xóa</a>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="text-center red-text-table">3</td>
                                            <td>ten san pham</td>
                                            <td>ten danh muc</td>
                                            <td>don vi tinh</td>
                                            <td>so luong </td>
                                            <td width="5%">
                                                <a href="" class="btn btn-info">Xem</a>
                                            </td>
                                            <td width="5%">
                                                <a href="" class="btn btn-danger">Xóa</a>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-success">Thêm món ăn đã chọn</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div> --%>

        <div class="text-center">
            <button type="submit" class="btn btn-lg btn-primary">Tạo chi nhánh</button>
        </div>
        <br>
    </form:form>
</div>
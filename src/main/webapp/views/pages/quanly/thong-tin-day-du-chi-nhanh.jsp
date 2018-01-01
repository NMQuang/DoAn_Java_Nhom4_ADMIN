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

        </ol>
    </div><!--/.row-->

    <div class="row">
        <div class="col-lg-12">
            <h2>Thông tin chi tiết chi nhánh ${branch.ten }</h2>
        </div>
    </div>


    <form:form method="post" modelAttribute="chiNhanh" enctype="multipart/form-data">
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                    	<div class="col-lg-3">
                        Thông tin chi nhánh
                        </div>
                        <a href="${pageContext.request.contextPath}/quanly/chinhanh/themchinhanh"  class="btn btn-primary pull-right fix">Thêm chi nhánh</a>
                    </div>

                    <div class="panel-body">
                        <div class="col-lg-5">
                            <div class="form-group">

								<img src="<c:url value="${chiNhanh.hinhAnh == null ? 'http://via.placeholder.com/350x220' : '/resources/images/chi-nhanh/'+= chiNhanh.hinhAnh} " />" id="img-upload" class="img-mon-an" width="350px" height="220px"/>
								<div class="col-lg-5 cn-label label-right">
									<input type="file" accept="image/*" name="hinhanh" id="upload" disabled="true"/>
									<input type="text" value="${chiNhanh.hinhAnh }" hidden name="hinhanh_backup"/>
									<form:errors path="hinhAnh" cssClass="my_error"/>
								</div>
							</div>

                        </div>
                        <div class="col-lg-7">
                            <div class="form-group">
								<label class="col-sm-3 cn-label label-right" >Tên </label>
								<div class="col-lg-9">
									<form:input type="text" class="expanded-input" path="ten" placeholder="Tên" disabled="true"/>
									<form:errors path="ten" cssClass="my_error"/>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 cn-label label-right">Địa chỉ</label>
								<div class="col-sm-9">
									<form:textarea class="expanded-input" path="diaChi" placeholder="Địa chỉ" rows="3" style="resize: none" disabled="true"></form:textarea>
									<form:errors path="diaChi" cssClass="my_error"/>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 cn-label label-right">Điện thoại</label>
								<div class="col-sm-9">
									<form:input class="expanded-input" path="dienThoai" placeholder="Điện thoại" rows="3" style="resize: none" disabled="true"/>
									<form:errors path="dienThoai" cssClass="my_error"/>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 cn-label label-right" for="description">Tỉnh thành</label>
								<div class="col-lg-5">
									<form:select id="tinhthanh" class="expanded-input" path="tinhthanh.tinhThanhId"  disabled="true">
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

        <div class="row">
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
                                    <button id="btn-search-table-header-bar" class="btn btn-default fix" type="button">
                                        <i class="fa fa-search" aria-hidden="true"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                        <a href="${pageContext.request.contextPath}/quanly/chinhanh-ban/${branch.chiNhanhId}/themban" class="btn btn-primary fix pull-right" >Thêm bàn mới</a>

                    </div>
                    <div class="panel-body">
                        <table class="table table-striped custab" id="table-search-header-bar">
                            <thead>
                            <tr>
                                <th width="5%" class="text-center red-text-table">ID</th>
                                <th>Tên bàn</th>
                                <th>Chi nhánh</th>
                                <th>Tình trạng</th>
                                <th width="5%"></th>
                                <th width="5%"></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${table }" var="item">
                            <tr>
                                <td class="text-center red-text-table">${item[0]}</td>
                                <td>${item[1]}</td>
                                <td>${item[3]}</td>
                                <c:choose>
								    <c:when test="${item[2]=='0'}">
								      <td>Chưa đặt</td>
								    </c:when>
								    <c:otherwise>
								      <td>Đã đặt</td>
								    </c:otherwise>
								</c:choose>
                                <td>
                                    <a href="${pageContext.request.contextPath}/quanly/chinhanh-ban/${branch.chiNhanhId}/suaban/${item[0]}" class="btn btn-info" disabled="true">Sửa</a>
                                </td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/quanly/chinhanh-ban/${branch.chiNhanhId}/xoaban/${item[0]}" class="btn btn-danger" onclick="return confirm('Bạn có chắc chắn muốn xóa')" disabled="true">Xóa</a>
                                </td>
                            </tr>
							</c:forEach>
                            </tbody>
                        </table>
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
                        <a href="${pageContext.request.contextPath}/quanly/chinhanh-menu/${branch.chiNhanhId}/themmonan"  class="btn btn-primary pull-right fix">Thêm món ăn vào menu</a>
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
                            <c:forEach items="${menu}" var="item">
                             <tr>
                                 <td class="text-center red-text-table">${item.pk.mon.monId }</td>

                                 <td>${item.pk.mon.danhmuc.ten}</td>
                                 <td>${item.pk.mon.ten}</td>
                                 <td>${item.gia}</td>
                                 <td>${item.pk.mon.donViTinh}</td>
                                 <td width="5%">
				                    <a href="<c:url value="/quanly/monan/${item.pk.mon.monId }"/>" class="btn btn-info">Xem</a>
				                </td>
                                 <td width="5%">
                                     <!-- <a href="" class="btn btn-info">Xem</a> -->
                                     <a href="#" data-toggle="modal" data-target="#modal-sua-gia" class="btn btn-info" disabled="true">Sửa giá</a>
                                 </td>
                                 <td width="5%">
                                     <a href="${pageContext.request.contextPath}/quanly/chinhanh-menu/${branch.chiNhanhId}/xoamonan/${item.pk.mon.monId}" onclick="return confirm('Bạn có chắc chắn muốn xóa')" class="btn btn-danger" disabled="true">Xóa</a>
                                 </td>
                             </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>

            </div>
        </div>
    </form:form>
</div>
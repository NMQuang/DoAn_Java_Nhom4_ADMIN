<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="<c:url value="/quanly" />"><i class="fa fa-home"></i></a></li>
            <li><a href="<c:url value="/quanly/chinhanh-menu/${mon.pk.chinhanh.chiNhanhId }" /> ">Danh sách món ăn chi nhánh ${mon.pk.chinhanh.ten }</a></li>
            <li class="active">${mon.pk.mon.ten }</li>
        </ol>
    </div><!--/.row-->

    <div class="panel panel-info">
        <div class="panel-heading">
            Thông tin món <b>${mon.pk.mon.ten }</b>
        </div>
        <div class="panel-body">
            <div class="row">

                <form:form method="post" modelAttribute="mon" enctype="multipart/form-data">
                    <div class="col-lg-4">
                        <img src="<c:url value="${mon.pk.mon.hinhAnh == null ? 'http://via.placeholder.com/350x220' : '/resources/images/mon-an/'+= mon.pk.mon.hinhAnh} " />" id="img-upload" class="img-mon-an" width="350px" height="220px"/>
                        <div class="">
                            <input type="file" accept="image/*" name="hinhanh" id="upload" disabled="true"/>
                            <form:errors path="pk.mon.hinhAnh" cssClass="my_error"/>
                        </div>
                    </div>
                    <div class="col-lg-8">
                        <div class="form-horizontal">
                            <div class="form-group">
                                <label class="control-label col-lg-3" for="food-name">Tên món ăn:</label>
                                <div class="col-lg-9">
                                    <form:input type="text" class="expanded-input" id="food-name" path="pk.mon.ten" disabled="true"/>
                                    <form:errors path="pk.mon.ten" cssClass="my_error"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-3" for="description">Mô tả:</label>
                                <div class="col-lg-9">
                                    <form:textarea class="expanded-input" id="description" rows="5" path="pk.mon.moTa" disabled="true"/>
									<form:errors path="pk.mon.moTa" cssClass="my_error"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-3" for="food-name">Giá:</label>
                                <div class="col-lg-9">
                                    <form:input type="text" class="expanded-input" id="food-name" path="gia"/>
                                    <form:errors path="gia" cssClass="my_error"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-3" for="food-name">Đơn vị:</label>
                                <div class="col-lg-9">
                                    <form:input type="text" class="expanded-input" id="food-name" path="pk.mon.donViTinh" disabled="true"/>
                                    <form:errors path="pk.mon.donViTinh" cssClass="my_error"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-lg-offset-3 col-lg-9">
                                    <button type="submit" class="btn btn-info btn-lg">Cập nhật</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form:form>
            </div>

        </div>

    </div>
</div>
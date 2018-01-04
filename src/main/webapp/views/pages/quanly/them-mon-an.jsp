<%@page pageEncoding="UTF-8" contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="<c:url value="/quanly"/>"><i class="fa fa-home"></i></a></li>
            <li><a href="<c:url value="/quanly/monan"/>" style="text-decoration: none;">Danh sách món ăn</a></li>
            <li class="active">Tạo món ăn mới</li>
        </ol>
    </div><!--/.row-->

    <div class="panel panel-info">
        <div class="panel-heading">
            Tạo món ăn mới
        </div>
        <div class="panel-body">
            <div class="row">
                <form:form method="post" modelAttribute="mon" enctype="multipart/form-data">
                    <div class="col-lg-4">
                        <img src="<c:url value="${mon.hinhAnh == null || mon.hinhAnh == '' ? 'http://via.placeholder.com/350x220' : '/global_resources/images/mon-an/'+= mon.hinhAnh} " />" id="img-upload" class="img-mon-an" width="350px" height="220px"/>
                        <div class="">
                            <input type="file" accept="image/*" name="hinhanh" id="upload"/>
                            <input type="text" value="${mon.hinhAnh }" hidden name="hinhanh_backup"/>
                            <form:errors path="hinhAnh" cssClass="my_error"/>      
                        </div>
                    </div>
                    <div class="col-lg-8">
                        <div class="form-horizontal">
                            <div class="form-group">
                                <label class="control-label col-lg-3" for="food-name">Tên món ăn:</label>
                                <div class="col-lg-9">
                                    <form:input type="text" class="expanded-input" id="food-name" path="ten"/>
                                    <form:errors path="ten" cssClass="my_error"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-3" for="description">Mô tả:</label>
                                <div class="col-lg-9">
                                    <form:textarea class="expanded-input" id="description" rows="5" path="moTa"/>
									<form:errors path="moTa" cssClass="my_error"/>                                
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-3" for="food-name">Đơn vị:</label>
                                <div class="col-lg-9">
                                    <form:input type="text" class="expanded-input" id="food-name" path="donViTinh"/>
                                    <form:errors path="donViTinh" cssClass="my_error"/>       
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-3" for="description">Chọn danh mục:</label>
                                <div class="col-lg-5">
                                    <form:select id="danhmuc" class="expanded-input" path="danhmuc.danhMucId">
                                    	<form:option value="-1" label="--------- Select --------"></form:option>
                                        <form:options items="${ADanhmuc}" itemValue="danhMucId" itemLabel="ten"/>
                                    </form:select>
                                    <form:errors path="danhmuc" cssClass="my_error"/>   
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-offset-4">
                                    <button type="submit" class="btn btn-info btn-lg">Tạo món ăn</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>

    </div>
</div>

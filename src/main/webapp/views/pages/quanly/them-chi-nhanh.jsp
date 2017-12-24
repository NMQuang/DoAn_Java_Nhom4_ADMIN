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
                <a href="${pageContext.request.contextPath}/quanly/chinhanh""> Danh sách chi nhánh </a> </li>
            <li>Tạo chi nhánh mới </li>
        </ol>
    </div><!--/.row-->

    <div class="row">
        <div class="col-lg-12">
            <h2>Tạo chi nhánh mới</h2>
        </div>
    </div>


    <form:form method="post" modelAttribute="chiNhanh" enctype="multipart/form-data">
        <div class="panel panel-default">
            <div class="panel-heading">
                Thông tin chi nhánh
            </div>
            <div class="panel-body">

                <div class="col-lg-6">
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
                            <form:textarea class="expanded-input" path="dienThoai" placeholder="Điện thoại" rows="3" style="resize: none"></form:textarea>
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

                <div class="col-lg-6">
                    <!-- <div class="form-group">
                        <label class="col-sm-4 cn-label label-right">Số lượng bàn</label>
                        <div class="col-sm-8">
                            <input class="expanded-input" type="text" placeholder="Số lượng" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 cn-label label-right">Thông tin bàn</label>
                        <div class="col-sm-8">
                            <textarea class="expanded-input" placeholder="Thông tin" rows="3" style="resize: none"></textarea>
                        </div>
                    </div> -->
                    <div class="form-group">

                    	<img src="<c:url value="${chiNhanh.hinhAnh == null ? 'http://via.placeholder.com/350x220' : '/resources/images/mon-an/'+= mon.hinhAnh} " />" id="img-upload" class="img-mon-an" width="350px" height="220px"/>
                        <div class="col-lg-5 cn-label label-right">
                            <input type="file" accept="image/*" name="hinhanh" id="upload"/>
                            <input type="text" value="${chiNhanh.hinhAnh }" hidden name="hinhanh_backup"/>
                            <form:errors path="hinhAnh" cssClass="my_error"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Menu của chi nhánh
                        <a href="tao_menu_chi_nhanh.html" class="btn btn-primary fix">Thêm món ăn vào menu</a>
                    </div>
                    <div class="panel-body">

                    </div>
                </div>
            </div>
        </div> -->

        <div class="text-center">
            <button type="submit" class="btn btn-lg btn-primary">Tạo chi nhánh mới</button>
        </div>
        <br>
    </form:form>
</div>
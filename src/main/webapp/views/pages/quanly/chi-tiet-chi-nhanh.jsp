<%@page pageEncoding="UTF-8" contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#">
                <em class="fa fa-home"></em>
            </a></li>
            <li>
                <a href="<c:url value="/quanly/chinhanh"/>"> Danh sách chi nhánh </a></li>
            <li>Chi nhánh ${chiNhanh.ten }</li>
        </ol>
    </div><!--/.row-->

    <form:form method="post" modelAttribute="chiNhanh" enctype="multipart/form-data">
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Thông tin chi nhánh ${chiNhanh.ten }
                    </div>
                    <div class="panel-body">
                        <div class="col-lg-5">
                            <div class="col-lg-4">
                                <img src="<c:url value="${chiNhanh.hinhAnh == null ? 'http://via.placeholder.com/350x220' : '/global_resources/images/chi-nhanh/'+= chiNhanh.hinhAnh} " />" id="img-upload" class="img-mon-an" width="350px" height="220px"/>
                        <div class="">
                            <input type="file" accept="image/*" name="hinhanh" id="upload"/>
                            <form:errors path="hinhAnh" cssClass="my_error"/>
                        </div>
                            </div>
                        </div>
                        <div class="col-lg-7">
                            <div class="form-group">
                                <label class="col-sm-3 cn-label label-right">Tên</label>
                                <div class="col-sm-9">
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
                                <label class="col-sm-3 cn-label label-right">Tỉnh thành</label>
                                <div class="col-sm-9">
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

        <div class="text-center">
            <button type="submit" class="btn btn-lg btn-primary">Sửa thông tin</button>
        </div>
        <br>
    </form:form>
</div>
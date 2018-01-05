<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="<c:url value="/quanly" />"><i class="fa fa-home"></i></a></li>
            <li><a href="<c:url value="/quanly/monan" /> ">Danh sách món ăn</a></li>
            <li class="active">${mon.ten }</li>
        </ol>
    </div><!--/.row-->

    <div class="panel panel-info">
        <div class="panel-heading">
            Thông tin món <b>${mon.ten }</b>
        </div>
        <div class="panel-body">
            <div class="row">
                
                <form:form method="post" modelAttribute="mon" enctype="multipart/form-data">
                    <div class="col-lg-4">
                        <img src="<c:url value="${mon.hinhAnh == null ? 'http://via.placeholder.com/350x220' : '/global_resources/images/mon-an/'+= mon.hinhAnh} " />" id="img-upload" class="img-mon-an" width="350px" height="220px"/>
                        <div class="">
                            <input type="file" accept="image/*" name="hinhanh" id="upload"/>
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
                                <div class="col-lg-offset-3 col-lg-9">
                                    <button type="submit" class="btn btn-info btn-lg">Cập nhật</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form:form>
            </div>
            <div class="row col-lg-12">
                <table class="table table-food">
                    <thead>
                    <tr>
                        <td colspan="2">
                            <b> Danh sách chi nhánh có món ăn này </b>
                        </td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${ listchinhanh}" var="item">
                    	 <tr>
                        <td width="60%">
                            <h5>${item.pk.chinhanh.ten }</h5>
                            <p> <i class="fa fa-map-marker"></i> &nbsp Địa chỉ: ${item.pk.chinhanh.diaChi}</p>
                        </td>
                        <td>
                            <i class="fa fa-tag"></i> Giá <span class="_single_price" price="${item.gia }"></span> VND
                        </td>
                    </tr>
                    </c:forEach>
                   
                    </tbody>
                </table>
            </div>
        </div>

    </div>
</div>
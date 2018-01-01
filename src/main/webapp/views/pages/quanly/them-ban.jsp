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
                <a href="${pageContext.request.contextPath}/quanly/chinhanh-ban/${chinhanh.chiNhanhId}"> Chi nhánh ${chinhanh.ten}</a></li>
            <li>Tạo bàn mới</li>
        </ol>
    </div><!--/.row-->

    <div class="row">
        <div class="col-lg-12">
            <h2>Tạo bàn mới</h2>
        </div>
    </div>


    <form:form method="post" modelAttribute="ban">
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Thông tin bàn
                    </div>
                    <div class="panel-body">
                        <div class="col-lg-7">
                            <div class="form-group">
								<label class="col-sm-3 cn-label label-right" >Tên bàn</label>
								<div class="col-lg-9">
									<form:input type="text" class="expanded-input" path="tenBan" placeholder="Tên"/>
									<form:errors path="tenBan" cssClass="my_error"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 cn-label label-right" >Tình trạng</label>
								<div class="col-lg-9">
									<form:input type="text" class="expanded-input" path="tinhTrang" placeholder="Tên" disabled="true"/>
									<form:errors path="tinhTrang" cssClass="my_error"/>
								</div>
							</div>
							<div class="form-group">
                                <label class="col-sm-3 cn-label label-right">Chi nhánh</label>
                                <div class="col-sm-9">
                                    <form:input type="text" class="expanded-input" path="chinhanh.ten" placeholder="Tên" disabled="true" value="${chinhanh.ten }"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="text-center">
            <button type="submit" class="btn btn-lg btn-primary">Tạo bàn</button>
        </div>
        <br>
    </form:form>
</div>
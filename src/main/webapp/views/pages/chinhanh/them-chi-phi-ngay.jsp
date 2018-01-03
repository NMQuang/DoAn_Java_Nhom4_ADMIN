<%@ page pageEncoding="UTF-8" contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#">
                <em class="fa fa-home"></em>
            </a></li>
            <li><a href="<c:url value="/chinhanh/chiphi/ngay"/>">Chi phí theo ngày</a></li>
            <li>Tạo chi phí theo ngày</li>
        </ol>
    </div><!--/.row-->

    <div class="row">
        <div class="col-md-12">
            <form:form action="/chinhanh/chiphi/ngay/create" method="post" modelAttribute="chiPhiNgay" class="form-horizontal">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Tạo chi phí theo ngày
                    </div>
                    <div class="panel-body">
                        <div class="form-group">
                            <label class="control-label col-md-3" for="ten-chi-phi">Tên chi phí</label>
                            <div class="col-md-7">
                                <form:input path="ten" class="form-control expanded-input" id="ten-chi-phi" name="ten-chi-phi"/>
                                <form:errors path="ten" cssClass="my_error"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3" for="mo-ta">Mô tả</label>
                            <div class="col-md-7">
                                <form:textarea path="mota" class="form-control expanded-input" id="mo-ta" name="mo-ta" rows="8"/>
                                <form:errors path="mota" cssClass="my_error"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3" for="tieu-hao">Tiêu hao</label>
                            <div class="col-md-4">
                                <form:input path="tien" type="number" class="form-control expanded-input" id="tieu-hao" name="tieu-hao"/>
                                <form:errors path="tien" cssClass="my_error"/>
                            </div>
                        </div>
                    </div>
                </div>
                <button class="btn btn-success btn-lg center-block" type="submit">Tạo chi phí mới</button>
                <hr>
            </form:form>
        </div>
    </div>
</div>
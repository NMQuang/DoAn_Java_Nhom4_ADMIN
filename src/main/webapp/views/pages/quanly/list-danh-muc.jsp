<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#">
                <em class="fa fa-home"></em>
            </a></li>
            <li class="active">Danh mục món ăn</li>
        </ol>
    </div><!--/.row-->
    <c:if test="${not empty createDmSuccess}">
        <div class="alert alert-success notify">
            <strong><spring:message code="danhmuc.create.success"/></strong>
        </div>
    </c:if>
    <c:if test="${not empty deleteDmSuccess}">
        <div class="alert alert-success notify">
            <strong><spring:message code="danhmuc.delete.success"/></strong>
        </div>
    </c:if>
    <c:if test="${not empty activeDmSuccess}">
        <div class="alert alert-success notify">
            <strong><spring:message code="danhmuc.delete.activesuccess"/></strong>
        </div>
    </c:if>
    <div class="panel panel-info">
        <div class="panel-heading">
            Danh sách tất cả các danh mục
            <select class="" id="type_mon" style="background-color: #30a5ff" name="type">
                <option ${type.equals("current") ? 'selected' : ''} value="current">hiện hành</option>
                <option ${type.equals('deleted') ? 'selected' : ''} value="deleted">đã xóa</option>
            </select>
            <button type="button" class="btn btn-default pull-right fix"
                    data-toggle="modal" data-target="#modal-tao-danh-muc"><b>+</b> Thêm danh mục mới</button>
        </div>

        <table class="table table-striped custab">
            <thead>
            <tr>
                <th class="text-center red-text-table">ID</th>
                <th width="40%">Tên danh mục</th>
                <th class="text-center">Số lượng món ăn</th>
                <th width="1%"></th>
                <th width="1%"></th>
                <th width="1%"></th>
            </tr>
            </thead>
            <c:forEach items="${listDanhmuc}" var="danhmuc">
            <tr>
                <td class="text-center red-text-table">${danhmuc.danhMucId}</td>
                <td>
                    <a href="#">${danhmuc.ten}</a>
                </td>
                <td class="text-center">${danhmuc.mons.size()}</td>
                <td>
                    <button class="btn btn-warning pull-right" type="button" data-toggle="modal" data-active-danh-muc-sua="${danhmuc.active}" data-ten-danh-muc-sua="${danhmuc.ten}" data-id-danh-muc-sua="${danhmuc.danhMucId}" data-target="#modal-sua-danh-muc">Sửa</button>
                </td>
                <td>
                    <c:if test="${type.equals('current')}">
                        <a href="<c:url value="/quanly/danhmuc/delete/${danhmuc.danhMucId}"/>" onclick="return confirm('Bạn có chắc chắn muốn xóa')" class="btn btn-danger pull-right" >Xóa</a>
                    </c:if>
                    <c:if test="${type.equals('deleted')}">
                        <a href="<c:url value="/quanly/danhmuc/active/${danhmuc.danhMucId}"/>" onclick="return confirm('Bạn có chắc chắn muốn hồi phục')" class="btn btn-success pull-right" >Thêm</a>
                    </c:if>
                </td>
                <td>
                    <a href="<c:url value="/quanly/danhmuc/${danhmuc.danhMucId}"/>" class="btn btn-info pull-right">Xem danh sách món ăn</a>
                </td>
            </tr>
            </c:forEach>
        </table>

        <div class="modal fade" id="modal-tao-danh-muc" data-autoshow="${hasErrorCreateDm}" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Thêm danh mục mới</h4>
                    </div>
                    <div class="modal-body">
                        <form:form method="post" action="/quanly/danhmuc" modelAttribute="newDm" class="form-horizontal" role="form">
                            <div class="form-group">
                                <label class="col-lg-3" for="ten-danh-muc" style="margin-top: 2px">Tên danh mục:</label>
                                <div class="col-lg-9">
                                    <form:input type="text" class="expanded-input" path="ten" id="ten-danh-muc"/>
                                    <form:errors path="ten" cssClass="error"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <button type="button" class="btn btn-default pull-right" style="margin-left: 20px" data-dismiss="modal">Cancel</button>
                                    <button type="submit" class="btn btn-info pull-right">Xác nhận</button>
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>

        <div class="modal fade" id="modal-sua-danh-muc" data-autoshow="${hasErrorUpdateDm}" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Sửa thông tin danh mục</h4>
                    </div>
                    <div class="modal-body">
                        <c:out value="${updateDm.danhMucId}"/>
                        <form action="<c:url value="/quanly/danhmuc/update"/>" method="post" class="form-horizontal" role="form">
                            <div class="form-group">
                                <label class="col-lg-3 control-label" for="ten-danh-muc-sua">Tên danh mục:</label>
                                <div class="col-lg-9">
                                    <input name="updateDm.ten" value="${updateDm.ten}" type="text" class="expanded-input" id="ten-danh-muc-sua"/>
                                    <form:errors path="ten" cssClass="error"/>
                                </div>
                            </div>
                            <input type="hidden" name="updateDm.danhMucId" value="${updateDm.danhMucId}" id="id-danh-muc-sua"/>
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <button type="button" class="btn btn-default pull-right" style="margin-left: 20px" data-dismiss="modal">Đóng</button>
                                    <button type="submit" class="btn btn-warning pull-right">Sửa thông tin</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
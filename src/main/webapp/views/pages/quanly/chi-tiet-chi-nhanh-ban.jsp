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
                <a href="${pageContext.request.contextPath}/quanly/chinhanh/"> Danh sách chi nhánh </a></li>
            <li><a href="${pageContext.request.contextPath}/quanly/chinhanh/${branch.chiNhanhId}">Chi nhánh ${branch.ten}</a></li>
        </ol>
    </div><!--/.row-->

    <form role="form" class="form-horizontal">
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

                        <!-- <div id="modal-tao-ban" class="modal fade" role="dialog">
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
                                        <button type="submit" class="btn btn-success">Xác nhận</button>
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                    </div>
                                </div>
                            </div>
                        </div> -->
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
                                    <a href="${pageContext.request.contextPath}/quanly/chinhanh-ban/${branch.chiNhanhId}/suaban/${item[0]}" class="btn btn-info" >Sửa</a>
                                </td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/quanly/chinhanh-ban/${branch.chiNhanhId}/xoaban/${item[0]}" class="btn btn-danger" onclick="return confirm('Bạn có chắc chắn muốn xóa')">Xóa</a>
                                </td>
                            </tr>
							</c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <%-- <div id="modal-sua-ban" class="modal fade" role="dialog">
                        <div class="modal-dialog">
                            <form>
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title">Sửa thông tin bàn</h4>
                                    </div>
                                    <div class="modal-body">
                                        <input class="expanded-input" type="text" id="table-change-info">
                                    </div>
                                    <div class="modal-footer">
                                        <button type="submit" class="btn btn-success">Xác nhận</button>
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div> --%>
                </div>
            </div>
        </div>


        <div class="text-center">
            <button type="submit" class="btn btn-lg btn-primary">Sửa thông tin</button>
        </div>
        <br>
    </form>
</div>
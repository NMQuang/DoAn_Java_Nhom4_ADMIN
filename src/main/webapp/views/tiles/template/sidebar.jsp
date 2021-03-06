<%@page pageEncoding="UTF-8" contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
    <div class="profile-sidebar">
        <div class="profile-usertitle">
            <div class="profile-usertitle-name">${nv_quanly.ten }</div>
            <div class="profile-usertitle-status"><span class="indicator label-success"></span>Online</div>
        </div>
        <div class="clear"></div>
    </div>
    <div class="divider"></div>
    <form role="search">
        <div class="form-group">
            <input type="text" class="form-control" placeholder="Search">
        </div>
    </form>
    <ul class="nav menu">
        <li ><a href="<c:url value="/quanly/index"/>"><em class="fa fa-bars">&nbsp;</em> Dashboard </a></li>
        <li><a href="<c:url value="/quanly/monan"/>"><em class="fa fa-cutlery">&nbsp;</em> Danh sách món ăn  </a></li>
        <li><a href="<c:url value="/quanly/danhmuc"/>"><em class="fa fa-list-alt">&nbsp;</em> Danh mục món ăn</a></li>
        <li><a href="<c:url value="/quanly/chinhanh"/>"><em class="fa fa-globe">&nbsp;</em> Danh sách chi nhánh </a></li>
        <li class="parent "><a data-toggle="collapse" href="#sub-item-1">
            <em class="fa fa-bar-chart">&nbsp;</em> Báo cáo <span data-toggle="collapse" href="#sub-item-1" class="icon pull-right"><em class="fa fa-plus"></em></span>
        </a>
            <ul class="children collapse" id="sub-item-1">
                <li><a class="" href="<c:url value="/quanly/baocao/tongdoanhthu"/>">
                    <span class="fa fa-arrow-right">&nbsp;</span> Doanh thu tổng
                </a></li>
                 <li><a class="" href="<c:url value="/quanly/baocao/tongdoanhthuchinhanh"/>">
                    <span class="fa fa-arrow-right">&nbsp;</span> Doanh thu chi nhánh
                </a></li>
                <li><a class="" href="<c:url value="/quanly/baocao/tongdonhang"/>">
                    <span class="fa fa-arrow-right">&nbsp;</span> Tổng đơn hàng
                </a></li>
                <li><a class="" href="<c:url value="/quanly/baocao/tongdonhangtheoloai"/>">
                    <span class="fa fa-arrow-right">&nbsp;</span> Đơn hàng theo loại
                </a></li>
                <li><a class="" href="<c:url value="/quanly/baocao/tongchiphi"/>">
                    <span class="fa fa-arrow-right">&nbsp;</span> Tổng chi phí
                </a></li>
                <li><a class="" href="<c:url value="/quanly/baocao/tongchiphichinhanh"/>">
                    <span class="fa fa-arrow-right">&nbsp;</span> Chi phí chi nhánh
                </a></li>
                <li><a class="" href="<c:url value="/quanly/baocao/tongsoluongmontrongthang"/>">
                    <span class="fa fa-arrow-right">&nbsp;</span> Món ăn
                </a></li>
                <li><a class="" href="<c:url value="/quanly/baocao/tongtien_donhang_khach"/>">
                    <span class="fa fa-arrow-right">&nbsp;</span> Khách hàng
                </a></li>
                <li><a class="" href="<c:url value="/quanly/baocao/thongkekhachmoi"/>">
                    <span class="fa fa-arrow-right">&nbsp;</span> Lượng khách mới
                </a></li>
            </ul>
        </li>
        <li><a href="#" onclick="postLogout()"><em class="fa fa-power-off">&nbsp;</em> Đăng xuất </a></li>
    </ul>
</div><!--/.sidebar-->
 <script>
                    function postLogout() {
                        var formLogout = document.createElement("form");
                        formLogout.setAttribute("method", "post");
                        formLogout.setAttribute("action", "<c:url value="/logout"/>");


                        document.body.appendChild(formLogout);
                        formLogout.submit();
                    }
                </script>
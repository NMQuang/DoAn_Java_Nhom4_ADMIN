<%@ page pageEncoding="UTF-8" contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
    <div class="profile-sidebar">
        <div class="profile-userpic">
            <img src="http://placehold.it/50/30a5ff/fff" class="img-responsive" alt="">
        </div>
        <div class="profile-usertitle">
            <div class="profile-usertitle-name">Username</div>
            <div class="profile-usertitle-status"><span class="indicator label-success"></span>Online</div>
        </div>
        <div class="clear"></div>
    </div>
    <div class="divider"></div>
    <ul class="nav menu">
        <li><a href="<c:url value="/chinhanh/taodonhang/taiquan"/>"><em class="fa fa-list-alt">&nbsp;</em> Tạo đơn hàng tại quán </a></li>
        <li><a href="<c:url value="/chinhanh/taodonhang/mangve"/>"><em class="fa fa-list-alt">&nbsp;</em> Tạo đơn hàng mang về </a></li>
        <li><a href="<c:url value="/chinhanh/danhsachdonhang"/>"> <em class="fa fa-list-ul">&nbsp;</em> Danh sách đơn hàng </a></li>
        <li><a href="<c:url value="/chinhanh/chiphi/ngay"/>"><em class="fa fa-credit-card-alt">&nbsp;</em> Chi phí theo ngày </a></li>
        <li><a href="<c:url value="/chinhanh/chiphi/thang"/>"><em class="fa fa-credit-card-alt">&nbsp;</em> Chi phí theo tháng</a></li>
        <li><a href="<c:url value="/chinhanh/chiphi/luongnhanvien"/>"><em class="fa fa-credit-card-alt">&nbsp;</em> Lương nhân viên</a></li>
        <li><a href="#" onclick="postLogout()"><em class="fa fa-power-off">&nbsp;</em> Đăng xuất</a></li>
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
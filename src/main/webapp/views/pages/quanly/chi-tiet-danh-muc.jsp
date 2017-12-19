<%@ page pageEncoding="utf-8" contentType="text/html" %>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#">
                <em class="fa fa-home"></em>
            </a></li>
            <li> <a href="danh_sach_danh_muc.html">Danh sách danh mục</a></li>
            <li class="active">Danh mục đồ nướng</li>
        </ol>
    </div><!--/.row-->

    <div class="panel panel-info">
        <div class="panel-heading">
            Danh sách tất cả các món ăn thuộc danh mục đồ nướng
            <a href="them_mon_an_danh_muc.html" class="btn btn-default pull-right fix"><b>+</b> Thêm món ăn vào danh mục</a>
        </div>

        <table class="table table-striped custab">
            <thead>
            <tr>
                <th class="text-center red-text-table">ID</th>
                <th>Tên món ăn</th>
                <th>Đơn vị tính</th>
                <th>Số lượng bán</th>
            </tr>
            </thead>
            <tr>
                <td class="text-center red-text-table">1</td>
                <td>ten san pham</td>
                <td>don vi tinh</td>
                <td>so luong ban</td>
                <td width="5%">
                    <a href="chi_tiet_mon_an.html" class="btn btn-info">Xem</a>
                </td>
                <td width="5%">
                    <a href="chi_tiet_mon_an.html" class="btn btn-danger">Xóa</a>
                </td>
            </tr>
            <tr>
                <td class="text-center red-text-table">2</td>
                <td>ten san pham</td>
                <td>don vi tinh</td>
                <td>so luong ban</td>
                <td width="5%">
                    <a href="chi_tiet_mon_an.html" class="btn btn-info">Xem</a>
                </td>
                <td width="5%">
                    <a href="chi_tiet_mon_an.html" class="btn btn-danger">Xóa</a>
                </td>
            </tr>
            <tr>
                <td class="text-center red-text-table">3</td>
                <td>ten san pham</td>
                <td>don vi tinh</td>
                <td>so luong ban</td>
                <td width="5%">
                    <a href="chi_tiet_mon_an.html" class="btn btn-info">Xem</a>
                </td>
                <td width="5%">
                    <a href="chi_tiet_mon_an.html" class="btn btn-danger">Xóa</a>
                </td>
                <!--      <td class="text-center"><a class='btn btn-info btn-xs' href="#"><span class="glyphicon glyphicon-edit"></span> Edit</a> <a href="#" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> Del</a></td> -->
            </tr>
        </table>
    </div>
</div>
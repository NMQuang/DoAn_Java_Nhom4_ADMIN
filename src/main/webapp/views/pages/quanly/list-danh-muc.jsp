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

    <div class="panel panel-info">
        <div class="panel-heading">
            Danh sách tất cả các danh mục
            <a href="tao_danh_muc_moi.html" class="btn btn-default pull-right fix"><b>+</b> Thêm danh mục mới</a>
        </div>

        <table class="table table-striped custab">
            <thead>
            <tr>
                <th class="text-center red-text-table">ID</th>
                <th>Tên danh mục</th>
                <th>Số lượng món ăn</th>
            </tr>
            </thead>
            <tr>
                <td class="text-center red-text-table">1</td>
                <td><a href="#">Tên danh mục</a></td>
                <td>Số lượng món ăn</td>
                <td width="20%"><a href="chi_tiet_danh_muc.html" class="btn btn-info">Xem danh sách món ăn</a></td>
            </tr>
            <tr>
                <td class="text-center red-text-table">2</td>
                <td><a href="#">Tên danh mục</a></td>
                <td>Số lượng món ăn</td>
                <td width="20%"><a href="chi_tiet_danh_muc.html" class="btn btn-info">Xem danh sách món ăn</a></td>
            </tr>
            <tr>
                <td class="text-center red-text-table">3</td>
                <td><a href="#">Tên danh mục</a></td>
                <td>Số lượng món ăn</td>
                <td width="20%"><a href="chi_tiet_danh_muc.html" class="btn btn-info">Xem danh sách món ăn</a></td>
                <!--      <td class="text-center"><a class='btn btn-info btn-xs' href="#"><span class="glyphicon glyphicon-edit"></span> Edit</a> <a href="#" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> Del</a></td> -->
            </tr>
        </table>
    </div>
</div>
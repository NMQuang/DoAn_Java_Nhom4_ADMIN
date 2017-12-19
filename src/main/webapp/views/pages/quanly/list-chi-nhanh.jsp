<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#">
                <em class="fa fa-home"></em>
            </a></li>
            <li class="active">Danh sách chi nhánh</li>
        </ol>
    </div><!--/.row-->

    <div class="panel panel-info">
        <div class="panel-heading">
            <a href="tao_chi_nhanh_moi.html" class="btn btn-default pull-right fix"><b>+</b> Thêm chi nhánh mới </a>
        </div>

        <table class="table table-striped custab">
            <thead>
            <tr>
                <th width="5%" class="text-center red-text-table">ID</th>
                <th width="20%">Tên chi nhánh</th>
                <th width="35%">Địa chỉ</th>
                <th width="15%">Số điện thoại</th>
                <th width="15%">Tỉnh thành</th>
                <th width="10%"></th>
            </tr>
            </thead>
            <tr>
                <td class="text-center red-text-table">1</td>
                <td><a href="#">Ten chi nhanh</a></td>
                <td>Dia chi</td>
                <td>01666xxxxxx</td>
                <td>Hồ Chí Minh</td>
                <td><a href="chi_tiet_chi_nhanh.html" class="btn btn-info pull-right">Xem thông tin</a></td>
            </tr>
            <tr>
                <td class="text-center red-text-table">2</td>
                <td><a href="#">Ten chi nhanh</a></td>
                <td>Dia chi</td>
                <td>01666xxxxxx</td>
                <td>Hà Nội</td>
                <td><a href="chi_tiet_chi_nhanh.html" class="btn btn-info pull-right">Xem thông tin</a></td>
            </tr>
            <tr>
                <td class="text-center red-text-table">3</td>
                <td><a href="#">Ten chi nhanh</a></td>
                <td>Dia chi</td>
                <td>01666xxxxxx</td>
                <td>Đồng Nai</td>
                <td><a href="chi_tiet_chi_nhanh.html" class="btn btn-info pull-right">Xem thông tin</a></td>
                <!--      <td class="text-center"><a class='btn btn-info btn-xs' href="#"><span class="glyphicon glyphicon-edit"></span> Edit</a> <a href="#" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> Del</a></td> -->
            </tr>
        </table>
    </div>
</div>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#">
                <em class="fa fa-home"></em>
            </a></li>
            <li>
                <a href="danh_sach_chi_nhanh.html"> Danh sách danh mục </a> </li>
            <li>Tạo danh mục mới </li>
        </ol>
    </div><!--/.row-->

    <div class="row">
        <div class="col-lg-12">
            <h2>Tạo danh mục mới</h2>
        </div>
    </div>


    <form role="form" class="form-horizontal">
        <div class="panel panel-default">
            <div class="panel-heading">
                Thông tin danh mục
            </div>
            <div class="panel-body">
                <div class="form-group">
                    <label class="col-sm-2 cn-label label-right">Tên danh mục</label>
                    <div class="col-sm-10">
                        <input class="expanded-input" type="text" placeholder="Tên" required>
                    </div>
                </div>
            </div>
        </div>
        <div class="text-center">
            <button type="submit" class="btn btn-lg btn-primary">Tạo danh mục mới</button>
        </div>
        <br>
    </form>
</div>
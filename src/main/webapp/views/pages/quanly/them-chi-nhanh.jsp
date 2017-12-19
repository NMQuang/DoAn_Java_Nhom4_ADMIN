<%@ page pageEncoding="UTF-8" contentType="text/html" %>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#">
                <em class="fa fa-home"></em>
            </a></li>
            <li>
                <a href="danh_sach_chi_nhanh.html"> Danh sách chi nhánh </a> </li>
            <li>Tạo chi nhánh mới </li>
        </ol>
    </div><!--/.row-->

    <div class="row">
        <div class="col-lg-12">
            <h2>Tạo chi nhánh mới</h2>
        </div>
    </div>


    <form role="form" class="form-horizontal">
        <div class="panel panel-default">
            <div class="panel-heading">
                Thông tin chi nhánh
            </div>
            <div class="panel-body">
                <div class="col-lg-6">
                    <div class="form-group">
                        <label class="col-sm-3 cn-label label-right">Tên</label>
                        <div class="col-sm-9">
                            <input class="expanded-input" type="text" placeholder="Tên" required>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 cn-label label-right">Địa chỉ</label>
                        <div class="col-sm-9">
                            <textarea class="expanded-input" placeholder="Địa chỉ" rows="3" style="resize: none"></textarea>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 cn-label label-right">Điện thoại</label>
                        <div class="col-sm-9">
                            <input class="expanded-input" type="text" placeholder="Điện thoại" required>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 cn-label label-right">Tỉnh thành</label>
                        <div class="col-sm-9">
                            <input class="expanded-input" type="text" placeholder="Tỉnh thành" required>
                        </div>
                    </div>
                </div>

                <div class="col-lg-6">
                    <div class="form-group">
                        <label class="col-sm-4 cn-label label-right">Số lượng bàn</label>
                        <div class="col-sm-8">
                            <input class="expanded-input" type="text" placeholder="Số lượng" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 cn-label label-right">Thông tin bàn</label>
                        <div class="col-sm-8">
                            <textarea class="expanded-input" placeholder="Thông tin" rows="3" style="resize: none"></textarea>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Menu của chi nhánh
                        <a href="tao_menu_chi_nhanh.html" class="btn btn-primary fix">Thêm món ăn vào menu</a>
                    </div>
                    <div class="panel-body">

                    </div>
                </div>
            </div>
        </div>

        <div class="text-center">
            <button type="submit" class="btn btn-lg btn-primary">Tạo chi nhánh mới</button>
        </div>
        <br>
    </form>
</div>
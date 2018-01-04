<%@ page pageEncoding="UTF-8" contentType="text/html" %>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#">
                <em class="fa fa-home"></em>
            </a></li>
            <li>Tạo đơn hàng mang về </li>
        </ol>
    </div><!--/.row-->

    <div class="row">
        <div class="col-md-12">
            <form class="form-horizontal">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Thông tin khách hàng
                    </div>
                    <div class="panel-body">
                        <div class="col-md-6 col-md-offset-6">
                            <label style="margin-left: 45px">
                                <input type="checkbox" id="checkbox-them-nguoi-nhan" name="checkbox">&nbsp;Người nhận khác với người gọi
                            </label>
                        </div>
                        <div class="col-md-12">
                            <div class="form-group" style="margin-top: 12px;">
                                <label class="control-label col-md-3">Số điện thoại người gọi</label>
                                <div class="col-md-3">
                                    <input class="form-control expanded-input">
                                </div>
                                <label class="control-label col-md-3">Số điện thoại người nhận</label>
                                <div class="col-md-3">
                                    <input class="form-control expanded-input input-nguoi-nhan" disabled>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3">Họ và tên người gọi</label>
                                <div class="col-md-3">
                                    <input class="form-control expanded-input">
                                </div>
                                <label class="control-label col-md-3">Họ và tên người nhận</label>
                                <div class="col-md-3">
                                    <input class="form-control expanded-input input-nguoi-nhan" disabled>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-12" style="margin-top: 10px">
                            <div class="form-group">
                                <label class="control-label col-md-3">Địa chỉ nhận</label>
                                <div class="col-md-5">
                                    <textarea class="form-control expanded-input" rows="4"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3">Tỉnh thành</label>
                                <div class="col-md-5">
                                    <input class="form-control expanded-input">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3">Chi nhánh</label>
                                <div class="col-md-5">
                                    <select class="expanded-input">
                                        <option>Chi nhánh 1</option>
                                        <option>Chi nhánh 2</option>
                                        <option>Chi nhánh 3</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3">Hình thức thanh toán</label>
                                <div class="col-md-5">
                                    <select class="expanded-input">
                                        <option>Thanh toán 1</option>
                                        <option>Thanh toán 2</option>
                                        <option>Thanh toán 3</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Danh sách món ăn trong đơn hàng
                        <a class="btn btn-primary fix pull-right" data-toggle="modal" data-target="#modal-them-mon">Thêm món ăn vào đơn hàng</a>
                    </div>
                    <div class="panel-body">
                        <form class="form-horizontal">
                            <table class="table table-striped custab" id="table-don-hang-mang-ve">
                                <thead>
                                <tr>
                                    <th width="5%" class="text-center red-text-table">ID</th>
                                    <th width="20%">Danh mục</th>
                                    <th>Tên món ăn</th>
                                    <th width="10%" class="text-center">Số lượng</th>
                                    <th width="12%" class="text-center">Giá tiền</th>
                                    <th width="5%"></th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td class="text-center red-text-table">1</td>
                                    <td>Đồ rán</td>
                                    <td>Gà rán nguyên con</td>
                                    <td><input class="input-sl-mon-an-dem-ve" value="1" price="80000" type="number" style="width: 90px"></td>
                                    <td><input class="input-gia-mon-an" value="80000" type="text" style="width: 110px" disabled></td>
                                    <td width="5%">
                                        <a class="btn btn-danger btn-remove-mon-an-mang-ve">Xóa</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="text-center red-text-table">1</td>
                                    <td>Đồ rán</td>
                                    <td>Gà rán nguyên con</td>
                                    <td><input class="input-sl-mon-an-dem-ve" value="1" price="90000" type="number" style="width: 90px"></td>
                                    <td><input class="input-gia-mon-an" value="90000" type="text" style="width: 110px" disabled></td>
                                    <td width="5%">
                                        <a class="btn btn-danger btn-remove-mon-an-mang-ve">Xóa</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="text-center red-text-table">1</td>
                                    <td>Đồ rán</td>
                                    <td>Gà rán nguyên con</td>
                                    <td><input class="input-sl-mon-an-dem-ve" value="1" price="180000" type="number" style="width: 90px"></td>
                                    <td><input class="input-gia-mon-an" value="180000" type="text" style="width: 110px" disabled></td>
                                    <td width="5%">
                                        <a class="btn btn-danger btn-remove-mon-an-mang-ve">Xóa</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="text-center red-text-table">1</td>
                                    <td>Đồ rán</td>
                                    <td>Gà rán nguyên con</td>
                                    <td><input class="input-sl-mon-an-dem-ve" value="1" price="150000" type="number" style="width: 90px"></td>
                                    <td><input class="input-gia-mon-an" value="150000" type="text" style="width: 110px" disabled></td>
                                    <td width="5%">
                                        <a class="btn btn-danger btn-remove-mon-an-mang-ve">Xóa</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="text-center red-text-table">1</td>
                                    <td>Đồ rán</td>
                                    <td>Gà rán nguyên con</td>
                                    <td><input class="input-sl-mon-an-dem-ve" value="1" price="120000" type="number" style="width: 90px"></td>
                                    <td><input class="input-gia-mon-an" value="120000" type="text" style="width: 110px" disabled></td>
                                    <td width="5%">
                                        <a class="btn btn-danger btn-remove-mon-an-mang-ve">Xóa</a>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                            <div class="form-group" style="margin-top: 12px">
                                <label class="control-label col-md-2">Tổng tiền</label>
                                <div class="col-md-3">
                                    <input id="tong-tien-don-hang-mang-ve" type="text" class="form-control expanded-input" disabled/>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <button type="submit" class="btn btn-success btn-lg center-block">Tạo đơn hàng</button>
                <hr>
            </form>
        </div>
        <div class="modal fade" id="modal-them-mon" role="dialog">
            <div class="modal-dialog modal-lg">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" style="margin-top: 6px">&times;</button>
                        <div class="modal-title">
                            <div class="input-group col-md-9 col-md-offset-1">
                                <div class="input-group-btn">
                                    <div id="btn-modal-search-food" class="btn btn-default fix" style="margin-top: 5px; border: 1px solid #E5E5E5" >
                                        <i class="fa fa-search" aria-hidden="true"></i>
                                    </div>
                                </div>
                                <input id="input-modal-search-food-menu" type="text" class="form-control" placeholder="Tìm kiếm món ăn" style="margin-top: 5px">
                            </div>

                        </div>
                    </div>
                    <div class="modal-body">
                        <ul class="list-group">
                            <li class="list-group-item">
                                <div class="row toggle" id="dropdown-detail-1" data-toggle="list-mon-an-1">
                                    <div class="col-xs-10">
                                        <strong>Đồ xào</strong>
                                    </div>
                                    <div class="col-xs-2"><i class="fa fa-chevron-down pull-right"></i></div>
                                </div>
                                <div id="list-mon-an-1" class="collapse">
                                    <hr>
                                    <div class="container">
                                        <ul class="list-group ul-search-mon-an">
                                            <li class="list-group-item col-lg-8">Gà xào nguyên con</li>
                                            <li class="list-group-item col-lg-8">Vịt xào nguyên con</li>
                                            <li class="list-group-item col-lg-8">Heo xào nguyên con</li>
                                            <li class="list-group-item col-lg-8">Bò xào nguyên con</li>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                            <li class="list-group-item">
                                <div class="row toggle" id="dropdown-detail-2" data-toggle="list-mon-an-2">
                                    <div class="col-xs-10">
                                        <strong>Đồ chiên</strong>
                                    </div>
                                    <div class="col-xs-2"><i class="fa fa-chevron-down pull-right"></i></div>
                                </div>
                                <div id="list-mon-an-2" class="collapse">
                                    <hr>
                                    <div class="container">
                                        <ul class="list-group ul-search-mon-an">
                                            <li class="list-group-item col-lg-8">Gà chiên nguyên con</li>
                                            <li class="list-group-item col-lg-8">Vịt chiên nguyên con</li>
                                            <li class="list-group-item col-lg-8">Heo chiên nguyên con</li>
                                            <li class="list-group-item col-lg-8">Bò chiên nguyên con</li>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                            <li class="list-group-item">
                                <div class="row toggle" id="dropdown-detail-3" data-toggle="list-mon-an-3">
                                    <div class="col-xs-10">
                                        <strong>Đồ nướng</strong>
                                    </div>
                                    <div class="col-xs-2"><i class="fa fa-chevron-down pull-right"></i></div>
                                </div>
                                <div id="list-mon-an-3" class="collapse">
                                    <hr>
                                    <div class="container">
                                        <ul class="list-group ul-search-mon-an">
                                            <li class="list-group-item col-lg-8">Gà nướng nguyên con</li>
                                            <li class="list-group-item col-lg-8">Vịt nướng nguyên con</li>
                                            <li class="list-group-item col-lg-8">Heo nướng nguyên con</li>
                                            <li class="list-group-item col-lg-8">Bò nướng nguyên con</li>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-success">Thêm món ăn đã chọn</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
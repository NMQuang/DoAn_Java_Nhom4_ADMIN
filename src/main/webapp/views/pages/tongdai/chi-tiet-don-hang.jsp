<%@ page pageEncoding="UTF-8" contentType="text/html" %>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#">
                <em class="fa fa-home"></em>
            </a></li>
            <li><a href="danh-sach-don-hang.html"> Danh sách đơn hàng</a></li>
            <li class="active">Chi tiết đơn hàng </li>
        </ol>
    </div><!--/.row-->

    <div class="row">
        <div class="col-md-12">
            <form class="form-horizontal">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Thông tin đơn hàng
                    </div>
                    <div class="panel-body">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="control-label col-md-5" for="id-hoa-don">ID hóa đơn</label>
                                <div class="col-md-7">
                                    <input class="form-control expanded-input" id="id-hoa-don" name="id-hoa-don" value="#123456" disabled>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-5" for="ten-khach-hang">Chủ hóa đơn</label>
                                <div class="col-md-7">
                                    <input class="form-control expanded-input" id="ten-khach-hang" name="ten-khach-hang" value="Phạm Đức Lộc" disabled>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-5" for="ngay-dat-hang">Ngày tạo</label>
                                <div class="col-md-5">
                                    <input class="form-control expanded-input" id="ngay-dat-hang" name="ngay-dat-hang" value="#123456" disabled>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-5" for="tong-tien">Tổng tiền</label>
                                <div class="col-md-3">
                                    <input class="form-control expanded-input" id="tong-tien" name="tong-tien" value="1000000" disabled>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-5" for="hinh-thuc-mua">Hình thức mua</label>
                                <div class="col-md-7">
                                    <select class="expanded-input" id="hinh-thuc-mua" name="hinh-thuc-mua" disabled>
                                        <option value="1">Đặt món trên web</option>
                                        <option value="2">Đặt món qua điện thoại</option>
                                        <option value="3">Đặt món tại chỗ</option>
                                        <option value="4">Đặt món mang về</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-5" for="hinh-thu-thanh-toan">Hình thức thanh toán</label>
                                <div class="col-md-7">
                                    <select class="expanded-input" id="hinh-thu-thanh-toan" name="hinh-thuc-thanh-toan" disabled>
                                        <option value="1">Không rõ 1</option>
                                        <option value="2">Không rõ 2</option>
                                        <option value="3">Không rõ 3</option>
                                        <option value="4">Không rõ 4</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-5" for="tinh-trang-thanh-toan">Tình trạng thanh toán</label>
                                <div class="col-md-7">
                                    <select class="expanded-input" id="tinh-trang-thanh-toan" name="tinh-trang-thanh-toan" disabled>
                                        <option value="1">Chưa thanh toán</option>
                                        <option value="2">Đã thanh toán</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-5" for="tinh-trang-don-hang">Tình trạng đơn hàng</label>
                                <div class="col-md-7">
                                    <select class="expanded-input" id="tinh-trang-don-hang" name="tinh-trang-don-hang" disabled>
                                        <option>Đang xác thực</option>
                                        <option>Đã xác thực</option>
                                        <option>Đang giao hàng</option>
                                        <option>Đã giao hàng</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="control-label col-md-5" for="so-ban">Số bàn</label>
                                <div class="col-md-7">
                                    <input class="form-control expanded-input" id="so-ban" name="so-ban" value="#123456" disabled>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-5" for="sdt">Số điện thoại người nhận</label>
                                <div class="col-md-4">
                                    <input class="form-control expanded-input" id="sdt" name="sdt" value="#123456" disabled>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-5" for="nguoi-giao-hang">Người giao hàng</label>
                                <div class="col-md-7">
                                    <input class="form-control expanded-input" id="nguoi-giao-hang" name="nguoi-giao-hang" value="#123456" disabled>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-5" for="thoi-gian">Thời gian giao dự kiến</label>
                                <div class="col-md-7">
                                    <input class="form-control expanded-input" id="thoi-gian" name="thoi-gian" value="#123456" disabled>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-5" for="dia-chi">Địa chỉ giao hàng</label>
                                <div class="col-md-7">
                                    <textarea class="form-control expanded-input" id="dia-chi" name="dia-chi" value="#123456" rows="5" disabled></textarea>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Danh sách món ăn trong đơn hàng
                    </div>
                    <div class="panel-body">
                        <table class="table table-striped custab" id="table-don-hang-mang-ve">
                            <thead>
                            <tr>
                                <th width="5%" class="text-center red-text-table">ID</th>
                                <th width="20%">Danh mục</th>
                                <th>Tên món ăn</th>
                                <th width="10%" class="text-center">Số lượng</th>
                                <th width="12%" class="text-center">Giá tiền</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td class="text-center red-text-table">1</td>
                                <td>Đồ rán</td>
                                <td>Gà rán nguyên con</td>
                                <td><input class="input-sl-mon-an-dem-ve" value="1" price="80000" type="number" style="width: 90px" disabled></td>
                                <td><input class="input-gia-mon-an" value="80000" type="text" style="width: 110px" disabled></td>
                            </tr>
                            <tr>
                                <td class="text-center red-text-table">1</td>
                                <td>Đồ rán</td>
                                <td>Gà rán nguyên con</td>
                                <td><input class="input-sl-mon-an-dem-ve" value="1" price="90000" type="number" style="width: 90px" disabled></td>
                                <td><input class="input-gia-mon-an" value="90000" type="text" style="width: 110px" disabled></td>
                            </tr>
                            <tr>
                                <td class="text-center red-text-table">1</td>
                                <td>Đồ rán</td>
                                <td>Gà rán nguyên con</td>
                                <td><input class="input-sl-mon-an-dem-ve" value="1" price="180000" type="number" style="width: 90px" disabled></td>
                                <td><input class="input-gia-mon-an" value="180000" type="text" style="width: 110px" disabled></td>
                            </tr>
                            <tr>
                                <td class="text-center red-text-table">1</td>
                                <td>Đồ rán</td>
                                <td>Gà rán nguyên con</td>
                                <td><input class="input-sl-mon-an-dem-ve" value="1" price="150000" type="number" style="width: 90px" disabled></td>
                                <td><input class="input-gia-mon-an" value="150000" type="text" style="width: 110px" disabled></td>
                            </tr>
                            <tr>
                                <td class="text-center red-text-table">1</td>
                                <td>Đồ rán</td>
                                <td>Gà rán nguyên con</td>
                                <td><input class="input-sl-mon-an-dem-ve" value="1" price="120000" type="number" style="width: 90px" disabled></td>
                                <td><input class="input-gia-mon-an" value="120000" type="text" style="width: 110px" disabled></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </form>
        </div>
    </div>

</div>
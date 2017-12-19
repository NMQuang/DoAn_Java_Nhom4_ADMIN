<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="index.html"><i class="fa fa-home"></i></a></li>
            <li><a href="danh_sach_mon_an.html">Danh sách món ăn</a></li>
            <li class="active">Gà rán</li>
        </ol>
    </div><!--/.row-->

    <div class="panel panel-info">
        <div class="panel-heading">
            Thông tin món <b>gà rán</b>
        </div>
        <div class="panel-body">
            <div class="row">
                <div class="col-lg-4">
                    <img src="images/mon-an/ga-ran.jpg" class="img-mon-an" width="350px" height="220px"/>
                    <div class="text-center">
                        <input type="file"/>
                    </div>
                </div>
                <div class="col-lg-8">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label class="control-label col-lg-3" for="food-name">Tên món ăn:</label>
                            <div class="col-lg-9">
                                <input type="email" class="expanded-input" id="food-name" value="Gà rán nguyên con">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-3" for="description">Mô tả:</label>
                            <div class="col-lg-9">
                                <textarea class="expanded-input" id="description" rows="7">Món gà chiên giòn với phần thịt bên trong chín mềm đậm đà cùng lớp vỏ giòn rụm vàng nâu vừa tới - nếu đó là những gì bạn mong muốn thì hãy đặt hàng ngay nhé!</textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-3" for="description">Chọn danh mục:</label>
                            <div class="col-lg-5">
                                <select id="danhmuc" class="expanded-input">
                                    <option value="1">Đồ ăn rán</option>
                                    <option value="2">Đồ ăn chiên</option>
                                    <option value="3">Đồ ăn xào</option>
                                    <option value="4">Đồ ăn luộc</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-offset-4">
                                <button type="submit" class="btn btn-info btn-lg">Thay đổi</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="row col-lg-12">
                <table class="table table-food">
                    <thead>
                    <tr>
                        <td colspan="2">
                            <b> Danh sách chi nhánh có món ăn này </b>
                        </td>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td width="60%">
                            <h5>Chi nhánh 1</h5>
                            <p> <i class="fa fa-map-marker"></i> &nbsp Địa chỉ:</p>
                        </td>
                        <td>
                            <i class="fa fa-tag"></i> Giá 100.000 VND
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h5>Chi nhánh 2</h5>
                            <p> <i class="fa fa-map-marker"></i> &nbsp Địa chỉ:</p>
                        </td>
                        <td>
                            <i class="fa fa-tag" ></i> Giá 150.000 VND
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h5>Chi nhánh 3</h5>
                            <p> <i class="fa fa-map-marker"></i> &nbsp Địa chỉ:</p>
                        </td>
                        <td>
                            <i class="fa fa-tag"></i> Giá 200.000 VND
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>

    </div>
</div>
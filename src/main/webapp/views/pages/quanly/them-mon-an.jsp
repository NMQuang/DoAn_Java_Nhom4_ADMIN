<%@page pageEncoding="UTF-8" contentType="text/html" %>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="index.html"><i class="fa fa-home"></i></a></li>
            <li><a href="danh_sach_mon_an.html" style="text-decoration: none;">Danh sách món ăn</a></li>
            <li class="active">Tạo món ăn mới</li>
        </ol>
    </div><!--/.row-->

    <div class="panel panel-info">
        <div class="panel-heading">
            Tạo món ăn mới
        </div>
        <div class="panel-body">
            <div class="row">
                <form>
                    <div class="col-lg-4">
                        <img src="http://via.placeholder.com/350x220" class="img-mon-an" width="350px" height="220px"/>
                        <div class="text-center">
                            <input type="file"/>
                        </div>
                    </div>
                    <div class="col-lg-8">
                        <div class="form-horizontal">
                            <div class="form-group">
                                <label class="control-label col-lg-3" for="food-name">Tên món ăn:</label>
                                <div class="col-lg-9">
                                    <input type="email" class="expanded-input" id="food-name">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-3" for="description">Mô tả:</label>
                                <div class="col-lg-9">
                                    <textarea class="expanded-input" id="description" rows="7"></textarea>
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
                                    <button type="submit" class="btn btn-info btn-lg">Tạo món ăn</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>

    </div>
</div>
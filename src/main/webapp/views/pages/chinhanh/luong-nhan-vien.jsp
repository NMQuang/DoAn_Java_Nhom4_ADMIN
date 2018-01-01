<%@ page pageEncoding="UTF-8" contentType="text/html" %>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#">
                <em class="fa fa-home"></em>
            </a></li>
            <li>Xem thông tin nhập lương nhân viên</li>
        </ol>
    </div><!--/.row-->

    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Danh sách nhập lương nhân viên
                    <button type="button" class="btn btn-primary fix pull-right" data-toggle="modal" data-target="#modal-them-luong-nhan-vien">Nhập lương nhân viên</button>
                </div>
                <div class="modal fade" id="modal-them-luong-nhan-vien">
                    <div class="modal-dialog modal-xl">
                        <div class="modal-content">
                            <div class="modal-header">
                                <b>Nhập lương nhân viên</b>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>
                            <form class="form-horizontal">
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label class="control-label col-md-2" for="ten-chi-phi">Tên chi phí</label>
                                        <div class="col-md-3">
                                            <input class="form-control expanded-input" id="ten-chi-phi" name="ten-chi-phi">
                                        </div>
                                        <label class="control-label col-md-2" for="thang">Tháng</label>
                                        <div class="col-md-1">
                                            <input class="form-control expanded-input" id="thang" name="thang">
                                        </div>
                                        <label class="control-label col-md-2" for="nam">Năm</label>
                                        <div class="col-md-1">
                                            <input class="form-control expanded-input" id="nam" name="nam">
                                        </div>
                                    </div>
                                    <table class="table table-striped custab table-don-hang">
                                        <thead>
                                        <tr>
                                            <th width="10%" class="text-center red-text-table">ID nhân viên</th>
                                            <th>Tên nhân viên</th>
                                            <th width="20%" class="text-center">Lương tháng</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td class="text-center red-text-table">1</td>
                                            <td>Nhân viên 1</td>
                                            <td class="text-center"><input class="expanded-input" style="text-align: right"></td>
                                        </tr>
                                        <tr>
                                            <td class="text-center red-text-table">1</td>
                                            <td>Nhân viên 2</td>
                                            <td class="text-center"><input class="expanded-input" style="text-align: right"></td>
                                        </tr>
                                        <tr>
                                            <td class="text-center red-text-table">1</td>
                                            <td>Nhân viên 3</td>
                                            <td class="text-center"><input class="expanded-input" style="text-align: right"></td>
                                        </tr>
                                        <tr>
                                            <td class="text-center red-text-table">1</td>
                                            <td>Nhân viên 4</td>
                                            <td class="text-center"><input class="expanded-input" style="text-align: right"></td>
                                        </tr>
                                        <tr>
                                            <td class="text-center red-text-table">1</td>
                                            <td>Nhân viên 5</td>
                                            <td class="text-center"><input class="expanded-input" style="text-align: right"></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default pull-right" style="margin-left: 16px" data-dismiss="modal">Đóng</button>
                                    <button type="submit" class="btn btn-success pull-right">Xác nhận</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="panel-body">
                    <table class="table table-striped custab table-don-hang">
                        <thead>
                        <tr>
                            <th width="10%" class="text-center red-text-table">ID</th>
                            <th>Tên chi phí</th>
                            <th width="5%" class="text-center">Tháng</th>
                            <th width="5%" class="text-center">Năm</th>
                            <th width="15%" class="text-center">Ngày chi</th>
                            <th width="5%"></th>
                            <th width="5%"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td class="text-center red-text-table">1</td>
                            <td>Tiền lương nhân viên tháng 1</td>
                            <td class="text-center">1</td>
                            <td class="text-center">2017</td>
                            <td class="text-center"> 27/01/2017 </td>
                            <td>
                                <a class="btn btn-warning" data-toggle="modal" data-target="#modal-sua-luong-nhan-vien">Sửa</a>
                            </td>
                            <td>
                                <a class="btn btn-danger">Xóa</a>
                            </td>
                        </tr>
                        <tr>
                            <td class="text-center red-text-table">1</td>
                            <td>Tiền lương nhân viên tháng 2</td>
                            <td class="text-center">2</td>
                            <td class="text-center">2017</td>
                            <td class="text-center"> 27/02/2017 </td>
                            <td>
                                <a class="btn btn-warning" data-toggle="modal" data-target="#modal-sua-luong-nhan-vien">Sửa</a>
                            </td>
                            <td>
                                <a class="btn btn-danger">Xóa</a>
                            </td>
                        </tr>
                        <tr>
                            <td class="text-center red-text-table">1</td>
                            <td>Tiền lương nhân viên tháng 3</td>
                            <td class="text-center">3</td>
                            <td class="text-center">2017</td>
                            <td class="text-center"> 27/03/2017 </td>
                            <td>
                                <a class="btn btn-warning" data-toggle="modal" data-target="#modal-sua-luong-nhan-vien">Sửa</a>
                            </td>
                            <td>
                                <a class="btn btn-danger">Xóa</a>
                            </td>
                        </tr>
                        <tr>
                            <td class="text-center red-text-table">1</td>
                            <td>Tiền lương nhân viên tháng 4</td>
                            <td class="text-center">4</td>
                            <td class="text-center">2017</td>
                            <td class="text-center"> 27/04/2017 </td>
                            <td>
                                <a class="btn btn-warning" data-toggle="modal" data-target="#modal-sua-luong-nhan-vien">Sửa</a>
                            </td>
                            <td>
                                <a class="btn btn-danger">Xóa</a>
                            </td>
                        </tr>
                        <tr>
                            <td class="text-center red-text-table">1</td>
                            <td>Tiền lương nhân viên tháng 5</td>
                            <td class="text-center">5</td>
                            <td class="text-center">2017</td>
                            <td class="text-center"> 27/05/2017 </td>
                            <td>
                                <a class="btn btn-warning" data-toggle="modal" data-target="#modal-sua-luong-nhan-vien">Sửa</a>
                            </td>
                            <td>
                                <a class="btn btn-danger">Xóa</a>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="modal fade" id="modal-sua-luong-nhan-vien">
                    <div class="modal-dialog modal-xl">
                        <div class="modal-content">
                            <div class="modal-header">
                                <b>Nhập lương nhân viên</b>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>
                            <form class="form-horizontal">
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label class="control-label col-md-2" for="ten-chi-phi">Tên chi phí</label>
                                        <div class="col-md-3">
                                            <input class="form-control expanded-input" id="" name="">
                                        </div>
                                        <label class="control-label col-md-2" for="thang">Tháng</label>
                                        <div class="col-md-1">
                                            <input class="form-control expanded-input" id="" name="">
                                        </div>
                                        <label class="control-label col-md-2" for="nam">Năm</label>
                                        <div class="col-md-1">
                                            <input class="form-control expanded-input" id="" name="">
                                        </div>
                                    </div>
                                    <table class="table table-striped custab table-don-hang">
                                        <thead>
                                        <tr>
                                            <th width="10%" class="text-center red-text-table">ID nhân viên</th>
                                            <th>Tên nhân viên</th>
                                            <th width="20%" class="text-center">Lương tháng</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td class="text-center red-text-table">1</td>
                                            <td>Nhân viên 1</td>
                                            <td class="text-center"><input class="expanded-input" style="text-align: right"></td>
                                        </tr>
                                        <tr>
                                            <td class="text-center red-text-table">1</td>
                                            <td>Nhân viên 2</td>
                                            <td class="text-center"><input class="expanded-input" style="text-align: right"></td>
                                        </tr>
                                        <tr>
                                            <td class="text-center red-text-table">1</td>
                                            <td>Nhân viên 3</td>
                                            <td class="text-center"><input class="expanded-input" style="text-align: right"></td>
                                        </tr>
                                        <tr>
                                            <td class="text-center red-text-table">1</td>
                                            <td>Nhân viên 4</td>
                                            <td class="text-center"><input class="expanded-input" style="text-align: right"></td>
                                        </tr>
                                        <tr>
                                            <td class="text-center red-text-table">1</td>
                                            <td>Nhân viên 5</td>
                                            <td class="text-center"><input class="expanded-input" style="text-align: right"></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default pull-right" style="margin-left: 16px" data-dismiss="modal">Đóng</button>
                                    <button type="submit" class="btn btn-success pull-right">Xác nhận</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
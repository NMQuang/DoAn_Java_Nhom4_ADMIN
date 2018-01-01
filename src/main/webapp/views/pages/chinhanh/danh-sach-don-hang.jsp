<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#">
                <em class="fa fa-home"></em>
            </a></li>
            <li>Xem danh sách đơn hàng </li>
        </ol>
    </div><!--/.row-->

    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="col-md-6">
                        Danh sách
                        <select id="select-danh-sach-don-hang">
                            <option value="option-don-hang-online">đơn hàng từ tổng đài và đặt online</option>
                            <option value="option-don-hang-tai-quan">đơn hàng tại quán</option>
                            <option value="option-don-hang-mang-ve">đơn hàng mang về</option>
                        </select>
                    </div>
                    <div class="input-group col-md-4 pull-right">
                        <input id="input-tim-kiem-don-hang" type="text" class="form-control input-search-header-bar"
                               placeholder="Tên món ăn">
                        <div class="input-group-btn">
                            <button id="btn-search-food-header-bar" class="btn btn-default" type="button">
                                <i class="fa fa-search" aria-hidden="true"></i>
                            </button>
                        </div>
                    </div>
                </div>
                <div class="panel-body">
                    <div class="select-danh-sach-don-hang" id="option-don-hang-online">
                        <table class="table table-striped custab table-don-hang">
                            <thead>
                            <tr>
                                <th width="5%" class="text-center red-text-table">ID</th>
                                <th width="15%" class="text-center">ID khách hàng</th>
                                <th>Tên khách hàng</th>
                                <th width="10%" class="text-center">Tổng tiền</th>
                                <th width="15%" class="text-center">Tình trạng</th>
                                <th width="5%"></th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td class="text-center red-text-table">1</td>
                                <td class="text-center">Đồ rán</td>
                                <td>Gà rán nguyên con</td>
                                <td><input class="expanded-input"></td>
                                <td></td>
                                <td width="5%">
                                    <a href="chi-tiet-don-hang.html" class="btn btn-info">Xem</a>
                                </td>
                            </tr>
                            <tr>
                                <td class="text-center red-text-table">2</td>
                                <td class="text-center">Đồ chiên</td>
                                <td>Vịt chiên nguyên con</td>
                                <td><input class="expanded-input"></td>
                                <td></td>
                                <td width="5%">
                                    <a href="chi-tiet-don-hang.html" class="btn btn-info">Xem</a>
                                </td>
                            </tr>
                            <tr>
                                <td class="text-center red-text-table">1</td>
                                <td class="text-center">Đồ rán</td>
                                <td>Gà rán nguyên con</td>
                                <td><input class="expanded-input"></td>
                                <td></td>
                                <td width="5%">
                                    <a href="chi-tiet-don-hang.html" class="btn btn-info">Xem</a>
                                </td>
                            </tr>
                            <tr>
                                <td class="text-center red-text-table">3</td>
                                <td class="text-center">Đồ nướng</td>
                                <td>Heo nướng nguyên con</td>
                                <td><input class="expanded-input"></td>
                                <td></td>
                                <td width="5%">
                                    <a href="chi-tiet-don-hang.html" class="btn btn-info">Xem</a>
                                </td>
                            </tr>
                            <tr>
                                <td class="text-center red-text-table">1</td>
                                <td class="text-center">Đồ rán</td>
                                <td>Gà rán nguyên con</td>
                                <td><input class="expanded-input"></td>
                                <td></td>
                                <td width="5%">
                                    <a href="chi-tiet-don-hang.html" class="btn btn-info">Xem</a>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="select-danh-sach-don-hang" id="option-don-hang-tai-quan">
                        <table class="table table-striped custab table-don-hang">
                            <thead>
                            <tr>
                                <th width="5%" class="text-center red-text-table">ID</th>
                                <th width="15%" class="text-center">ID khách hàng</th>
                                <th>Tên khách hàng</th>
                                <th width="10%" class="text-center">Tổng tiền</th>
                                <th width="15%" class="text-center">Tình trạng</th>
                                <th width="5%"></th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td class="text-center red-text-table">1</td>
                                <td class="text-center">Đồ rán</td>
                                <td>Gà rán nguyên con</td>
                                <td><input class="expanded-input"></td>
                                <td></td>
                                <td width="5%">
                                    <a href="chi-tiet-don-hang.html" class="btn btn-info">Xem</a>
                                </td>
                            </tr>
                            <tr>
                                <td class="text-center red-text-table">2</td>
                                <td class="text-center">Đồ chiên</td>
                                <td>Vịt chiên nguyên con</td>
                                <td><input class="expanded-input"></td>
                                <td></td>
                                <td width="5%">
                                    <a href="chi-tiet-don-hang.html" class="btn btn-info">Xem</a>
                                </td>
                            </tr>
                            <tr>
                                <td class="text-center red-text-table">1</td>
                                <td class="text-center">Đồ rán</td>
                                <td>Gà rán nguyên con</td>
                                <td><input class="expanded-input"></td>
                                <td></td>
                                <td width="5%">
                                    <a href="chi-tiet-don-hang.html" class="btn btn-info">Xem</a>
                                </td>
                            </tr>
                            <tr>
                                <td class="text-center red-text-table">3</td>
                                <td class="text-center">Đồ nướng</td>
                                <td>Heo nướng nguyên con</td>
                                <td><input class="expanded-input"></td>
                                <td></td>
                                <td width="5%">
                                    <a href="chi-tiet-don-hang.html" class="btn btn-info">Xem</a>
                                </td>
                            </tr>
                            <tr>
                                <td class="text-center red-text-table">1</td>
                                <td class="text-center">Đồ rán</td>
                                <td>Gà rán nguyên con</td>
                                <td><input class="expanded-input"></td>
                                <td></td>
                                <td width="5%">
                                    <a href="chi-tiet-don-hang.html" class="btn btn-info">Xem</a>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="select-danh-sach-don-hang" id="option-don-hang-mang-ve">
                        <table class="table table-striped custab table-don-hang">
                            <thead>
                            <tr>
                                <th width="5%" class="text-center red-text-table">ID</th>
                                <th width="15%" class="text-center">ID khách hàng</th>
                                <th>Tên khách hàng</th>
                                <th width="10%" class="text-center">Tổng tiền</th>
                                <th width="15%" class="text-center">Tình trạng</th>
                                <th width="5%"></th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td class="text-center red-text-table">1</td>
                                <td class="text-center">Đồ rán</td>
                                <td>Gà rán nguyên con</td>
                                <td><input class="expanded-input"></td>
                                <td></td>
                                <td width="5%">
                                    <a href="chi-tiet-don-hang.html" class="btn btn-info">Xem</a>
                                </td>
                            </tr>
                            <tr>
                                <td class="text-center red-text-table">2</td>
                                <td class="text-center">Đồ chiên</td>
                                <td>Vịt chiên nguyên con</td>
                                <td><input class="expanded-input"></td>
                                <td></td>
                                <td width="5%">
                                    <a href="chi-tiet-don-hang.html" class="btn btn-info">Xem</a>
                                </td>
                            </tr>
                            <tr>
                                <td class="text-center red-text-table">1</td>
                                <td class="text-center">Đồ rán</td>
                                <td>Gà rán nguyên con</td>
                                <td><input class="expanded-input"></td>
                                <td></td>
                                <td width="5%">
                                    <a href="chi-tiet-don-hang.html" class="btn btn-info">Xem</a>
                                </td>
                            </tr>
                            <tr>
                                <td class="text-center red-text-table">3</td>
                                <td class="text-center">Đồ nướng</td>
                                <td>Heo nướng nguyên con</td>
                                <td><input class="expanded-input"></td>
                                <td></td>
                                <td width="5%">
                                    <a href="chi-tiet-don-hang.html" class="btn btn-info">Xem</a>
                                </td>
                            </tr>
                            <tr>
                                <td class="text-center red-text-table">1</td>
                                <td class="text-center">Đồ rán</td>
                                <td>Gà rán nguyên con</td>
                                <td><input class="expanded-input"></td>
                                <td></td>
                                <td width="5%">
                                    <a href="chi-tiet-don-hang.html" class="btn btn-info">Xem</a>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
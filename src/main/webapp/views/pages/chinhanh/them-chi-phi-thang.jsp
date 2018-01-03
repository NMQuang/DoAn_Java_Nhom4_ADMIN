<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#">
                <em class="fa fa-home"></em>
            </a></li>
            <li><a href="chi-phi-theo-thang.html">Chi phí theo tháng</a></li>
            <li>Tạo chi phí theo tháng</li>
        </ol>
    </div><!--/.row-->

    <div class="row">
        <div class="col-md-12">
            <form class="form-horizontal">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Tạo chi phí theo tháng
                    </div>
                    <div class="panel-body">
                        <div class="form-group">
                            <label class="control-label col-md-3" for="thang">Tháng</label>
                            <div class="col-md-2">
                                <input class="form-control expanded-input" id="thang" name="thang">
                            </div>
                            <label class="control-label col-md-3" for="nam">Năm</label>
                            <div class="col-md-2">
                                <input class="form-control expanded-input" id="nam" name="nam">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3" for="ten-chi-phi">Tên chi phí</label>
                            <div class="col-md-7">
                                <input class="form-control expanded-input" id="ten-chi-phi" name="ten-chi-phi">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3" for="mo-ta">Mô tả</label>
                            <div class="col-md-7">
                                <textarea class="form-control expanded-input" id="mo-ta" name="mo-ta" rows="8"></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3" for="tieu-hao">Tiêu hao</label>
                            <div class="col-md-4">
                                <input class="form-control expanded-input" id="tieu-hao" name="tieu-hao">
                            </div>
                        </div>
                    </div>
                </div>
                <button class="btn btn-success btn-lg center-block" type="submit">Tạo chi phí mới</button>
                <hr>
            </form>

        </div>
    </div>
</div>
$('#calendar').datepicker({
		});

!function ($) {
    $(document).on("click","ul.nav li.parent > a ", function(){          
        $(this).find('em').toggleClass("fa-minus");      
    }); 
    $(".sidebar span.icon").find('em:first').addClass("fa-plus");
}

(window.jQuery);
	$(window).on('resize', function () {
  if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
})
$(window).on('resize', function () {
  if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
})

$(document).on('click', '.panel-heading span.clickable', function(e){
    var $this = $(this);
	if(!$this.hasClass('panel-collapsed')) {
		$this.parents('.panel').find('.panel-body').slideUp();
		$this.addClass('panel-collapsed');
		$this.find('em').removeClass('fa-toggle-up').addClass('fa-toggle-down');
	} else {
		$this.parents('.panel').find('.panel-body').slideDown();
		$this.removeClass('panel-collapsed');
		$this.find('em').removeClass('fa-toggle-down').addClass('fa-toggle-up');
	}
})

$('#modal-sua-danh-muc').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget);
    var data = button.data('tendanhmuc');
    $(this).find('#ten-danh-muc-1').val(data);
});

$('#modal-sua-ban').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget);
    var data = button.data('info');
    $(this).find('#table-change-info').val(data);
});

$('#input-search-food-header-bar').keyup(function() {
    var $rows = $('#food-search-header-bar tbody tr');
    var val = $.trim($(this).val()).replace(/ +/g, ' ').toLowerCase();

    $rows.show().filter(function() {
        var text = $(this).text().replace(/\s+/g, ' ').toLowerCase();
        return !~text.indexOf(val);
    }).hide();
});

$('#input-search-table-header-bar').keyup(function() {
    var $rows = $('#table-search-header-bar tbody tr');
    var val = $.trim($(this).val()).replace(/ +/g, ' ').toLowerCase();

    $rows.show().filter(function() {
        var text = $(this).text().replace(/\s+/g, ' ').toLowerCase();
        return !~text.indexOf(val);
    }).hide();
});

$(document).ready(function() {
    $('[id^=detail-]').hide();
    $('.toggle').click(function() {
        $input = $( this );
        $target = $('#'+$input.attr('data-toggle'));
        $target.slideToggle();
    });
});

$(function () {
    $("div[id*='list-mon-an-']").on('click', '.list-group .list-group-item', function () {
        $(this).toggleClass('active');
    });
});


$("#input-modal-search-food-menu").keyup(function(){
    var searchText = $.trim($(this).val()).replace(/ +/g, ' ').toLowerCase();
    $('ul.ul-search-mon-an > li').each(function(){
        var currentLiText = $(this).text().replace(/\s+/g, ' ').toLowerCase();
            showCurrentLi = currentLiText.indexOf(searchText) !== -1;
        $(this).toggle(showCurrentLi);
    });
});

//  Change option báo cáo thống kê
$(document).ready(function () {
    $('.option-thong-ke').hide();
    $('#option-ngay').show();
    $('#option-thong-ke').change(function () {
        $('.option-thong-ke').hide();
        $('#'+$(this).val()).show();
    })
});

$('[data-provide="datepicker"]').datepicker({
    format: 'dd-mm-yyyy',
    endDate: new Date(),
    "autoclose": true
});

$('[data-provide="datepicker-month"]').datepicker({
    format: 'mm-yyyy',
    minViewMode: 1,
    endDate: new Date(),
    "autoclose": true
});

$('[data-provide="datepicker-year"]').datepicker({
    format: 'yyyy',
    minViewMode: 2,
    endDate: new Date(),
    "autoclose": true
});

//  thay đổi lựa chọn danh mục của tạo đơn hàng tại quá
$(document).ready(function () {
    $('.select-danh-muc').hide();
    $('#option-mon-an-nuong').show();
    $('#select-danh-muc').change(function () {
        $('.select-danh-muc').hide();
        $('#'+$(this).val()).show();
    })
});

/////////// ĐƠN HÀNG TẠI QUÁN /////////////
//  Thêm món ăn vào danh sách món ăn được chọn bên phải
$(document).ready(function() {

    $('.btn-them-mon-an').click(function () {

        var text = $(this).attr('name');
        var id = $(this).attr('id-sp');
        var price = $(this).attr('price');
        var found = false;

        if ($('li.ds-mon-an-da-chon').length !== 0) {

            $('li.ds-mon-an-da-chon').each(function (i) {

                if ($(this).attr('id-chon-mon') === id) {
                    found = true;
                    return;
                }
            })
        }

        if (text.length && found===false) {

            var labelTenMonAn = $('<p class="li-p-ten-mon-an"></p>');
            labelTenMonAn.append(text);
            var divTenMonAn = $('<div class="col-md-6"></div>');
            divTenMonAn.append(labelTenMonAn);

            var inputSoluong = $('<input type="number" class="input-sl-mon-an" value="1" price/>');
            inputSoluong.attr({id: id, price: price});

            var inputTongTien = $('<input class="input-gia-mon-an" type="text" price>');
            inputTongTien.attr({value: price, price: price});

            var btnXoa = $('<a href="#" class="btn-remove"><i class="fa fa-times" aria-hidden="true"></i></a>');

            var divFormInline = $('<div class="form-inline"></div>');
            divFormInline.append('<p class="li-p-ds-mon-an">Số lượng: </p>');
            divFormInline.append(inputSoluong);
            divFormInline.append('<p class="li-p-ds-mon-an t">Tổng tiền: </p>');
            divFormInline.append(inputTongTien);
            divFormInline.append(btnXoa);

            var myLi = $('<li id-chon-mon class="ds-mon-an-da-chon"/>');
            myLi.attr({'id-chon-mon': id});
            myLi.append(divTenMonAn);
            myLi.append(divFormInline);

            $('ul#danh-sach-mon-an-da-chon').append(myLi);
        }
    });
});

//  Nút xóa món ăn khỏi danh sách món ăn được chọn bên phải
$(document).on('click', 'a.btn-remove', function () {
    $(this).closest('li').remove();
});

//  Giới hạn số lượng món ăn được chọn bên phải, tính tiền và hiển thị lên tổng tiền
$(document).on('change', '.input-sl-mon-an', function () {
    var value = $(this).val();
    var price = $(this).attr('price');
    var myLi = $(this).closest('li');
    console.log(myLi);
    if ((value !== '') && (value.indexOf('.') === -1)) {
        if (value < 1 || value > 50) {
            $(this).val(Math.max(Math.min(value, 50), 1));
        }   else {
            var totalPrice = value * price;
            console.log(totalPrice);
            $(myLi).find('.input-gia-mon-an').attr({value: totalPrice});
        }
    }
});
/////////// END ĐƠN HÀNG TẠI QUÁN /////////////

/////////// ĐƠN HÀNG MANG VỀ /////////////
$(document).on('change', '.input-sl-mon-an-dem-ve', function () {

    var value = $(this).val();

    if ((value !== '') && (value.indexOf('.') === -1)) {

        if (value < 1 || value > 50) {

            $(this).val(Math.max(Math.min(value, 50), 1));
        }   else {

            var price = $(this).attr('price');
            var parent = $(this).closest('tr');
            var totalPrice = value * price;
            $(parent).find('.input-gia-mon-an').attr({value: totalPrice});

            var TongTien = 0;
            $('.input-gia-mon-an').each(function (i) {

                TongTien += parseInt($(this).val());
            })

            $('#tong-tien-don-hang-mang-ve').attr({value: TongTien});
        }
    }
});

$('.btn-remove-mon-an-mang-ve').click(function () {
    $(this).closest('tr').remove();
});
/////////// END ĐƠN HÀNG MANG VỀ /////////////

/////////// DANH SÁCH ĐƠN HÀNG /////////////
//// change select trang danh sách đơn hàng
$(document).ready(function () {
    $('.select-danh-sach-don-hang').hide();
    $('#option-don-hang-online').show();
    $('#select-danh-sach-don-hang').change(function () {
        $('.select-danh-sach-don-hang').hide();
        $('#'+$(this).val()).show();
    });
});
////

//// tìm kiếm đơn hàng
$('#input-tim-kiem-don-hang').keyup(function() {
    var $rows = $('.table-don-hang tbody tr');
    var val = $.trim($(this).val()).replace(/ +/g, ' ').toLowerCase();

    $rows.show().filter(function() {
        var text = $(this).text().replace(/\s+/g, ' ').toLowerCase();
        return !~text.indexOf(val);
    }).hide();
});
/////////// END DANH SÁCH ĐƠN HÀNG /////////////

/////////// TẠO ĐƠN HÀNG TRÊN TỔNG ĐÀI /////////////
//// disable input khi không chọn checkbox với người nhận khác người gọi điện
$('#checkbox-them-nguoi-nhan').click(function () {
    var check = $(this).prop('checked');
    console.log(check);
    if (check) {
        $('.input-nguoi-nhan').prop('disabled', false);
    } else {
        $('.input-nguoi-nhan').prop('disabled', true);
    }
});

/////////// END TẠO ĐƠN HÀNG TRÊN TỔNG ĐÀI  /////////////

/////////// DANH SÁCH ĐƠN HÀNG TRÊN TỔNG ĐÀI /////////////
//// change select danh sách đơn hàng trên tổng đài
$(document).ready(function () {
    $('.select-danh-sach-don-hang-tong-dai').hide();
    $('#option-don-hang-qua-dt-tong-dai').show();
    $('#select-danh-sach-don-hang-tong-dai').change(function () {
        $('.select-danh-sach-don-hang-tong-dai').hide();
        $('#'+$(this).val()).show();
    });
});
////

//// tìm kiếm đơn hàng
$('#input-tim-kiem-don-hang').keyup(function() {
    var $rows = $('.table-don-hang tbody tr');
    var val = $.trim($(this).val()).replace(/ +/g, ' ').toLowerCase();

    $rows.show().filter(function() {
        var text = $(this).text().replace(/\s+/g, ' ').toLowerCase();
        return !~text.indexOf(val);
    }).hide();
});

/////////// END DANH SÁCH ĐƠN HÀNG TRÊN TỔNG ĐÀI  /////////////
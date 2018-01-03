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
//////////////////////////////////////////////////
//upload file
function readURL(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();

		reader.onload = function(e) {
			$('#img-upload').attr('src', e.target.result);

		}

		reader.readAsDataURL(input.files[0]);
	}
}

$("#upload").change(function() {
	readURL(this);
	
});
////////////////////////////////////
//Khi thay đổi giá trị thì các error biến mất
$('input, textarea, select').on('change keyup paste',function(){
	$(this).siblings('.my_error').hide();
})
////////////////////////////////////
//Active menu màu xanh
$(function(){
	var pathname = window.location.pathname;
	$('.nav li').removeClass('active')
	$('.nav li').each(function(index, value){
		if(pathname.indexOf( $(value).find('a').attr('href')) >= 0){
			$(value).addClass('active')
		}
			
	})
})
/////////////////////////////////////
//Hiển thị giá theo format
$(function(){
	$('._single_price').each(function(index, element){
		var price = $(element).attr('price');
		price = Number(parseFloat(price)).toLocaleString();
		$(element).text(price)
	})
})
/////////////////////////////////////
//Phân trang
$(function(){
	$('#pagination-demo').twbsPagination({
        totalPages: $('#pagination-demo').attr('data-pages'),
        visiblePages: 7,
        startPage: parseInt($('#pagination-demo').attr('data-index')),
        initiateStartPageClick: false,
        onPageClick: function (event, page) {
        	var path = window.location.pathname; 
        	var url = path + "?index=" + page + "&type=" + $('#type_mon').find('option:selected').val();
        	window.location.href= url
        }
	})
})
////////////////////////////////////
//Thay doi khi nguoi dung muon xem giua active va chua active
$(function(){
	$('#type_mon').on('change', function(){
		var path = window.location.pathname; 
    	var url = path + "?index=" + 1 + "&type=" + $('#type_mon').find('option:selected').val();
    	window.location.href= url
	})
})

$(function () {
	if($('#modal-tao-danh-muc').attr('data-autoshow')) {
        $(window).on('load',function(){
            $('#modal-tao-danh-muc').modal('show');
        });
	}
})
/////////////////////////////////////
//  Change option
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

//  thay đổi lựa chọn danh mục của tạo đơn hàng tại quán
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


$(document).ready(function () {
	$('#menu-ben-phai').attr("hidden", "true");
	
	$(".btn-dat-ban").on("click", function(){
		$('#menu-ben-phai').removeAttr("hidden");
		$.ajax({
			url: ""
		}).done(function(data){
			console.log(data);
		}).fail(function(jqXHR, textStatus, error){
			console.log(textStatus);
			console.log(error);
			console.log(jqXHR);
		})
	})
});
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

$(function () {
    if($('#modal-sua-danh-muc').attr('data-autoshow')) {
        $(window).on('load',function(){
            $('#modal-sua-danh-muc').modal('show');
        });
    }
})


$('#modal-sua-danh-muc').on('show.bs.modal', function (event) {
	if(!($('#has-error-update').data('value'))) {
        var button = $(event.relatedTarget);
        var data = button.data('ten-danh-muc-sua');
        var id = button.data('id-danh-muc-sua');
        var active = button.data('active-danh-muc-sua');

        $(this).find('#ten-danh-muc-sua').val(data);
        $(this).find('#id-danh-muc-sua').val(id);
        $(this).find('#active-danh-muc-sua').val(active);
    }
});

//////////////////////////////////
// CHON NGAY TINH CHI PHI NGAY ////////
$(function () {
    $('#chon-ngay-cp-ngay').datepicker({
        format: 'dd-mm-yyyy',
        endDate: new Date(),
        "autoclose": true
    });

    $('#chon-ngay-cp-ngay').datepicker().on('changeDate', function(ev){
        var newUrl = '/chinhanh/chiphi/ngay?date='+ev.format();
        console.log(newUrl);
        window.location.replace(newUrl);
    });

    function dateToString(date) {
        var dd = date.getDate();
        var mm = date.getMonth()+1; //January is 0!

        var yyyy = date.getFullYear();

        return joinDate(dd, mm, yyyy);
    }

    function joinDate(dd, mm, yyyy) {
        if(dd<10){
            dd='0'+dd;
        }
        if(mm<10){
            mm='0'+mm;
        }
        return dd+'-'+mm+'-'+yyyy;
    }

    function stringToDate(strDate) {
        var strDateParts = strDate.split('-');
        return new Date(strDateParts[1]+'-'+strDateParts[0]+'-'+strDateParts[2]);
    }

    var dateUse;
    if($('#dateFindCpNgay').val() != "") {
        dateUse = new Date(stringToDate($('#dateFindCpNgay').val()));
    } else {
        // Chỗ này vầy mới chạy đúng
        dateUse = stringToDate(dateToString(new Date()));
    }

    $('#chon-ngay-cp-ngay').datepicker('update', dateUse);
});

// XOA CHI PHI NGAY
$(document).ready(function () {
    $('.xoa-chi-phi-ngay').click(function (e) {
        if(confirm("Bạn có chắc muốn xóa ?")) {
            const idDelete = $(this).data('id');

            var form = $('<form method="post" action="/chinhanh/chiphi/ngay/delete"></form>');
            var input = $('<input type="hidden" name="id"/>');
            input.attr('value', idDelete);
            form.append(input);

            $('body').append(form);
            form.submit();
        }
    });
});




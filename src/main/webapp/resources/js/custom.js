var globalURL = "http://localhost:8080/foodGroup4_QuanLy/"

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
        totalPages: $('#pagination-demo').attr('data-pages') >= 1 ? $('#pagination-demo').attr('data-pages') :1,
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
    $("#" + $("#select-danh-muc option:first-child").val()).show();
    $('#select-danh-muc').change(function () {
        $('.select-danh-muc').hide();
        $('#'+$(this).val()).show();
    })
});

/////////// ĐƠN HÀNG TẠI QUÁN /////////////
//  Thêm món ăn vào danh sách món ăn được chọn bên phải

var banid;
$(document).ready(function () {
	$('#menu-ben-phai').attr("hidden", "true");
	
	$(".btn-dat-ban").on("click", function(){
		$('#menu-ben-phai').removeAttr("hidden");
		$("#table-don-hang-tai-quan tbody").empty();//danh sach mon ben phai
		$("#menu-ben-phai-tong-tien").val(0)
		banid = $(this).attr("data-id");
		$.ajax({
			url: globalURL +"chinhanh/api/ban/" + banid,
			type: 'GET'
		}).done(function(data){
			console.log(data);
			$("#menu-ben-phai-ten-ban").text("Bàn " + data.tenBan)
			if(data.tinhTrang == 0){
				$("#status-ban").val("Trống")
				$("#btn-mo-ban").text("Mở bàn")
				$("#btn-chon-mon").attr("disabled", true)
				$("#btn-thanh-toan").attr("disabled", true)
				$("#btn-chuyen-xuong-bep").attr("disabled", true)
			}
			else{
				$("#status-ban").val("Có khách")
				$("#btn-mo-ban").text("Hủy bàn")
				$("#btn-chon-mon").removeAttr("disabled")
				$("#btn-thanh-toan").removeAttr("disabled")
				$("#btn-chuyen-xuong-bep").removeAttr("disabled")
				getBillByTable(banid) //lay hoa don
			}
				
		}).fail(function(jqXHR, textStatus, error){
			console.log(textStatus);
			console.log(error);
			console.log(jqXHR);
		})
		
	})
	$("#btn-mo-ban").on("click", function(){
		if($(this).text() == "Hủy bàn"){
			if(confirm("Bạn có chắc chắn muốn hủy")){
				console.log("Hủy bàn")
				console.log(banid)
				$.ajax({
					url: globalURL +"chinhanh/api/hoadon/cancelled-on-table/"+ banid,
					type: 'DELETE'
				}).done(function(data){
					$("#status-ban").val("Trống")
					$("#btn-mo-ban").text("Mở bàn")
					$("#btn-chon-mon").attr("disabled", true)
					$("#btn-thanh-toan").attr("disabled", true)
					$("#btn-chuyen-xuong-bep").attr("disabled", true)
					$(".btn-dat-ban[data-id="+ banid + "]").removeClass("btn-dat-ban-occupied")
					$("#menu-ben-phai-tong-tien").val(0)
					$("#table-don-hang-tai-quan tbody").empty();
				}).fail(function(jqXHR, textStatus, error){
					console.log(textStatus);
					console.log(error);
					console.log(jqXHR);
					alert("Có lỗi xảy ra")
					window.location.reload();
				})
			}
		}else
			if($(this).text() == "Mở bàn"){
				$.ajax({
					url: globalURL +"chinhanh/api/hoadon/created-on-table",
					type: 'POST',
					data: {idBan : banid}
				}).done(function(data){
					$("#btn-mo-ban").text("Hủy bàn")
					$("#status-ban").val("Có khách")
					$("#btn-chon-mon").removeAttr("disabled")
					$("#btn-thanh-toan").removeAttr("disabled")
					$("#btn-chuyen-xuong-bep").removeAttr("disabled")
					$(".btn-dat-ban[data-id="+ banid + "]").addClass("btn-dat-ban-occupied")
				}).fail(function(jqXHR, textStatus, error){
					console.log(textStatus);
					console.log(error);
					console.log(jqXHR);
					alert("Có lỗi xảy ra")
					window.location.reload();
				})
			}
	})
	
	//khi tat modal chon mon
	$('#modal-dat-hang-tai-quan').on('hide.bs.modal', function (e) {
		$("#table-don-hang-tai-quan tbody").empty();
		var listChiTiet = [];
		var tongtien = 0;
		$("#danh-sach-mon-an-da-chon li").each(function( index, element ) {
			var id = $(element).attr("id-chon-mon");
			var ten = $(element).find(".li-p-ten-mon-an").text();
			var sl = $(element).find(".input-sl-mon-an").val();
			var gia = $(element).find(".input-gia-mon-an").val();
			console.log(ten + sl + gia)
			tongtien += parseInt(gia);
			listChiTiet.push({id: id, sl : sl, tong: gia})
			$("#table-don-hang-tai-quan tbody").append(' <tr><td data-id = "'+id+'"width="60%" style="padding-left: 10px">'+ ten +'</td><td width="20%" class="text-center">' + sl +'</td><td width="20%" class="text-right" style="padding-right: 10px">' + gia +'</td></tr>')
		})
		$("#menu-ben-phai-tong-tien").val(tongtien)
		$.ajax({
			url: globalURL +"chinhanh/api/hoadon/updateBillDetailsByTable/" + banid,
			type: 'POST',
			contentType: 'application/json',
			data : JSON.stringify(listChiTiet)
		}).done(function(data){
			//console.log(data.chitiethoadons);
			
		}).fail(function(jqXHR, textStatus, error){
			console.log(textStatus);
			console.log(error);
			console.log(jqXHR);
		})
	})
	
	//khi bat modal chon mon len
	$('#modal-dat-hang-tai-quan').on('show.bs.modal', function (e) {
		$("#danh-sach-mon-an-da-chon").empty();
		$("#table-don-hang-tai-quan tbody tr").each(function( index, element ) {
			var id = $(element).find("td:nth-child(1)").attr("data-id");
			var ten = $(element).find("td:nth-child(1)").text();
			var sl = $(element).find("td:nth-child(2)").text();
			var gia = $(element).find("td:nth-child(3)").text();
			console.log(id + ten + sl + gia)
			$("#danh-sach-mon-an-da-chon").append('<li id-chon-mon="' + id +'" class="ds-mon-an-da-chon"><div class="col-md-6"><p class="li-p-ten-mon-an"> ' + ten +'</p></div><div class="form-inline"><p class="li-p-ds-mon-an">Số lượng: </p><input type="number" class="input-sl-mon-an" value="' + sl + '" price=" '+ gia/sl +'"><p class="li-p-ds-mon-an t">Tổng tiền: </p><input class="input-gia-mon-an" readonly="" type="text"  value=" ' + gia +'"><a href="#" class="btn-remove"><i class="fa fa-times" aria-hidden="true"></i></a></div></li>')
		})
	})
	
	//khi nhan nut thanh toan
	
});
function getBillByTable(idBan){
	$.ajax({
		url: globalURL +"chinhanh/api/hoadon/getBillByTable/" + banid,
		type: 'GET'
	}).done(function(data){
		//console.log(data.chitiethoadons);
		$("#table-don-hang-tai-quan tbody").empty();
		$("#menu-ben-phai-tong-tien").val(0)
		var tongtien = 0;
		$(data.chitiethoadons).each(function( index, element ) {
			console.log(element)
			var id = element.pk.mon.monId;
			var ten = element.pk.mon.ten;
			var sl = element.soLuong;
			var gia = element.tongTien;
			tongtien += gia;
			$("#table-don-hang-tai-quan tbody").append(' <tr><td data-id = "'+id+'" width="60%" style="padding-left: 10px">'+ ten +'</td><td width="20%" class="text-center">' + sl +'</td><td width="20%" class="text-right" style="padding-right: 10px">' + gia +'</td></tr>')
		})
		$("#menu-ben-phai-tong-tien").val(tongtien)
	}).fail(function(jqXHR, textStatus, error){
		console.log(textStatus);
		console.log(error);
		console.log(jqXHR);
	})
}
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

            var inputTongTien = $('<input class="input-gia-mon-an" readonly type="text">');
            inputTongTien.attr({value: price});

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
            var totalPrice = Math.max(Math.min(value, 50), 1) * price;
            $(myLi).find('.input-gia-mon-an').attr({value: totalPrice});
        }   else {
            var totalPrice = value * price;
            console.log(totalPrice);
            $(myLi).find('.input-gia-mon-an').attr({value: totalPrice});
        }
    }
});

$("#btn-thanh-toan").on("click", function(){
	if($("#table-don-hang-tai-quan tbody tr").length == 0){
		return alert("Không có gì để tính tiền")
	}
	
	$.ajax({
		url: globalURL +"chinhanh/api/hoadon/getBillByTable/" + banid,
		type: 'GET'
	}).done(function(data){
		window.location.href = globalURL + "chinhanh/thanhtoandonhang/" + data.hoaDonId;
	}).fail(function(jqXHR, textStatus, error){
		console.log(textStatus);
		console.log(error);
		console.log(jqXHR);
	})
})

$("#btn-chuyen-xuong-bep").on("click", function(){
	if($("#table-don-hang-tai-quan tbody tr").length == 0){
		return alert("Không có gì để chế biến.")
	}
	
	$.ajax({
		url: globalURL +"chinhanh/api/hoadon/getBillByTable/" + banid,
		type: 'GET'
	}).done(function(data){
		window.open( globalURL + "chinhanh/chuyendonhangxuongbep/" + data.hoaDonId, '_blank');
	}).fail(function(jqXHR, textStatus, error){
		console.log(textStatus);
		console.log(error);
		console.log(jqXHR);
	})
})
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

$(document).on("click", '.btn-remove-mon-an-mang-ve', function () {
    var id = $(this).closest('tr').find('td:nth-child(1)').text()
    $(this).closest('tr').remove();
    var TongTien = 0;
    $('.input-gia-mon-an').each(function (i) {

        TongTien += parseInt($(this).val());
    })

    $('#tong-tien-don-hang-mang-ve').attr({value: TongTien});
    $('.mon-item').each(function(index, element){
    	if($(element).attr('data-id') == id)
    		$(element).removeClass('active');
    })
});

$('#btn-mang-ve-them-mon-da-chon').on("click", function(){
	$('.mon-item.active').each(function(index, element){
		var id = $(element).attr('data-id')
		var price = $(element).attr('data-price');
		var name = $(element).text()
		console.log(id + price + name)
		if(!checkContainMonMangVe(id)){
			$('#table-don-hang-mang-ve tbody').append('<tr><td class="text-center red-text-table">'+ id +'</td><td>Đồ rán</td><td>' + name + '</td><td><input class="input-sl-mon-an-dem-ve" value="1" price="'+ price + '" type="number" style="width: 90px"></td><td><input class="input-gia-mon-an" value="'+ price + '" type="text" style="width: 110px" disabled=""></td><td width="5%"><a class="btn btn-danger btn-remove-mon-an-mang-ve">Xóa</a></td></tr>')
		}
	})
	var TongTien = 0;
    $('.input-gia-mon-an').each(function (i) {

        TongTien += parseInt($(this).val());
    })

    $('#tong-tien-don-hang-mang-ve').attr({value: TongTien});
})
function checkContainMonMangVe(id){
	var check = false;
	$('#table-don-hang-mang-ve tbody tr').each(function(index, element){
		if($(element).find('td:nth-child(1)').text() == id)
			check =  true;
	})
	return check;
}

$('#btn-mang-ve-tao-don-hang').on("click", function(){
	if($('#table-don-hang-mang-ve tbody tr').length == 0)
		return alert("Vui lòng chọn món cho đơn hàng")
		
	var ten_nguoi_nhan = prompt("Nhập tên người nhận");
	var listChiTiet = [];
		$("#table-don-hang-mang-ve tbody tr").each(function( index, element ) {
			var id = $(element).find('td:nth-child(1)').text();
			var sl = $(element).find('td:nth-child(4) input').val();
			var gia = $(element).find('td:nth-child(5) input').val();
			console.log(id+ sl + gia)
			listChiTiet.push({id: id, sl : sl, tong: gia})
		})
		$.ajax({
			url: globalURL +"chinhanh/api/hoadon/createBillGetAway",
			type: 'POST',
			contentType: 'application/json',
			data : JSON.stringify({
				ten_nguoi_nhan: ten_nguoi_nhan,
				listChiTiet : listChiTiet
			})
		}).done(function(data){
			alert("Tạo đơn hàng thành công")
			console.log(data)
			window.open( globalURL + "chinhanh/chuyendonhangxuongbep/" + data.id, '_blank');
			window.location.reload();
		}).fail(function(jqXHR, textStatus, error){
			console.log(textStatus);
			console.log(error);
			console.log(jqXHR);
			alert("Có lỗi xảy ra")
		})
	
})


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
    if($('#chon-ngay-cp-ngay').val() != undefined) {
        $('#chon-ngay-cp-ngay').datepicker({
            format: 'dd-mm-yyyy',
            endDate: new Date(),
            "autoclose": true
        });

        $('#chon-ngay-cp-ngay').datepicker().on('changeDate', function (ev) {
            var newUrl = '/chinhanh/chiphi/ngay?date=' + ev.format();
            console.log(newUrl);
            window.location.replace(newUrl);
        });

        function convertStrDate(date) {
            var dateParts = date.split('-');
            return dateParts[1] + '-' + dateParts[0] + '-' + dateParts[2];
        }

        var strDateUse;
        if ($('#dateFindCpNgay').val() != "") {
            strDateUse = convertStrDate($('#dateFindCpNgay').val());
        } else {
            var currentDate = new Date();
            strDateUse = (currentDate.getMonth() + 1) + '-' + currentDate.getDay() + '-' + currentDate.getFullYear();
        }
        console.log(strDateUse);
        $('#chon-ngay-cp-ngay').datepicker('update', new Date(strDateUse));
    }
});

////////////////////////////////////////////
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

///////////////////////////////////////////
// CHON CHI NGAY CHI PHI THANG
$(function () {
    $('#chon-ngay-cp-thang').datepicker({
        format: 'yyyy',
        minViewMode: 2,
        endDate: new Date(),
        "autoclose": true
    });

    $('#chon-ngay-cp-thang').datepicker().on('changeDate', function(ev){
        var newUrl = '/chinhanh/chiphi/thang?year='+ev.format();
        window.location.replace(newUrl);
    });

    var yearUse;
    if($('#dateFindCpThang').val() != "") {
        yearUse = $('#dateFindCpThang').val();
    } else {
        var currentDate = new Date();
        yearUse = currentDate.getFullYear().toString(10);
    }

    $('#chon-ngay-cp-thang').datepicker('update', yearUse);
});

///////////////////////////////////////////////
// Chọn tháng thêm chi phí tháng
$(function () {
    $('#chon-thang-them-cp-thang').datepicker({
        format: 'mm-yyyy',
        minViewMode: 1,
        endDate: new Date(),
        "autoclose": true
    });

    var yearUse;
    if($('#dateChosenThemCpThang').val() != "") {
        yearUse = $('#dateChosenThemCpThang').val();
    } else {
        var currentDate = new Date();
        yearUse = currentDate.getFullYear().toString(10);
    }

    $('#chon-thang-them-cp-thang').datepicker('update', yearUse);
});


/////////////////////////////////////////////////////////////////
//Thanh toan
$(function () {
	var x_timer;
    $("#sdt_khach").on('change paste keyup', function(e) {
    	$("#ten-khach-hang").removeAttr("readonly")
        clearTimeout(x_timer);
        var user_name = $(this).val();
        x_timer = setTimeout(function() {
            check_username_ajax(user_name);
        }, 1000);
    });
    function check_username_ajax(username) {
    	 
    	if($('#sdt_khach').val().trim().length == 0) return;
		$.ajax({
			url: globalURL +"api/khachhang?sdt=" + $('#sdt_khach').val(),
			type: 'GET',
			timeout: 10000,
			contentType: 'application/json',
		}).done(function(data) {
			console.log(data);
			$("#ten-khach-hang").val(data.ten)
			$("#ten-khach-hang").attr("readonly", true).trigger('change');
		}).fail(function(jqXHR, textStatus, error) {
			console.log(textStatus);
			console.log(error);
			console.log(jqXHR);
		});
    }
})

/////////////////////////////////////////////////////////////
//TONG DAI
$(function(){
	$("#checkbox-them-nguoi-nhan").change(function() {
	    if(this.checked) {
	    	$("#sdt_nguoi_nhan").removeAttr("readonly")
	    	$("#ho_ten_nguoi_nhan").removeAttr("readonly")
	    }else{
	    	$("#sdt_nguoi_nhan").attr("readonly", true)
	    	$("#ho_ten_nguoi_nhan").attr("readonly", true)
	    	$("#sdt_nguoi_nhan").val($("#sdt_khach").val())
	    	$("#ho_ten_nguoi_nhan").val($("#ten-khach-hang").val())
	    }
	});
	
	$("#sdt_khach").on('change paste keyup', function(){
		if(!$("#checkbox-them-nguoi-nhan").is(':checked'))
			$("#sdt_nguoi_nhan").val($("#sdt_khach").val())
	})
	$("#ten-khach-hang").on('change paste keyup', function(){
		if(!$("#checkbox-them-nguoi-nhan").is(':checked'))
			$("#ho_ten_nguoi_nhan").val($("#ten-khach-hang").val())
	})
	
	$("#tong-dai-select-chi-nhanh").on("change", function(){
		var chinhanh = $(this).find('option:selected').val();
		$.ajax({
			url: globalURL + "api/chinhanhmon/"+ chinhanh,
			type: 'GET',
			timeout: 10000,
			contentType: 'application/json',
		}).done(function(data) {
			console.log(data);
			$(".danh-muc-item").empty();
			$("#table-don-hang-mang-ve tbody").empty();
			$('#tong-tien-don-hang-mang-ve').val(0)
			$(data).each(function(index, element){
				$("#list-mon-" + element.mon.danhmuc.danhMucId).append('<li  class="list-group-item col-lg-8 mon-item" data-id="'+ element.mon.monId+'" data-price="'+ element.gia+'">'+ element.mon.ten+'</li>')
			})
		}).fail(function(jqXHR, textStatus, error) {
			console.log(textStatus);
			console.log(error);
			console.log(jqXHR);
		});
	})
	
	$("#tong-dai-btn-tao-don-hang").on("click", function(){
		var ten_khach_hang = $('#ten-khach-hang').val();
		var sdt_khach = $("#sdt_khach").val();
		var sdt_nguoi_nhan = $("#sdt_nguoi_nhan").val();
		var ho_ten_nguoi_nhan = $("#ho_ten_nguoi_nhan").val();
		var dia_chi_nhan = $("#dia_chi_nhan").val();
		var id_Chinhanh = $("#tong-dai-select-chi-nhanh").val();
		var listChiTiet = [];
		$("#table-don-hang-mang-ve tbody tr").each(function( index, element ) {
			var id = $(element).find('td:nth-child(1)').text();
			var sl = $(element).find('td:nth-child(4) input').val();
			var gia = $(element).find('td:nth-child(5) input').val();
			console.log(id+ sl + gia)
			listChiTiet.push({id: id, sl : sl, tong: gia})
		})
		if(ten_khach_hang == ""|| sdt_khach == "" || sdt_nguoi_nhan == "" || ho_ten_nguoi_nhan == ""
			|| dia_chi_nhan == "" || id_Chinhanh == "")
			return alert("Vui lòng nhập đủ các trường")
		if(listChiTiet.length == 0)
			return alert("Vui lòng chọn ít nhất 1 món")
			
		$.ajax({
			url: globalURL +"tongdai/api/hoadon/create",
			type: 'POST',
			contentType: 'application/json',
			data : JSON.stringify({
				ten_khach_hang: ten_khach_hang,
				sdt_khach : sdt_khach,
				sdt_nguoi_nhan : sdt_nguoi_nhan,
				ho_ten_nguoi_nhan : ho_ten_nguoi_nhan,
				dia_chi_nhan : dia_chi_nhan,
				id_Chinhanh : id_Chinhanh,
				listChiTiet : listChiTiet
			})
		}).done(function(data){
			alert("Tạo đơn hàng thành công")
			window.location.reload();
		}).fail(function(jqXHR, textStatus, error){
			console.log(textStatus);
			console.log(error);
			console.log(jqXHR);
			alert("Có lỗi xảy ra")
		})
	})
	
	
})
$(function(){
	if($("#option-don-hang-can-duyet").length != 0){
		getDonHangCanXacNhan();
	    setInterval(function(){getDonHangCanXacNhan()}, 10000)	;
	}
	
	function getDonHangCanXacNhan(){
		$.ajax({
			url: globalURL +"tongdai/api/hoadon/lay-don-hang-can-confirm",
			type: 'GET',
			contentType: 'application/json'
		}).done(function(data){
			console.log(data)
			$("#option-don-hang-can-duyet tbody").empty();
			$(data).each(function(index, element){
				$("#option-don-hang-can-duyet tbody").append('<tr><td class="text-center red-text-table">' + element.hoaDonId + ' </td><td class="text-center">' + element.sdtNguoiNhan + '</td><td>'+ element.hoTenNguoiNhan +'</td><td class="text-center"><span class="_single_price" price="' + element.tongTien +'">'+ element.tongTien +'</span></td><td class="text-center">' + 'Đang xử lý' + '</td><td><a href="'+globalURL
						+ 'tongdai/chi-tiet-don-hang-need-confirm/' + element.hoaDonId+'" class="btn btn-info">Xem</a></td></tr>')
			})
			$('._single_price').each(function(index, element){
				var price = $(element).attr('price');
				price = Number(parseFloat(price)).toLocaleString();
				$(element).text(price)
			})
		}).fail(function(jqXHR, textStatus, error){
			console.log(textStatus);
			console.log(error);
			console.log(jqXHR);
			alert("Có lỗi xảy ra")
		})
	}
})

$('#time-picker').timepicker({
	timeFormat: 'HH:mm ',
    interval: 15,
    minTime: '6:00',
    maxTime: '22:00',
    startTime: '6:00',
    dynamic: false,
    dropdown: true,
    scrollbar: true
});



















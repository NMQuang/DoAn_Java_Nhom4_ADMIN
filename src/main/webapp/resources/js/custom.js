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
$('input, textarea').on('change keyup paste',function(){
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







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


$(document).ready(function () {
    $('.option-don-hang').hide();
    $('#option-tai-quan').show();
    $('#option-don-hang').change(function () {
        $('.option-don-hang').hide();
        $('#'+$(this).val()).show();
    })
});

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

// $('#input-search-header-bar2').keyup(function() {
//     var $rows = $('#food-search-header-bar2 tbody tr');
//     var val = $.trim($(this).val()).replace(/ +/g, ' ').toLowerCase();
//
//     $rows.show().filter(function() {
//         var text = $(this).text().replace(/\s+/g, ' ').toLowerCase();
//         return !~text.indexOf(val);
//     }).hide();
// });

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


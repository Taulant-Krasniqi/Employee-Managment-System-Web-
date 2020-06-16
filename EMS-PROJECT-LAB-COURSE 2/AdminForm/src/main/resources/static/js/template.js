(function($) {
  'use strict';
  $(function() {
    var body = $('body');
    var contentWrapper = $('.content-wrapper');
    var scroller = $('.container-scroller');
    var footer = $('.footer');
    var sidebar = $('.sidebar');

    //Add active class to nav-link based on url dynamically
    //Active class can be hard coded directly in html file also as required

    function addActiveClass(element) {
      if (current === "") {
        //for root url
        if (element.attr('href').indexOf("index.html") !== -1) {
          element.parents('.nav-item').last().addClass('active');
          if (element.parents('.sub-menu').length) {
            element.closest('.collapse').addClass('show');
            element.addClass('active');
          }
        }
      } else {
        //for other url
        if (element.attr('href').indexOf(current) !== -1) {
          element.parents('.nav-item').last().addClass('active');
          if (element.parents('.sub-menu').length) {
            element.closest('.collapse').addClass('show');
            element.addClass('active');
          }
          if (element.parents('.submenu-item').length) {
            element.addClass('active');
          }
        }
      }
    }







    $(document).ready(function () {
      $('#maxRows').on('change', function() {
        getPagination('#tabletest',$(this).val());
      });
      getPagination('#tabletest',5); // the no of rows default you want to show
    });

    function getPagination(table,noRows) {

      $('.pagination').html(''); // reset pagination
      var trnum = 0; // reset tr counter
      var maxRows = noRows; // get Max Rows from select option
      var totalRows = $(table + ' tbody tr').length; // numbers of rows
      $(table + ' tr:gt(0)').each(function() { // each TR in  table and not the header
        trnum++; // Start Counter
        if (trnum > maxRows) { // if tr number gt maxRows

          $(this).hide(); // fade it out
        }
        if (trnum <= maxRows) {
          $(this).show();
        } // else fade in Important in case if it ..
      }); //  was fade out to fade it in
      if (totalRows > maxRows) { // if tr total rows gt max rows option
        var pagenum = Math.ceil(totalRows / maxRows); // ceil total(rows/maxrows) to get ..
        //    numbers of pages
        for (var i = 1; i <= pagenum;) { // for each page append pagination li
          $('.pagination').append('<li class="page-item" data-page="' + i + '">\
                                     <span>' + i++ + '<span class="page-link"></span></span>\
                                    </li>').show();
        } // end for i
      } // end if row count > max rows
      $('.pagination li:first-child').addClass('active'); // add active class to the first li
      $('.pagination li').on('click', function() { // on click each page
        var pageNum = $(this).attr('data-page'); // get it's number
        var trIndex = 0; // reset tr counter
        $('.pagination li').removeClass('active'); // remove active class from all li
        $(this).addClass('active'); // add active class to the clicked
        $(table + ' tr:gt(0)').each(function() { // each tr in table not the header
          trIndex++; // tr index counter
          // if tr index gt maxRows*pageNum or lt maxRows*pageNum-maxRows fade if out
          if (trIndex > (maxRows * pageNum) || trIndex <= ((maxRows * pageNum) - maxRows)) {
            $(this).hide();
          } else {
            $(this).show();
          } //else fade in
        }); // end of for each tr in table
      }); // end of on click pagination list
    }





















//
//     var btnContainer = document.getElementById("nrrofaqet");
//
// // Get all buttons with class="btn" inside the container
//     var btns = btnContainer.getElementsByClassName("page-item");
//
// // Loop through the buttons and add the active class to the current/clicked button
//     for (var i = 0; i < btns.length; i++) {
//       btns[i].addEventListener("click", function() {
//         var current = document.getElementsByClassName("active");
//         current[0].className = current[0].className.replace(" active", "");
//         this.className += " active";
//       });
//     }
//
//     var current = location.pathname.split("/").slice(-1)[0].replace(/^\/|\/$/g, '');
//     $('.ul li a', sidebar).each(function() {
//       var $this = $(this);
//       addActiveClass($this);
//     })

    //Close other submenu in sidebar on opening any

    sidebar.on('show.bs.collapse', '.collapse', function() {
      sidebar.find('.collapse.show').collapse('hide');
    });




    //Change sidebar

    $('[data-toggle="minimize"]').on("click", function() {
      body.toggleClass('sidebar-icon-only');
    });

    //checkbox and radios
    $(".form-check label,.form-radio label").append('<i class="input-helper"></i>');

    // Remove pro banner on close
    document.querySelector('#bannerClose').addEventListener('click',function() {
      document.querySelector('#proBanner').classList.add('d-none');
    });

  });
})(jQuery);

$(document).ready(function(){
	$('body').on('mouseenter','.gnb>ul>li',function(){
		$(this).children('ul').stop().slideDown(500)
		$(this).addClass('on')
	})
	$('body').on('mouseleave','.gnb>ul>li',function(){
		$(this).children('ul').stop().slideUp(500)
		$(this).removeClass('on')
	})


})
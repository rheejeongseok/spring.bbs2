$(function(){
	$('.section1 .btns .prev').click(function(){

		var idx = $('.section1 li.on').index();
		var lastidx = $('.section1 li:last-child').index();
		console.log("aa")
		$('.section1 li').eq(0).css('display','block')
		$('.section1 li.on').prev('li').css({'display':'block','left':'-90%'})
		$('.section1 li.on').animate({'left':'100%'})
		$('.section1 li.on').prev('li').addClass('on').animate({'left':'0%'}).siblings('li').removeClass('on')

		if(idx == 0){
			$('.section1 li').eq(lastidx).css('display','block')
			$('.section1 li').eq(lastidx).addClass('on').css('left','-95%').animate({'left':0}).siblings('li').removeClass('on')
		}
		$('.on_num').text($('.section1 li.on').index()+1);
	})
	$('.section1 .btns .next').click(function(){

		var idx = $('.section1 li.on').index();
		var lastidx = $('.section1 li:last-child').index();
		$('.section1 li').eq(0).css('display','block')
		$('.section1 li.on').next('li').css({'display':'block','left':'99%'})
		$('.section1 li.on').animate({'left':'-100%'})
		$('.section1 li.on').next('li').addClass('on').css('left','95%').animate({'left':'0'}).siblings('li').removeClass('on')
		if(idx == lastidx){
			$('.section1 li').eq(0).addClass('on').css('left','99%').animate({'left':0}).siblings('li').removeClass('on')
		}
		$('.on_num').text($('.section1 li.on').index()+1);
	})
	$('.section3 .btns .next').click(function(){

		var idx = $('.section3 li.on').index();
		var lastidx = $('.section3 li:last-child').index();
		$('.section3 li').eq(0).css('display','block')
		$('.section3 li.on').next('li').css({'display':'block','left':'99%'})
		$('.section3 li.on').animate({'left':'-95%'})
		$('.section3 li.on').next('li').addClass('on').css('left','95%').animate({'left':'0'}).siblings('li').removeClass('on')
		if(idx == lastidx){
			$('.section3 li').eq(0).addClass('on').css('left','99%').animate({'left':0}).siblings('li').removeClass('on')
		}
	})
	$('.section3 .btns .prev').click(function(){

		var idx = $('.section3 li.on').index();
		var lastidx = $('.section3 li:last-child').index();
		console.log("aa")
		$('.section3 li').eq(0).css('display','block')
		$('.section3 li.on').prev('li').css({'display':'block','left':'-90%'})
		$('.section3 li.on').animate({'left':'100%'})
		$('.section3 li.on').prev('li').addClass('on').animate({'left':'0'}).siblings('li').removeClass('on')

		if(idx == 0){
			$('.section3 li').eq(lastidx).css('display','block')
			$('.section3 li').eq(lastidx).addClass('on').css('left','-95%').animate({'left':0}).siblings('li').removeClass('on')
		}
	})
	$('.section4 .btns .next').click(function(){

		var idx = $('.section4 li.on').index();
		var lastidx = $('.section4 li:last-child').index();
		$('.section4 li').eq(0).css('display','block')
		$('.section4 li.on').next('li').css({'display':'block','left':'98%'})
		$('.section4 li.on').animate({'left':'-100%'})
		$('.section4 li.on').next('li').addClass('on').css('left','95%').animate({'left':'0'}).siblings('li').removeClass('on')
		if(idx == lastidx){
			$('.section4 li').eq(0).addClass('on').css('left','99%').animate({'left':0}).siblings('li').removeClass('on')
		}
	})
	$('.section4 .btns .prev').click(function(){

		var idx = $('.section4 li.on').index();
		var lastidx = $('.section4 li:last-child').index();
		console.log("aa")
		$('.section4 li').eq(0).css('display','block')
		$('.section4 li.on').prev('li').css({'display':'block','left':'-90%'})
		$('.section4 li.on').animate({'left':'100%'})
		$('.section4 li.on').prev('li').addClass('on').animate({'left':'0'}).siblings('li').removeClass('on')

		if(idx == 0){
			$('.section4 li').eq(lastidx).css('display','block')
			$('.section4 li').eq(lastidx).addClass('on').css('left','-95%').animate({'left':0}).siblings('li').removeClass('on')
		}
	})
	$('.section6 .section6_list ul').slick({
		infinite: true,
		centerMode: true,
        slidesToShow: 3,
        slidesToScroll: 3,
        speed:500
	})
})

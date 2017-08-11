$(function(){
	var liidx = $('.section1 li:last-child').index()+1;
	console.log(liidx)
	$('.full_num').text('/'+liidx)
	$('.btns .prev').click(function(){
		console.log($('.section1 li.on').index())


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
	$('.btns .next').click(function(){

		var idx = $('.section1 li.on').index();
		var lastidx = $('.section1 li:last-child').index();
		$('.section1 li').eq(0).css('display','block')
		$('.section1 li.on').next('li').css({'display':'block','left':'99%'})
		$('.section1 li.on').animate({'left':'-100%'})
		$('.section1 li.on').next('li').addClass('on').css('left','95%').animate({'left':'0'}).siblings('li').removeClass('on')
		if(idx == lastidx){
			$('.section1 li').eq(0).addClass('on').css('left','100%').animate({'left':0}).siblings('li').removeClass('on')

		}
		$('.on_num').text($('.section1 li.on').index()+1);
	})
})
$(document).ready(function(){
	var height =  $(".notice").height();
	var num = $(".rolling li").length;
	var max = height * num;
	var move = 0;
	function noticeRolling(){
		move += height;
		$(".rolling").stop().animate({"top":-move},600,function(){
			if( move >= max ){
				$(this).css("top",0);
				move = 0;
			};
		});
	};
	noticeRollingOff = setInterval(noticeRolling,2000);
	$(".rolling").append($(".rolling li").first().clone());

	/*$(".rolling_stop").click(function(){
		clearInterval(noticeRollingOff);
	});
	$(".rolling_start").click(function(){
		noticeRollingOff = setInterval(noticeRolling,1000);
	});*/
	$('.notice').mouseover(function(){
        clearInterval(noticeRollingOff);
        $(this).css("text-decoration", "underline");
    });
	$('.notice').mouseout(function(){
        noticeRollingOff = setInterval(noticeRolling,2000);
        $(this).css("text-decoration", "none");
    });
});		
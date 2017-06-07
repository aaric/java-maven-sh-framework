(function(){
  // 显示页面加载状态
    var tt = 1,times = 100;
	function loading(l,t){
		var lo = l || '100%';
		var time = t || 1000;
		
		$('.loading').clearQueue();
		$('.loading').animate({'width':lo},time);
		
		if(tt >= 100)
		{
			  clearInterval(timeid);
		}
		
		tt++;
	};

	$(window).load(function(){
        
		// 判断加载状态
		if(100 > tt)
		{
		   $('.loading').animate({'width':100 + "%"},400);
		   clearInterval(timeid);
		}
		setTimeout(function(){$('.loading').hide();delete tt;delete times;},700);
		
	});
	
	var timeid = setInterval(function(){
		  loading(tt + '%',times);
	 },times);
})(jQuery);
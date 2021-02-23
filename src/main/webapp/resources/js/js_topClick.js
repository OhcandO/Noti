$(function (){
	$(".serachToss").click(function() {
		alert($(this).text()+"클릭!");
		$("#search").val( $(this).text());
		var e = jQuery.Event( "keydown", { keyCode: 13 } ); 
		$("#search").trigger(e);
	});
});

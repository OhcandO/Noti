$(function () {
	
	$("#search").keyup(function () {
	  // 로그인 프로세스 호출
	  $.ajax({
		type: "GET", // 전송방식
		async: true, // 비동신통신
		url: "searchText.do", // **** 요청
		contentType: "application/x-www-form-urlencoded;charset=UTF-8", // 한글
		data: "searchText=" + $("#search").val(), // 클라이언트에서 보내는 데이타
		
		success: function (rmap) {
		  // 성공하면 함수연결
			$("#infoboardList").html(rmap);

		},
		error:function(request,status,error){
			//out.print("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);}
		    alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);}
	  });
	});
  });
  
$(function () {
   $("#search").keydown(function(key) {
      if (key.keyCode == 13) {
         // 로그인 프로세스 호출
         if($("#search").val().length < 2)
            {
               alert("2글자 이상으로 검색해주세요.");
            } else{
         $.ajax({
            type: "GET", // 전송방식
            async: true, // 비동신통신
            url: "getTotalSearch.do", // **** 요청
            contentType: "application/x-www-form-urlencoded;charset=UTF-8", // 한글
            data: "searchText=" + $("#search").val(), // 클라이언트에서 보내는 데이타
            
            success: function (rmap) {
               // 성공하면 함수연결
               $("#body").html(rmap);
            },
            error:function(request,status,error){
               //out.print("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);}
               alert("회원만 검색이 가능합니다!");}
         });
            }
      }
   });
  });
  
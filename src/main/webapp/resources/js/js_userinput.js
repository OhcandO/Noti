$(function () {
	// 사용자의 자료 입력여부를 검사하는 함수
	$("#confirm").click(function () {
	  if ($.trim($("#user_id").val()) == "") {
		alert("아이디를 입력해 주세요.");
		$("#user_Id").focus();
		return;
	  }
  
	  if ($.trim($("#user_pass").val()) == "") {
		alert("비번입력해주세요.");
		$("#user_Pass").focus();
		return;
	  }
  
	  if ($.trim($("#user_pass").val()) != $.trim($("#user_pass2").val())) {
		alert("비밀번호가 일치하지 않습니다..");
		$("#user_pass2").focus();
		return;
	  }
  
	  if ($.trim($("#user_name").val()) == "") {
		alert("이름입력해주세요.");
		$("#user_name").foucs();
		return;
	  }
	  if ($.trim($("#user_email").val()) == "") {
		alert("이메일입력해주세요.");
		$("#user_email").foucs();
		return;
	  }
	  if ($.trim($("#user_gender").val()) == "") {
		alert("성별입력해주세요.");
		$("#user_gender").foucs();
		return;
	  }
  
	  // 자료를 전송합니다.
	  document.userinput.submit();
	});
  
	//아이디 중복체크
	$("#user_id").keyup(function () {
	  // 로그인 프로세스 호출
  
	  $.ajax({
		type: "post", // 전송방식
		async: true, // 비동신통신
		url: "idCheck.do", // **** 요청
		contentType: "application/x-www-form-urlencoded;charset=UTF-8", // 한글
		data: "user_id=" + $("#user_id").val(), // 클라이언트에서 보내는 데이타
		success: function (resultData) {
		  // 성공하면 함수연결
		  //alert("resultData = "+resultData)
		  $("#idCheckResult").html(resultData);
		  if ($("#idCheckResult").html() == "중복된 아이디입니다.") {
			$("#confirm").attr("disabled", true);
			return;
		  } else {
			$("#confirm").attr("disabled", false);
			return;
		  }
		},
	  });
	});
  });
  
$(function() {
	// 사용자의 자료 입력여부를 검사하는 함수
	$("#confirm").click(function() {
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
		document.userUpdate.submit();
	});
});
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>

<!DOCTYPE html>
<html>
<head>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- 기본 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>





<!-- 이모티콘 -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.9.0/css/all.css"
	integrity="sha384-i1LQnF23gykqWXg6jxC2ZbCbUMxyw5gLZY6UiUS98LYV5unm8GWmfkIS6jqJfb4E"
	crossorigin="anonymous">

<!-- css -->
<link rel="stylesheet" href="resources/css/style.css">
<link rel="stylesheet" href="resources/css/base.css">

<title>Noti</title>
<style>
/* Make the image fully responsive */
</style>
</head>
<title>글 목록</title>
<link rel="stylesheet" href="resources/css/user_boardList.css">
</head>
<body>

	<%@ include file="base/top.jsp"%>
	<div id="body">
		<div class="container-fluid">
			<div class="row">
				<img alt="bg" src="resources/images/info_board.png" class="w-100">
			</div>
			
			<div class="row text-center font-weight-600 font-color-white pointer">
				<div class="col-lg-3 col-12 sub_menu_none py-2" onclick="location.href='http://localhost:8888/noti/getinfoBoardList.do'">
					공지사항
				</div> 
				<div class="col-lg-3 col-12 sub_menu_none py-2" onclick="location.href='http://localhost:8888/noti/getBoardList.do'">
					자유게시판
				</div>
				<div class="col-lg-3 col-12 sub_menu_none py-2" onclick="location.href='http://localhost:8888/noti/getTopSearch.do'">
					인기검색어
				</div>
				<div class="col-lg-3 col-12 sub_menu_click main-font-color py-2" onclick="location.href='http://localhost:8888/noti/getNotiInfo.do'">
					노티소개
				</div>
			</div>
		</div>
		<div class="container">
		    <div class="row mt-5 mb-4">		    	
		    	<div class="col-lg-12 text-center font-size-18">
		    		<div class="color-noti">
		    			Noti: the Notice 는
		    		</div>
		    		<div class="font-weight-600">
		    			
		    			<div class="typing-demo main-font-color">
					      [ 알짜배기 정책 정보를 공유하는 플랫폼 ]
					    </div>
		    		</div>
		    		<div class="color-noti">
		    			 기존의 ‘정보공개 정부 웹페이지’와는 이런 점이 다릅니다!
		    		</div>		    		
		    	</div>
		    </div>    
		    
		    <div class="row mt-7">
		        <div class="col-lg-6">
		        	<div class="accordian">
					  <ul>
					    <li>
					      <div class="title pointer"><span class="fa fa-plus"></span>
					       	 복지정책은 보통 나는 해당되지 않는다고요 ?
					      </div>
					      <ul>
					        <li> <span> <img alt="bg" src="resources/images/board_re.gif"></span>아니요! 소소할 수 있지만 확실한 복지 정보를 제공합니다.</li>
					      </ul>
					    </li>
					    <li>
					      <div class="title pointer"><span class="fa fa-plus"></span>
					       	정부 주도의 일방적인 정보 공개?
					      </div>
					      <ul>
					        <li><span> <img alt="bg" src="resources/images/board_re.gif"></span> 아니오! 정책에 관해 자유롭게 댓글을 표현할 수 있습니다</li>
					      </ul>
					    </li>
					    <li>
					      <div class="title pointer"><span class="fa fa-plus"></span>
					       	 무슨 복지 정책을 검색할지 모른다고요?
					      </div>
					      <ul>
					        <li><span> <img alt="bg" src="resources/images/board_re.gif"></span> 일/주/월간 인기 검색어로 힌트를 얻으세요!</li>
					      </ul>
					    </li>
					    <li>
					      <div class="title pointer"><span class="fa fa-plus"></span>
					        	복지 정보들이 여기저기 흩어져 있었다고요?
					      </div>
					      <ul>
					        <li><span> <img alt="bg" src="resources/images/board_re.gif"></span>노티는 매일 자동으로 정보들을 쓸어옵니다!</li>
					      </ul>
					    </li>
					    <li>
					      <div class="title pointer"><span class="fa fa-plus"></span>
					        	정보 공유 사이트는 딱딱하다?
					      </div>
					      <ul>
					        <li><span> <img alt="bg" src="resources/images/board_re.gif"></span>여기 커뮤니티 서비스가 활성화된 말랑한 노티로 오세요!</li>
					      </ul>
					    </li>
					  </ul>
					</div>
		        </div>
		        
		        <div class="col-lg-6 text-center pt-3">
		            <main>
						<section>
						    <div class="pieID pie">
						     
						    </div>
							<ul class="pieID legend border">
								<li class="legendli">
								  <em>대전광역시</em>
								  <span>718</span>
								</li>
								<li class="legendli">
								  <em>서울광역시</em>
								  <span>531</span>
								</li>
								<li class="legendli">
								  <em>공기업</em>
								  <span>868</span>
								</li>
								<li class="legendli">
								  <em>청년복시</em>
								  <span>344</span>
								</li>
								<li class="legendli">
								  <em>기타</em>
								  <span>245</span>
								</li>
							</ul>
							<div class="text-center font-size-08 mt-2">
								정책게시판 구성 비율
							</div>
						 </section>
					</main>
		        </div>
		    </div>
		    <div class="row">
		        <div class="col-lg-12 text-center mt-6 font-weight-600 mb-4">
		        	<div class="font-size-10 color-noti">
		        		Information Use
		        	</div>
		        	<div class="font-size-18 main-font-color">
		        		이용안내
		        	</div>		    		
		    	</div>
		    	<div class="col-lg-3 text-center">
		    		<div class="card-1 p-2 pointer py-4" style="border-top:2px solid #c75c5c">
			    		<div class="font-size-25">
			    			<img alt="bg" src="resources/images/noti_a.png" class="">
			    		</div>
			    		<div class="font-weight-600 mt-2">
			    			정책 게시판
			    		</div>
			    		<div class="font-size-08 mt-2">
			    			전국 중 ~ 소규모 관공서의<br> 공지 정보를 모아봅니다
			    		</div>
		    		</div>
		    	</div>
		    	<div class="col-lg-3 text-center">
		    		<div class="card-1 p-2 pointer py-4" style="border-top:2px solid #76c2af">
			    		<div class="font-size-25">
			    			<img alt="bg" src="resources/images/noti_b.png" class="">
			    		</div>
			    		<div class="font-weight-600 mt-2">
			    			인기 검색어
			    		</div>
			    		<div class="font-size-08 mt-2">
			    			일간, 주간, 월간 사람들이  <br>많이 검색한 정보? 이 곳에서 확인!
			    		</div>
		    		</div>
		    	</div>
		    	<div class="col-lg-3 text-center ">
		    		<div class="card-1 p-2 pointer py-4" style="border-top:2px solid #77b3d4">
			    		<div class="font-size-25">
			    			<img alt="bg" src="resources/images/noti_c.png" class="">
			    		</div>
			    		<div class="font-weight-600 mt-2">
			    			회원 게시판
			    		</div>
			    		<div class="font-size-08 mt-2">
			    			우리 노티 회원 여러분들의  <br>자유로운 의사소통 공간!
			    		</div>
		    		</div>
		    	</div>
		    	<div class="col-lg-3 text-center">
		    		<div class="card-1 p-2 pointer py-4" style="border-top:2px solid #e0995e">
			    		<div class="font-size-25">
			    			<img alt="bg" src="resources/images/noti_search.png" class="">
			    		</div>
			    		<div class="font-weight-600 mt-2">
			    			통합검색
			    		</div>
			    		<div class="font-size-08 mt-2">
			    			웹 페이지 상단 검색으로 <br> [정책]/[회원] 게시판 모두를 검색
			    		</div>
		    		</div>
		    	</div>	    	
		    </div>
		    <div class="row mt-3">
		    	
		     </div> 
		    
		    <!-- <div class="row">	
		    	<div class="col-lg-12 text-center mt-6 font-weight-600 mb-4">
		        	<div class="font-size-10 color-noti">
		        		Creators
		        	</div>
		        	<div class="font-size-18 main-font-color">
		        		만들이들
		        	</div>		    		
		    	</div>
		    	
		     </div>    -->
		</div>


	</div>
</body>

<script>

function sliceSize(dataNum, dataTotal) {
	  return (dataNum / dataTotal) * 360;
	}
	function addSlice(sliceSize, pieElement, offset, sliceID, color) {
	  $(pieElement).append("<div class='slice "+sliceID+"'><span></span></div>");
	  var offset = offset - 1;
	  var sizeRotation = -179 + sliceSize;
	  $("."+sliceID).css({
	    "transform": "rotate("+offset+"deg) translate3d(0,0,0)"
	  });
	  $("."+sliceID+" span").css({
	    "transform"       : "rotate("+sizeRotation+"deg) translate3d(0,0,0)",
	    "background-color": color
	  });
	}
	function iterateSlices(sliceSize, pieElement, offset, dataCount, sliceCount, color) {
	  var sliceID = "s"+dataCount+"-"+sliceCount;
	  var maxSize = 179;
	  if(sliceSize<=maxSize) {
	    addSlice(sliceSize, pieElement, offset, sliceID, color);
	  } else {
	    addSlice(maxSize, pieElement, offset, sliceID, color);
	    iterateSlices(sliceSize-maxSize, pieElement, offset+maxSize, dataCount, sliceCount+1, color);
	  }
	}
	function createPie(dataElement, pieElement) {
	  var listData = [];
	  $(dataElement+" span").each(function() {
	    listData.push(Number($(this).html()));
	  });
	  var listTotal = 0;
	  for(var i=0; i<listData.length; i++) {
	    listTotal += listData[i];
	  }
	  var offset = 0;
	  var color = [
	    "cornflowerblue", 
	    "olivedrab", 
	    "orange", 
	    "tomato", 
	    "crimson", 
	    "purple", 
	    "turquoise", 
	    "forestgreen", 
	    "navy", 
	    "gray"
	  ];
	  for(var i=0; i<listData.length; i++) {
	    var size = sliceSize(listData[i], listTotal);
	    iterateSlices(size, pieElement, offset, i, 0, color[i]);
	    $(dataElement+" li:nth-child("+(i+1)+")").css("border-color", color[i]);
	    offset += size;
	  }
	}
	createPie(".pieID.legend", ".pieID.pie");


</script>

<script type="text/javascript">

$(function(){
  $(".accordian .title").click(function(e){
    $('accordian .title').find('.fa.fa-plus open').toggleClass('open');
    $($(e.target).find('.fa.fa-plus').toggleClass('open'));
  $(".accordian ul ul").slideUp();
    if ($(this).next().is(":hidden")){
    $(this).next().slideDown();
    }
  });
  

});
</script>

</html>




<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> --%>
   <!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="utf-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">

   <!-- 기본 -->
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
   
   <!-- 카운트 업(숫자)ajax -->
   <script type="text/javascript" src="resources/js/indexCountUp.js"></script>

   <!-- 이모티콘 -->
   <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.9.0/css/all.css"
      integrity="sha384-i1LQnF23gykqWXg6jxC2ZbCbUMxyw5gLZY6UiUS98LYV5unm8GWmfkIS6jqJfb4E" crossorigin="anonymous">

   <!-- css -->
   <link rel="stylesheet" href="resources/css/style.css?after">
   <link rel="stylesheet" href="resources/css/base.css?after">

   <title>Noti</title>
   <style>
      /* Make the image fully responsive */
   </style>
   <style>
      /* Make the image fully responsive */
      .carousel-inner img {
        width: 100%;
        height: 100%;
      }
   </style>
   
</head>

<script type="text/javascript">
$('.carousel').carousel()
</script>

<body>
   <%@ include file="base/top.jsp"%>
   
   <div id="body">
   <div class="wrap">
      <!-- <div class="container py-3">
         <div class="row">
            <div class="col-lg-4 font-weight-600 font-size-29 main-font-color">
               Noti<span class="" style="font-size:1px">rannosaurus</span>
            </div>
            <div class="col-lg-4 pt-4">
               <input type="text" class="form-control w-100 serch_bar_sty" placeholder="검색어를 입력해 주세요.">
            </div>
            <div class="col-lg-4 pt-4">
               <div class="text-right">
                  <a href="user/userLogin.do" class="main-font-color font-weight-600 pr-3">로그인</a>
                  <a href="user/userJoin.do" class="main-font-color font-weight-600">회원가입</a>
               </div>
            </div>
         </div>
      </div> -->
      
      
      <div id="demo" class="carousel slide" data-ride="carousel">

        <!-- Indicators -->
        <ul class="carousel-indicators">
          <li data-target="#demo" data-slide-to="0" class="active"></li>
          <li data-target="#demo" data-slide-to="1"></li>
          <li data-target="#demo" data-slide-to="2"></li>
        </ul>
        
        <!-- The slideshow -->
        <div class="carousel-inner">
          <div class="carousel-item active">
               <img src="resources/images/m-bg1.png" alt="Los Angeles" class="mobile-bg">
            <img src="resources/images/bg1a.png" alt="Los Angeles" class="pc-bg">
          </div>
          <div class="carousel-item">
            <img src="resources/images/bg2.png">
          </div>
          <div class="carousel-item">
            <img src="resources/images/bg3.png">
          </div>
        </div>
        
        <!-- Left and right controls -->
        <a class="carousel-control-prev" href="#demo" data-slide="prev">
          <span class="carousel-control-prev-icon"></span>
        </a>
        <a class="carousel-control-next" href="#demo" data-slide="next">
          <span class="carousel-control-next-icon"></span>
        </a>
      </div>
      

      <div class="container mt-5">
         <div class="row">
            <div class="col-lg-3 my-2">
               <div class="media border p-3 pointer card-1">
                  <i class="fab fa-app-store-ios font-size-29 main-font-color2 pt-4 pr-3"></i>
                  <div class="media-body">
                     <div class="font-size-09 font-weight-600">
                        총 게시글 수
                     </div>
                     <div class="font-weight-600 font-size-18 main-font-color2">
                        <span class="counter">${boardListSize + infoboardListSize} </span> 건
                     </div>
                     <div class="font-size-08">
                        복지는 좋은 건강, 윤택한 생활, 안락한 환경들이 누릴 수 있는 상태를 말한다.
                     </div>
                  </div>
               </div>
            </div>
            <div class="col-lg-3 my-2">
               <div class="media border p-3 pointer card-1">
                  <i class="fab fa-buromobelexperte font-size-29 main-font-color2 pt-4 pr-3"></i>
                  <div class="media-body">
                     <div class="font-size-09 font-weight-600">
                        정책 게시글
                     </div>
                     <div class="font-weight-600 font-size-18 main-font-color2">
                        <span class="counter">${infoboardListSize} </span> 건
                     </div>
                     <div class="font-size-08">
                        복지는 좋은 건강, 윤택한 생활, 안락한 환경들이 누릴 수 있는 상태를 말한다.
                     </div>
                  </div>
               </div>
            </div>
            <div class="col-lg-3 my-2">
               <div class="media border p-3 pointer card-1">
                  <i class="fas fa-democrat font-size-29 main-font-color2 pt-4 pr-3"></i>
                  <div class="media-body">
                     <div class="font-size-09 font-weight-600">
                        일반 게시글
                     </div>
                     <div class="font-weight-600 font-size-18 main-font-color2">
                        <span class="counter">${boardListSize}</span> 건
                     </div>
                     <div class="font-size-08">
                        복지는 좋은 건강, 윤택한 생활, 안락한 환경들이 누릴 수 있는 상태를 말한다.
                     </div>
                  </div>
               </div>
            </div>
            <div class="col-lg-3 my-2">
               <div class="media border p-3 pointer card-1">
                  <i class="fab fa-app-store-ios font-size-29 main-font-color2 pt-4 pr-3"></i>
                  <div class="media-body">
                     <div class="font-size-09 font-weight-600">
                        인기검색
                     </div>
                     <div class="font-weight-600 font-size-18 main-font-color2">
                        <span class="counter"> 751 </span> 건
                     </div>
                     <div class="font-size-08">
                        복지는 좋은 건강, 윤택한 생활, 안락한 환경들이 누릴 수 있는 상태를 말한다.
                     </div>
                  </div>
               </div>
            </div>
         </div>

         <div class="row mt-3">
            <div class="col-lg-6 my-2">
               <div class="main_infoboard_pst_rlt">
                  <div class="font-size-08 font-weight-600">
                     정책게시판
                  </div>
                  <div class="main_infoboard_pst_abs font-size-08 font-weight-600">
                     <a href="getinfoBoardList.do" class=""><i class="fas fa-plus-circle"></i> 더보기</a>
                  </div>
               </div>
               <div class="mt-3">
                  <table class="font-size-08 w-100" id="infoboardList">
                     <tr class="text-center main_th_sty font-weight-600">
                        <th class="py-2 px-2">번호</th>
                        <th class="">제목</th>
                        <th >날짜</th>
                        <!-- user_board_count -->
            
                     </tr>
                     <c:forEach items="${minfoboardList }" var="infoboard" begin="0" end="5">
                        <!-- 프라퍼티이름 변경 -->
                        <tr class="main_td_sty">
                           <td align="center" class="py-2">${infoboard.info_board_no}</td>
                           <td class=""><a href="getinfoBoard.do?info_board_no=${infoboard.info_board_no }"  class="title_simple">${infoboard.info_board_title }</a></td>
                           <td align="center"><fmt:formatDate value="${infoboard.info_board_start}" pattern="yyyy.MM.dd" /></td>            
                        </tr>
                     </c:forEach>                     
                  </table>
               </div>
            </div>
            <div class="col-lg-6 my-2">
               <div class="main_infoboard_pst_rlt">
                  <div class="font-size-08 font-weight-600">
                     일반게시판
                  </div>
                  <div class="main_infoboard_pst_abs font-size-08 font-weight-600">
                     <a href="getBoardList.do" class=""><i class="fas fa-plus-circle"></i> 더보기</a>
                  </div>
               </div>
               <div class="mt-3">
                     <table class="font-size-08 w-100" id="infoboardList">
                        <tr class="text-center main_th_sty font-weight-600">
                     <th class="py-2 px-2">번호</th>
                     <th class="">제목</th>
                     <th >날짜</th>
                     <!-- user_board_count -->
         
                  </tr>
                        <c:forEach items="${mboardList }" var="board" begin="0" end="5">
                           <!-- 프라퍼티이름 변경 -->
                           <tr class="main_td_sty">
                              <td align="center" class="py-2">${board.user_board_no}</td>
                              <td><a href="getBoard.do?user_board_no=${board.user_board_no }"  class="title_simple">${board.user_board_title }</a></td>
                              <td align="center">${board.user_board_start}</td>            
                           </tr>
                        </c:forEach>                     
                     </table>
                  </div>
            </div>
         </div>
      </div>

      <!-- <footer class="footer py-3">
         <div>푸터자리 푸터자리푸터자리푸터자리푸터자리푸터자리푸터자리푸터자리푸터자리푸터자리푸터자리푸터자리푸터자리</div>
         <div>@ Noti Footer</div>
      </footer> -->
   </div>
   </div>
<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/waypoints/2.0.3/waypoints.min.js"></script>
<script type="text/javascript" src="resources/js/jquery.counterup.min.js"></script>

<script type="text/javascript">
$(".title_simple").each(function(){

    var length = 35; //표시할 글자수 정하기

    $(this).each(function(){

        if( $(this).text().length >= length ){

            $(this).text( $(this).text().substr(0,length)+'...') 
            //지정할 글자수 이후 표시할 텍스트

        }

    });

});
</script>

</body>


</html>
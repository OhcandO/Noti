<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
   language="java"%>
<%-- <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%> --%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>

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
            <div class="col-lg-3 col-12 sub_menu_click main-font-color  py-2" onclick="location.href='http://localhost:8888/noti/getinfoBoardList.do'">
               공지사항
            </div> 
            <div class="col-lg-3 col-12 sub_menu_none py-2" onclick="location.href='http://localhost:8888/noti/getBoardList.do'">
               자유게시판
            </div>
            <div class="col-lg-3 col-12 sub_menu_none py-2" onclick="location.href='http://localhost:8888/noti/getTopSearch.do'">
               인기검색어
            </div>
            <div class="col-lg-3 col-12 sub_menu_none py-2" onclick="location.href='http://localhost:8888/noti/getNotiInfo.do'">
               노티소개
            </div>
         </div>
      </div>

      <div class="container mt-5">
         <input class="form-control-sm border-radius-0 float-right mb-3" id="myInput" type="text" placeholder="공지사항 검색하기">
         <table class="table" id="infoboardList">
            <tr class="text-center">
               <th>번호</th>
               <th class="w-50">제목</th>
               <th>그룹번호</th>
               <!-- user_id -->
               <th>날짜</th>
               <!-- user_board_start -->
               <th>추천수</th>
               <th>조회수</th>
               <!-- user_board_count -->

            </tr>
            <tbody id="myTable">
               <c:forEach items="${getinfoBoardList}" var="infoboard">
                  <!-- 프라퍼티이름 변경 -->
                  <tr>
                     <td align="center">${infoboard.info_board_no}</td>
                     <td align=""><a
                        href="getinfoBoard.do?info_board_no=${infoboard.info_board_no }">${infoboard.info_board_title }</a></td>
                     <td align="center">${infoboard.cat_small_group_name }</td>
                     <td><fmt:formatDate value="${infoboard.info_board_start}" pattern="yyyy.MM.dd" /></td>
                     <td align="center">${infoboard.info_board_like }</td>
                     <td align="center">${infoboard.info_board_count }</td>
   
                  </tr>
               </c:forEach>
            </tbody>

         </table>
         <div class="text-center my-2" style="margin:0 auto; width:275px;">
            <ul class="float-left-dddd">
               <c:if test="${pageMaker.prev}">
                  <li class="float-left-dddd"><a href="getinfoBoardList${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a></li>
               </c:if>

               <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
                  <li class="float-left-dddd"><a href="getinfoBoardList${pageMaker.makeQuery(idx)}">${idx}</a></li>
               </c:forEach>

               <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
                  <li class="float-left-dddd"><a href="getinfoBoardList${pageMaker.makeQuery(pageMaker.endPage + 1)}">다음</a></li>
               </c:if>
            </ul>
         </div>
      </div>
   </div>
   
   <br>

   <script>
      function openCity(cityName, elmnt, color) {
         var i, tabcontent, tablinks;
         tabcontent = document.getElementsByClassName("tabcontent");
         for (i = 0; i < tabcontent.length; i++) {
            tabcontent[i].style.display = "none";
         }
         tablinks = document.getElementsByClassName("tablink");
         for (i = 0; i < tablinks.length; i++) {
            tablinks[i].style.backgroundColor = "";
         }
         document.getElementById(cityName).style.display = "block";
         elmnt.style.backgroundColor = color;

      }
      // Get the element with id="defaultOpen" and click on it
      document.getElementById("defaultOpen").click();
   </script>
   
   <script type="text/javascript">
      $(document).ready(function(){
        $("#myInput").on("keyup", function() {
          var value = $(this).val().toLowerCase();
          $("#myTable tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
          });
        });
      });
   </script>
</body>
</html>
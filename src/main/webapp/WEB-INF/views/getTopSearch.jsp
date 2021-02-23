<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
   language="java"%>
<%-- <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%> --%>

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

<!-- 추가 클릭시 이동 -->
<script src= "resources/js/js_topClick.js" type="text/javascript"></script>
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
            <img alt="bg" src="resources/images/top_board.png" class="w-100">
         </div>
         
         <div class="row text-center font-weight-600 font-color-white pointer">
			<div class="col-lg-3 col-12 sub_menu_none py-2" onclick="location.href='http://localhost:8888/noti/getinfoBoardList.do'">
				공지사항
			</div> 
			<div class="col-lg-3 col-12 sub_menu_none py-2" onclick="location.href='http://localhost:8888/noti/getBoardList.do'">
				자유게시판
			</div>
			<div class="col-lg-3 col-12 sub_menu_click main-font-color py-2" onclick="location.href='http://localhost:8888/noti/getTopSearch.do'">
				인기검색어
			</div>
			<div class="col-lg-3 col-12 sub_menu_none py-2" onclick="location.href='http://localhost:8888/noti/getNotiInfo.do'">
				노티소개
			</div>
		</div>
      </div>
      <div class="">
         <div class="container pt-5">
            <div class="row">
               <div class="col-lg-4">                  
                  <div class="border shadow-sm p-3">
                     <div class="font-sty-1 text-center font-size-15 main-font-color">
                        N<span style="color:#9ec9d0">o</span>ti <span>일간 인기검색어</span>
                     </div>
                     <div class="text-center mt-2 " >
                        
                     </div>
                     <div id="d-day" class="text-center font-color-white" style="background-color:#9ec9d0"></div>
                     <table class="w-100 mt-3" id="infoboardList">
                        <tr class="text-center main_td_sty" style="border-top:1px solid #9ec9d0">
                           <th>순위</th>
                           <th class="py-1">검색어</th>
                           <th class="">검색 횟수</th>         
                        </tr>
                        <tbody id="myTable">
                           <c:forEach items="${getTopSearchday}" var="texx"  begin="0" end="9" varStatus="status">
                              <!-- 프라퍼티이름 변경 -->
                              <tr class="main_td_sty">
                                 <td class="py-1 font-color-white" align="center" style="background-color:#9ec9d0">                              
                                    ${status.count}                     
                                 </td >
                                 <td class="pl-2 font-weight-600"><a class="serachToss" style="cursor:pointer">${texx.text}</a></td>
                                 <td class="text-center">${texx.count}</td>            
                              </tr>
                           </c:forEach>
                        </tbody>
            
                     </table>
                  </div>
               </div>
               <div class="col-lg-4">                  
                  <div class="border shadow-sm p-3">
                     <div class="font-sty-1 text-center font-size-15 main-font-color">
                        N<span style="color:#9ec9d0">o</span>ti <span>주간 인기검색어</span>
                     </div>
                     <div class="text-center mt-2 " >
                        
                     </div>
                     <div class="text-center font-color-white" style="background-color:#9ec9d0">
                        <span id="d-week"></span> - <span id="d-week-d"></span>
                     </div>
                     <table class="w-100 mt-3" id="infoboardList">
                        <tr class="text-center main_td_sty" style="border-top:1px solid #9ec9d0">
                           <th>순위</th>
                           <th class="py-1">검색어</th>
                           <th class="">검색 횟수</th>         
                        </tr>
                        <tbody id="myTable">
                           <c:forEach items="${getTopSearchweek}" var="texx"  begin="0" end="9" varStatus="status">
                              <!-- 프라퍼티이름 변경 -->
                              <tr class="main_td_sty">
                                 <td class="py-1 font-color-white" align="center" style="background-color:#9ec9d0">                              
                                    ${status.count}                     
                                 </td >
                                 <td class="pl-2 font-weight-600"><a class="serachToss" style="cursor:pointer">${texx.text}</a></td>
                                 <td class="text-center">${texx.count}</td>            
                              </tr>
                           </c:forEach>
                        </tbody>
            
                     </table>
                  </div>
               </div>
               <div class="col-lg-4">                  
                  <div class="border shadow-sm p-3">
                     <div class="font-sty-1 text-center font-size-15 main-font-color">
                        N<span style="color:#9ec9d0">o</span>ti <span>월간 인기검색어</span>
                     </div>
                     <div class="text-center mt-2 " >
                        
                     </div>
                     <div class="text-center font-color-white" style="background-color:#9ec9d0">
                        <span >2021년 02월 01일</span> - <span id="d-mon-d"></span>
                     </div>
                     <table class="w-100 mt-3" id="infoboardList">
                        <tr class="text-center main_td_sty" style="border-top:1px solid #9ec9d0">
                           <th>순위</th>
                           <th class="py-1">검색어</th>
                           <th class="">검색 횟수</th>         
                        </tr>
                        <tbody id="myTable">
                           <c:forEach items="${getTopSearchmonth}" var="texx"  begin="0" end="9" varStatus="status">
                              <!-- 프라퍼티이름 변경 -->
                              <tr class="main_td_sty">
                                 <td class="py-1 font-color-white" align="center" style="background-color:#9ec9d0">                              
                                    ${status.count}                     
                                 </td >
                                 <td class="pl-2 font-weight-600"><a class="serachToss" style="cursor:pointer">${texx.text}</a></td>
                                 <td class="text-center">${texx.count}</td>            
                              </tr>
                           </c:forEach>
                        </tbody>
            
                     </table>
                  </div>
               </div>
            </div>
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
   
   <script type="text/javascript">
      var now = new Date();        
      
      var nowYear = now.getFullYear();
      
      var nowMonth = now.getMonth() + 1; 
      var nowDate = now.getDate();
      var nowHour = now.getHours();
      var nowMt = now.getMinutes();
      var nowSc = now.getSeconds();
      
      document.getElementById("d-day").innerHTML =nowYear + '년 ' + nowMonth + '월 ' + nowDate + '일 ' 
    </script>
    
    <!-- 주간달력 -->
    <script type="text/javascript">
      var now = new Date();        
      
      var nowYear = now.getFullYear();
      
      var nowMonth = now.getMonth() + 1; 
      var nowDate = now.getDate()-7;
      var nowHour = now.getHours();
      var nowMt = now.getMinutes();
      var nowSc = now.getSeconds();
      
      document.getElementById("d-week").innerHTML =nowYear + '년 ' + nowMonth + '월 ' + nowDate + '일 ' 
    </script>
    
    <script type="text/javascript">
      var now = new Date();        
      
      var nowYear = now.getFullYear();
      
      var nowMonth = now.getMonth() + 1; 
      var nowDate = now.getDate();
      var nowHour = now.getHours();
      var nowMt = now.getMinutes();
      var nowSc = now.getSeconds();
      
      document.getElementById("d-week-d").innerHTML =nowYear + '년 ' + nowMonth + '월 ' + nowDate + '일 ' 
    </script>
    
    <!-- 월간달력 -->
    <script type="text/javascript">
      var now = new Date();        
      
      var nowYear = now.getFullYear();
      
      var nowMonth = now.getMonth() + 1; 
      var nowDate = now.getDate()-30;
      var nowHour = now.getHours();
      var nowMt = now.getMinutes();
      var nowSc = now.getSeconds();
      
      document.getElementById("d-mon").innerHTML =nowYear + '년 ' + nowMonth + '월 ' + nowDate + '일 ' 
    </script>
    
    <script type="text/javascript">
      var now = new Date();        
      
      var nowYear = now.getFullYear();
      
      var nowMonth = now.getMonth() + 1; 
      var nowDate = now.getDate();
      var nowHour = now.getHours();
      var nowMt = now.getMinutes();
      var nowSc = now.getSeconds();
      
      document.getElementById("d-mon-d").innerHTML =nowYear + '년 ' + nowMonth + '월 ' + nowDate + '일 ' 
    </script>




</body>
</html>
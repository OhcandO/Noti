package com.ncs.noti.scheduled;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.ncs.noti.board.VO.infoBoardVO;
import com.ncs.noti.board.service.infoBoardService;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@Service
public class crawling {
   @Autowired
   infoBoardService infoboardService;

   int Maxpage = 2;

//@Scheduled(cron = "*/60 * * * * *") // @Scheduled(cron="0 10 9 * * *")
   @Scheduled(cron="0 10 9 * * *")
   public void TestScheduler() {
      java.util.Calendar calendar = java.util.Calendar.getInstance();
      java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      System.out.println("현재 시각: " + dateFormat.format(calendar.getTime()));
      eeeee();
   }

   public void eeeee() {
      // 크롤링 한번에 몇 다 긁어오는 버전
      // 스케쥴에선 하루에 한페이지에서 오늘의 날짜 값만 가져옴
      //9시 10분 경 사이트 들려서 가져옴
      kywa_or_kr();
      daegon_go();
      youth_seoul();
      daejeon_on_youth();
   }

   private void kywa_or_kr() {
      int sum = 0;
      for (int i = 1; i < Maxpage; i++) {
         String URL = "https://www.kywa.or.kr/pressinfo/notice_list.jsp?code=null&currPage=" + i
               + "&searchColumn=&searchText=&cate=";
         System.out.println(URL);

         String text = null;
         String date = null;
         String content = "";
         try {
            // 2. Connection 생성
            Connection conn = Jsoup.connect(URL);

            // 3. HTML 파싱.
            Document html = conn.get(); // conn.post();

            // 불러온 html이 맞는 페이지인지 확인
            if (html.hasText()) {
               // 데이터 저장 배열
               ArrayList<String> date_al = new ArrayList<String>(); // 날짜 배열
               ArrayList<String> title_al = new ArrayList<String>(); // 제목 배열
               ArrayList<String> content_al = new ArrayList<String>(); // 내용 배열
               ArrayList<String> url_al = new ArrayList<String>(); // 내용 배열

//            // System.out.println("*****************공고일");
               Elements files = html.select("table.t-type02 tbody tr:nth-child(n+6) td:nth-child(4)");
               for (Element elm : files) {
                  date = elm.text();
                  date_al.add(date);
               }

               Elements title = html.select("table.t-type02 tbody tr:nth-child(n+6) td:nth-child(2) a");
               for (Element elm : title) {
                  // System.out.println("*****************제목");
                  text = elm.text();
                  String href = elm.attr("href");

                  // 다음 페이지 가져오기
                  conn = Jsoup.connect("https://www.kywa.or.kr/pressinfo/" + href);
                  html = conn.get(); // conn.post();

                  files = html.select("div div.sub-border-con01 p");
                  for (Element elme : files) {
                     // System.out.println("안의 내용");
                     content += "<p>"
                           + elme.html().replace("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "")
                           + "</p>";
                  }
                  url_al.add(href);
                  title_al.add(text);
                  content_al.add(content);
                  content = "";
               }
               System.out.println();
               System.out.println(title_al.size());
               for (int j = 0; j < title_al.size(); j++) {
                  infoBoardVO vo = new infoBoardVO();
                  SimpleDateFormat tF = new SimpleDateFormat("yyyy-MM-dd");
                  Date today = new Date();
                  if ((date_al.get(j)).equals(tF.format(today))) {
                     if (content_al.get(j).length() < 3000) {
                        vo.setInfo_board_content(content_al.get(j)); //1
                     } else {
                        vo.setInfo_board_content(content_al.get(j).substring(0, 3000)); //1
                     }
                     // url
                     vo.setInfo_board_start(tF.parse(date_al.get(j))); //2
                     vo.setInfo_board_title(title_al.get(j)); //3
                     vo.setInfo_board_url("https://www.kywa.or.kr/pressinfo/" + url_al.get(j)); //4
                     vo.setCat_small_group_no(5); //5
                     System.out.println("오늘입니다. 파싱 ㄱㄱ");
                     System.out.println("today : " + tF.format(today));
                     System.out.println("tF.parse(date_al.get(j) : " + (date_al.get(j)));
                     infoboardService.insertinfoBoard(vo);
                  } else {
                     System.out.println("지난건 안됨");
                     System.out.println("today : " + tF.format(today));
                     System.out.println("tF.parse(date_al.get(j) : " + (date_al.get(j)));
                  }
               }
            } else {
               System.out.println("잘못된 페이지");

            }
         } catch (IOException e) {
            System.out.println("에러1");
            e.printStackTrace();
         } catch (ParseException e) {
            System.out.println("에러2");
            e.printStackTrace();
         }

      }
   }

   private void daejeon_on_youth() {
      int sum = 0;

      String URL = "https://daejeonyouth.co.kr/bbs/board.php?bo_table=suitrental_notify";
      System.out.println(URL);

      String text = null;
      String date = null;
      String content = "";
      try {
         // 2. Connection 생성
         Connection conn = Jsoup.connect(URL);

         // 3. HTML 파싱.
         Document html = conn.get(); // conn.post();

         // 불러온 html이 맞는 페이지인지 확인
         if (html.hasText()) {
            // 데이터 저장 배열
            ArrayList<String> date_al = new ArrayList<String>(); // 날짜 배열
            ArrayList<String> title_al = new ArrayList<String>(); // 제목 배열
            ArrayList<String> content_al = new ArrayList<String>(); // 내용 배열
            ArrayList<String> url_al = new ArrayList<String>(); // 내용 배열

            // System.out.println("*****************공고일");
            Elements files = html.select("table tbody tr td:nth-child(3)");
            for (Element elm : files) {
               date = elm.text();
               date_al.add(date);
            }

            Elements title = html.select("table tbody tr td:nth-child(2) a");
            for (Element elm : title) {
               // System.out.println("*****************제목");
               text = elm.text();
               String href = elm.attr("href");

               // 다음 페이지 가져오기
               conn = Jsoup.connect(href);
               html = conn.get(); // conn.post();

               files = html.select("div.view-content p");
               for (Element elme : files) {
                  // System.out.println("안의 내용");
                  content += "<p>" + elme.html().replace("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "")
                        + "</p>";
               }
               url_al.add(href);
               title_al.add(text);
               content_al.add(content);
               content = "";
            }
            System.out.println();

            for (int j = 0; j < title_al.size(); j++) {
               infoBoardVO vo = new infoBoardVO();
               SimpleDateFormat tF = new SimpleDateFormat("yyyy.MM.dd");
               Date today = new Date();
               if ((date_al.get(j)).equals(tF.format(today))) {
                  if (content_al.get(j).length() < 3000) {
                     vo.setInfo_board_content(content_al.get(j));
                  } else {
                     vo.setInfo_board_content(content_al.get(j).substring(0, 3000));
                  }
                  // url
                  vo.setInfo_board_start(tF.parse(date_al.get(j)));
                  vo.setInfo_board_title(title_al.get(j));
                  vo.setInfo_board_url(url_al.get(j));
                  vo.setCat_small_group_no(5);
                  System.out.println("오늘입니다. 파싱 ㄱㄱ");
                  System.out.println("today : " + tF.format(today));
                  System.out.println("tF.parse(date_al.get(j) : " + (date_al.get(j)));
                  infoboardService.insertinfoBoard(vo);
               } else {
                  System.out.println("지난건 안됨");
                  System.out.println("today : " + tF.format(today));
                  System.out.println("tF.parse(date_al.get(j) : " + (date_al.get(j)));
               }
            }
         }
      } catch (IOException e) {
         System.out.println("에러1");
         e.printStackTrace();
      } catch (ParseException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

   private void daegon_go() {
      int sum = 0;
      for (int i = 1; i < Maxpage; i++) {
         if (i == 39) {
            i++;
         }
         String URL = "https://daejeon.go.kr/drh/board/boardNormalList.do?pageIndex=" + i
               + "&boardId=normal_0096&searchCondition=&searchKeyword=&categorySeq=&menuSeq=1631";
         System.out.println(URL);

         String text = null;
         String date = null;
         String content = "";
         try {
            // 2. Connect ion 생성
            Connection conn = Jsoup.connect(URL);

            // 3. HTML 파싱.
            Document html = conn.get(); // conn.post();

            // 데이터 저장 배열
            ArrayList<String> date_al = new ArrayList<String>(); // 날짜 배열
            ArrayList<String> title_al = new ArrayList<String>(); // 제목 배열
            ArrayList<String> content_al = new ArrayList<String>(); // 내용 배열
            ArrayList<String> url_al = new ArrayList<String>(); // 내용 배열

            // System.out.println("*****************공고일");
            Elements files = html.select("td.date");
            for (Element elm : files) {
               date = elm.text();

               date_al.add(date);
            }

            Elements title = html.select("td.al_left a");
            for (Element elm : title) {
               // System.out.println("*****************제목");
               text = elm.text();

               String href = elm.attr("href");

               // 다음 페이지 가져오기
               conn = Jsoup.connect("https://daejeon.go.kr/" + href);
               html = conn.get(); // conn.post();

               files = html.select("div.board_txt p");
               for (Element elme : files) {
                  // System.out.println("안의 내용");
                  content += "<p>" + elme.html().replace("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "")
                        + "</p>";
               }
               url_al.add("https://daejeon.go.kr/" + href);
               title_al.add(text);
               content_al.add(content);
               content = "";
            }
            System.out.println();

            for (int j = 0; j < title_al.size(); j++) {
               infoBoardVO vo = new infoBoardVO();
               SimpleDateFormat tF = new SimpleDateFormat("yyyy-MM-dd");
               Date today = new Date();
               if ((date_al.get(j)).equals(tF.format(today))) {
                  if (content_al.get(j).length() < 3000) {
                     vo.setInfo_board_content(content_al.get(j));
                  } else {
                     vo.setInfo_board_content(content_al.get(j).substring(0, 3000));
                  }
                  // url
                  vo.setInfo_board_start(tF.parse(date_al.get(j)));
                  vo.setInfo_board_title(title_al.get(j));
                  vo.setInfo_board_url(url_al.get(j));
                  vo.setCat_small_group_no(5);
                  System.out.println("오늘입니다. 파싱 ㄱㄱ");
                  System.out.println("today : " + tF.format(today));
                  System.out.println("tF.parse(date_al.get(j) : " + (date_al.get(j)));
                  infoboardService.insertinfoBoard(vo);
               } else {
                  System.out.println("지난건 안됨");
                  System.out.println("today : " + tF.format(today));
                  System.out.println("tF.parse(date_al.get(j) : " + (date_al.get(j)));
               }
            }
         } catch (IOException e) {
            System.out.println("에러1");
            e.printStackTrace();
         } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
   }

   private void youth_seoul() {
      for (int i = 1; i < Maxpage; i++) {
         String URL = "https://youth.seoul.go.kr/site/main/board/notice/list?cp=" + i
               + "&sortOrder=BA_REGDATE&sortDirection=DESC&bcId=notice&baCategory1=basic&baNotice=false&baCommSelec=true&baOpenDay=true&baUse=true";
         System.out.println(URL);

         String text = null;
         String date = null;
         String content = "";
         try {
            // 2. Connection 생성
            Connection conn = Jsoup.connect(URL);

            // 3. HTML 파싱.
            Document html = conn.get(); // conn.post();

            // 데이터 저장 배열
            ArrayList<String> date_al = new ArrayList<String>(); // 날짜 배열
            ArrayList<String> title_al = new ArrayList<String>(); // 제목 배열
            ArrayList<String> content_al = new ArrayList<String>(); // 내용 배열
            ArrayList<String> url_al = new ArrayList<String>(); // 내용 배열

            // class 탐색

            // System.out.println("*****************공고일");
            Elements files = html.select("table tr td:nth-child(3)");
            for (Element elm : files) {
               date = elm.text();

               date_al.add(date);
            }

            Elements title = html.select(".tlt a");
            for (Element elm : title) {
               // System.out.println("*****************제목");
               text = elm.text();

               String href = elm.attr("href");

               // 다음 페이지 가져오기
               conn = Jsoup.connect("https://youth.seoul.go.kr/" + href);
               html = conn.get(); // conn.post();

               files = html.select("table tbody tr:nth-child(4) td p");
               for (Element elme : files) {
                  // System.out.println("안의 내용");
                  content += "<p>" + elme.html().replace("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "")
                        + "</p>";

               }
               url_al.add("https://youth.seoul.go.kr/" + href);
               title_al.add(text);
               content_al.add(content);
               content = "";
            }
            System.out.println();

            for (int j = 0; j < title_al.size(); j++) {
               infoBoardVO vo = new infoBoardVO();
               SimpleDateFormat tF = new SimpleDateFormat("yyyy-MM-dd");
               Date today = new Date();
               if ((date_al.get(j)).equals(tF.format(today))) {
                  if (content_al.get(j).length() < 3000) {
                     vo.setInfo_board_content(content_al.get(j));
                  } else {
                     vo.setInfo_board_content(content_al.get(j).substring(0, 3000));
                  }
                  // url

                  vo.setInfo_board_start(tF.parse(date_al.get(j)));

                  vo.setInfo_board_title(title_al.get(j));
                  vo.setInfo_board_url(url_al.get(j));
                  vo.setCat_small_group_no(5);
                  System.out.println("오늘입니다. 파싱 ㄱㄱ");
                  System.out.println("today : " + tF.format(today));
                  System.out.println("tF.parse(date_al.get(j) : " + (date_al.get(j)));
                  infoboardService.insertinfoBoard(vo);
               } else {
                  System.out.println("지난건 안됨");
                  System.out.println("today : " + tF.format(today));
                  System.out.println("tF.parse(date_al.get(j) : " + (date_al.get(j)));
               }
            }
         } catch (IOException e) {
            System.out.println("에러1");
            e.printStackTrace();
         } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
   }
}
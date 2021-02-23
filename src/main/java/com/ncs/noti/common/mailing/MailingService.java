package com.ncs.noti.common.mailing;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.jsoup.select.Evaluator.IsEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.ncs.noti.member.VO.MemberVO;

@Service("mailingService")
public class MailingService {

	@Autowired
	private MailingDAO mailingDAO;

	@Autowired
	JavaMailSenderImpl javaMailSender;

	/** 회원 가입 메일 */
	@Async // 비동기로 메일 발송
	public void welcomeMail(MemberVO vo) {
		MimeMessage message = javaMailSender.createMimeMessage();

		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

			// 제목
			messageHelper.setSubject("[NOTI]노티 가입을 축하드립니다!");

			// To 설정
			messageHelper.setTo(vo.getUser_email());

			// 내용 html
			String htmlStr = "<table class=\"wrapper\"\r\n"
					+ "    style=\"border-collapse: collapse;table-layout: fixed;min-width: 320px;width: 100%;background-color: #fff;\"\r\n"
					+ "    cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\">\r\n" + "    <tbody>\r\n"
					+ "      <tr>\r\n" + "        <td>\r\n" + "          <div role=\"banner\">\r\n"
					+ "            <div class=\"preheader\"\r\n"
					+ "              style=\"Margin: 0 auto;max-width: 560px;min-width: 280px; width: 280px;width: calc(28000% - 167440px);\">\r\n"
					+ "              <div style=\"border-collapse: collapse;display: table;width: 100%;\">\r\n"
					+ "                <!--[if (mso)|(IE)]><table align=\"center\" class=\"preheader\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\"><tr><td style=\"width: 280px\" valign=\"top\"><![endif]-->\r\n"
					+ "                <div class=\"snippet\"\r\n"
					+ "                  style=\"display: table-cell;Float: left;font-size: 12px;line-height: 19px;max-width: 280px;min-width: 140px; width: 140px;width: calc(14000% - 78120px);padding: 10px 0 5px 0;color: #363f48;font-family: Karla,Calibri,Geneva,sans-serif;\">\r\n"
					+ "\r\n" + "                </div>\r\n"
					+ "                <!--[if (mso)|(IE)]></td><td style=\"width: 280px\" valign=\"top\"><![endif]-->\r\n"
					+ "                <div class=\"webversion\"\r\n"
					+ "                  style=\"display: table-cell;Float: left;font-size: 12px;line-height: 19px;max-width: 280px;min-width: 139px; width: 139px;width: calc(14100% - 78680px);padding: 10px 0 5px 0;text-align: right;color: #363f48;font-family: Karla,Calibri,Geneva,sans-serif;\">\r\n"
					+ "                  <p style=\"Margin-top: 0;Margin-bottom: 0;\">사진이 안보이세요? <webversion style=\"text-decoration: underline;\">\r\n"
					+ "                      여기를 클릭하세요</webversion>\r\n" + "                  </p>\r\n"
					+ "                </div>\r\n"
					+ "                <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n"
					+ "              </div>\r\n" + "            </div>\r\n" + "            <div class=\"header\"\r\n"
					+ "              style=\"Margin: 0 auto;max-width: 600px;min-width: 320px; width: 320px;width: calc(28000% - 167400px);\"\r\n"
					+ "              id=\"emb-email-header-container\">\r\n"
					+ "              <!--[if (mso)|(IE)]><table align=\"center\" class=\"header\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\"><tr><td style=\"width: 600px\"><![endif]-->\r\n"
					+ "              <div class=\"logo emb-logo-margin-box\"\r\n"
					+ "                style=\"font-size: 26px;line-height: 32px;Margin-top: 6px;Margin-bottom: 20px;color: #41637e;font-family: Avenir,sans-serif;Margin-left: 20px;Margin-right: 20px;\"\r\n"
					+ "                align=\"center\">\r\n"
					+ "                <div class=\"logo-center\" align=\"center\" id=\"emb-email-header\"><img\r\n"
					+ "                    style=\"display: block;height: auto;width: 100%;border: 0;max-width: 560px;\" src=\"https://i.esdrop.com/d/asqABhxis0.png\" alt=\"\" width=\"560\" /></div>\r\n"
					+ "              </div>\r\n"
					+ "              <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n" + "            </div>\r\n"
					+ "          </div>\r\n" + "          <div>\r\n"
					+ "            <div style=\"background-color: #ffffff;\">\r\n"
					+ "              <div class=\"layout one-col stack\"\r\n"
					+ "                style=\"Margin: 0 auto;max-width: 600px;min-width: 320px; width: 320px;width: calc(28000% - 167400px);overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;\">\r\n"
					+ "                <div class=\"layout__inner\" style=\"border-collapse: collapse;display: table;width: 100%;\">\r\n"
					+ "                  <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\"><tr class=\"layout-full-width\" style=\"background-color: #ffffff;\"><td class=\"layout__edges\">&nbsp;</td><td style=\"width: 600px\" class=\"w560\"><![endif]-->\r\n"
					+ "                  <div class=\"column\"\r\n"
					+ "                    style=\"text-align: left;color: #363f48;font-size: 16px;line-height: 24px;font-family: Karla,Calibri,Geneva,sans-serif;\">\r\n"
					+ "\r\n" + "                    <div style=\"Margin-left: 20px;Margin-right: 20px;\">\r\n"
					+ "                      <div style=\"mso-line-height-rule: exactly;mso-text-raise: 11px;vertical-align: middle;\">\r\n"
					+ "                        <h1\r\n"
					+ "                          style=\"Margin-top: 0;Margin-bottom: 0;font-style: normal;font-weight: normal;color: #363f48;font-size: 32px;line-height: 40px;font-family: Montserrat,DejaVu Sans,Verdana,sans-serif;\">\r\n"
					+ "                          <strong>회원 가입을 축하합니다!</strong></h1>\r\n"
					+ "                        <p style=\"Margin-top: 20px;Margin-bottom: 0;\">새로운 노티, "
					+ vo.getUser_name() + " 님 안녕하세요</p>\r\n"
					+ "                        <p style=\"Margin-top: 20px;Margin-bottom: 20px;\">Noti: the Notice 는 자유롭게 중/소규모 복지 정보를 공유하는 웹 플랫폼이에요.<br> 저희는 노티 여러분에게 <b>소</b>소하지만 손에 <b>확</b>실히 잡을 수 있는 <b>복</b>지 소식을 전해드리기 위해 힘쓸게요!</p>\r\n"
					+ "                        <p>아래에서는 Noti 에서 접할 수 있는 기능들을 알려드릴게요</p><i style=\"font-size: 14px;\">아니면 바로 가보셔도 좋아요!</i>\r\n"
					+ "                      </div>\r\n" + "                    </div>\r\n" + "\r\n"
					+ "                    <div style=\"Margin-left: 20px;Margin-right: 20px;\">\r\n"
					+ "                      <div class=\"btn btn--flat btn--large\" style=\"Margin-bottom: 20px;text-align: left;\">\r\n"
					+ "                        <![if !mso]><a\r\n"
					+ "                          style=\"border-radius: 4px;display: inline-block;font-size: 14px;font-weight: bold;line-height: 24px;padding: 12px 24px;text-align: center;text-decoration: none !important;transition: opacity 0.1s ease-in;color: #ffffff !important;background-color: #363f48;font-family: Karla, Calibri, Geneva, sans-serif;\"\r\n"
					+ "                          href=\"http://61.81.99.86:8888/noti\">NOTI 로 바로가기</a>\r\n"
					+ "                        <![endif]>\r\n"
					+ "                        <!--[if mso]><p style=\"line-height:0;margin:0;\">&nbsp;</p><v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" href=\"https://example.com\" style=\"width:201px\" arcsize=\"9%\" fillcolor=\"#363F48\" stroke=\"f\"><v:textbox style=\"mso-fit-shape-to-text:t\" inset=\"0px,11px,0px,11px\"><center style=\"font-size:14px;line-height:24px;color:#FFFFFF;font-family:Karla,Calibri,Geneva,sans-serif;font-weight:bold;mso-line-height-rule:exactly;mso-text-raise:4px\">SEE ALL OF OUR FEATURES</center></v:textbox></v:roundrect><![endif]-->\r\n"
					+ "                      </div>\r\n" + "                    </div>\r\n" + "\r\n"
					+ "                    <div style=\"Margin-left: 20px;Margin-right: 20px;\">\r\n"
					+ "                      <div style=\"mso-line-height-rule: exactly;line-height: 40px;font-size: 1px;\">&nbsp;</div>\r\n"
					+ "                    </div>\r\n" + "\r\n" + "                  </div>\r\n"
					+ "                  <!--[if (mso)|(IE)]></td><td class=\"layout__edges\">&nbsp;</td></tr></table><![endif]-->\r\n"
					+ "                </div>\r\n" + "              </div>\r\n" + "            </div>\r\n" + "\r\n"
					+ "            <div style=\"background-color: #004e64;\">\r\n"
					+ "              <div class=\"layout stack\"\r\n"
					+ "                style=\"Margin: 0 auto;max-width: 600px;min-width: 320px; width: 320px;width: calc(28000% - 167400px);overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;\">\r\n"
					+ "                <div class=\"layout__inner\" style=\"border-collapse: collapse;display: table;width: 100%;\">\r\n"
					+ "                  <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\"><tr class=\"layout-full-width\" style=\"background-color: #004e64;\"><td class=\"layout__edges\">&nbsp;</td><td style=\"width: 200px\" valign=\"top\" class=\"w160\"><![endif]-->\r\n"
					+ "                  <div class=\"column narrow\"\r\n"
					+ "                    style=\"text-align: left;color: #363f48;font-size: 16px;line-height: 24px;font-family: Karla,Calibri,Geneva,sans-serif;Float: left;max-width: 320px;min-width: 200px; width: 320px;width: calc(72200px - 12000%);\">\r\n"
					+ "\r\n" + "                    <div style=\"Margin-left: 20px;Margin-right: 20px;\">\r\n"
					+ "                      <div style=\"mso-line-height-rule: exactly;line-height: 40px;font-size: 1px;\">&nbsp;</div>\r\n"
					+ "                    </div>\r\n" + "\r\n"
					+ "                    <div style=\"Margin-left: 20px;Margin-right: 20px;\">\r\n"
					+ "                      <div style=\"font-size: 12px;font-style: normal;font-weight: normal;line-height: 19px;\"\r\n"
					+ "                        align=\"center\">\r\n"
					+ "                        <img style=\"border: 0;display: block;height: auto;width: 80%;max-width: 472px;\" alt=\"\"\r\n"
					+ "                          width=\"160\" src=\"https://i.esdrop.com/d/iLF5vx82sv.png\" />\r\n"
					+ "                      </div>\r\n" + "                    </div>\r\n" + "\r\n"
					+ "                  </div>\r\n"
					+ "                  <!--[if (mso)|(IE)]></td><td style=\"width: 400px\" valign=\"top\" class=\"w360\"><![endif]-->\r\n"
					+ "                  <div class=\"column wide\"\r\n"
					+ "                    style=\"text-align: left;color: #363f48;font-size: 16px;line-height: 24px;font-family: Karla,Calibri,Geneva,sans-serif;Float: left;max-width: 400px;min-width: 320px; width: 320px;width: calc(8000% - 47600px);\">\r\n"
					+ "\r\n" + "                    <div style=\"Margin-left: 20px;Margin-right: 20px;\">\r\n"
					+ "                      <div style=\"mso-line-height-rule: exactly;line-height: 40px;font-size: 1px;\">&nbsp;</div>\r\n"
					+ "                    </div>\r\n" + "\r\n"
					+ "                    <div style=\"Margin-left: 20px;Margin-right: 20px;\">\r\n"
					+ "                      <div style=\"mso-line-height-rule: exactly;mso-text-raise: 11px;vertical-align: middle;\">\r\n"
					+ "                        <h2\r\n"
					+ "                          style=\"Margin-top: 0;Margin-bottom: 0;font-style: normal;font-weight: normal;color: #363f48;font-size: 20px;line-height: 28px;font-family: Montserrat,DejaVu Sans,Verdana,sans-serif;\">\r\n"
					+ "                          <span style=\"color:#ffffff\"><strong>정책 게시판</strong></span></h2>\r\n"
					+ "                        <p style=\"Margin-top: 16px;Margin-bottom: 20px;\"><span style=\"color:#ffffff\">&#8226; 매일 업데이트 되는 복지정보<br />\r\n"
					+ "                            &#8226; 관심설정으로 내 리스트 만들기<br />\r\n"
					+ "                            &#8226; 댓글로 토론하는 자유로운 분위기<br />\r\n"
					+ "                            </span></p>\r\n" + "                      </div>\r\n"
					+ "                    </div>\r\n" + "\r\n"
					+ "                    <div style=\"Margin-left: 20px;Margin-right: 20px;\">\r\n"
					+ "                      <div style=\"mso-line-height-rule: exactly;line-height: 40px;font-size: 1px;\">&nbsp;</div>\r\n"
					+ "                    </div>\r\n" + "\r\n" + "                  </div>\r\n"
					+ "                  <!--[if (mso)|(IE)]></td><td class=\"layout__edges\">&nbsp;</td></tr></table><![endif]-->\r\n"
					+ "                </div>\r\n" + "              </div>\r\n" + "            </div>\r\n" + "\r\n"
					+ "            <div style=\"background-color: #5dd9c1;\">\r\n"
					+ "              <div class=\"layout stack\"\r\n"
					+ "                style=\"Margin: 0 auto;max-width: 600px;min-width: 320px; width: 320px;width: calc(28000% - 167400px);overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;\">\r\n"
					+ "                <div class=\"layout__inner\" style=\"border-collapse: collapse;display: table;width: 100%;\">\r\n"
					+ "                  <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\"><tr class=\"layout-full-width\" style=\"background-color: #5dd9c1;\"><td class=\"layout__edges\">&nbsp;</td><td style=\"width: 200px\" valign=\"top\" class=\"w160\"><![endif]-->\r\n"
					+ "                  <div class=\"column narrow\"\r\n"
					+ "                    style=\"text-align: left;color: #363f48;font-size: 16px;line-height: 24px;font-family: Karla,Calibri,Geneva,sans-serif;Float: left;max-width: 320px;min-width: 200px; width: 320px;width: calc(72200px - 12000%);\">\r\n"
					+ "\r\n" + "                    <div style=\"Margin-left: 20px;Margin-right: 20px;\">\r\n"
					+ "                      <div style=\"mso-line-height-rule: exactly;line-height: 40px;font-size: 1px;\">&nbsp;</div>\r\n"
					+ "                    </div>\r\n" + "\r\n"
					+ "                    <div style=\"Margin-left: 20px;Margin-right: 20px;\">\r\n"
					+ "                      <div style=\"font-size: 12px;font-style: normal;font-weight: normal;line-height: 19px;\"\r\n"
					+ "                        align=\"center\">\r\n"
					+ "                        <img style=\"border: 0;display: block;height: auto;width: 80%;max-width: 368px;\" alt=\"\"\r\n"
					+ "                          width=\"160\" src=\"https://i.esdrop.com/d/5kSoojcA7L.png\" />\r\n"
					+ "                      </div>\r\n" + "                    </div>\r\n" + "\r\n"
					+ "                  </div>\r\n"
					+ "                  <!--[if (mso)|(IE)]></td><td style=\"width: 400px\" valign=\"top\" class=\"w360\"><![endif]-->\r\n"
					+ "                  <div class=\"column wide\"\r\n"
					+ "                    style=\"text-align: left;color: #363f48;font-size: 16px;line-height: 24px;font-family: Karla,Calibri,Geneva,sans-serif;Float: left;max-width: 400px;min-width: 320px; width: 320px;width: calc(8000% - 47600px);\">\r\n"
					+ "\r\n" + "                    <div style=\"Margin-left: 20px;Margin-right: 20px;\">\r\n"
					+ "                      <div style=\"mso-line-height-rule: exactly;line-height: 40px;font-size: 1px;\">&nbsp;</div>\r\n"
					+ "                    </div>\r\n" + "\r\n"
					+ "                    <div style=\"Margin-left: 20px;Margin-right: 20px;\">\r\n"
					+ "                      <div style=\"mso-line-height-rule: exactly;mso-text-raise: 11px;vertical-align: middle;\">\r\n"
					+ "                        <h2\r\n"
					+ "                          style=\"Margin-top: 0;Margin-bottom: 0;font-style: normal;font-weight: normal;color: #363f48;font-size: 20px;line-height: 28px;font-family: Montserrat,DejaVu Sans,Verdana,sans-serif;\">\r\n"
					+ "                          <strong>인기 검색어</strong></h2>\r\n"
					+ "                        <p style=\"Margin-top: 16px;Margin-bottom: 20px;\">&#8226; 일/주/월간 핫 이슈는?<br />\r\n"
					+ "                          &#8226; 정책 게시판, 회원 게시판 인기 소식<br />\r\n"
					+ "                          &#8226; 복지 트렌드 여기서 찾아보세요<br />\r\n"
					+ "                          </p>\r\n" + "                      </div>\r\n"
					+ "                    </div>\r\n" + "\r\n"
					+ "                    <div style=\"Margin-left: 20px;Margin-right: 20px;\">\r\n"
					+ "                      <div style=\"mso-line-height-rule: exactly;line-height: 40px;font-size: 1px;\">&nbsp;</div>\r\n"
					+ "                    </div>\r\n" + "\r\n" + "                  </div>\r\n"
					+ "                  <!--[if (mso)|(IE)]></td><td class=\"layout__edges\">&nbsp;</td></tr></table><![endif]-->\r\n"
					+ "                </div>\r\n" + "              </div>\r\n" + "            </div>\r\n" + "\r\n"
					+ "            <div style=\"background-color: #91f9e5;\">\r\n"
					+ "              <div class=\"layout stack\"\r\n"
					+ "                style=\"Margin: 0 auto;max-width: 600px;min-width: 320px; width: 320px;width: calc(28000% - 167400px);overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;\">\r\n"
					+ "                <div class=\"layout__inner\" style=\"border-collapse: collapse;display: table;width: 100%;\">\r\n"
					+ "                  <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\"><tr class=\"layout-full-width\" style=\"background-color: #91f9e5;\"><td class=\"layout__edges\">&nbsp;</td><td style=\"width: 200px\" valign=\"top\" class=\"w160\"><![endif]-->\r\n"
					+ "                  <div class=\"column narrow\"\r\n"
					+ "                    style=\"text-align: left;color: #363f48;font-size: 16px;line-height: 24px;font-family: Karla,Calibri,Geneva,sans-serif;Float: left;max-width: 320px;min-width: 200px; width: 320px;width: calc(72200px - 12000%);\">\r\n"
					+ "\r\n" + "                    <div style=\"Margin-left: 20px;Margin-right: 20px;\">\r\n"
					+ "                      <div style=\"mso-line-height-rule: exactly;line-height: 40px;font-size: 1px;\">&nbsp;</div>\r\n"
					+ "                    </div>\r\n" + "\r\n"
					+ "                    <div style=\"Margin-left: 20px;Margin-right: 20px;\">\r\n"
					+ "                      <div style=\"font-size: 12px;font-style: normal;font-weight: normal;line-height: 19px;\"\r\n"
					+ "                        align=\"center\">\r\n"
					+ "                        <img style=\"border: 0;display: block;height: auto;width: 80%;max-width: 410px;\" alt=\"\"\r\n"
					+ "                          width=\"160\" src=\"https://i.esdrop.com/d/TzakKQHqGm.png\" />\r\n"
					+ "                      </div>\r\n" + "                    </div>\r\n" + "\r\n"
					+ "                  </div>\r\n"
					+ "                  <!--[if (mso)|(IE)]></td><td style=\"width: 400px\" valign=\"top\" class=\"w360\"><![endif]-->\r\n"
					+ "                  <div class=\"column wide\"\r\n"
					+ "                    style=\"text-align: left;color: #363f48;font-size: 16px;line-height: 24px;font-family: Karla,Calibri,Geneva,sans-serif;Float: left;max-width: 400px;min-width: 320px; width: 320px;width: calc(8000% - 47600px);\">\r\n"
					+ "\r\n" + "                    <div style=\"Margin-left: 20px;Margin-right: 20px;\">\r\n"
					+ "                      <div style=\"mso-line-height-rule: exactly;line-height: 40px;font-size: 1px;\">&nbsp;</div>\r\n"
					+ "                    </div>\r\n" + "\r\n"
					+ "                    <div style=\"Margin-left: 20px;Margin-right: 20px;\">\r\n"
					+ "                      <div style=\"mso-line-height-rule: exactly;mso-text-raise: 11px;vertical-align: middle;\">\r\n"
					+ "                        <h2\r\n"
					+ "                          style=\"Margin-top: 0;Margin-bottom: 0;font-style: normal;font-weight: normal;color: #363f48;font-size: 20px;line-height: 28px;font-family: Montserrat,DejaVu Sans,Verdana,sans-serif;\">\r\n"
					+ "                          <strong>통합 검색</strong></h2>\r\n"
					+ "                        <p style=\"Margin-top: 16px;Margin-bottom: 20px;\">&#8226; 정책/회원 게시판 모두에서 찾자<br />\r\n"
					+ "                          &#8226; 신속하게 반응하는 검색기능<br />\r\n"
					+ "                          &#8226; 검색 기록이 인기 검색어로 전환<br />\r\n"
					+ "                          </p>\r\n" + "                      </div>\r\n"
					+ "                    </div>\r\n" + "\r\n"
					+ "                    <div style=\"Margin-left: 20px;Margin-right: 20px;\">\r\n"
					+ "                      <div style=\"mso-line-height-rule: exactly;line-height: 40px;font-size: 1px;\">&nbsp;</div>\r\n"
					+ "                    </div>\r\n" + "\r\n" + "                  </div>\r\n"
					+ "                  <!--[if (mso)|(IE)]></td><td class=\"layout__edges\">&nbsp;</td></tr></table><![endif]-->\r\n"
					+ "                </div>\r\n" + "              </div>\r\n" + "            </div>\r\n" + "\r\n"
					+ "            <div class=\"layout one-col fixed-width stack\"\r\n"
					+ "              style=\"Margin: 0 auto;max-width: 600px;min-width: 320px; width: 320px;width: calc(28000% - 167400px);overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;\">\r\n"
					+ "              <div class=\"layout__inner\"\r\n"
					+ "                style=\"border-collapse: collapse;display: table;width: 100%;background-color: #ffffff;\">\r\n"
					+ "                <!--[if (mso)|(IE)]><table align=\"center\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\"><tr class=\"layout-fixed-width\" style=\"background-color: #ffffff;\"><td style=\"width: 600px\" class=\"w560\"><![endif]-->\r\n"
					+ "                <div class=\"column\"\r\n"
					+ "                  style=\"text-align: left;color: #363f48;font-size: 16px;line-height: 24px;font-family: Karla,Calibri,Geneva,sans-serif;\">\r\n"
					+ "\r\n" + "                  <div style=\"Margin-left: 20px;Margin-right: 20px;\">\r\n"
					+ "                    <div style=\"mso-line-height-rule: exactly;line-height: 60px;font-size: 1px;\">&nbsp;</div>\r\n"
					+ "                  </div>\r\n" + "\r\n"
					+ "                  <div style=\"Margin-left: 20px;Margin-right: 20px;\">\r\n"
					+ "                    <div style=\"mso-line-height-rule: exactly;mso-text-raise: 11px;vertical-align: middle;\">\r\n"
					+ "                      <h1\r\n"
					+ "                        style=\"Margin-top: 0;Margin-bottom: 0;font-style: normal;font-weight: normal;color: #363f48;font-size: 32px;line-height: 40px;font-family: Montserrat,DejaVu Sans,Verdana,sans-serif;text-align: center;\">\r\n"
					+ "                        <strong>서비스 운영이 궁금하세요?</strong></h1>\r\n"
					+ "                      <p style=\"Margin-top: 20px;Margin-bottom: 20px;text-align: center;\">Noti 프로젝트 팀은 노티들의 의견에 귀를 기울이고 있어요. <br/>허심탄회한 이야기를 기다리고 있을게요!</p>\r\n"
					+ "                    </div>\r\n" + "                  </div>\r\n" + "\r\n"
					+ "                  <div style=\"Margin-left: 20px;Margin-right: 20px;\">\r\n"
					+ "                    <div style=\"mso-line-height-rule: exactly;line-height: 10px;font-size: 1px;\">&nbsp;</div>\r\n"
					+ "                  </div>\r\n" + "\r\n"
					+ "                  <div style=\"Margin-left: 20px;Margin-right: 20px;\">\r\n"
					+ "                    <div class=\"btn btn--flat fullwidth btn--large\" style=\"Margin-bottom: 20px;text-align: center;\">\r\n"
					+ "                      <![if !mso]><a\r\n"
					+ "                        style=\"border-radius: 4px;display: block;font-size: 14px;font-weight: bold;line-height: 24px;padding: 12px 24px;text-align: center;text-decoration: none !important;transition: opacity 0.1s ease-in;color: #ffffff !important;background-color: #363f48;font-family: Karla, Calibri, Geneva, sans-serif;\"\r\n"
					+ "                        href=\"noti.the.notice@gmail.com\">Noti : the Notice 로 메일 보내기 </a>\r\n"
					+ "                      <![endif]>\r\n"
					+ "                      <!--[if mso]><p style=\"line-height:0;margin:0;\">&nbsp;</p><v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" href=\"https://example.com\" style=\"width:560px\" arcsize=\"9%\" fillcolor=\"#363F48\" stroke=\"f\"><v:textbox style=\"mso-fit-shape-to-text:t\" inset=\"0px,11px,0px,11px\"><center style=\"font-size:14px;line-height:24px;color:#FFFFFF;font-family:Karla,Calibri,Geneva,sans-serif;font-weight:bold;mso-line-height-rule:exactly;mso-text-raise:4px\">GET MORE INFO ON OUR HELPFUL FEATURES</center></v:textbox></v:roundrect><![endif]-->\r\n"
					+ "                    </div>\r\n" + "                  </div>\r\n" + "\r\n"
					+ "                  <div style=\"Margin-left: 20px;Margin-right: 20px;\">\r\n"
					+ "                    <div style=\"mso-line-height-rule: exactly;line-height: 60px;font-size: 1px;\">&nbsp;</div>\r\n"
					+ "                  </div>\r\n" + "\r\n" + "                </div>\r\n"
					+ "                <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n"
					+ "              </div>\r\n" + "            </div>\r\n" + "\r\n"
					+ "            <div style=\"mso-line-height-rule: exactly;line-height: 20px;font-size: 20px;\">&nbsp;</div>\r\n"
					+ "\r\n" + "          </div>\r\n" + "          <div role=\"contentinfo\">\r\n"
					+ "            <div class=\"layout email-footer stack\"\r\n"
					+ "              style=\"Margin: 0 auto;max-width: 600px;min-width: 320px; width: 320px;width: calc(28000% - 167400px);overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;\">\r\n"
					+ "              <div class=\"layout__inner\" style=\"border-collapse: collapse;display: table;width: 100%;\">\r\n"
					+ "                <!--[if (mso)|(IE)]><table align=\"center\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\"><tr class=\"layout-email-footer\"><td style=\"width: 400px;\" valign=\"top\" class=\"w360\"><![endif]-->\r\n"
					+ "                <div class=\"column wide\"\r\n"
					+ "                  style=\"text-align: left;font-size: 12px;line-height: 19px;color: #363f48;font-family: Karla,Calibri,Geneva,sans-serif;Float: left;max-width: 400px;min-width: 320px; width: 320px;width: calc(8000% - 47600px);\">\r\n"
					+ "                  <div style=\"Margin-left: 20px;Margin-right: 20px;Margin-top: 10px;Margin-bottom: 10px;\">\r\n"
					+ "                    <table class=\"email-footer__links\" style=\"border-collapse: collapse;table-layout: fixed;\"\r\n"
					+ "                      role=\"presentation\" emb-web-links>\r\n"
					+ "                      <tbody>\r\n" + "                        <tr role=\"navigation\">\r\n"
					+ "\r\n" + "                        </tr>\r\n" + "                      </tbody>\r\n"
					+ "                    </table>\r\n"
					+ "                    <div style=\"font-size: 12px;line-height: 19px;Margin-top: 20px;\">\r\n"
					+ "\r\n" + "                    </div>\r\n"
					+ "                    <div style=\"font-size: 12px;line-height: 19px;Margin-top: 18px;\">\r\n"
					+ "\r\n" + "                    </div>\r\n"
					+ "                    <!--[if mso]>&nbsp;<![endif]-->\r\n" + "                  </div>\r\n"
					+ "                </div>\r\n"
					+ "                <!--[if (mso)|(IE)]></td><td style=\"width: 200px;\" valign=\"top\" class=\"w160\"><![endif]-->\r\n"
					+ "                <div class=\"column narrow\"\r\n"
					+ "                  style=\"text-align: left;font-size: 12px;line-height: 19px;color: #363f48;font-family: Karla,Calibri,Geneva,sans-serif;Float: left;max-width: 320px;min-width: 200px; width: 320px;width: calc(72200px - 12000%);\">\r\n"
					+ "                  <div style=\"Margin-left: 20px;Margin-right: 20px;Margin-top: 10px;Margin-bottom: 10px;\">\r\n"
					+ "\r\n" + "                  </div>\r\n" + "                </div>\r\n"
					+ "                <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n"
					+ "              </div>\r\n" + "            </div>\r\n"
					+ "            <div class=\"layout one-col email-footer\"\r\n"
					+ "              style=\"Margin: 0 auto;max-width: 600px;min-width: 320px; width: 320px;width: calc(28000% - 167400px);overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;\">\r\n"
					+ "              <div class=\"layout__inner\" style=\"border-collapse: collapse;display: table;width: 100%;\">\r\n"
					+ "                <!--[if (mso)|(IE)]><table align=\"center\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\"><tr class=\"layout-email-footer\"><td style=\"width: 600px;\" class=\"w560\"><![endif]-->\r\n"
					+ "                <div class=\"column\"\r\n"
					+ "                  style=\"text-align: left;font-size: 12px;line-height: 19px;color: #363f48;font-family: Karla,Calibri,Geneva,sans-serif;\">\r\n"
					+ "                  <div style=\"Margin-left: 20px;Margin-right: 20px;Margin-top: 10px;Margin-bottom: 10px;\">\r\n"
					+ "                    <div style=\"font-size: 12px;line-height: 19px;\">\r\n"
					+ "                      <span>\r\n"
					+ "                      ※ 본 이메일은 Noti:the Notice 서비스에 가입한 새로운 노티들에게만 발송되는 메일입니다.  \r\n"
					+ "                      </span>\r\n" + "                      \r\n"
					+ "                    </div>\r\n" + "                  </div>\r\n" + "                </div>\r\n"
					+ "                <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n"
					+ "              </div>\r\n" + "            </div>\r\n" + "          </div>\r\n"
					+ "          <div style=\"line-height:40px;font-size:40px;\">&nbsp;</div>\r\n" + "        </td>\r\n"
					+ "      </tr>\r\n" + "    </tbody>\r\n" + "  </table>";
			// 내용설정
			messageHelper.setText(htmlStr, true);

			// 전송
			javaMailSender.send(message);

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	/** 주간 메일 */
	// 구독 설정한 회원에게 메일 전송. 주간 인기 검색어 + 회원 검색어 일람
	@Async
	public void weeklyMail(MemberVO vo) {


		MimeMessage message = javaMailSender.createMimeMessage();

		String user_id = "";

		if (vo != null) {

			// 주간 인기 검색어 들어갈 자리
			List<MailingVO> popular_textL = new ArrayList<MailingVO>();

			// 주간 인기 게시물 들어갈 자리
		List <MailingVO> popular_contentL = new ArrayList();

			// 주간 회원의 상위 3개 검색어에 대한 DB 검색 결과
		List <MailingVO> user_search_resultL = new ArrayList();

			user_id = vo.getUser_id();
			System.out.println("=========메일링 서비스 시작-==========");

			popular_textL.addAll(mailingDAO.getPopular_textL());
			popular_contentL.addAll(mailingDAO.getPopularContentL());
			user_search_resultL.addAll(mailingDAO.getUserSearchResultL(user_id));
			
			System.out.println("======------메일링 내용 작성 중------=====");

			try {
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

				// 제목
				messageHelper.setSubject("[NOTI]주간 노티");

				// To 설정
				messageHelper.setTo(vo.getUser_email());

				// 내용 html
				String htmlStr = "";

				htmlStr += "<!--[if !mso]><!-->\r\n" + 
						"<style type=\"text/css\">\r\n" + 
						"    @import url(https://fonts.googleapis.com/css?family=Roboto:400,700,400italic,700italic);\r\n" + 
						"</style>\r\n" + 
						"<link href=\"https://fonts.googleapis.com/css?family=Roboto:400,700,400italic,700italic\" rel=\"stylesheet\"\r\n" + 
						"    type=\"text/css\" />\r\n" + 
						"<!--<![endif]-->\r\n" + 
						"<style type=\"text/css\">\r\n" + 
						"    .main,\r\n" + 
						"    .mso {\r\n" + 
						"        background-color: #ecf3f5\r\n" + 
						"    }\r\n" + 
						"\r\n" + 
						"    .logo a:hover,\r\n" + 
						"    .logo a:focus {\r\n" + 
						"        color: #859bb1 !important\r\n" + 
						"    }\r\n" + 
						"\r\n" + 
						"    .mso .layout-has-border {\r\n" + 
						"        border-top: 1px solid #a9c9d2;\r\n" + 
						"        border-bottom: 1px solid #a9c9d2\r\n" + 
						"    }\r\n" + 
						"\r\n" + 
						"    .mso .layout-has-bottom-border {\r\n" + 
						"        border-bottom: 1px solid #a9c9d2\r\n" + 
						"    }\r\n" + 
						"\r\n" + 
						"    .mso .border,\r\n" + 
						"    .ie .border {\r\n" + 
						"        background-color: #a9c9d2\r\n" + 
						"    }\r\n" + 
						"\r\n" + 
						"    .mso h1,\r\n" + 
						"    .ie h1 {}\r\n" + 
						"\r\n" + 
						"    .mso h1,\r\n" + 
						"    .ie h1 {\r\n" + 
						"        font-size: 26px !important;\r\n" + 
						"        line-height: 34px !important\r\n" + 
						"    }\r\n" + 
						"\r\n" + 
						"    .mso h2,\r\n" + 
						"    .ie h2 {}\r\n" + 
						"\r\n" + 
						"    .mso h2,\r\n" + 
						"    .ie h2 {\r\n" + 
						"        font-size: 20px !important;\r\n" + 
						"        line-height: 28px !important\r\n" + 
						"    }\r\n" + 
						"\r\n" + 
						"    .mso h3,\r\n" + 
						"    .ie h3 {}\r\n" + 
						"\r\n" + 
						"    .mso .layout__inner,\r\n" + 
						"    .ie .layout__inner {}\r\n" + 
						"\r\n" + 
						"    .mso .footer__share-button p {}\r\n" + 
						"\r\n" + 
						"    .mso .footer__share-button p {\r\n" + 
						"        font-family: Roboto, Tahoma, sans-serif\r\n" + 
						"    }\r\n" + 
						"</style>\r\n" + 
						"<meta name=\"robots\" content=\"noindex,nofollow\" />\r\n" + 
						"<meta property=\"og:title\" content=\"My First Campaign\" />\r\n" + 
						"</head>\r\n" + 
						"<!--[if mso]>\r\n" + 
						"  <body class=\"mso\">\r\n" + 
						"<![endif]-->\r\n" + 
						"<!--[if !mso]><!-->\r\n" + 
						"\r\n" + 
						"<body class=\"main full-padding\" style=\"margin: 0;padding: 0;-webkit-text-size-adjust: 100%;\">\r\n" + 
						"    <!--<![endif]-->\r\n" + 
						"    <table class=\"wrapper\"\r\n" + 
						"        style=\"border-collapse: collapse;table-layout: fixed;min-width: 320px;width: 100%;background-color: #ecf3f5;\"\r\n" + 
						"        cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\">\r\n" + 
						"        <tbody>\r\n" + 
						"            <tr>\r\n" + 
						"                <td>\r\n" + 
						"                    <div role=\"banner\">\r\n" + 
						"                        <div class=\"preheader\"\r\n" + 
						"                          style=\"Margin: 0 auto;max-width: 560px;min-width: 280px; width: 280px;width: calc(28000% - 167440px);\">\r\n" + 
						"                          <div style=\"border-collapse: collapse;display: table;width: 100%;\">\r\n" + 
						"                            <!--[if (mso)|(IE)]><table align=\"center\" class=\"preheader\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\"><tr><td style=\"width: 280px\" valign=\"top\"><![endif]-->\r\n" + 
						"                            <div class=\"snippet\"\r\n" + 
						"                              style=\"display: table-cell;Float: left;font-size: 12px;line-height: 19px;max-width: 280px;min-width: 140px; width: 140px;width: calc(14000% - 78120px);padding: 10px 0 5px 0;color: #363f48;font-family: Karla,Calibri,Geneva,sans-serif;\">\r\n" + 
						"            \r\n" + 
						"                            </div>\r\n" + 
						"                            <!--[if (mso)|(IE)]></td><td style=\"width: 280px\" valign=\"top\"><![endif]-->\r\n" + 
						"                            <div class=\"webversion\"\r\n" + 
						"                              style=\"display: table-cell;Float: left;font-size: 12px;line-height: 19px;max-width: 280px;min-width: 139px; width: 139px;width: calc(14100% - 78680px);padding: 10px 0 5px 0;text-align: right;color: #363f48;font-family: Karla,Calibri,Geneva,sans-serif;\">\r\n" + 
						"                              <p style=\"Margin-top: 0;Margin-bottom: 0;\">사진이 안보이세요? <webversion style=\"text-decoration: underline;\">\r\n" + 
						"                                  여기를 클릭하세요</webversion>\r\n" + 
						"                              </p>\r\n" + 
						"                            </div>\r\n" + 
						"                            <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n" + 
						"                          </div>\r\n" + 
						"                        </div>\r\n" + 
						"                        <div class=\"header\"\r\n" + 
						"                          style=\"Margin: 0 auto;max-width: 600px;min-width: 320px; width: 320px;width: calc(28000% - 167400px);\"\r\n" + 
						"                          id=\"emb-email-header-container\">\r\n" + 
						"                          <!--[if (mso)|(IE)]><table align=\"center\" class=\"header\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\"><tr><td style=\"width: 600px\"><![endif]-->\r\n" + 
						"                          <div class=\"logo emb-logo-margin-box\"\r\n" + 
						"                            style=\"font-size: 26px;line-height: 32px;Margin-top: 6px;Margin-bottom: 20px;color: #41637e;font-family: Avenir,sans-serif;Margin-left: 20px;Margin-right: 20px;\"\r\n" + 
						"                            align=\"center\">\r\n" + 
						"                            <div class=\"logo-center\" align=\"center\" id=\"emb-email-header\"><img\r\n" + 
						"                                style=\"display: block;height: auto;width: 100%;border: 0;max-width: 560px;\" src=\"https://i.esdrop.com/d/asqABhxis0.png\" alt=\"\" width=\"560\" /></div>\r\n" + 
						"                          </div>\r\n" + 
						"                          <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n" + 
						"                        </div>\r\n" + 
						"                      </div>\r\n" + 
						"                    <div>\r\n" + 
						"                        <div style=\"background-color: #ecf3f5;\">\r\n" + 
						"                            <div class=\"layout two-col stack\"\r\n" + 
						"                                style=\"Margin: 0 auto;max-width: 600px;min-width: 320px; width: 320px;width: calc(28000% - 167400px);overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;\">\r\n" + 
						"                                <div class=\"layout__inner\"\r\n" + 
						"                                    style=\"border-collapse: collapse;display: table;width: 100%;\">\r\n" + 
						"                                    <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\"><tr class=\"layout-full-width\" style=\"background-color: #ecf3f5;\"><td class=\"layout__edges\">&nbsp;</td><td style=\"width: 300px\" valign=\"top\" class=\"w260\"><![endif]-->\r\n" + 
						"                                    <div class=\"column\"\r\n" + 
						"                                        style=\"text-align: left;color: #757575;font-size: 14px;line-height: 21px;font-family: Roboto,Tahoma,sans-serif;max-width: 320px;min-width: 300px; width: 320px;width: calc(12300px - 2000%);Float: left;\">\r\n" + 
						"\r\n" + 
						"                                        <div style=\"Margin-left: 20px;Margin-right: 20px;Margin-top: 24px;\">\r\n" + 
						"                                            <div\r\n" + 
						"                                                style=\"mso-line-height-rule: exactly;mso-text-raise: 11px;vertical-align: middle;\">\r\n" + 
						"                                                <h2\r\n" + 
						"                                                    style=\"Margin-top: 0;Margin-bottom: 0;font-style: normal;font-weight: normal;color: #557187;font-size: 17px;line-height: 26px;\">\r\n" + 
						"                                                    주간 인기 검색어</h2>\r\n" + 
						"                                                <p style=\"Margin-top: 16px;Margin-bottom: 20px;\">이번주엔 사람들이 무엇을 주로 검색했을까요? Noti가 선별한 HOT한 검색어를 만나보세요!\r\n" + 
						"                                                </p>\r\n" + 
						"                                                <table style=\"width: 300px;\">\r\n" + 
			//TODO 주간 인기 검색어
						"                                                    <tr style=\"font-size: 12px; text-align: left;\"> <th>검색어</th> <th>빈도</th> </tr>\r\n" ;
								
				for (MailingVO v : popular_textL) {
					htmlStr += "<tr style='font-size:8px;'>"
							+ "<td>"+ v.getText()+"</td>";
					htmlStr += "<td>"+v.getCount()+"</td>"
							+ "</tr>";
				}
				
				htmlStr+="</table>" + 
						"                                            </div>\r\n" + 
						"                                        </div>\r\n" + 
						"\r\n" + 
						"                                        <div style=\"Margin-left: 20px;Margin-right: 20px;Margin-bottom: 24px;\">\r\n" + 
						"                                            <div style=\"mso-line-height-rule: exactly;line-height: 5px;font-size: 1px;\">\r\n" + 
						"                                                &nbsp;</div>\r\n" + 
						"                                        </div>\r\n" + 
						"\r\n" + 
						"                                    </div>\r\n" + 
						"                                    <!--[if (mso)|(IE)]></td><td style=\"width: 300px\" valign=\"top\" class=\"w260\"><![endif]-->\r\n" + 
						"                                    <div class=\"column\"\r\n" + 
						"                                        style=\"text-align: left;color: #757575;font-size: 14px;line-height: 21px;font-family: Roboto,Tahoma,sans-serif;max-width: 320px;min-width: 300px; width: 320px;width: calc(12300px - 2000%);Float: left;\">\r\n" + 
						"\r\n" + 
						"                                        <div style=\"font-size: 12px;font-style: normal;font-weight: normal;line-height: 19px;\"\r\n" + 
						"                                            align=\"center\">\r\n" + 
						"                                            <img style=\"border: 0;display: block;height: auto;width: 100%;max-width: 182px;\"\r\n" + 
						"                                                alt=\"\" width=\"182\" src=\"https://i.esdrop.com/d/DJG3GuaIfY.png\" />\r\n" + 
						"                                        </div>\r\n" + 
						"\r\n" + 
						"                                        <div style=\"Margin-left: 20px;Margin-right: 20px;Margin-top: 20px;\">\r\n" + 
						"                                            <div style=\"mso-line-height-rule: exactly;line-height: 6px;font-size: 1px;\">\r\n" + 
						"                                                &nbsp;</div>\r\n" + 
						"                                        </div>\r\n" + 
						"\r\n" + 
						"                                        <div style=\"Margin-left: 20px;Margin-right: 20px;Margin-bottom: 24px;\">\r\n" + 
						"                                            <div class=\"btn btn--flat btn--large\" style=\"text-align:center;\">\r\n" + 
						"                                                <![if !mso]><a\r\n" + 
						"                                                    style=\"border-radius: 4px;display: inline-block;font-size: 14px;font-weight: bold;line-height: 24px;padding: 12px 24px;text-align: center;text-decoration: none !important;transition: opacity 0.1s ease-in;color: #ffffff !important;background-color: #557187;font-family: Roboto, Tahoma, sans-serif;\"\r\n" + 
						"                                                    href=\"http://61.81.99.86:8888/noti\">노티로 가기</a>\r\n" + 
						"                                                <![endif]>\r\n" + 
						"                                                <!--[if mso]><p style=\"line-height:0;margin:0;\">&nbsp;</p><v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" href=\"http://test.com\" style=\"width:176px\" arcsize=\"9%\" fillcolor=\"#557187\" stroke=\"f\"><v:textbox style=\"mso-fit-shape-to-text:t\" inset=\"0px,11px,0px,11px\"><center style=\"font-size:14px;line-height:24px;color:#FFFFFF;font-family:Roboto,Tahoma,sans-serif;font-weight:bold;mso-line-height-rule:exactly;mso-text-raise:4px\">View the roadmap</center></v:textbox></v:roundrect><![endif]-->\r\n" + 
						"                                            </div>\r\n" + 
						"                                        </div>\r\n" + 
						"\r\n" + 
						"                                    </div>\r\n" + 
						"                                    <!--[if (mso)|(IE)]></td><td class=\"layout__edges\">&nbsp;</td></tr></table><![endif]-->\r\n" + 
						"                                </div>\r\n" + 
						"                            </div>\r\n" + 
						"                        </div>\r\n" + 
						"\r\n" + 
						"                        <div style=\"background-color: #ffffff;\">\r\n" + 
						"                            <div class=\"layout two-col stack\"\r\n" + 
						"                                style=\"Margin: 0 auto;max-width: 600px;min-width: 320px; width: 320px;width: calc(28000% - 167400px);overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;\">\r\n" + 
						"                                <div class=\"layout__inner\"\r\n" + 
						"                                    style=\"border-collapse: collapse;display: table;width: 100%;\">\r\n" + 
						"                                    <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\"><tr class=\"layout-full-width\" style=\"background-color: #ffffff;\"><td class=\"layout__edges\">&nbsp;</td><td style=\"width: 300px\" valign=\"top\" class=\"w260\"><![endif]-->\r\n" + 
						"                                    <div class=\"column\"\r\n" + 
						"                                        style=\"text-align: left;color: #757575;font-size: 14px;line-height: 21px;font-family: Roboto,Tahoma,sans-serif;max-width: 320px;min-width: 300px; width: 320px;width: calc(12300px - 2000%);Float: left;\">\r\n" + 
						"\r\n" + 
						"                                        <div style=\"Margin-left: 20px;Margin-right: 20px;Margin-top: 24px;\">\r\n" + 
						"                                            <div\r\n" + 
						"                                                style=\"mso-line-height-rule: exactly;line-height: 29px;font-size: 1px;\">\r\n" + 
						"                                                &nbsp;</div>\r\n" + 
						"                                        </div>\r\n" + 
						"\r\n" + 
						"                                        <div style=\"Margin-left: 20px;Margin-right: 20px;\">\r\n" + 
						"                                            <div style=\"mso-line-height-rule: exactly;line-height: 5px;font-size: 1px;\">\r\n" + 
						"                                                &nbsp;</div>\r\n" + 
						"                                        </div>\r\n" + 
						"\r\n" + 
						"                                        <div style=\"font-size: 12px;font-style: normal;font-weight: normal;line-height: 19px;\"\r\n" + 
						"                                            align=\"center\">\r\n" + 
						"                                            <img style=\"border: 0;display: block;height: auto;width: 100%;max-width: 221px;\"\r\n" + 
						"                                                alt=\"\" width=\"221\" src=\"https://i.esdrop.com/d/UsT8iXAPSF.png\" />\r\n" + 
						"                                        </div>\r\n" + 
						"\r\n" + 
						"                                        <div\r\n" + 
						"                                            style=\"Margin-left: 20px;Margin-right: 20px;Margin-top: 20px;Margin-bottom: 24px;\">\r\n" + 
						"                                            <div class=\"btn btn--flat btn--large\" style=\"text-align:center;\">\r\n" + 
						"                                                <![if !mso]><a\r\n" + 
						"                                                style=\"border-radius: 4px;display: inline-block;font-size: 14px;font-weight: bold;line-height: 24px;padding: 12px 24px;text-align: center;text-decoration: none !important;transition: opacity 0.1s ease-in;color: #ffffff !important;background-color: #557187;font-family: Roboto, Tahoma, sans-serif;\"\r\n" + 
						"                                                href=\"http://61.81.99.86:8888/noti\">GO TO NOTI</a>\r\n" + 
						"                                                <![endif]>\r\n" + 
						"                                                <!--[if mso]><p style=\"line-height:0;margin:0;\">&nbsp;</p><v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" href=\"http://test.com\" style=\"width:175px\" arcsize=\"9%\" fillcolor=\"#557187\" stroke=\"f\"><v:textbox style=\"mso-fit-shape-to-text:t\" inset=\"0px,11px,0px,11px\"><center style=\"font-size:14px;line-height:24px;color:#FFFFFF;font-family:Roboto,Tahoma,sans-serif;font-weight:bold;mso-line-height-rule:exactly;mso-text-raise:4px\">View your profiles</center></v:textbox></v:roundrect><![endif]-->\r\n" + 
						"                                            </div>\r\n" + 
						"                                        </div>\r\n" + 
						"\r\n" + 
						"                                    </div>\r\n" + 
						"                                    <!--[if (mso)|(IE)]></td><td style=\"width: 300px\" valign=\"top\" class=\"w260\"><![endif]-->\r\n" + 
						"                                    <div class=\"column\"\r\n" + 
						"                                        style=\"text-align: left;color: #757575;font-size: 14px;line-height: 21px;font-family: Roboto,Tahoma,sans-serif;max-width: 320px;min-width: 300px; width: 320px;width: calc(12300px - 2000%);Float: left;\">\r\n" + 
						"\r\n" + 
						"                                        <div style=\"Margin-left: 20px;Margin-right: 20px;Margin-top: 24px;\">\r\n" + 
						"                                            <div\r\n" + 
						"                                                style=\"mso-line-height-rule: exactly;line-height: 20px;font-size: 1px;\">\r\n" + 
						"                                                &nbsp;</div>\r\n" + 
						"                                        </div>\r\n" + 
						"\r\n" + 
						"                                        <div style=\"Margin-left: 20px;Margin-right: 20px;\">\r\n" + 
						"                                            <div\r\n" + 
						"                                                style=\"mso-line-height-rule: exactly;mso-text-raise: 11px;vertical-align: middle;\">\r\n" + 
						"                                                <h2\r\n" + 
						"                                                    style=\"Margin-top: 0;Margin-bottom: 0;font-style: normal;font-weight: normal;color: #557187;font-size: 17px;line-height: 26px;\">\r\n" + 
						"                                                    주간 인기 게시물</h2>\r\n" + 
						"                                                <p style=\"Margin-top: 16px;Margin-bottom: 20px;\">이번주에는 사람들이 어떤 게시물에 관심을 보였을까요? Noti에서 확인하세요!</p>\r\n" + 
						"<table  style=\"width: 300px;\">\r\n" + 
						"<tr style=\"font-size: 12px; text-align: left;\"> <th>게시판</th> <th>제목</th><th>추천</th><th>조회수</th> </tr>\r\n"; 
						
				//TODO 주간 인기 게시물
				//htmlStr += "<tr> <td>aa</td> <td>aa</td> <td>11</td> <td>11</td> </tr>\r\n" + 
				for (MailingVO v : popular_contentL) {
					htmlStr += "<tr style='font-size:8px;'>"
							+ "<td>"+ v.getSource()+"</td>";
					htmlStr += "<td>"+v.getTitle()+"</td>";
					htmlStr += "<td>"+v.getLikes()+"</td>";
					htmlStr += "<td>"+v.getCount()+"</td>"
							+ "</tr>";
				}
				
				htmlStr+="</table>" + 
				
						"\r\n" + 
						"\r\n" + 
						"                                                </table>\r\n" + 
						"                                            </div>\r\n" + 
						"                                        </div>\r\n" + 
						"\r\n" + 
						"                                        <div style=\"Margin-left: 20px;Margin-right: 20px;Margin-bottom: 24px;\">\r\n" + 
						"                                            <div\r\n" + 
						"                                                style=\"mso-line-height-rule: exactly;line-height: 10px;font-size: 1px;\">\r\n" + 
						"                                                &nbsp;</div>\r\n" + 
						"                                        </div>\r\n" + 
						"\r\n" + 
						"                                    </div>\r\n" + 
						"                                    <!--[if (mso)|(IE)]></td><td class=\"layout__edges\">&nbsp;</td></tr></table><![endif]-->\r\n" + 
						"                                </div>\r\n" + 
						"                            </div>\r\n" + 
						"                        </div>\r\n" + 
						"\r\n" + 
						"                        <div style=\"background-color: #ecf3f5;\">\r\n" + 
						"                            <div class=\"layout two-col stack\"\r\n" + 
						"                                style=\"Margin: 0 auto;max-width: 600px;min-width: 320px; width: 320px;width: calc(28000% - 167400px);overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;\">\r\n" + 
						"                                <div class=\"layout__inner\"\r\n" + 
						"                                    style=\"border-collapse: collapse;display: table;width: 100%;\">\r\n" + 
						"                                    <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\"><tr class=\"layout-full-width\" style=\"background-color: #ecf3f5;\"><td class=\"layout__edges\">&nbsp;</td><td style=\"width: 300px\" valign=\"top\" class=\"w260\"><![endif]-->\r\n" + 
						"                                    <div class=\"column\"\r\n" + 
						"                                        style=\"text-align: left;color: #757575;font-size: 14px;line-height: 21px;font-family: Roboto,Tahoma,sans-serif;max-width: 320px;min-width: 300px; width: 320px;width: calc(12300px - 2000%);Float: left;\">\r\n" + 
						"\r\n" + 
						"                                        <div style=\"Margin-left: 20px;Margin-right: 20px;Margin-top: 24px;\">\r\n" + 
						"                                            <div\r\n" + 
						"                                                style=\"mso-line-height-rule: exactly;line-height: 22px;font-size: 1px;\">\r\n" + 
						"                                                &nbsp;</div>\r\n" + 
						"                                        </div>\r\n" + 
						"\r\n" + 
						"                                        <div style=\"Margin-left: 20px;Margin-right: 20px;Margin-bottom: 24px;\">\r\n" + 
						"                                            <div\r\n" + 
						"                                                style=\"mso-line-height-rule: exactly;mso-text-raise: 11px;vertical-align: middle;\">\r\n" + 
						"                                                <h2\r\n" + 
						"                                                    style=\"Margin-top: 0;Margin-bottom: 0;font-style: normal;font-weight: normal;color: #557187;font-size: 17px;line-height: 26px;\">\r\n" + 
						"                                                    ";
				//TODO 회원 관심 게시물		
				htmlStr += user_id+" 님의 관심 검색 결과"
						+ "</h2>\r\n" + 
						"                                                <p style=\"Margin-top: 16px;Margin-bottom: 0;\">"
						+ vo.getUser_name()+" 님은 이번주에 이런 검색을 하셨군요? Noti가 회원님이 관심가질만한 HOT한 정책 정보를 모아보았습니다!</p>\r\n" ;
				
				
				if(user_search_resultL.isEmpty()) {
					htmlStr += "<p> 아직 검색하지 않으셨군요. Noti 에서 로그인 한 후 검색해 보세요!</p>";
				}else {
					htmlStr +="<table style=\"width: 300px;\">" + 
							"<tr style=\"font-size: 12px; text-align: left;\"> <th>검색어</th> <th>제목</th> <th>추천</th> <th>조회수</th>"
//							+ " <th>출처</th>"
							+ " </tr>\r\n" ;
					
							//"<tr> <td>aa</td> <td>aa</td> <td>11</td> <td>11</td> <td>aa</td> </tr>\r\n" + 
					for (MailingVO v : user_search_resultL) {
						htmlStr += "<tr style='font-size:8px;'><td>"+ v.getText()+"</td>";
						htmlStr += "<td >"+v.getTitle()+"</td>";
						htmlStr += "<td>"+v.getLikes()+"</td>";
						htmlStr += "<td>"+v.getCount()+"</td>"
//						htmlStr += "<td>"+v.getSource()+"</td>"
								+ "</tr>";
					}
					htmlStr += "</table>\r\n" ;
				}
				
				htmlStr +=
						"                                            </div>\r\n" + 
						"                                        </div>\r\n" + 
						"\r\n" + 
						"                                    </div>\r\n" + 
						"                                    <!--[if (mso)|(IE)]></td><td style=\"width: 300px\" valign=\"top\" class=\"w260\"><![endif]-->\r\n" + 
						"                                    <div class=\"column\"\r\n" + 
						"                                        style=\"text-align: left;color: #757575;font-size: 14px;line-height: 21px;font-family: Roboto,Tahoma,sans-serif;max-width: 320px;min-width: 300px; width: 320px;width: calc(12300px - 2000%);Float: left;\">\r\n" + 
						"\r\n" + 
						"                                        <div style=\"Margin-left: 20px;Margin-right: 20px;Margin-top: 24px;\">\r\n" + 
						"                                            <div\r\n" + 
						"                                                style=\"mso-line-height-rule: exactly;line-height: 29px;font-size: 1px;\">\r\n" + 
						"                                                &nbsp;</div>\r\n" + 
						"                                        </div>\r\n" + 
						"\r\n" + 
						"                                        <div style=\"font-size: 12px;font-style: normal;font-weight: normal;line-height: 19px;\"\r\n" + 
						"                                            align=\"center\">\r\n" + 
						"                                            <img style=\"border: 0;display: block;height: auto;width: 100%;max-width: 176px;\"\r\n" + 
						"                                                alt=\"\" width=\"176\" src=\"https://i.esdrop.com/d/sQ2AVbF91a.png\" />\r\n" + 
						"                                        </div>\r\n" + 
						"\r\n" + 
						"                                        <div\r\n" + 
						"                                            style=\"Margin-left: 20px;Margin-right: 20px;Margin-top: 20px;Margin-bottom: 24px;\">\r\n" + 
						"                                            <div class=\"btn btn--flat btn--large\" style=\"text-align:center;\">\r\n" + 
						"                                                <![if !mso]><a\r\n" + 
						"                                                style=\"border-radius: 4px;display: inline-block;font-size: 14px;font-weight: bold;line-height: 24px;padding: 12px 24px;text-align: center;text-decoration: none !important;transition: opacity 0.1s ease-in;color: #ffffff !important;background-color: #557187;font-family: Roboto, Tahoma, sans-serif;\"\r\n" + 
						"                                                href=\"http://61.81.99.86:8888/noti\">노티에게로..</a>\r\n" + 
						"                                                <![endif]>\r\n" + 
						"                                                <!--[if mso]><p style=\"line-height:0;margin:0;\">&nbsp;</p><v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" href=\"http://test.com\" style=\"width:176px\" arcsize=\"9%\" fillcolor=\"#557187\" stroke=\"f\"><v:textbox style=\"mso-fit-shape-to-text:t\" inset=\"0px,11px,0px,11px\"><center style=\"font-size:14px;line-height:24px;color:#FFFFFF;font-family:Roboto,Tahoma,sans-serif;font-weight:bold;mso-line-height-rule:exactly;mso-text-raise:4px\">Download the app</center></v:textbox></v:roundrect><![endif]-->\r\n" + 
						"                                            </div>\r\n" + 
						"                                        </div>\r\n" + 
						"\r\n" + 
						"                                    </div>\r\n" + 
						"                                    <!--[if (mso)|(IE)]></td><td class=\"layout__edges\">&nbsp;</td></tr></table><![endif]-->\r\n" + 
						"                                </div>\r\n" + 
						"                            </div>\r\n" + 
						"                        </div>\r\n" + 
						"\r\n" + 
						"                        <div style=\"mso-line-height-rule: exactly;line-height: 70px;font-size: 70px;\">&nbsp;</div>\r\n" + 
						"\r\n" + 
						"                    </div>\r\n" + 
						"                    <div role=\"contentinfo\">\r\n" + 
						"                        <div class=\"layout email-footer stack\"\r\n" + 
						"                            style=\"Margin: 0 auto;max-width: 600px;min-width: 320px; width: 320px;width: calc(28000% - 167400px);overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;\">\r\n" + 
						"                            <div class=\"layout__inner\" style=\"border-collapse: collapse;display: table;width: 100%;\">\r\n" + 
						"                                <!--[if (mso)|(IE)]><table align=\"center\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\"><tr class=\"layout-email-footer\"><td style=\"width: 400px;\" valign=\"top\" class=\"w360\"><![endif]-->\r\n" + 
						"                                <div class=\"column wide\"\r\n" + 
						"                                    style=\"text-align: left;font-size: 12px;line-height: 19px;color: #b9b9b9;font-family: Roboto,Tahoma,sans-serif;Float: left;max-width: 400px;min-width: 320px; width: 320px;width: calc(8000% - 47600px);\">\r\n" + 
						"                                    <div\r\n" + 
						"                                        style=\"Margin-left: 20px;Margin-right: 20px;Margin-top: 10px;Margin-bottom: 10px;\">\r\n" + 
						"                                        <table class=\"email-footer__links\"\r\n" + 
						"                                            style=\"border-collapse: collapse;table-layout: fixed;\" role=\"presentation\"\r\n" + 
						"                                            emb-web-links>\r\n" + 
						"                                            <tbody>\r\n" + 
						"                                                <tr role=\"navigation\">\r\n" + 
						"\r\n" + 
						"                                                </tr>\r\n" + 
						"                                            </tbody>\r\n" + 
						"                                        </table>\r\n" + 
						"                                        <div style=\"font-size: 12px;line-height: 19px;Margin-top: 20px;\">\r\n" + 
						"                                            <div>Noti.the.notice@gmail.com</div>\r\n" + 
						"                                        </div>\r\n" + 
						"                                        <div style=\"font-size: 12px;line-height: 19px;Margin-top: 18px;\">\r\n" + 
						"                                            <div>본 이메일은 회원님의 주간 메일 발송 요청에 따라 발송되었습니다.</div>\r\n" + 
						"                                        </div>\r\n" + 
						"                                        <!--[if mso]>&nbsp;<![endif]-->\r\n" + 
						"                                    </div>\r\n" + 
						"                                </div>\r\n" + 
						"                                <!--[if (mso)|(IE)]></td><td style=\"width: 200px;\" valign=\"top\" class=\"w160\"><![endif]-->\r\n" + 
						"                                <div class=\"column narrow\"\r\n" + 
						"                                    style=\"text-align: left;font-size: 12px;line-height: 19px;color: #b9b9b9;font-family: Roboto,Tahoma,sans-serif;Float: left;max-width: 320px;min-width: 200px; width: 320px;width: calc(72200px - 12000%);\">\r\n" + 
						"                                    <div\r\n" + 
						"                                        style=\"Margin-left: 20px;Margin-right: 20px;Margin-top: 10px;Margin-bottom: 10px;\">\r\n" + 
						"\r\n" + 
						"                                    </div>\r\n" + 
						"                                </div>\r\n" + 
						"                                <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n" + 
						"                            </div>\r\n" + 
						"                        </div>\r\n" + 
						"                        <div class=\"layout one-col email-footer\"\r\n" + 
						"                            style=\"Margin: 0 auto;max-width: 600px;min-width: 320px; width: 320px;width: calc(28000% - 167400px);overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;\">\r\n" + 
						"                            <div class=\"layout__inner\" style=\"border-collapse: collapse;display: table;width: 100%;\">\r\n" + 
						"                                <!--[if (mso)|(IE)]><table align=\"center\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\"><tr class=\"layout-email-footer\"><td style=\"width: 600px;\" class=\"w560\"><![endif]-->\r\n" + 
						"                                <div class=\"column\"\r\n" + 
						"                                    style=\"text-align: left;font-size: 12px;line-height: 19px;color: #b9b9b9;font-family: Roboto,Tahoma,sans-serif;\">\r\n" + 
						"                                    <div\r\n" + 
						"                                        style=\"Margin-left: 20px;Margin-right: 20px;Margin-top: 10px;Margin-bottom: 10px;\">\r\n" + 
						"                                        <div style=\"font-size: 12px;line-height: 19px;\">\r\n" + 
						"                                            <unsubscribe style=\"text-decoration: underline;\">Impossible to unsubscribe</unsubscribe>\r\n" + 
						"                                        </div>\r\n" + 
						"                                    </div>\r\n" + 
						"                                </div>\r\n" + 
						"                                <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n" + 
						"                            </div>\r\n" + 
						"                        </div>\r\n" + 
						"                    </div>\r\n" + 
						"                    <div style=\"line-height:40px;font-size:40px;\">&nbsp;</div>\r\n" + 
						"                </td>\r\n" + 
						"            </tr>\r\n" + 
						"        </tbody>\r\n" + 
						"    </table>\r\n" + 
						"\r\n" + 
						"</body>\r\n" + 
						"\r\n" + 
						"</html>";

				// 내용설정
				messageHelper.setText(htmlStr, true);

				// 전송
				javaMailSender.send(message);

			} catch (MessagingException e) {
				e.printStackTrace();
			}

		} else {
			return;
		}
	}
}

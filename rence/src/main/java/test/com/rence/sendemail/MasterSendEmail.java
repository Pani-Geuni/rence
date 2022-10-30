/**
 * 
 * @author 최진실
 *
 */
package test.com.rence.sendemail;

import java.util.concurrent.ThreadLocalRandom;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import test.com.rence.backoffice.BackOfficeVO;

@Component
public class MasterSendEmail {
	private static final Logger logger = LoggerFactory.getLogger(MasterSendEmail.class);

	@Autowired
	JavaMailSender javaMailSender;

	@Autowired
	AES256Util aes;

	//////////////////////////////////////////////////
	// ******* (가입 승인) 비밀번호 초기화 링크 전송 *******//
	/////////////////////////////////////////////////
	public BackOfficeVO settingPw(BackOfficeVO vo, EmailVO evo) {
		

		String originText = vo.getBackoffice_no();

//		String encText = aes.encryptAES("0123456789abcdefghij0123456789ab", originText, false);
//        System.out.println("encText (encodeBase64) : " + encText);

		String encText = aes.encryptAES("0123456789abcdefghij0123456789ab", originText, true);
		logger.info("encText (encodeBase64URLSafeString) : " + encText);

		// 이메일 제목, 내용 설정
		evo.setSubject("[rence] 호스트 비밀번호 설정");
		evo.setContent("아래의 링크에 접속하여 비밀번호를 재설정 해주시길 바랍니다.");

		// 비밀번호 재설정

		try {
			// 전송
			MimeMessage msg = javaMailSender.createMimeMessage();
			msg.setSubject(evo.getSubject());
			msg.setText("비밀번호 재설정 링크 : " + "http://localhost:8090/rence/backoffice_update_pw?backoffice_no="
					+ encText);
			msg.setRecipient(RecipientType.TO, new InternetAddress(vo.getBackoffice_email()));

			javaMailSender.send(msg);
		} catch (MessagingException e) {
			vo = null;
		}
		return vo;
	}

	///////////////////////////////
	// ******* (가입 거절) *******//
	//////////////////////////////
	
	
	///////////////////////////////
	// ******* (탈퇴 완료) *******//
	//////////////////////////////
	
	


}

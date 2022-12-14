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

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import test.com.rence.backoffice.BackOfficeVO;

@Component
public class BackOfficeSendEmail {
	private static final Logger logger = LoggerFactory.getLogger(BackOfficeSendEmail.class);

	@Autowired
	JavaMailSender javaMailSender;

	@Autowired
	AES256Util aes;

	///////////////////////////////
	// ******* 인증 코드 전송 *******//
	//////////////////////////////
	public AuthVO sendEmail(AuthVO vo, EmailVO evo) {

		// 이메일 제목, 내용 설정
		evo.setSubject("[rence] 이메일 인증코드");
		evo.setContent("해당 코드를 인증번호 란에 기입 후, 인증확인을 마쳐주세요.");

		// 인증코드 생성
		int RANDOM_BOUND = 100000;
		ThreadLocalRandom random = ThreadLocalRandom.current();
		vo.setAuth_code(String.valueOf(random.nextInt(RANDOM_BOUND, RANDOM_BOUND * 10)));

		try {

			// 전송
			MimeMessage msg = javaMailSender.createMimeMessage();
			msg.setSubject(evo.getSubject());
			msg.setText("인증 코드 : " + vo.getAuth_code());
			msg.setRecipient(RecipientType.TO, new InternetAddress(vo.getUser_email()));

			javaMailSender.send(msg);
		} catch (MessagingException e) {
			vo = null;
		}
		return vo;
	}

	///////////////////////////////
	// ******* 비밀번호 찾기 *******//
	//////////////////////////////
	public BackOfficeVO findPw(BackOfficeVO vo, EmailVO evo) {
		
		// 이메일 제목, 내용 설정
		evo.setSubject("[rence] 임시 비밀번호 발급");
		
		String temp_pw = RandomStringUtils.randomAlphanumeric(6);
		
//		String enc_pw = aes.encryptAES("0123456789abcdefghij0123456789ab", temp_pw, true);
//		logger.info("encText (encodeBase64URLSafeString) : " + enc_pw);
//		vo.setBackoffice_pw(enc_pw);
		vo.setBackoffice_pw(temp_pw);


		try {
			MimeMessage msg = javaMailSender.createMimeMessage();
			msg.setSubject(evo.getSubject());
			msg.setText("임시 비밀번호 : " + temp_pw);
			msg.setRecipient(RecipientType.TO, new InternetAddress(vo.getBackoffice_email()));

			javaMailSender.send(msg);
		} catch (MessagingException e) {
			vo = null;
		}
		return vo;
	}

}

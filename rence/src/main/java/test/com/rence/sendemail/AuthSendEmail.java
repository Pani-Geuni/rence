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
public class AuthSendEmail {
	private static final Logger logger = LoggerFactory.getLogger(AuthSendEmail.class);

	@Autowired
	JavaMailSender javaMailSender;

	///////////////////////////////
	// ******* 인증 코드 전송 *******//
	//////////////////////////////
	public AuthVO sendEmail(AuthVO vo) {

		// 이메일 제목, 내용 설정
		vo.setSubject("[rence] 이메일 인증코드");
		vo.setContent("해당 코드를 인증번호 란에 기입 후, 인증확인을 마쳐주세요.");

		// 인증코드 생성
		int RANDOM_BOUND = 100000;
		ThreadLocalRandom random = ThreadLocalRandom.current();
		vo.setAuth_code(String.valueOf(random.nextInt(RANDOM_BOUND)));

		try {

			// 전송
			MimeMessage msg = javaMailSender.createMimeMessage();
			msg.setSubject(vo.getSubject());
			msg.setText(vo.getContent(), "인증 코드 : " + vo.getAuth_code());
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
		evo.setSubject("[rence] 비밀번호 재설정");
		evo.setContent("아래의 링크에 접속하여 비밀번호를 재설정 해주시길 바랍니다.");

		// 비밀번호 재설정

		try {
			// 전송
			MimeMessage msg = javaMailSender.createMimeMessage();
			msg.setSubject(evo.getSubject());
			msg.setText(evo.getContent(),
					"비밀번호 재설정 링크 : " + "<a href='http://localhost:8090/backoffice/pwfindOK?user_no=");
			msg.setRecipient(RecipientType.TO, new InternetAddress(vo.getBackoffice_email()));

			javaMailSender.send(msg);
		} catch (MessagingException e) {
			vo = null;
		}
		return vo;
	}

}
